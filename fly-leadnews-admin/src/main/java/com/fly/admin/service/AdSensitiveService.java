package com.fly.admin.service;

import com.fly.model.admin.dtos.SensitiveDto;
import com.fly.model.admin.pojos.AdSensitive;
import com.fly.model.common.dtos.ResponseResult;

public interface AdSensitiveService {

    ResponseResult findByNameAndPage(SensitiveDto sensitiveDto);


    /**
     * 新增
     * @param adSensitive
     * @return
     */
    ResponseResult addAdSensitive(AdSensitive adSensitive);

    /**
     * 修改
     * @param adSensitive
     * @return
     */
    ResponseResult updateAdSensitive(AdSensitive adSensitive);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    ResponseResult deleteAdSensitiveById(Integer id);
}
