package com.example.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 11:44 2021/5/17
 * @ Description：全局异常处理
 */

@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截异常信息
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e){
        //记录异常信息
        logger.error("Request URL : {},Exception : {}",request.getRequestURL(),e);

        //判断异常是否带有状态码
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) !=null){
            try {
                throw e;
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        //把错误信息返回到错误页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("Exception",e);
        //转发到的页面
        mv.setViewName("error/error");
        return mv;
    }
}
