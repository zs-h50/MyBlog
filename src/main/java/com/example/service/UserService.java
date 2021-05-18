package com.example.service;

import com.example.pojo.User;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 10:24 2021/5/18
 * @ Description：用户登录业务
 */
public interface UserService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User checkUser(String username, String password);
}
