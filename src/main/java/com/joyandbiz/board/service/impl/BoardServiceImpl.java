package com.joyandbiz.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joyandbiz.board.domain.BoardDTO;
import com.joyandbiz.board.repository.BoardRepository;
import com.joyandbiz.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository dao;
	
	@Override
	public List<BoardDTO> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public BoardDTO getContentByCon_No(String con_no) {
		// 게시물 조회수 카운팅
		dao.plusReadCount(con_no);
		
		return dao.getContentByCon_No(con_no);
	}

}
