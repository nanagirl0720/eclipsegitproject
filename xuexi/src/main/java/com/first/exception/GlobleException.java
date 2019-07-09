package com.first.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobleException {

	/**
	 * 所有的算数异常(java.lang.ArithmeticException)都进入这个方法
	 * @return	ModelAndView返回值是为了封装异常信息以及指定视图
	 * e 传入页面异常对象
	 */
	@ExceptionHandler(value= {java.lang.ArithmeticException.class,java.lang.NullPointerException.class})
	public ModelAndView suanshuExceptionHandler(Exception e) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("error", e.toString());
		mav.setViewName("error/error_zdy");
		return mav;
	}
}
