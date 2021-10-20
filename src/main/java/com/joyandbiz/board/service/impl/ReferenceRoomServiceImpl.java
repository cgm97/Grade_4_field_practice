package com.joyandbiz.board.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joyandbiz.board.IPConfig;
import com.joyandbiz.board.repository.BoardRepository;
import com.joyandbiz.board.service.ReferenceRoomService;

@Service
public class ReferenceRoomServiceImpl implements ReferenceRoomService {
	
	@Autowired
	private BoardRepository dao;
	
	private int page; 
	private int display; 
	private int rowStart; 
	private int rowEnd;
	
	public HashMap<String, Object> setCon_div(HashMap<String, Object> board) { 
		board.put("con_div", "02");
		
		return board;
	}
	
	public HashMap<String, Object> calRowStartEnd(HashMap<String, Object> board) {
		
		this.page = Integer.valueOf(String.valueOf(board.get("page")));
		this.display = Integer.valueOf(String.valueOf(board.get("display")));

		rowStart = ((page - 1) * display) + 1;
		rowEnd = rowStart + display -1;
				
		board.put("rowStart", rowStart);
		board.put("rowEnd", rowEnd);
		
		return board;
	}
	
	@Override
	public HashMap<String, Object> getBoardList(HashMap<String, Object> board) {
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		setCon_div(board);
		
		board = calRowStartEnd(board);
	 
		List<HashMap<String, Object>> BoardList = dao.getBoardList(board); 
		
		result.put("boardList", BoardList);

		return result;
	}

	@Override
	public HashMap<String, Object> getContentByCon_No(/* BoardDTO board */ HashMap<String, Object> board) {
		setCon_div(board);

		dao.plusReadCount(board);
		
		return dao.getContentByCon_No(board);
	}

	@Override
	public int writeBoard( /*BoardDTO board*/ HttpServletRequest request, HashMap<String, Object> board) {
		IPConfig ip = new IPConfig();
		String yourIP = ip.getIPConfig(request);

		setCon_div(board);
		board.put("reg_ip", yourIP);

		System.out.println("sdsad "+board.toString());	
		return dao.insertBoard(board);
	}

	@Override
	public boolean checkIdentify(HashMap<String, Object> board) {
		setCon_div(board);
		
		return dao.isCheckIdentify(board);
	}

	@Override
	public int editContent(HashMap<String, Object> board) {
		setCon_div(board);
		
		return dao.updateBoard(board);
	}

	@Override
	public int deleteContent(HashMap<String, Object> board) {
		setCon_div(board);
		
		return dao.deleteBoard(board);
	}
}