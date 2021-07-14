package com.fly.model.user.dtos;

import lombok.Data;

@Data
public class LoginDto {

    //设备id
    private Integer equipmentId;

    //手机号
    private String phone;

    //密码
    private String password;

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
