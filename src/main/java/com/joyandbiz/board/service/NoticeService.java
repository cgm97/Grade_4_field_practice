package com.joyandbiz.board.service;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.joyandbiz.board.SearchCriteria;

public interface NoticeService {
	
	public HashMap<String, Object> getBoardList(SearchCriteria scri);
		
	public HashMap<String, Object> getContentByCon_No(HashMap<String, Object> board);

	public int writeBoard(HttpServletRequest request, HashMap<String, Object> board);

	public boolean checkIdentify(HashMap<String, Object> board);

	public int editContent(HashMap<String, Object> board);

	public int deleteContent(HashMap<String, Object> board);

//	public List<BoardDTO> getSearchedBoardList(HashMap<String, Object> map);
	
//	public int countBoardList(SearchCriteria scri);

}
