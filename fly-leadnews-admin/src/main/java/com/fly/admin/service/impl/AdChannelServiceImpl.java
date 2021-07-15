package com.fly.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fly.admin.mapper.AdChannerlMapper;
import com.fly.admin.service.AdChannelService;
import com.fly.model.admin.dtos.ChannelDto;
import com.fly.model.admin.pojos.AdChannel;
import com.fly.model.common.dtos.PageResponseResult;
import com.fly.model.common.dtos.ResponseResult;
import com.fly.model.common.enums.AppHttpCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdChannelServiceImpl extends ServiceImpl<AdChannerlMapper, AdChannel> implements AdChannelService {

    @Autowired
    private AdChannerlMapper adChannerlMapper;

    @Override
    public ResponseResult findByNameAndPage(ChannelDto dto) {
        //1.检查参数
        if (null == dto){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        dto.checkParam();
        //2.根据名称模糊分页查询
        Page page = new Page(dto.getPage(), dto.getSize());
        //复杂写法
        QueryWrapper<AdChannel> objectQueryWrapper = new QueryWrapper<>();
        QueryWrapper<AdChannel> name = objectQueryWrapper.eq("name", dto.getName());
        List<AdChannel> adChannels = adChannerlMapper.selectList(name);
        System.out.println(adChannels);
        //简化写法
        LambdaQueryWrapper<AdChannel> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (StringUtils.isNoneBlank(dto.getName())){
            lambdaQueryWrapper.like(AdChannel::getName,dto.getName());
        }
        //3.结果返回
        IPage result = page(page, lambdaQueryWrapper);
        PageResponseResult pageResponseResult = new PageResponseResult(dto.getPage(), dto.getSize(), (int) result.getTotal());
        pageResponseResult.setData(result.getRecords());
        return pageResponseResult;
    }

    @Override
    public ResponseResult addAdChannel(AdChannel adChannel) {
        if (null == adChannel){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        adChannel.setCreatedTime(new Date());
        save(adChannel);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult updateAdChannel(AdChannel adChannel) {
        if (null == adChannel){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        updateById(adChannel);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult deleteAdChannelById(Integer id) {
        if (null == id){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        boolean flag = removeById(id);
        if (flag){
            return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.ERROR);
    }
}
