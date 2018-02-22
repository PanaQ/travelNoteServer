package com.garfield.travelnote.biz.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.garfield.travelnote.biz.service.ObjectStorageService;
import com.garfield.travelnote.biz.service.impl.ObjectStorageServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@DisconfFile(filename = "oss.properties")
public class OSSDisconfConfig {

    private String endPoint;

    private String accessKeyID;

    private String accessKeySecret;

    /**
     * app-ttt
     */
    private String bucket;

    private String imageService;

    private String roleArn;

    private String tokenExpireTime;

    private String readTokenExpireTime;

    /**
     * 格式：acs:oss:*:*:app-ttt/XXXX/
     */
    private String resource;

    private String ossEndpointOpen;


    @DisconfFileItem(name = "oss.access.key.id")
    public String getAccessKeyID() {
        return accessKeyID;
    }

    public void setAccessKeyID(String accessKeyID) {
        this.accessKeyID = accessKeyID;
    }

    @DisconfFileItem(name = "oss.access.key.secret")
    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    @DisconfFileItem(name = "oss.bucket")
    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    @DisconfFileItem(name = "oss.endpoint")
    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    @DisconfFileItem(name = "oss.imageservice")
    public String getImageService() {
        return imageService;
    }

    public void setImageService(String imageService) {
        this.imageService = imageService;
    }

    @DisconfFileItem(name = "oss.role.arn")
    public String getRoleArn() {
        return roleArn;
    }

    public void setRoleArn(String roleArn) {
        this.roleArn = roleArn;
    }

    @DisconfFileItem(name = "oss.token.expire.time")
    public String getTokenExpireTime() {
        return tokenExpireTime;
    }

    public void setTokenExpireTime(String tokenExpireTime) {
        this.tokenExpireTime = tokenExpireTime;
    }

    @DisconfFileItem(name = "oss.read.token.expire.time")
    public String getReadTokenExpireTime() {
        return readTokenExpireTime;
    }

    public void setReadTokenExpireTime(String readTokenExpireTime) {
        this.readTokenExpireTime = readTokenExpireTime;
    }


    @DisconfFileItem(name = "oss.resource")
    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @DisconfFileItem(name = "oss.endpoint.open")
    public String getOssEndpointOpen() {
        return ossEndpointOpen;
    }

    public void setOssEndpointOpen(String ossEndpointOpen) {
        this.ossEndpointOpen = ossEndpointOpen;
    }

    @Bean
    public ObjectStorageService objectStorageService() {
        return new ObjectStorageServiceImpl(endPoint, accessKeyID, accessKeySecret, bucket, imageService);
    }
}
