package com.doge.config.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2019/4/14 14:12
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("authc", new AjaxPermissionsAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         * 常用的过滤器：
         * anon：无需认证（登录）可以访问
         * authc：必须认证才可以访问
         * user：如果使用rememberMe的功能可以直接访问
         * perms：该资源必须得到资源权限才可以访问
         * role：该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();

        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/register", "anon");
        filterChainDefinitionMap.put("/getUserByEmail", "anon");
        filterChainDefinitionMap.put("/active/*", "anon");
        filterChainDefinitionMap.put("/dog","anon");

        filterChainDefinitionMap.put("/dogPicsUpload","anon");

        filterChainDefinitionMap.put("/listDogsByFosterId","anon");
        filterChainDefinitionMap.put("/listDogsByAdoptId","anon");
        filterChainDefinitionMap.put("/updateUser","anon");
        filterChainDefinitionMap.put("/getDogById/*","anon");
        filterChainDefinitionMap.put("/findUserById","anon");
        filterChainDefinitionMap.put("/listByType/*","anon");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("dogeRealm") DogeRealm dogeRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(dogeRealm);
        return securityManager;

    }

    /**
     * 创建Realm
     */
    @Bean(name = "dogeRealm")
    public DogeRealm getRealm() {
        return new DogeRealm();
    }
}
