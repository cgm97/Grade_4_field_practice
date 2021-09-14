package com.joyandbiz.board;

import java.util.List;
import com.joyandbiz.board.domain.BoardDTO;

public interface BoardRepository {
	public List<BoardDTO> getBoardList();
}
