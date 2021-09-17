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
		logger.info(">>> notice / ");
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
	
	// �Խù� �󼼺��� ȭ��
	@PostMapping("/detailContent.do")
	public ModelAndView content(BoardDTO board) {
		
		BoardDTO boardInfo = noticeService.getContentByCon_No(board);		
		ModelAndView mv = new ModelAndView();
		
		logger.info(">>> detailContent.do");
		mv.setViewName("/notice/detailContent");
		mv.addObject("boardInfo", boardInfo);
		
		return mv;
	}
	
	// �Խù� ���� ��� ȭ��
	@PostMapping("/editContent.do")
	public ModelAndView editContent(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
		
		logger.info(">>> editContent.do");
		mv.setViewName("/notice/editContent");
		mv.addObject("boardInfo", board);
		
		return mv;
	}
	
	// ���� ���� ȭ��
	@PostMapping("/identification.do")
	public ModelAndView identification(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
		
		logger.info(">>> identification.do");
		mv.setViewName("/notice/identification");
		mv.addObject("boardInfo", board);
		
		return mv;
	}
	
	// ���� ���� ó�� �ܰ�
	@PostMapping("/checkIdentify.do")
	public ModelAndView checkIdentify(BoardDTO board) { // key = 2 ����, 3 ����
		
		ModelAndView mv = new ModelAndView();
		
		
		
		mv.setViewName("/notice/identification");
		mv.addObject("flag", noticeService.checkIdentify(board)); // ���� ���� Ȯ�� ���� ���� ���� True or False
		mv.addObject("key", board.getKey()); // �������� ���� ���� ��û�̾����� �Ǵ�
		mv.addObject("boardInfo", board);
		
		
		logger.info(">>> checkIdentify.do �������� ó�� ��� : " + noticeService.checkIdentify(board) + " " + board.getKey());
		return mv;
	}
	
	// �Խù� �ۼ� ó��
	@PostMapping("/write.do")
	public ModelAndView write(HttpServletRequest request, BoardDTO board) {
				
		ModelAndView mv = new ModelAndView();
		
		noticeService.writeBoard(request, board);
		mv.setViewName("redirect:/notice/");
		
				
		return mv;
	}
	
	// ���� ó�� ���� �ۼ� / delete.do
	@PostMapping("/delete.do")
	public ModelAndView delete(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
		logger.info(">>> delete.do");
		
		noticeService.deleteContent(board);
		
		mv.setViewName("redirect:/notice/");
		return mv;
	}
	
	// �Խù� ���� ���� �ۼ� /edit.do
	@PostMapping("/edit.do")
	public ModelAndView edit(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
		logger.info(">>> edit.do" + board.toString());
		
		int result = noticeService.editContent(board);
		
		mv.setViewName("redirect:/notice/");
		return mv;
	}
}
