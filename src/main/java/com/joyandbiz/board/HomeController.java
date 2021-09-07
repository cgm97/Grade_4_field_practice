package com.joyandbiz.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joyandbiz.board.domain.MemberDTO;

@Controller
public class HomeController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		
		return "home";
	}
	
	@PostMapping("/searchMember")
	public String db_test(Model model) throws Exception {
		model.addAttribute("member", memberService.getListMember());
		 
		return "memberList";
	}
	
	@PostMapping("/addMember.do")
	public String insertMember(Model model, MemberDTO dto) throws Exception {
		memberService.insertMember(dto);
		return "home";
	}
	
	@GetMapping("/addMember")
	public String st(Model model) throws Exception {
		
		return "addMember";
	}
}
