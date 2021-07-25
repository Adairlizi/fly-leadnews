package com.fly.apis.admin;

import com.fly.model.admin.dtos.AdUserDto;
import com.fly.model.common.dtos.ResponseResult;

/**
 * 登录接口
 */
public interface LoginControllerApi {

    public ResponseResult Login(AdUserDto adUserDto);
}
