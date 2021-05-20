package com.example.controller;

import com.example.pojo.Type;
import com.example.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
     * 查询分页
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping(value = "/admin/types")
    public String types(Model model, @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum){
        //只对这次查询有效,pageNum表示当前页，pageSize条数
        PageHelper.startPage(pageNum,3);
        List<Type> allType = typeService.getAllType();
        PageInfo pageInfo = new PageInfo(allType);  //
        model.addAttribute("pageInfo",pageInfo);
        return "admin/adtype";
    }

    /**
     * 跳转到增加分类页面
     * @return
     */
    @GetMapping(value = "/types/input")
    public String input(){
        return "admin/typeinput";
    }

    @PostMapping(value = "/admin/types")
    public String typeinsert(@Validated Type type, BindingResult result, RedirectAttributes attributes){
        int i = 0;
        if (result.hasErrors()){
            return "admin/typeinput";
        }
        //在前端已经判断输入的不能为空
//        if (type != null){
//            i = typeService.insert(type);
//        }
        i = typeService.insert(type);
        if (i != 0){
            //增加成功情况
            attributes.addFlashAttribute("message","添加成功！");
        } else{
            //添加失败情况
            attributes.addFlashAttribute("message","添加失败！");
        }
        return "redirect:/admin/types" ; //重定向到之前请求
    }

}
