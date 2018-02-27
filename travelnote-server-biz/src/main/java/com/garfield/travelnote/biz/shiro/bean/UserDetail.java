package com.garfield.travelnote.biz.shiro.bean;

import com.garfield.travelnote.common.model.bo.UserBo;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

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

    @Indexed
    private Long userId;

    @TimeToLive
    private Long expire;

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

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
