package com.joyandbiz.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		
		return "home";
	}
	
	@GetMapping("/searchMember")
	public String db_test(Model model) throws Exception {
		model.addAttribute("member", memberService.getListMember());
		 
		return "memberList";
	}
}
