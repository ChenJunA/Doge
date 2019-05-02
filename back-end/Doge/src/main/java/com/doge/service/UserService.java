package com.doge.service;

import com.doge.entity.User;

import java.util.Map;

/**
 * @Description: 用户相关操作
 * @Author: chenjun
 * @Date: 2019/4/12 10:53
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @param user
     */
    void insertUser(User user) throws Exception;

    /**
     * 登录
     */
    Map login(User user) throws Exception;

    /**
     * 登出
     */
    void logout() throws Exception;

    /**
     * 更新用户资料
     *
     * @param user
     */
    User updateUser(User user) throws Exception;

    /**
     * 删除用户
     *
     * @param userId
     */
    void deleteUser(long userId) throws Exception;

    /**
     * 激活
     */
    void active(Long userId) throws Exception;

    /**
     * 根据用户名查找用户
     *
     * @param userName
     */
    User getUserByName(String userName) throws Exception;

    /**
     * 根据邮箱查找用户
     *
     * @param email
     */
    User getUserByEmail(String email) throws Exception;

    /**
     * 根据ID查找用户
     *
     * @param userId
     */
    User getUserById(Long userId) throws Exception;

    /**
     * 封禁用户
     *
     * @param userId
     */
    void ban(Long userId) throws Exception;
}
