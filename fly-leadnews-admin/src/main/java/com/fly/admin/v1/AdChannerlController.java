package com.fly.admin.v1;

import com.fly.admin.service.AdChannelService;


import com.fly.apis.admin.AdChannerlControllerApi;
import com.fly.model.admin.dtos.ChannelDto;
import com.fly.model.admin.pojos.AdChannel;
import com.fly.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/add")
    @Override
    public ResponseResult addAdChannerl(@RequestBody AdChannel adChannel) {
        return adChannelService.addAdChannel(adChannel);
    }

    @RequestMapping("/update")
    @Override
    public ResponseResult updateAdChanner(@RequestBody AdChannel adChannel) {
        return adChannelService.updateAdChannel(adChannel);
    }

    @RequestMapping("/delete")
    @Override
    public ResponseResult deleteSAdChannerById(@RequestParam("id") Integer id) {
        return adChannelService.deleteAdChannelById(id);
    }
}
