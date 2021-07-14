package com.fly.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fly.model.admin.dtos.ChannelDto;
import com.fly.model.admin.pojos.AdChannel;
import com.fly.model.common.dtos.ResponseResult;
import org.springframework.stereotype.Service;

public interface AdChannelService extends IService<AdChannel> {

    ResponseResult findByNameAndPage(ChannelDto dto);
}
