package com.joyandbiz.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.joyandbiz.board.domain.BoardDTO;
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
	
	@PostMapping("/write.do")
	public ModelAndView write(HttpServletRequest request, BoardDTO board) {
		IPConfig ip = new IPConfig();
		ModelAndView mv = new ModelAndView();

		String yourIP = ip.getIPConfig(request);
		board.setReg_ip(yourIP);
		
		mv.setViewName("redirect:/list.do");
		boardService.writeBoard(board);
		
		return mv;
	}
	
	@GetMapping("/content")
	public ModelAndView content(String con_no) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("content");
		mv.addObject("content", boardService.getContentByCon_No(con_no));
		System.out.println(boardService.getContentByCon_No(con_no));
		mv.addObject("con_no", con_no);
		
		return mv;
	}
	
	@GetMapping("/editContent")
	public ModelAndView editContent(int key) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editContent");
		mv.addObject("key", key);
		
		return mv;
	}
	
	@GetMapping("/identification.do")
	public ModelAndView identification(int key, String con_no) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("identification");
		mv.addObject("key", key);
		mv.addObject("con_no", con_no);
		return mv;
	}
	
	@PostMapping("/update")
	@ResponseBody // 비동기로 구현할것 게시글 수정
	public BoardDTO test(BoardDTO dto) {
		System.out.println(dto.getCon_id());
		
		return dto;
	}
}
