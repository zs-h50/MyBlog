package com.example.service;

import com.example.pojo.Type;

import java.util.List;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 17:24 2021/5/18
 * @ Description：分类业务
 */
public interface TypeService {

    /**
     * 分页
     * @return
     */
    List<Type> getAllType();

    /**
     * 增加分类
     * @param record
     * @return
     */
    int insert(Type record);

    /**
     * 查询数据库已存在分类名称
     * @param name
     * @return
     */
    Type getTypeByName(String name);

    /**
     * 查询
     * @param id
     * @return
     */
    Type selectByPrimaryKey(Long id);
}
