package com.fly.admin.v1;

import com.fly.admin.service.UserService;
import com.fly.apis.admin.LoginControllerApi;
import com.fly.model.admin.dtos.AdUserDto;
import com.fly.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/login")
@RestController
public class LoginController implements LoginControllerApi {

    @Autowired
    private UserService userService;

    @PostMapping("/in")
    @Override
    public ResponseResult Login(@RequestBody AdUserDto adUserDto) {
        return userService.Login(adUserDto);
    }
}
