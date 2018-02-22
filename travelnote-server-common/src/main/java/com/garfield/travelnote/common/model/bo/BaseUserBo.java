package com.garfield.travelnote.common.model.bo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

/**
 * Created by Jingly on 2018/2/22.
 */
public class BaseUserBo {
    /**
     * 登录名
     */
    @NotEmpty(message = "用户名不能为空")
    private String name;

    /**
     * 手机号
     */
    @NotEmpty
    @Pattern(regexp = "^[1][34578][0-9]{9}$")
    private String phone;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;
    /**
     * 确定密码
     */
    @NotEmpty(message = "确认密码不能为空")
    private String confirmPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
