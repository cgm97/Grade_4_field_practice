package com.joyandbiz.board.repository;

import java.util.HashMap;
import java.util.List;
import com.joyandbiz.board.SearchCriteria;
import com.joyandbiz.board.domain.BoardDTO;

public interface NoticeRepository {
	public List<BoardDTO> getBoardList(SearchCriteria scri);

	public HashMap<String, Object> getContentByCon_No(HashMap<String, Object> board);

	public int plusReadCount(HashMap<String, Object> board);

	public int insertBoard(HashMap<String, Object> board);

	public boolean isCheckIdentify(HashMap<String, Object> board);

	public int updateBoard(HashMap<String, Object> board);

	public int deleteBoard(HashMap<String, Object> boar);

//	public List<BoardDTO> selectSearchBoard(HashMap<String, Object> map);
	
	public int countBoardList(SearchCriteria scri);
}
