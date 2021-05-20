package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 15:15 2021/5/18
 * @ Description：博客控制器
 */
@Controller
public class BlogController {

    @Autowired
    //private BlogService blogService;

    @GetMapping(value = "/admin/adblog")
    public String adblog(){
        return "admin/adblog";
    }

}
