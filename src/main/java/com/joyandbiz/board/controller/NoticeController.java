package com.joyandbiz.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.joyandbiz.board.domain.BoardDTO;
import com.joyandbiz.board.service.NoticeService;

@RequestMapping("/notice")
@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	Logger logger = LoggerFactory.getLogger(this.getClass());
		
	@GetMapping("/")
	public ModelAndView root() {	
		
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("redirect:/notice/list.do");
		
		return mv;
	}
	@GetMapping("/list.do")
	public ModelAndView list(BoardDTO board) {
		
		List<BoardDTO> BoardList = noticeService.getBoardList(board);	
		logger.info(">>> list.do");
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/notice/boardList");
		mv.addObject("boardList", BoardList);
		
		return mv;
	}
	
	@PostMapping("/write.do")
	public ModelAndView write(HttpServletRequest request, BoardDTO board) {
				
		ModelAndView mv = new ModelAndView();
		
		logger.info(">>> write.do");
		mv.setViewName("redirect:/notice/");
		
		noticeService.writeBoard(request, board);
		
		return mv;
	}
	
	@PostMapping("/detailContent.do")
	public ModelAndView content(BoardDTO board) {
		
		BoardDTO contentInfo = noticeService.getContentByCon_No(board);		
		ModelAndView mv = new ModelAndView();
		
		logger.info(">>> detailContent.do");
		mv.setViewName("/notice/detailContent");
		mv.addObject("content", contentInfo);
		
		return mv;
	}
	
	@PostMapping("/editContent.do")
	public ModelAndView editContent(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
		
		logger.info(">>> editContent.do");
		mv.setViewName("/notice/editContent");
		mv.addObject("key", board.getKey());
		
		return mv;
	}
	
	@PostMapping("/identification.do")
	public ModelAndView identification(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
		
		logger.info(">>> identification.do");
		mv.setViewName("/notice/identification");
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
