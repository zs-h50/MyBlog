package com.example.config;

import com.example.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 16:07 2021/5/18
 * @ Description：自定义配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration Registration = registry.addInterceptor(new LoginInterceptor());
        Registration.addPathPatterns("/admin/**");  //拦截/admin/所有的请求路径
        Registration.excludePathPatterns("/admin");   //不需要拦截路径
        Registration.excludePathPatterns("/admin/login");      //不需要拦截路径
        //WebMvcConfigurer.super.addInterceptors(registry);
    }
}
