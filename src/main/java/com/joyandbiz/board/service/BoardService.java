package com.joyandbiz.board.service;

import java.util.List;

import com.joyandbiz.board.domain.BoardDTO;

public interface BoardService {
	public List<BoardDTO> getBoardList();
	
	public BoardDTO getContentByCon_No(String con_no);

	public int writeBoard(BoardDTO board);
}
