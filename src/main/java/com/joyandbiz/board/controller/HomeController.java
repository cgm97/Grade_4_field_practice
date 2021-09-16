package com.joyandbiz.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView root() {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("redirect:/notice/list.do");
		
		return mv;
	}
}
