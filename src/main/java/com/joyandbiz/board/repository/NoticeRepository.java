package com.joyandbiz.board.repository;

import java.util.List;
import com.joyandbiz.board.domain.BoardDTO;
import com.joyandbiz.board.domain.SearchDTO;

public interface NoticeRepository {
	public List<BoardDTO> getBoardList(BoardDTO board);

	public BoardDTO getContentByCon_No(BoardDTO board);

	public int plusReadCount(BoardDTO board);

	public int insertBoard(BoardDTO board);

	public boolean isCheckIdentify(BoardDTO board);

	public int updateBoard(BoardDTO board);

	public int deleteBoard(BoardDTO board);

	public List<BoardDTO> selectSearchBoard(SearchDTO sto);
}
