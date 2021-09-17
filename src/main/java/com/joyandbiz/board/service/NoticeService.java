package com.joyandbiz.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.joyandbiz.board.domain.BoardDTO;
import com.joyandbiz.board.domain.SearchDTO;

public interface NoticeService {
	public List<BoardDTO> getBoardList(BoardDTO board);
	
	public BoardDTO getContentByCon_No(BoardDTO board);

	public int writeBoard(HttpServletRequest request, BoardDTO board);

	public boolean checkIdentify(BoardDTO board);

	public int editContent(BoardDTO board);

	public int deleteContent(BoardDTO board);

	public List<BoardDTO> getSearchedBoardList(SearchDTO sto);
}
