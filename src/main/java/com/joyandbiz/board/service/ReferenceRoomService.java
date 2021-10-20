package com.joyandbiz.board.service;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

public interface ReferenceRoomService {
			
	public HashMap<String, Object> getBoardList(HashMap<String, Object> board);
	
	public HashMap<String, Object> getContentByCon_No(HashMap<String, Object> board);

	public int writeBoard(HttpServletRequest request, HashMap<String, Object> board);

	public boolean checkIdentify(HashMap<String, Object> board);

	public int editContent(HashMap<String, Object> board);

	public int deleteContent(HashMap<String, Object> board);

}
