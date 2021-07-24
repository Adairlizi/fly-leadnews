package com.fly.common.exception;

import com.fly.model.common.dtos.ResponseResult;
import com.fly.model.common.enums.AppHttpCodeEnum;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice //控制器增强
@Log4j2
public class ExceptionCatch {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception e){
        e.printStackTrace();
        //记录日志
        log.error("catch exception:{}",e.getMessage());
        //返回通用的异常信息
        return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR);
    }
}
