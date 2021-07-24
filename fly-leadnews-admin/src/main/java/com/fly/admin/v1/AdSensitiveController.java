package com.fly.admin.v1;

import com.fly.admin.service.AdSensitiveService;
import com.fly.apis.admin.AdSensitiveControllerApi;
import com.fly.model.admin.dtos.SensitiveDto;
import com.fly.model.admin.pojos.AdSensitive;
import com.fly.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 敏感词接口
 */
@RestController
@RequestMapping("/api/v1/sensitive")
public class AdSensitiveController implements AdSensitiveControllerApi {

    @Autowired
    private AdSensitiveService adSensitiveService;

    @Override
    @PostMapping("list")
    public ResponseResult findByNameAndPage(@RequestBody SensitiveDto sensitiveDto) {
        return adSensitiveService.findByNameAndPage(sensitiveDto);
    }

    @PostMapping("/save")
    @Override
    public ResponseResult addAdSensitive(@RequestBody AdSensitive adSensitive) {
        return adSensitiveService.addAdSensitive(adSensitive);
    }

    @PostMapping("/update")
    @Override
    public ResponseResult updateAdSensitive(@RequestBody AdSensitive adSensitive) {
        return adSensitiveService.updateAdSensitive(adSensitive);
    }

    @DeleteMapping("/del/{id}")
    @Override
    public ResponseResult deleteSAdSensitiveById(@PathVariable("id") Integer id) {
        return adSensitiveService.deleteAdSensitiveById(id);
    }
}
