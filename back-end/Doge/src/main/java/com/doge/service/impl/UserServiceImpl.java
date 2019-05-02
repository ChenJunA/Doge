package com.doge.service.impl;

import com.doge.entity.User;
import com.doge.entity.UserExample;
import com.doge.enums.StatusCode;
import com.doge.mapper.UserMapper;
import com.doge.service.UserService;
import io.swagger.models.auth.In;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2019/4/12 10:54
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    JavaMailSenderImpl mailSender;

    @Override
    public void insertUser(User user) throws Exception {
        //设置默认用户名为邮箱账号
        user.setUsername(user.getEmail());

        //设置默认头像和封面图片
        user.setAvatar("https://i.loli.net/2017/08/21/599a521472424.jpg");
        user.setPicture("");
        userMapper.insertSelective(user);
        //发送邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //设置收件人、寄件人
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setFrom("cj_chenjuna@163.com");
        simpleMailMessage.setSubject("激活邮件");
        simpleMailMessage.setText("请点击链接完成激活:http://localhost:80/active/" + user.getId());
        //发送邮件
        mailSender.send(simpleMailMessage);
    }

    @Override
    public Map login(User user) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        String username = user.getUsername();
        String password = user.getPassword();
        Subject currentUser = SecurityUtils.getSubject();

        //是否已登录
        if (!currentUser.isAuthenticated()) {
            //封装用户数据
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException e) {
                //用户不存在
                map.put("statusCode", StatusCode.USERNAME_ERROR.getCode());
            } catch (IncorrectCredentialsException e) {
                //密码错误
                map.put("statusCode", StatusCode.PASSWORD_ERROR.getCode());
            } catch (AuthenticationException e) {
                map.put("statusCode",StatusCode.UNKNOWN_ERROR.getCode());
            }
        }
        return map;
    }

    @Override
    public void logout() throws Exception {
        SecurityUtils.getSubject().logout();
    }

    @Override
    public User updateUser(User user) throws Exception {
        userMapper.updateByPrimaryKeySelective(user);
        User respUser = getUserById(user.getId());
        return respUser;
    }

    @Override
    public void deleteUser(long userId) throws Exception {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public User getUserByName(String userName) throws Exception {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public void active(Long userId) throws Exception {
        User user = getUserById(userId);
        user.setIsActive(true);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getUserByEmail(String email) throws Exception {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andEmailEqualTo(email);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public User getUserById(Long userId) throws Exception {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public void ban(Long userId) throws Exception {
        User user = getUserById(userId);
        user.setIsBan(true);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
