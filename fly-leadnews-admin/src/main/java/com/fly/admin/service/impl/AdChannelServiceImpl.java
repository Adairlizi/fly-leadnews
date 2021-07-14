package com.fly.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
import org.springframework.stereotype.Service;

@Service
public class AdChannelServiceImpl extends ServiceImpl<AdChannerlMapper, AdChannel> implements AdChannelService {
    @Override
    public ResponseResult findByNameAndPage(ChannelDto dto) {
        //1.检查参数
        if (null == dto){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        dto.checkParam();
        //2.根据名称模糊分页查询
        Page page = new Page(dto.getPage(), dto.getSize());
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
}
