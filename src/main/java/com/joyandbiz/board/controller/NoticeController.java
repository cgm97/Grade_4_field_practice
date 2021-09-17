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
import com.joyandbiz.board.domain.SearchDTO;
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
		logger.info(">>> notice / ");
		
		return mv;
	}
	@GetMapping("/list.do")
	public ModelAndView list(BoardDTO board) {
		
		List<BoardDTO> BoardList = noticeService.getBoardList(board);	
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/notice/boardList");
		mv.addObject("boardList", BoardList);
		logger.info(">>> list.do");
		
		return mv;
	}
	
	@PostMapping("/search.do")
	public ModelAndView search(SearchDTO sto) {
		
		List<BoardDTO> SearchedBoardList = noticeService.getSearchedBoardList(sto);	
		ModelAndView mv = new ModelAndView();
		
		if (sto.getKeyword() == "") {
			mv.setViewName("redirect:/notice/list.do");		
			logger.info(">>> search.do >> redirect:list.do");

		} else {
			mv.setViewName("/notice/boardList");	
			mv.addObject("boardList", SearchedBoardList);
			logger.info(">>> search.do " + sto.toString());
		}
		
		return mv;
	}
	
	// �Խù� �󼼺��� ȭ��
	@PostMapping("/detailContent.do")
	public ModelAndView content(BoardDTO board) {
		
		BoardDTO boardInfo = noticeService.getContentByCon_No(board);		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/notice/detailContent");
		mv.addObject("boardInfo", boardInfo);
		logger.info(">>> detailContent.do");
		
		return mv;
	}
	
	// �Խù� ���� ��� ȭ��
	@PostMapping("/editContent.do")
	public ModelAndView editContent(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/notice/editContent");
		mv.addObject("boardInfo", board);
		logger.info(">>> editContent.do");
		
		return mv;
	}
	
	// ���� ���� ȭ��
	@PostMapping("/identification.do")
	public ModelAndView identification(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
				
		mv.setViewName("/notice/identification");
		mv.addObject("boardInfo", board);
		logger.info(">>> identification.do");
		
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
		noticeService.deleteContent(board);
		
		mv.setViewName("redirect:/notice/");
		logger.info(">>> delete.do");
		
		return mv;
	}
	
	// �Խù� ���� ���� �ۼ� /edit.do
	@PostMapping("/edit.do")
	public ModelAndView edit(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
		noticeService.editContent(board);
		
		mv.setViewName("redirect:/notice/");
		logger.info(">>> edit.do" + board.toString());
		
		return mv;
	}
}
