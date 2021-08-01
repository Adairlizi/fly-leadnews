package com.fly.wemedia.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fly.model.wemedia.pojos.WmUser;
import com.fly.wemedia.mapper.WmUserMapper;
import com.fly.wemedia.service.WmUserService;
import org.springframework.stereotype.Service;

@Service
public class WmUserServiceImpl extends ServiceImpl<WmUserMapper, WmUser> implements WmUserService {
}
