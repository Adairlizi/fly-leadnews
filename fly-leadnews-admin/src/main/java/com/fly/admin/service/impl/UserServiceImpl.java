package com.fly.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fly.admin.mapper.UserMapper;
import com.fly.admin.service.UserService;
import com.fly.model.admin.dtos.AdUserDto;
import com.fly.model.admin.pojos.AdUser;
import com.fly.model.common.dtos.ResponseResult;
import com.fly.model.common.enums.AppHttpCodeEnum;
import com.fly.utils.common.AppJwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, AdUser> implements UserService {
    @Override
    public ResponseResult Login(AdUserDto adUserDto) {
        //1.判断参数是否存在
        if (null==adUserDto || StringUtils.isEmpty(adUserDto.getName()) || StringUtils.isEmpty(adUserDto.getPassword())){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE, "用户名或密码不能为空");
        }
        //2.校验密码是否正确
        List<AdUser> list = list(Wrappers.<AdUser>lambdaQuery().eq(AdUser::getName,adUserDto.getName()));
        if (null!=list && list.size()==1){
            AdUser adUser = list.get(0);
            String pwd = DigestUtils.md5DigestAsHex((adUser.getPassword() + adUser.getSalt()).getBytes());
            Map<String,Object> map = new HashMap();
            map.put("token", AppJwtUtil.getToken(adUser.getId().longValue()));
            adUser.setPassword("");
            adUser.setSalt("");
            map.put("user",adUser);
            return ResponseResult.okResult(map);
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
        }
    }
}
