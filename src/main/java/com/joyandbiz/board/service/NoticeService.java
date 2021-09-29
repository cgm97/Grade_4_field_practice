package com.joyandbiz.board.service;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.joyandbiz.board.SearchCriteria;
import com.joyandbiz.board.domain.BoardDTO;

public interface NoticeService {
	
	public List<BoardDTO> getBoardList(SearchCriteria scri);
	
	public HashMap<String, Object> getContentByCon_No(HashMap<String, Object> board);

	public int writeBoard(HttpServletRequest request, HashMap<String, Object> board);

	public boolean checkIdentify(HashMap<String, Object> board);

	public int editContent(HashMap<String, Object> board);

	public int deleteContent(HashMap<String, Object> boar);

//	public List<BoardDTO> getSearchedBoardList(HashMap<String, Object> map);
	
	public int countBoardList(SearchCriteria scri);

}
