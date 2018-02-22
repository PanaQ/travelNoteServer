package com.garfield.travelnote.api.bean;

/**
 * 应用版本信息
 * Created by guofe on 2016/6/3.
 */
public class AppVersionBean {

    public String id;

    /**
     * 版本号
     */
    public Integer versionCode;

    /**
     * 版本名称
     */
    public String versionName;

    /**
     * 强制升级的版本
     */
    public Integer forceVersion;

    /**
     * 更新内容
     */
    public String updateDescription;

    /**
     * 对象存储键名
     */
    public String objectKey;

    /**
     * 下载链接
     */
    public String downloadUrl;

    /**
     * 文件大小
     */
    public long fileSize;

    /**
     * 文件MD5值
     */
    public String md5Value;
}
