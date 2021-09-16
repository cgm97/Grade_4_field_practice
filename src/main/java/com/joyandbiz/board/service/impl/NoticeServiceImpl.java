package com.joyandbiz.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joyandbiz.board.domain.BoardDTO;
import com.joyandbiz.board.repository.NoticeRepository;
import com.joyandbiz.board.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeRepository dao;
	
	@Override
	public List<BoardDTO> getBoardList() {
		BoardDTO dto = new BoardDTO();
		dto.setCon_div("01");
		return dao.getBoardList();
	}

	@Override
	public BoardDTO getContentByCon_No(String con_no) {
		// 게시물 조회수 카운팅
		BoardDTO dto = new BoardDTO();
		dto.setCon_div("01");
		dto.setCon_no(con_no);
		
		dao.plusReadCount(con_no);	
		return dao.getContentByCon_No(con_no);
	}

	@Override
	public int writeBoard(BoardDTO board) {
		return dao.insertBoard(board);
	}

}
