package com.example.service;

import com.example.pojo.Blog;

import java.util.List;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 9:29 2021/5/24
 * @ Description：博客业务接口
 */
public interface BlogService {

    /**
     * 查询全部记录
     * @return
     */
    List<Blog> getALlBlog();

    /**
     * 条件查询
     * @param blog
     * @return
     */
    List<Blog> searchAllBlog(Blog blog);
}
