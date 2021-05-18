package com.example.service.Imp;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 10:26 2021/5/18
 * @ Description：用户登录业务实现类
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public User checkUser(String username, String password) {
        User user = userMapper.findUser(username,password);
        return user;
    }
}
