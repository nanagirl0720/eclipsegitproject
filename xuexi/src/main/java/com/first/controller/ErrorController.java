package com.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	/*@RequestMapping("/errorzdy")	//	自定义异常页面内容error.html
	public String erronZdy() {
		String str=null;
		str.length();
		int a=2;
		a=a/0;
		return "index";
	}*/
	
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
