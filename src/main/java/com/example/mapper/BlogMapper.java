package com.example.mapper;

import com.example.pojo.Blog;

import java.util.List;

public interface BlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);

    List<Blog> getALlBlog();

    List<Blog> searchAllBlog(Blog blog);
}