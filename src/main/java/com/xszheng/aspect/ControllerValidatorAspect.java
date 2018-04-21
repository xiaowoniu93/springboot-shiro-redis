package com.xszheng.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xszheng.util.JsonUtil;

@Component
@Aspect
public class ControllerValidatorAspect {
	
	@Pointcut("execution(* com.xszheng.controller.*.*(..)) && args(..,result)")
	public void methodPoint(){}

	@Around("execution(* com.xszheng.controller.*.*(..)) && args(..,result)")
	public Object doAround(ProceedingJoinPoint pjp, BindingResult result) throws Throwable{
		if(result.hasErrors()){
			return JsonUtil.newJson().addCode(400).addMessage(result.getFieldError().getDefaultMessage()).toJson();
		}else{
			Object object = pjp.proceed();
			return object;
		}
	}
	
//	@Before(value = "execution(* com.xszheng.controller.*.*(..)) && args(..,result)")
//	public JSON beforeMethod(JoinPoint point, BindingResult  result){
//		JSONObject json = new JSONObject();
//		if(result.hasErrors()){
//			return JsonUtil.newJson().addCode(400).addMessage(result.getFieldError().getDefaultMessage()).toJson();
//		} else {
//			return json;
//		}
//	}
	
}
