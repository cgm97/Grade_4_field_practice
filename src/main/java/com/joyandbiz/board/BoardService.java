package com.joyandbiz.board;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joyandbiz.board.domain.BoardDTO;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository dao;

	public List<BoardDTO> getBoardList(){
		return dao.getBoardList();
	}
	
}
