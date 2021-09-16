package com.joyandbiz.board.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyandbiz.board.IPConfig;
import com.joyandbiz.board.domain.BoardDTO;
import com.joyandbiz.board.repository.NoticeRepository;
import com.joyandbiz.board.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeRepository dao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public BoardDTO setCon_div(BoardDTO board) { // �Խ��� ������ ���� �޼ҵ�
		board.setCon_div("01");
		logger.info(">>> �Խ��� ������ : " + board.getCon_div()+" ����");
		
		return board;
	}
	
	@Override
	public List<BoardDTO> getBoardList(BoardDTO board) {
		setCon_div(board);
		logger.info(">>> �Խ��� ����Ʈ ��������");
		
		return dao.getBoardList(board);
	}

	@Override
	public BoardDTO getContentByCon_No(BoardDTO board) {
		// �Խù� ��ȸ�� ī����
		setCon_div(board);
		dao.plusReadCount(board);
		logger.info(">>> �Խ��� �󼼺���");
		
		return dao.getContentByCon_No(board);
	}

	@Override
	public int writeBoard(HttpServletRequest request, BoardDTO board) {
		IPConfig ip = new IPConfig();
		String yourIP = ip.getIPConfig(request);

		setCon_div(board);
		board.setReg_ip(yourIP);
		logger.info(">>> �Խ��� �۾���");
		
		return dao.insertBoard(board);
	}

	@Override
	public boolean checkIdentify(BoardDTO board) {
		setCon_div(board);
		logger.info(">>> �ſ� Ȯ��");
		
		return dao.isCheckIdentify(board);
	}
}
