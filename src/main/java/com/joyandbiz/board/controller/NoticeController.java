package com.joyandbiz.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.joyandbiz.board.IPConfig;
import com.joyandbiz.board.domain.BoardDTO;
import com.joyandbiz.board.service.NoticeService;

@RequestMapping("/notice")
@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/list.do")
	public ModelAndView list() {
		
		List<BoardDTO> BoardList = noticeService.getBoardList();		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("boardList");
		mv.addObject("boardList", BoardList);
		
		return mv;
	}
	
	@PostMapping("/write.do")
	public ModelAndView write(HttpServletRequest request, BoardDTO board) {
		
		IPConfig ip = new IPConfig();
		ModelAndView mv = new ModelAndView();

		String yourIP = ip.getIPConfig(request);
		board.setReg_ip(yourIP);
		
		mv.setViewName("redirect:/list.do");
		
		noticeService.writeBoard(board);
		
		return mv;
	}
	
	@PostMapping("/detailContent.do")
	public ModelAndView content(BoardDTO board) {
		
		BoardDTO contentInfo = noticeService.getContentByCon_No(board.getCon_no());		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("detailContent");
		mv.addObject("content", contentInfo);
		
		return mv;
	}
	
	@PostMapping("/editContent.do")
	public ModelAndView editContent(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("editContent");
		mv.addObject("key", board.getKey());
		
		return mv;
	}
	
	@PostMapping("/identification.do")
	public ModelAndView identification(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("identification");
		mv.addObject("key", board.getKey());
		mv.addObject("con_no", board.getCon_no());
		
		return mv;
	}
	
	@PostMapping("/update")
	@ResponseBody // 비동기로 구현할것 게시글 수정
	public BoardDTO test(BoardDTO dto) {
		System.out.println(dto.getCon_id());
		
		return dto;
	}
}
