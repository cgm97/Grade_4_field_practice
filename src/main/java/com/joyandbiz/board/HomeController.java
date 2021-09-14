package com.joyandbiz.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joyandbiz.board.domain.BoardDTO;

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
	public String content() {
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
