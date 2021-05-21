package com.example.mapper;

import com.example.pojo.Type;

import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Type record);

    int insertSelective(Type record);

    /**
     * 根据id查询分类
     * @param id
     * @return
     */
    Type selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    /**
     * 分页查询
     * @return
     */
    List<Type> getAllType();


     /*
     查询分类名称
      */
    Type getTypeByName(String name);




}
