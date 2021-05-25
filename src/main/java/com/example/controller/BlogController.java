package com.example.controller;

import com.example.pojo.Blog;
import com.example.service.BlogService;
import com.example.service.TagService;
import com.example.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 15:15 2021/5/18
 * @ Description：博客控制器
 */
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    /**
     * 查询分类和标签的所有记录
     * @param model
     */
    public void setTypeAndTag(Model model){
        model.addAttribute("type",typeService.getAllType());
        model.addAttribute("tag",tagService.getAllTag());
    }

    @PostMapping(value = "/admin/adblog")
    public String adblog(Model model, @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Blog> aLlBlog = blogService.getALlBlog();
        PageInfo<Blog> pageInfo = new PageInfo<>(aLlBlog);
        model.addAttribute("pageInfo",pageInfo);
        setTypeAndTag(model);
        return "admin/adblog";
    }

    @GetMapping(value = "/admin/adblog/search")
    public String search(Blog blog,
                         Model model,
                         @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Blog> aLlBlog = blogService.searchAllBlog(blog);
        PageInfo<Blog> pageInfo = new PageInfo<>(aLlBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("message", "查询成功");
        setTypeAndTag(model);
        return "admin/adblog";
    }

}
