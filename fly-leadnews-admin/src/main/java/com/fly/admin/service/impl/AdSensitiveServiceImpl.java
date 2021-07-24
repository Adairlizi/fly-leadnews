package com.fly.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fly.admin.mapper.AdSensitiveMapper;
import com.fly.admin.service.AdSensitiveService;
import com.fly.model.admin.dtos.SensitiveDto;
import com.fly.model.admin.pojos.AdSensitive;
import com.fly.model.common.dtos.PageResponseResult;
import com.fly.model.common.dtos.ResponseResult;
import com.fly.model.common.enums.AppHttpCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdSensitiveServiceImpl extends ServiceImpl<AdSensitiveMapper, AdSensitive> implements AdSensitiveService {

    @Autowired
    private AdSensitiveMapper adSensitiveMapper;

    public ResponseResult findByNameAndPage(SensitiveDto sensitiveDto) {
        if (null == sensitiveDto) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        sensitiveDto.checkParam();

        Page page = new Page(sensitiveDto.getPage(), sensitiveDto.getSize());
        LambdaQueryWrapper<AdSensitive> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //模糊查询
        if (StringUtils.isNotEmpty(sensitiveDto.getName())) {
            lambdaQueryWrapper.like(AdSensitive::getSensitives, sensitiveDto.getName());
        }
        IPage result = page(page, lambdaQueryWrapper);
        PageResponseResult pageResponseResult = new PageResponseResult(sensitiveDto.getPage(), sensitiveDto.getSize(), (int) result.getTotal());
        pageResponseResult.setData(result.getRecords());
        return pageResponseResult;
    }

    @Override
    public ResponseResult addAdSensitive(AdSensitive adSensitive) {
        if(null == adSensitive){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        boolean saveFlag = save(adSensitive);
        if (!saveFlag){
            return ResponseResult.errorResult(AppHttpCodeEnum.ERROR);
        }
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult updateAdSensitive(AdSensitive adSensitive) {
        if(null == adSensitive){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        boolean updateFlag = updateById(adSensitive);
        if (!updateFlag){
            return ResponseResult.errorResult(AppHttpCodeEnum.ERROR);
        }
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult deleteAdSensitiveById(Integer id) {
        if (null == id) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        boolean daleteFlag = removeById(id);
        if (!daleteFlag) {
            return ResponseResult.errorResult(AppHttpCodeEnum.ERROR);
        }
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}
