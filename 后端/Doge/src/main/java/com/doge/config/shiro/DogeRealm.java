package com.doge.config.shiro;

import com.doge.entity.User;
import com.doge.enums.StatusCode;
import com.doge.exception.DogeException;
import com.doge.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2019/4/14 14:14
 */
public class DogeRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 执行认证逻辑
     *
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException{
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User nameUser = null;
        try {
            nameUser = userService.findByName(username);
        } catch (Exception e) {
            throw new DogeException(StatusCode.USERNAME_ERROR);
        }

        if(nameUser == null){
            throw new UnknownAccountException("用户不存在");
        }
        return new SimpleAuthenticationInfo("", nameUser.getPassword(), "");
    }
}
