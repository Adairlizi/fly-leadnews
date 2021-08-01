package com.fly.apis.wemedia;

import com.fly.model.common.dtos.ResponseResult;
import com.fly.model.wemedia.pojos.WmUser;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 自媒体接口
 */
public interface WmUserControllerApi {

    /**
     * 报错自媒体用户
     * @param wmUser
     * @return
     */
    public ResponseResult save(WmUser wmUser);

    /**
     * 通过姓名
     * @param name
     * @return
     */
    public WmUser findByName(@PathVariable("name") String name);
}
