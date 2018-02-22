package com.garfield.travelnote.api.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * device info schema
 * Created by konie on 16-8-25.
 */
public class DeviceInfoBean {
    private String deviceName;
    @JsonProperty("IMEI")
    private String IMEI;
    @JsonProperty("IMSI")
    private String IMSI;
    private String androidVersion;
    private String appVersion;
    private String iccId;
    private String channelId;
    private String others;

    public DeviceInfoBean() {

    }

    public DeviceInfoBean(String deviceName, String IMEI, String IMSI, String androidVersion,
                          String appVersion, String iccId, String channelId, String others) {
        this.deviceName = deviceName;
        this.IMEI = IMEI;
        this.IMSI = IMSI;
        this.androidVersion = androidVersion;
        this.appVersion = appVersion;
        this.iccId = iccId;
        this.channelId = channelId;
        this.others = others;
    }

    @JsonIgnore
    public String getIMEI() {
        return IMEI;
    }

    @JsonIgnore
    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    @JsonIgnore
    public String getIMSI() {
        return IMSI;
    }

    @JsonIgnore
    public void setIMSI(String IMSI) {
        this.IMSI = IMSI;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getIccId() {
        return iccId;
    }

    public void setIccId(String iccId) {
        this.iccId = iccId;
    }

}
