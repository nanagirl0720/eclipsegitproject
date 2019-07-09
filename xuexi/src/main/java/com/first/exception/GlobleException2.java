package com.first.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class GlobleException2 implements HandlerExceptionResolver{

	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv=new ModelAndView();
		//判断不同异常类型，做不同的视图跳转
		if(ex instanceof ArithmeticException) {
			mv.setViewName("error");
		}
		if(ex instanceof NullPointerException) {
			mv.setViewName("error/error_zdy");
		}
		mv.addObject("error", ex.toString());
		return mv;
	}
}
