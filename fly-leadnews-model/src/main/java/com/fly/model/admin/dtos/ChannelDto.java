package com.fly.model.admin.dtos;


import com.fly.model.common.dtos.PageRequestDto;
import io.swagger.annotations.ApiModelProperty;

public class ChannelDto extends PageRequestDto {

    /**
     * 频道名称
     */
    @ApiModelProperty("频道名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
