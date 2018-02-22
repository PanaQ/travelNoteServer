package com.garfield.travelnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * 应用启动类
 *
 * @author chenx
 * @date 2016/4/18
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.garfield.travelnote"})
//@PropertySource(value= "classpath:config.properties")
@ImportResource({"classpath:disconf.xml"})//引入disconf
public class Application extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    /**
     * 应用入口函数
     *
     * @param args 运行参数
     *
     * @author chenx
     * @date 2016/4/18
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
