package com.web.eran.web.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
* @author Promise
* @createTime 2019年4月8日 下午4:29:12
* @description
*/
@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(value = AuthorizationException.class)
    public String errorHandler(Exception ex) {
       return "/common/403";
    }
}
