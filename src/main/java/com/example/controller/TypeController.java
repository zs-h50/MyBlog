package com.example.controller;

import com.example.pojo.Type;
import com.example.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        PageHelper.startPage(pageNum,5);
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
    public String input(Model model){
        /*
        用于前端接收type中的name，然后校验
         */
        model.addAttribute("type",new Type());
        return "admin/typeinput";
    }

    @PostMapping(value = "/admin/types")
    public String typeinsert(Type type,
                             BindingResult result,
                             RedirectAttributes attributes){
        int i ;
        if (result.hasErrors()) {
            return "admin/typeinput";
        }
        if (typeService.getTypeByName(type.getName()) != null){
            /*
             查询是否插入相同的名称
             */
            //System.out.println("111111111111");
            attributes.addFlashAttribute("msg","分类名称已存在！请重新输入！");
            //.out.println("222222222222222");
            //return "redirect:/admin/types";
            return "redirect:/types/input";
        }

        i = typeService.insert(type);
        if (i != 0) {
            //增加成功情况
            attributes.addFlashAttribute("message", "添加成功！");
        } else {
            //添加失败情况
            attributes.addFlashAttribute("message", "添加失败！");
        }
        return "redirect:/admin/types"; //重定向到之前请求
    }

    /**
     * 修改分类名称
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/admin/types/{id}/input")
    public String edittpye(@PathVariable Long id,
                           Model model,
                           RedirectAttributes attributes){
        Type type = typeService.selectByPrimaryKey(id);
        attributes.addFlashAttribute("type",type);
        //model.addAttribute("Type",Type);
        return "admin/typeinput";
    }

}
