package com.joyandbiz.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.joyandbiz.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public ModelAndView root() {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("redirect:/list.do");

		return mv;
	}
	
	@GetMapping("/list.do")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boardList");
		mv.addObject("getBoardList", boardService.getBoardList());
		
		return mv;
	}
	
	@GetMapping("/content")
	public ModelAndView content(Model model, String con_no) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("content");
		mv.addObject("content", boardService.getContentByCon_No(con_no));
		
		return mv;
	}
	
	@GetMapping("/editContent")
	public ModelAndView editContent(Model model, int key) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editContent");
		mv.addObject("key", key);
		
		return mv;
	}
	
	@GetMapping("/identification")
	public ModelAndView identification(Model model, int key) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("identification");
		mv.addObject("key", key);
		
		return mv;
	}
}
