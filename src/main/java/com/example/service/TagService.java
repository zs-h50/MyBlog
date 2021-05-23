package com.example.service;

import com.example.pojo.Tag;

import java.util.List;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 20:32 2021/5/23
 * @ Description：业务接口
 */
public interface TagService {
    /**
     * 查询所有标签
     * @return
     */
    List<Tag> getAllTag();

    /**
     * 查询标签名称
     * @param name
     * @return
     */
    Tag getTagByName(String name);

    /**
     * 添加标签
     * @param tag
     * @return
     */
    int insert(Tag tag);

    /**
     * 根据id查询标签记录
     * @param id
     * @return
     */
    Tag selectByPrimaryKey(Long id);

    /**
     * 修改标签名称
     * @param tag
     * @return
     */
    int updateTag(Tag tag);

    /**
     * 删除标签
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);
}
