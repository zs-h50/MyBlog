package com.example.mapper;

import com.example.pojo.Tag;

import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    /**
     * 查询全部记录
     * @return
     */
    List<Tag> getAllTag();

    /**
     *
     * @param name
     * @return
     */
    Tag getTagByName(String name);
}