package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 10:42 2021/5/18
 * @ Description：用户登录控制器
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value ="/admin")
    public String loginPage(){
      return "admin/login";
    }

    @GetMapping(value ="/admin/login")
    public String loginPage1(){
        return "admin/login";
    }

    @GetMapping(value = "/admin/adindex")
    public String adindex(){
        return "admin/adindex";
    }

    /**
     * 登录校验
     * @param username 用户名
     * @param password 密码
     * @param session session域
     * @param attributes 返回页面消息
     * @return 登录成功跳转登录成功页面，登录失败返回登录页面
     */
    @PostMapping(value = "/admin/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        RedirectAttributes attributes){
        User user = userService.checkUser(username,password);
        if (user != null){
            user.setPassword(null);
            session.setAttribute("user",user);
            System.out.println(user);
            return "admin/adindex";
        } else{
            /**
             * 为什么不用Model
             * 因为Model适用在当前请求域中，重点后为另外一个请求
             */
            attributes.addFlashAttribute("message","用户名或密码错误，请重新输入！");
            return "redirect:/admin"; //重定向到admin
        }
    }

    @GetMapping(value = "/admin/logout")
    public String logout(HttpSession session){
        //清空session
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
