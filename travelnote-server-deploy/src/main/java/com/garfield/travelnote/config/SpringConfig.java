package com.garfield.travelnote.config;

import com.garfield.travelnote.biz.config.MysqlConfig;
import com.garfield.travelnote.biz.config.RedisDisconfConfig;
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
    public HikariDataSource hikariDataSource(MysqlConfig dbConfig) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbConfig.getDataSourceUrl());
        config.setDriverClassName(dbConfig.getDataSourceDriverClassName());
        config.setUsername(dbConfig.getDataSourceUsername());
        config.setPassword(dbConfig.getDataSourcePassword());
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
    public JedisConnectionFactory connectionFactory(RedisDisconfConfig redisConfig) {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(redisConfig.getRedisHost());
        factory.setPassword(redisConfig.getRedisPassword());
        factory.setPort(redisConfig.getRedisPort());
        factory.setUsePool(true);
        factory.setTimeout(redisConfig.getRedisTimeOut());
        factory.getPoolConfig().setMaxIdle(-1);
        factory.getPoolConfig().setMaxTotal(-1);
        factory.getPoolConfig().setMaxWaitMillis(60000);
        return factory;
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
