package com.example.mapper;

import com.example.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 查询用户名和密码
     * @param username
     * @param password
     * @return
     */
    User findUser(String username,String password);
}