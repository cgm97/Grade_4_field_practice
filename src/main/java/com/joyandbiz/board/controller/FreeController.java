package com.joyandbiz.board.controller;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.joyandbiz.board.service.BoardService;

@RequestMapping("/free")
@Controller
public class FreeController {
	
	@Qualifier("freeServiceImpl")
	@Autowired
	private BoardService boardService;
	public static final  String TARGET = "free";
 	Logger logger = LoggerFactory.getLogger(this.getClass());
		
	@GetMapping("/")
	public ModelAndView root() {	
		
		ModelAndView mv = new ModelAndView(); 

		mv.setViewName("redirect:/"+TARGET+"/list.do?page=1");
		logger.info(">>> notice / ");
		
		return mv;
	}

	@GetMapping("/list.do")
	public ModelAndView list(@RequestParam HashMap<String, Object> BoardListMap) {		
		logger.info(">>> list.d0 : " + BoardListMap.toString());
		
		ModelAndView mv = new ModelAndView();
		BoardListMap = boardService.getBoardList(BoardListMap);
		
		mv.setViewName("/"+TARGET+"/boardList");		
		
		mv.addObject("boardList", BoardListMap.get("BoardList"));
		mv.addObject("SearchAndPagingData", BoardListMap.get("SearchAndPagingData"));
		
		logger.info(BoardListMap.get("SearchAndPagingData").toString());
		
		return mv;
	}
	
	// �Խù� �󼼺��� ȭ��
	@PostMapping("/detailContent.do")
	public ModelAndView content(/* BoardDTO board */ @RequestParam HashMap<String, Object> board) {
		
		HashMap<String, Object> boardInfo = boardService.getContentByCon_No(board);		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/"+TARGET+"/detailContent");
		mv.addObject("boardInfo", boardInfo);
		logger.info(">>> detailContent.do" + boardInfo.toString());
		
		return mv;
	}
	
	// �Խù� ���� ��� ȭ��
	@PostMapping("/editContent.do") 
	public ModelAndView editContent(@RequestParam HashMap<String, Object> board) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/"+TARGET+"/editContent");
		mv.addObject("boardInfo", board);
		logger.info(">>> editContent.do" + board.toString());
		
		return mv;
	}
	
	// ���� ���� ȭ��
	@PostMapping("/identification.do")
	public ModelAndView identification(/* BoardDTO board */ @RequestParam HashMap<String, Object> board) {
		
		ModelAndView mv = new ModelAndView();
				
		mv.setViewName("/"+TARGET+"/identification");
		mv.addObject("boardInfo", board);
		logger.info(">>> identification.do" + board.toString());
		
		return mv;
	}
	
	// ���� ���� ó�� �ܰ�
	@PostMapping("/checkIdentify.do")
	public ModelAndView checkIdentify(/* BoardDTO board */ @RequestParam HashMap<String, Object> board) { // key = 2 ����, 3 ����
		
		ModelAndView mv = new ModelAndView();
		boolean isCheckedUser = boardService.checkIdentify(board);
		
		mv.setViewName("/"+TARGET+"/identification");
		mv.addObject("flag", isCheckedUser); // ���� ���� Ȯ�� ���� ���� ���� True or False
		mv.addObject("key", board.get("key")); // �������� ���� ���� ��û�̾����� �Ǵ�
		mv.addObject("boardInfo", board);			
		logger.info(">>> checkIdentify.do �������� ó�� ��� : " + isCheckedUser + " " + board.get("key"));
		
		return mv;
	}
	
	// �Խù� �ۼ� ó��
	@PostMapping("/write.do")
	public ModelAndView write(/* BoardDTO board */ HttpServletRequest request, @RequestParam HashMap<String, Object> board) {
				
		ModelAndView mv = new ModelAndView();		
		boardService.writeBoard(request, board);
		
		mv.setViewName("redirect:/"+TARGET+"/");
					
		return mv;
	}
	
	// ���� ó�� ���� �ۼ� / delete.do
	@PostMapping("/delete.do")
	public ModelAndView delete(@RequestParam HashMap<String, Object> board) {
		
		ModelAndView mv = new ModelAndView();		
		boardService.deleteContent(board);
		
		mv.setViewName("redirect:/"+TARGET+"/");
		logger.info(">>> delete.do");
		
		return mv;
	}
	
	// �Խù� ���� ���� �ۼ� /edit.do
	@PostMapping("/edit.do")
	public ModelAndView edit(@RequestParam HashMap<String, Object> board) {
		
		ModelAndView mv = new ModelAndView();
		boardService.editContent(board);
		
		mv.setViewName("redirect:/"+TARGET+"/");
		logger.info(">>> edit.do" + board.toString());
		
		return mv;
	}
}
