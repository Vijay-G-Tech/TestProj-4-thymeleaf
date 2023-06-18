package com.wip.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/emp")
	public ModelAndView details() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("Name", "Vijay");
		mav.addObject("Company", "TCS");
		mav.setViewName("details");
		return mav;
	}
}
