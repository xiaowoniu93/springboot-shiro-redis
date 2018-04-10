package com.xszheng.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alibaba.fastjson.JSON;
import com.xszheng.util.JsonUtil;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=Exception.class)
	public JSON defaultErrorHandler(HttpServletRequest request, Exception e){
		return JsonUtil.newJson().addCode(400).addMessage(e.getMessage()).toJson();
	}
	
}
