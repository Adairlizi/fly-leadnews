package com.fly.apis.admin;

import com.fly.model.admin.dtos.SensitiveDto;
import com.fly.model.admin.pojos.AdSensitive;
import com.fly.model.common.dtos.ResponseResult;

public interface AdSensitiveControllerApi {
    /**
     * 根据名称分页查询
     * @param sensitiveDto
     * @return
     */
    public ResponseResult findByNameAndPage(SensitiveDto sensitiveDto);

    /**
     * 频道查询
     * @param adSensitive
     * @return
     */
    public ResponseResult addAdSensitive(AdSensitive adSensitive);

    /**
     * 频道修改
     * @param adSensitive
     * @return
     */
    public ResponseResult updateAdSensitive(AdSensitive adSensitive);

    /**
     * 通过ID删除
     * @param id 删除
     * @return
     */
    public ResponseResult deleteSAdSensitiveById(Integer id);

}
