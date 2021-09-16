package com.joyandbiz.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.joyandbiz.board.domain.BoardDTO;

public interface NoticeService {
	public List<BoardDTO> getBoardList(BoardDTO board);
	
	public BoardDTO getContentByCon_No(BoardDTO board);

	public int writeBoard(HttpServletRequest request, BoardDTO board);
}
