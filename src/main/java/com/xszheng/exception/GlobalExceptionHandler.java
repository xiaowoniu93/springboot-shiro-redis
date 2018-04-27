package com.xszheng.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alibaba.fastjson.JSON;
import com.xszheng.util.JsonUtil;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public JSON defaultErrorHandler(HttpServletRequest request, Exception e){
		if(e instanceof MethodArgumentNotValidException){
			MethodArgumentNotValidException manve = (MethodArgumentNotValidException)e;
			String str = manve.getBindingResult().getFieldError().getDefaultMessage();
			return JsonUtil.newJson().addCode(400).addMessage(str).toJson();
		}
		return JsonUtil.newJson().addCode(400).addMessage(e.getMessage()).toJson();
	}
	
}
