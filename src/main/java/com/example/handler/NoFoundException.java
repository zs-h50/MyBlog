package com.example.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 12:20 2021/5/17
 * @ Description：自定义异常处理
 */
//返回状态码
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoFoundException extends RuntimeException{

    public NoFoundException() {
        super();
    }

    public NoFoundException(String message) {
        super(message);
    }

    public NoFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
