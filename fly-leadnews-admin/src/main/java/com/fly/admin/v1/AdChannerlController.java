package com.fly.admin.v1;

import com.fly.admin.service.AdChannelService;


import com.fly.apis.admin.AdChannerlControllerApi;
import com.fly.model.admin.dtos.ChannelDto;
import com.fly.model.admin.pojos.AdChannel;
import com.fly.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 频道接口
 */
@RestController
@RequestMapping("/api/v1/channel")
public class AdChannerlController implements AdChannerlControllerApi {

    @Autowired
    private AdChannelService adChannelService;

    @RequestMapping("/list")
    @Override
    public ResponseResult findByNameAndPage(@RequestBody ChannelDto channelDto) {
        return adChannelService.findByNameAndPage(channelDto);
    }

    @PostMapping("/save")
    @Override
    public ResponseResult addAdChannerl(@RequestBody AdChannel adChannel) {
        return adChannelService.addAdChannel(adChannel);
    }

    @PostMapping("/update")
    @Override
    public ResponseResult updateAdChanner(@RequestBody AdChannel adChannel) {
        return adChannelService.updateAdChannel(adChannel);
    }

    @GetMapping("/del/{id}")
    @Override
    public ResponseResult deleteSAdChannerById(@PathVariable("id") Integer id) {
        return adChannelService.deleteAdChannelById(id);
    }
}
