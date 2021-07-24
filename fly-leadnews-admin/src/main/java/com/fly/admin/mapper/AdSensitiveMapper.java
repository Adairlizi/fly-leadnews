package com.fly.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fly.model.admin.dtos.SensitiveDto;
import com.fly.model.admin.pojos.AdSensitive;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdSensitiveMapper extends BaseMapper<AdSensitive> {

    List<AdSensitive> findByNameAndPage(SensitiveDto sensitiveDto);
}
