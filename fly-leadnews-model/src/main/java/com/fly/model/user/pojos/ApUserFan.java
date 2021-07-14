package com.fly.model.user.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * APP用户粉丝信息表
 * </p>
 *
 * @author itheima
 */
@Data
@TableName("ap_user_fan")
public class ApUserFan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 粉丝ID
     */
    @TableField("fans_id")
    private Long fansId;

    /**
     * 粉丝昵称
     */
    @TableField("fans_name")
    private String fansName;

    /**
     * 粉丝忠实度
            0 正常
            1 潜力股
            2 勇士
            3 铁杆
            4 老铁
     */
    @TableField("level")
    private Short level;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;

    /**
     * 是否可见我动态
     */
    @TableField("is_display")
    private Boolean isDisplay;

    /**
     * 是否屏蔽私信
     */
    @TableField("is_shield_letter")
    private Boolean isShieldLetter;

    /**
     * 是否屏蔽评论
     */
    @TableField("is_shield_comment")
    private Boolean isShieldComment;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getFansId() {
        return fansId;
    }

    public void setFansId(Long fansId) {
        this.fansId = fansId;
    }

    public String getFansName() {
        return fansName;
    }

    public void setFansName(String fansName) {
        this.fansName = fansName;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Boolean getDisplay() {
        return isDisplay;
    }

    public void setDisplay(Boolean display) {
        isDisplay = display;
    }

    public Boolean getShieldLetter() {
        return isShieldLetter;
    }

    public void setShieldLetter(Boolean shieldLetter) {
        isShieldLetter = shieldLetter;
    }

    public Boolean getShieldComment() {
        return isShieldComment;
    }

    public void setShieldComment(Boolean shieldComment) {
        isShieldComment = shieldComment;
    }
}