package com.joyandbiz.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.joyandbiz.board.service.ReferenceRoomService;

@RestController
@RequestMapping("/reference")
public class ReferenceRoomController {

	@Autowired
	private ReferenceRoomService referenceService;
	
	@RequestMapping(value="/list.do", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> list(@RequestBody HashMap<String, Object> BoardListMap) {		
		BoardListMap = (HashMap<String, Object>) BoardListMap.get("searchData");
		Map resObj = new HashMap();

		resObj = referenceService.getBoardList(BoardListMap);

		return resObj;
	}
	
	@RequestMapping(value="/detailContent.do", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> content(/* BoardDTO board */ @RequestBody HashMap<String, Object> board) {
		board = (HashMap<String, Object>) board.get("searchContent");
		
		Map resObj = new HashMap();

		resObj.put("contentDetail", referenceService.getContentByCon_No(board));
		
		return resObj;
	}

	@RequestMapping(value="/checkIdentify.do", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> checkIdentify( @RequestBody HashMap<String, Object> board) { // key = 2 占쏙옙占쏙옙, 3 占쏙옙占쏙옙
		System.out.println(board.toString());
		
		board = (HashMap<String, Object>) board.get("identiInfo");
		
		boolean isCheckedUser = referenceService.checkIdentify(board);
		
		board = new HashMap<String, Object>();
		
		Map resObj = new HashMap();
		board.put("result", isCheckedUser);

		resObj.put("checkUser", board);
		
		return resObj;
	}

	@PostMapping("/write.do")
	public @ResponseBody Map<String, Object> write(/* BoardDTO board */ HttpServletRequest request, @RequestBody HashMap<String, Object> board) {
		board = (HashMap<String, Object>) board.get("contentData");				
		int write_result = referenceService.writeBoard(request, board);
		
		board = new HashMap<String, Object>();
		Map resObj = new HashMap();
		
		board.put("result", write_result);
		resObj.put("resultData", board);
		
		return resObj;
	}
	
	@PostMapping("/delete.do")
	public @ResponseBody Map<String, Object> delete(@RequestBody HashMap<String, Object> board) {
		board = (HashMap<String, Object>) board.get("con_no");	
		System.out.println(board.toString());
		
		int del_result = referenceService.deleteContent(board);
		
		board = new HashMap<String, Object>();
		
		Map resObj = new HashMap();
		
		board.put("result", del_result);
		resObj.put("resultData", board);
		
		return resObj;
	}
	
	@PostMapping("/edit.do")
	public @ResponseBody Map<String, Object> edit(@RequestBody HashMap<String, Object> board) {
		board = (HashMap<String, Object>) board.get("contentData");
		
		int edit_result = referenceService.editContent(board);
		board = new HashMap<String, Object>();
		
		Map resObj = new HashMap();
		board = new HashMap<String, Object>();
		
		board.put("result", edit_result);
		resObj.put("resultData", board);

		return resObj;
	}
}
