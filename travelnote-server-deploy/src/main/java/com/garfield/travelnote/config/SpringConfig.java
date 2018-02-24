package com.garfield.travelnote.config;

import com.garfield.travelnote.dal.util.UpdateInterceptor;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Mybatis Spring 配置类
 *
 * @author chenx
 * @date 2016/4/19
 */
@Configuration
@MapperScan(basePackages = {"com.garfield.travelnote.dal.mapper"})
public class SpringConfig {

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://192.168.30.174:3306/travel_note?characterEncoding=utf-8&amp;useSSL=false");
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("123456");
        //连接池中允许的最大连接数。缺省值：10；推荐的公式：((core_count * 2) + effective_spindle_count)
        config.setMaximumPoolSize(10);
        //等待连接池分配连接的最大时长（毫秒）
        config.setConnectionTimeout(600000);
        //一个连接idle状态的最大时长（毫秒）
        config.setIdleTimeout(600000);
        //一个连接的生命时长（毫秒），超时而且没被使用则被释放（retired），缺省:30分钟，建议设置比数据库超时时长少30秒，
        // 参考MySQL wait_timeout参数（show variables like '%timeout%';）
        config.setMaxLifetime(28770000);

        HikariDataSource server_hikari = new HikariDataSource(config);
//        server_hikari.setPoolName("uriel_server_hikari");


        return server_hikari;
    }

    @Bean
    public RedisTemplate redisTemplate(JedisConnectionFactory connectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

    @Bean
    public HashOperations hashOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForHash();
    }

    @Bean
    public ValueOperations valueOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForValue();
    }

    /**
     * 给mybatis添加插件
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean(HikariDataSource dataSource) {
        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
        sfb.setDataSource(dataSource);

        Interceptor[] plugins = {new UpdateInterceptor()};
        sfb.setPlugins(plugins);

        return sfb;
    }
}
