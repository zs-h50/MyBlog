package com.example.service.Imp;

import com.example.mapper.BlogMapper;
import com.example.pojo.Blog;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 9:29 2021/5/24
 * @ Description：博客业务接口实现
 */
@Service
@Transactional
public class BlogServiceImp implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    /**
     * 查询全部记录
     * @return
     */
    @Override
    public List<Blog> getALlBlog() {
        return blogMapper.getALlBlog();
    }

    /**
     * 条件查询
     * @param blog
     * @return
     */
    @Override
    public List<Blog> searchAllBlog(Blog blog) {
        return blogMapper.searchAllBlog(blog);
    }
}
