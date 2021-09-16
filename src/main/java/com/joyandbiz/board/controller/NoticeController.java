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
	
	// 게시물 상세보기 화면
	@PostMapping("/detailContent.do")
	public ModelAndView content(BoardDTO board) {
		
		BoardDTO boardInfo = noticeService.getContentByCon_No(board);		
		ModelAndView mv = new ModelAndView();
		
		logger.info(">>> detailContent.do");
		mv.setViewName("/notice/detailContent");
		mv.addObject("boardInfo", boardInfo);
		
		return mv;
	}
	
	// 게시물 수정 등록 화면
	@PostMapping("/editContent.do")
	public ModelAndView editContent(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
		
		logger.info(">>> editContent.do");
		mv.setViewName("/notice/editContent");
		mv.addObject("boardInfo", board);
		
		return mv;
	}
	
	// 본인 인증 화면
	@PostMapping("/identification.do")
	public ModelAndView identification(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
		
		logger.info(">>> identification.do");
		mv.setViewName("/notice/identification");
		mv.addObject("boardInfo", board);
		
		return mv;
	}
	
	// 본인 인증 처리 단계
	@PostMapping("/checkIdentify.do")
	public ModelAndView checkIdentify(BoardDTO board) { // key = 1 수정, 2 삭제
		
		ModelAndView mv = new ModelAndView();
		
		logger.info(">>> checkIdentify.do");
		
		mv.setViewName("/notice/identification");
		mv.addObject("flag", noticeService.checkIdentify(board));
		mv.addObject("key", board.getKey());// 본인 인증 확인 여부 True or False
		mv.addObject("boardInfo", board);
		
		return mv;
	}
	
	// 게시물 작성 처리
	@PostMapping("/write.do")
	public ModelAndView write(HttpServletRequest request, BoardDTO board) {
				
		ModelAndView mv = new ModelAndView();
		
		logger.info(">>> write.do");
		mv.setViewName("redirect:/notice/");
		
		noticeService.writeBoard(request, board);
		
		return mv;
	}
	
	// 삭제 처리 매핑 작성 / delete.do
	
	
	// 게시물 수정 메핑 작성 /edit.do
}
