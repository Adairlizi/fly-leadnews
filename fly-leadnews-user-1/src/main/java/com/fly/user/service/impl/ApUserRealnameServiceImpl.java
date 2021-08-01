package com.fly.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fly.common.user.UserConstants;
import com.fly.model.article.pojos.ApAuthor;
import com.fly.model.common.dtos.PageResponseResult;
import com.fly.model.common.dtos.ResponseResult;
import com.fly.model.common.enums.AppHttpCodeEnum;
import com.fly.model.user.dtos.AuthDto;
import com.fly.model.user.pojos.ApUser;
import com.fly.model.user.pojos.ApUserRealname;
import com.fly.model.wemedia.pojos.WmUser;
import com.fly.user.feign.ArticleFeign;
import com.fly.user.feign.WemediaFeign;
import com.fly.user.mapper.ApUserMapper;
import com.fly.user.mapper.ApUserRealnameMapper;
import com.fly.user.service.ApUserRealnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ApUserRealnameServiceImpl extends ServiceImpl<ApUserRealnameMapper, ApUserRealname> implements ApUserRealnameService {

    @Override
    public ResponseResult loadListByStatus(AuthDto dto) {
        //1.检查参数
        if(dto == null ){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //分页检查
        dto.checkParam();
        Page page = new Page(dto.getPage(), dto.getSize());

        //2.根据状态分页查询
        LambdaQueryWrapper<ApUserRealname> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        IPage<ApUserRealname> result = page(page, lambdaQueryWrapper);

        //3.返回结果
        PageResponseResult responseResult = new PageResponseResult(dto.getPage(),dto.getSize(),(int)result.getTotal());
        responseResult.setData(result.getRecords());
        return responseResult;
    }

    @Override
    public ResponseResult updateStatusById(AuthDto dto, Short status) {
        //1.检查参数
        if(dto == null || dto.getId()==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //检查状态
        if(checkStatus(status)){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        //2.修改状态
        ApUserRealname apUserRealname = new ApUserRealname();
        apUserRealname.setId(dto.getId());
        apUserRealname.setStatus(status);
        if(dto.getMsg() != null){
            apUserRealname.setReason(dto.getMsg());
        }

        updateById(apUserRealname);

        //3.如果审核状态是通过，创建自媒体账户，创建作者信息
        if(status.equals(UserConstants.PASS_AUTH)){
            //创建自媒体账户，创建作者信息
            ResponseResult result = createWmUserAndAuthor(dto);
            if(result != null){
                return result;
            }
        }

        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Autowired
    private ApUserMapper apUserMapper;

    @Autowired
    private WemediaFeign wemediaFeign;

    /**
     *  创建自媒体账户，创建作者信息
     * @param dto
     */
    private ResponseResult createWmUserAndAuthor(AuthDto dto) {
        //获取ap_user信息
        Integer apUserRealnameId = dto.getId();
        ApUserRealname apUserRealname = getById(apUserRealnameId);
        ApUser apUser = apUserMapper.selectById(apUserRealname.getUserId());
        if(apUser == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        WmUser wmUser = wemediaFeign.findByName(apUser.getName());
        //创建自媒体账户
        if(wmUser == null){
            wmUser = new WmUser();
            wmUser.setApUserId(apUser.getId());
            wmUser.setCreatedTime(new Date());
            wmUser.setName(apUser.getName());
            wmUser.setPassword(apUser.getPassword());
            wmUser.setSalt(apUser.getSalt());
            wmUser.setPhone(apUser.getPhone());
            wmUser.setStatus(9);
            wemediaFeign.save(wmUser);
        }
        //创建作者
        createAuthor(wmUser);

        apUser.setFlag((short)1);
        apUserMapper.updateById(apUser);
        return  null;
    }

    @Autowired
    private ArticleFeign articleFeign;

    /**
     * 创建作者
     * @param wmUser
     */
    private void createAuthor(WmUser wmUser) {
        Integer apUserId = wmUser.getApUserId();
        ApAuthor apAuthor = articleFeign.findByUserId(apUserId);
        if(apAuthor == null){
            apAuthor = new ApAuthor();
            apAuthor.setName(wmUser.getName());
            apAuthor.setCreatedTime(new Date());
            apAuthor.setUserId(apUserId);
            apAuthor.setType(UserConstants.AUTH_TYPE);
            articleFeign.save(apAuthor);
        }
    }


    /**
     * 检查状态
     * @param status
     * @return
     */
    private boolean checkStatus(Short status) {
        if(status == null || (!status.equals(UserConstants.FAIL_AUTH) && !status.equals(UserConstants.PASS_AUTH))){
            return  true;
        }
        return false;
    }
}
