package com.garfield.travelnote.common.bean;

/**
 * @author treezhu
 * @version 1.0
 * @date 2018/2/25 18:10
 */
public class LoginBean {

    private String login;

    private String password;

    private String captcha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
