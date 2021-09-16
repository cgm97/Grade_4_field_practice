package com.joyandbiz.board.repository;

import java.util.List;
import com.joyandbiz.board.domain.BoardDTO;

public interface NoticeRepository {
	public List<BoardDTO> getBoardList();

	public BoardDTO getContentByCon_No(String con_no);

	public int plusReadCount(String con_no);

	public int insertBoard(BoardDTO board);
}
