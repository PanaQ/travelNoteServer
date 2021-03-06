package com.garfield.travelnote.config;

import com.garfield.travelnote.biz.shiro.filter.TokenAuthenticationFilter;
import com.garfield.travelnote.biz.shiro.realm.UserLoginRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author treezhu
 * @version 1.0
 * @date 2018/2/25 18:42
 */
@Configuration
public class ShiroConfiguration {

    @Bean
    public FilterRegistrationBean registration(TokenAuthenticationFilter tokenAuthenticationFilter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(tokenAuthenticationFilter);
        registration.setEnabled(false);
        return registration;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager, TokenAuthenticationFilter tokenAuthenticationFilter) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        //配置登录的url和登录成功的url
        bean.setLoginUrl("/user/login");
        Map<String,Filter> filters = new HashMap<>();
        filters.put("tokenAuthenticationFilter",tokenAuthenticationFilter);
        bean.setFilters(filters);
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/user/register","anon");
        filterChainDefinitionMap.put("/note/uploadPicture","anon");
        filterChainDefinitionMap.put("/note/uploadVideo","anon");
        filterChainDefinitionMap.put("/note/getNoteList","anon");
        filterChainDefinitionMap.put("/upload/**","anon");
        filterChainDefinitionMap.put("/mateNote/getMateNoteList","anon");
        filterChainDefinitionMap.put("/division/*","anon");
        filterChainDefinitionMap.put("/**", "tokenAuthenticationFilter");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    //配置核心安全事务管理器
    @Bean(name = "securityManager")
    public SecurityManager securityManager(UserLoginRealm loginRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(loginRealm);
        return manager;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }
}