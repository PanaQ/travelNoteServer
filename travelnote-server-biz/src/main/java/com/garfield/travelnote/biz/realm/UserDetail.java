package com.garfield.travelnote.biz.realm;

import com.garfield.travelnote.common.model.bo.UserBo;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Objects;

/**
 * @author treezhu
 * @version 1.0
 * @date 2018/2/25 17:15
 */
@RedisHash
public class UserDetail {

    @Id
    private String token;

    private UserBo userBo;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserBo getUserBo() {
        return userBo;
    }

    public void setUserBo(UserBo userBo) {
        this.userBo = userBo;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserDetail) {
            return Objects.equals(this.token, ((UserDetail) obj).token);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }
}