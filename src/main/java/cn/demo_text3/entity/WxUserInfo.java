package cn.demo_text3.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.core.serializer.Serializer;

import java.io.Serializable;
import java.util.Date;

// 微信用户信息实体
@TableName("t_wxuserinfo")
@Data
public class WxUserInfo implements Serializable {
    private Integer id;   // 用户编号
    private String openid;  // 用户唯一标识
    private String nickName;   // 用户昵称
    private String avatarUrl;  // 用户头像图片的 URL

    @JsonSerialize(using=CustomDateTimeSerializer.class)
    private Date registerDate;    // 注册日期

    @JsonSerialize(using=CustomDateTimeSerializer.class)
    private Date lastLoginDate;   // 最后登录日期

    @TableField(select = false, exist = false)
    private String code;     // 微信用户code 前端传来的（临时的数据，不存在数据库）

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
