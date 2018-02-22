package com.garfield.travelnote.biz.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.springframework.stereotype.Component;

@Component
@DisconfFile(filename = "redis.properties")
public class RedisDisconfConfig {

    private String redisHost;

    private String redisPassword;

    private int redisPort;

    private int redisTimeOut;

    @DisconfFileItem(name = "spring.redis.host")
    public String getRedisHost() {
        return redisHost;
    }

    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    @DisconfFileItem(name = "spring.redis.password")
    public String getRedisPassword() {
        return redisPassword;
    }

    public void setRedisPassword(String redisPassword) {
        this.redisPassword = redisPassword;
    }

    @DisconfFileItem(name = "spring.redis.port")
    public int getRedisPort() {
        return redisPort;
    }

    public void setRedisPort(int redisPort) {
        this.redisPort = redisPort;
    }

    @DisconfFileItem(name = "spring.redis.timeout")
    public int getRedisTimeOut() {
        return redisTimeOut;
    }

    public void setRedisTimeOut(int redisTimeOut) {
        this.redisTimeOut = redisTimeOut;
    }
}
