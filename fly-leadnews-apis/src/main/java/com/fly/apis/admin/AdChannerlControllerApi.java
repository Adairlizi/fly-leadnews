package com.fly.apis.admin;

import com.fly.model.admin.dtos.ChannelDto;
import com.fly.model.admin.pojos.AdChannel;
import com.fly.model.common.dtos.ResponseResult;


public interface AdChannerlControllerApi {

    /**
     * 根据名称分页查询
     * @param channelDto
     * @return
     */
    public ResponseResult findByNameAndPage(ChannelDto channelDto);

    /**
     * 频道查询
     * @param adChannel
     * @return
     */
    public ResponseResult addAdChannerl(AdChannel adChannel);

    /**
     * 频道修改
     * @param adChannel
     * @return
     */
    public ResponseResult updateAdChanner(AdChannel adChannel);

    /**
     * 通过ID删除
     * @param id 删除
     * @return
     */
    public ResponseResult deleteSAdChannerById(Integer id);
}
