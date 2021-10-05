package com.joyandbiz.board.repository;

import java.util.HashMap;
import java.util.List;

public interface NoticeRepository {
	public List<HashMap<String, Object>> getBoardList(HashMap<String, Object> board);

	public HashMap<String, Object> getContentByCon_No(HashMap<String, Object> board);

	public int plusReadCount(HashMap<String, Object> board);

	public int insertBoard(HashMap<String, Object> board);

	public boolean isCheckIdentify(HashMap<String, Object> board);

	public int updateBoard(HashMap<String, Object> board);

	public int deleteBoard(HashMap<String, Object> boar);

//	public List<BoardDTO> selectSearchBoard(HashMap<String, Object> map);
	
//	public int countBoardList(SearchCriteria scri);
}
