package com.joyandbiz.board.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.joyandbiz.board.SearchCriteria;
import com.joyandbiz.board.domain.BoardDTO;

public interface NoticeService {
	
	public List<BoardDTO> getBoardList(SearchCriteria scri);
	
	public BoardDTO getContentByCon_No(BoardDTO board);

	public int writeBoard(HttpServletRequest request, BoardDTO board);

	public boolean checkIdentify(BoardDTO board);

	public int editContent(BoardDTO board);

	public int deleteContent(BoardDTO board);

//	public List<BoardDTO> getSearchedBoardList(HashMap<String, Object> map);
	
	public int countBoardList(SearchCriteria scri);

}
