package com.fly.admin.service;

import com.fly.model.admin.dtos.AdUserDto;
import com.fly.model.common.dtos.ResponseResult;

/**
 *
 */
public interface UserService {

    /**
     * 登录接口
     * @param adUserDto
     * @return
     */
    ResponseResult Login(AdUserDto adUserDto);

}
