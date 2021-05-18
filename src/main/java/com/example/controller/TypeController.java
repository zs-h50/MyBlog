package com.example.controller;

import com.example.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 20:08 2021/5/18
 * @ Description：分类
 */
@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     *
     * @return
     */
    @GetMapping(value = "/admin/types")
    public String list(Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        //按照排序字段，倒序
        String orderBy = "id desc";

        return "admin/adtype";
    }

}
