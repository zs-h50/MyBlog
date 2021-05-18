package com.example.mapper;

import com.example.pojo.BlogTags;

public interface BlogTagsMapper {
    int insert(BlogTags record);

    int insertSelective(BlogTags record);
}