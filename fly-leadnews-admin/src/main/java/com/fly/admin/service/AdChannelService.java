package com.fly.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fly.model.admin.dtos.ChannelDto;
import com.fly.model.admin.pojos.AdChannel;
import com.fly.model.common.dtos.ResponseResult;

public interface AdChannelService extends IService<AdChannel> {

    /**
     * 根据书名查询
     * @param dto
     * @return
     */
    ResponseResult findByNameAndPage(ChannelDto dto);

    /**
     * 新增
     * @param adChannel
     * @return
     */
    ResponseResult addAdChannel(AdChannel adChannel);

    /**
     * 频道修改
     * @param adChannel
     * @return
     */
    ResponseResult updateAdChannel(AdChannel adChannel);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    ResponseResult deleteAdChannelById(Integer id);


}
