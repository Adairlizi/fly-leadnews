package com.fly.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fly.model.common.dtos.ResponseResult;
import com.fly.model.user.dtos.AuthDto;
import com.fly.model.user.pojos.ApUserRealname;


public interface ApUserRealnameService extends IService<ApUserRealname> {

    /**
     * 按照状态分页查询用户列表
     * @param dto
     * @return
     */
    public ResponseResult loadListByStatus(AuthDto dto);

    /**
     * 修改认证用户状态
     * @param dto
     * @param status
     * @return
     */
    public ResponseResult updateStatusById(AuthDto dto,Short status);

}
