package com.joyandbiz.board.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joyandbiz.board.IPConfig;
import com.joyandbiz.board.domain.BoardDTO;
import com.joyandbiz.board.domain.SearchDTO;
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
	public List<BoardDTO> getBoardList(HashMap<String, Object> map) {
		logger.info(">>> �Խ��� ����Ʈ ��������");
		
		BoardDTO board = new BoardDTO();
		board = (BoardDTO) map.get("board");
		setCon_div(board);
		map.put("board", board);
		
		return dao.getBoardList(map);
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
		logger.info(">>> �ſ� Ȯ��"+ board.toString() );
		
		return dao.isCheckIdentify(board);
	}

	@Override
	public int editContent(BoardDTO board) {
		setCon_div(board);
		logger.info(">>> �� ����");
		
		return dao.updateBoard(board);
	}

	@Override
	public int deleteContent(BoardDTO board) {
		setCon_div(board);
		logger.info(">>> ��  ����");
		
		return dao.deleteBoard(board);
	}

	@Override
	public List<BoardDTO> getSearchedBoardList(HashMap<String, Object> map) {
		SearchDTO sto = new SearchDTO();
		sto = (SearchDTO) map.get("search");
		sto.setCon_div("01");
		map.put("search", sto);
		logger.info(">>> ��  �˻�");
		
		return dao.selectSearchBoard(map);
	}

	@Override
	public int countBoardList(SearchDTO sto) {
		logger.info(">>> �Խù� �� ���� ��ȸ");
		
			sto.setCon_div("01");

		return dao.countBoardList(sto);		
	}
}
