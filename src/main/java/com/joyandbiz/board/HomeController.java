package com.joyandbiz.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("getBoardList", boardService.getBoardList());
		
		return "home";
	}
	
	@GetMapping("/content")
	public String content(Model model, String con_no) {
		model.addAttribute("content", boardService.getContentByCon_No(con_no));
		
		return "content";
	}
	
	@GetMapping("/editContent")
	public String editContent(Model model, int key) {
		model.addAttribute("key", key);
		
		return "editContent";
	}
	
	@GetMapping("/identification")
	public String identification(Model model, int key) {
		model.addAttribute("key", key);
		
		return "identification";
	}
}
