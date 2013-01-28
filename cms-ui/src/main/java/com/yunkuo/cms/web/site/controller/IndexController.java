package com.yunkuo.cms.web.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test(){
		ModelAndView mav=new ModelAndView();		
		return mav;
	}
}
