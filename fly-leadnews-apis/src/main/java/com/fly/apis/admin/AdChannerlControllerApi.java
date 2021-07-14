package com.fly.apis.admin;

import com.fly.model.admin.dtos.ChannelDto;
import com.fly.model.common.dtos.ResponseResult;


public interface AdChannerlControllerApi {

    /**
     * 根据名称分页查询
     * @param channelDto
     * @return
     */
    public ResponseResult findByNameAndPage(ChannelDto channelDto);
}
