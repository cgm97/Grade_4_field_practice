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
import com.joyandbiz.board.PageMaker;
import com.joyandbiz.board.SearchCriteria;
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
		logger.info(">>> notice / ");
		
		return mv;
	}
	
	@GetMapping("/list.do")
	public ModelAndView list(SearchCriteria scri) {
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(noticeService.countBoardList(scri));
		
		List<BoardDTO> BoardList = noticeService.getBoardList(scri);	
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/notice/boardList");
		mv.addObject("boardList", BoardList);
		mv.addObject("pageMaker", pageMaker);
		
		logger.info(">>> list.do");
		
		return mv;
	}
	
	/*
	 * @PostMapping("/search.do") public ModelAndView search(SearchDTO sto, Criteria
	 * cri, HashMap<String, Object> map) { logger.info(">>> search.do " +
	 * sto.toString());
	 * 
	 * map.put("search", sto); map.put("cri", cri);
	 * 
	 * List<BoardDTO> SearchedBoardList = noticeService.getSearchedBoardList(map);
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * PageMaker pageMaker = new PageMaker(); pageMaker.setCri(cri);
	 * pageMaker.setTotalCount(noticeService.countBoardList(sto));
	 * 
	 * if (sto.getKeyword() == "") { mv.setViewName("redirect:/notice/list.do");
	 * logger.info(">>> search.do >> redirect:list.do");
	 * 
	 * } else { mv.setViewName("/notice/boardList"); mv.addObject("boardList",
	 * SearchedBoardList); mv.addObject("pageMaker", pageMaker);
	 * logger.info(">>> search.do " + sto.toString()); }
	 * 
	 * return mv; }
	 */
	
	// 게시물 상세보기 화면
	@PostMapping("/detailContent.do")
	public ModelAndView content(BoardDTO board) {
		
		BoardDTO boardInfo = noticeService.getContentByCon_No(board);		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/notice/detailContent");
		mv.addObject("boardInfo", boardInfo);
		logger.info(">>> detailContent.do");
		
		return mv;
	}
	
	// 게시물 수정 등록 화면
	@PostMapping("/editContent.do")
	public ModelAndView editContent(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/notice/editContent");
		mv.addObject("boardInfo", board);
		logger.info(">>> editContent.do");
		
		return mv;
	}
	
	// 본인 인증 화면
	@PostMapping("/identification.do")
	public ModelAndView identification(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
				
		mv.setViewName("/notice/identification");
		mv.addObject("boardInfo", board);
		logger.info(">>> identification.do");
		
		return mv;
	}
	
	// 본인 인증 처리 단계
	@PostMapping("/checkIdentify.do")
	public ModelAndView checkIdentify(BoardDTO board) { // key = 2 수정, 3 삭제
		
		ModelAndView mv = new ModelAndView();
			
		mv.setViewName("/notice/identification");
		mv.addObject("flag", noticeService.checkIdentify(board)); // 본인 인증 확인 성공 실패 여부 True or False
		mv.addObject("key", board.getKey()); // 수정인지 삭제 인증 요청이었는지 판단
		mv.addObject("boardInfo", board);			
		logger.info(">>> checkIdentify.do 본인인증 처리 결과 : " + noticeService.checkIdentify(board) + " " + board.getKey());
		
		return mv;
	}
	
	// 게시물 작성 처리
	@PostMapping("/write.do")
	public ModelAndView write(HttpServletRequest request, BoardDTO board) {
				
		ModelAndView mv = new ModelAndView();		
		noticeService.writeBoard(request, board);
		
		mv.setViewName("redirect:/notice/");
					
		return mv;
	}
	
	// 삭제 처리 매핑 작성 / delete.do
	@PostMapping("/delete.do")
	public ModelAndView delete(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();		
		noticeService.deleteContent(board);
		
		mv.setViewName("redirect:/notice/");
		logger.info(">>> delete.do");
		
		return mv;
	}
	
	// 게시물 수정 메핑 작성 /edit.do
	@PostMapping("/edit.do")
	public ModelAndView edit(BoardDTO board) {
		
		ModelAndView mv = new ModelAndView();
		noticeService.editContent(board);
		
		mv.setViewName("redirect:/notice/");
		logger.info(">>> edit.do" + board.toString());
		
		return mv;
	}
}
