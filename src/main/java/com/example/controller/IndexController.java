package com.example.controller;

import com.example.handler.NoFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 11:42 2021/5/17
 * @ Description：页面控制器
 */
@Controller
public class IndexController {
    @GetMapping(value = "/")
    public String index(){
//        String blog =null;
//        if (blog == null){
//            throw new NoFoundException("博客地址不存在！");
//        }
        int i = 10/0;
        return "index";
    }
}
