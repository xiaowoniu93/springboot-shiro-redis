package com.xszheng.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.alibaba.fastjson.JSON;
import com.xszheng.util.JsonUtil;

@Aspect
@Component
public class ControllerValidatorAspect {

	@Around("execution(* com.xszheng.controller.*.*(..)) && args(..,result)")
	public JSON doAround(ProceedingJoinPoint pjp, BindingResult result) throws Exception{
		if(result.hasErrors()){
			return JsonUtil.newJson().addCode(400).addMessage(result.getFieldError().getDefaultMessage()).toJson();
		}else{
			return JsonUtil.newJson().toJson();
		}
	}
	
}
