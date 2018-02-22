package com.garfield.travelnote.biz.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by treezhu on 2017/5/23.
 */
@Service
@Scope("singleton")
@DisconfFile(filename = "mysql.properties")
public class MysqlConfig {

    private String dataSourceUrl;
    private String dataSourceDriverClassName;
    private String dataSourceUsername;
    private String dataSourcePassword;

    @DisconfFileItem(name="spring.datasource.url")
    public String getDataSourceUrl() {
        return dataSourceUrl;
    }

    public void setDataSourceUrl(String dataSourceUrl) {
        this.dataSourceUrl = dataSourceUrl;
    }

    @DisconfFileItem(name="spring.datasource.driver-class-name")
    public String getDataSourceDriverClassName() {
        return dataSourceDriverClassName;
    }

    public void setDataSourceDriverClassName(String dataSourceDriverClassName) {
        this.dataSourceDriverClassName = dataSourceDriverClassName;
    }

    @DisconfFileItem(name="spring.datasource.username")
    public String getDataSourceUsername() {
        return dataSourceUsername;
    }

    public void setDataSourceUsername(String dataSourceUsername) {
        this.dataSourceUsername = dataSourceUsername;
    }

    @DisconfFileItem(name="spring.datasource.password")
    public String getDataSourcePassword() {
        return dataSourcePassword;
    }

    public void setDataSourcePassword(String dataSourcePassword) {
        this.dataSourcePassword = dataSourcePassword;
    }

}
