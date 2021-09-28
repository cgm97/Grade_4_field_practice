package com.joyandbiz.board.service.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joyandbiz.board.IPConfig;
import com.joyandbiz.board.SearchCriteria;
import com.joyandbiz.board.domain.BoardDTO;
import com.joyandbiz.board.repository.NoticeRepository;
import com.joyandbiz.board.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeRepository dao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public BoardDTO setBoardCon_div(BoardDTO board) { // �Խ��� ������ ���� �޼ҵ�
		board.setCon_div("01");
		logger.info(">>> �Խ��� ������ : Board 01 : ����");
		
		return board;
	}
	
	public SearchCriteria setScriCon_div(SearchCriteria scri) { // �Խ���  �˻� ������ ���� �޼ҵ�
		scri.setCon_div("01");
		logger.info(">>> �Խ��� ������ Scri 01 : ����");
		
		return scri;
	}
	
	@Override
	public List<BoardDTO> getBoardList(SearchCriteria scri) {
		logger.info(">>> �Խ��� ����Ʈ ��������");
		
		setScriCon_div(scri);
		
		return dao.getBoardList(scri);
	}

	@Override
	public BoardDTO getContentByCon_No(BoardDTO board) {
		// �Խù� ��ȸ�� ī����
		setBoardCon_div(board);
		dao.plusReadCount(board);
		logger.info(">>> �Խ��� �󼼺���");
		
		return dao.getContentByCon_No(board);
	}

	@Override
	public int writeBoard(HttpServletRequest request, BoardDTO board) {
		IPConfig ip = new IPConfig();
		String yourIP = ip.getIPConfig(request);

		setBoardCon_div(board);
		board.setReg_ip(yourIP);
		logger.info(">>> �Խ��� �۾���");
		
		return dao.insertBoard(board);
	}

	@Override
	public boolean checkIdentify(BoardDTO board) {
		setBoardCon_div(board);
		logger.info(">>> �ſ� Ȯ��"+ board.toString() );
		
		return dao.isCheckIdentify(board);
	}

	@Override
	public int editContent(BoardDTO board) {
		setBoardCon_div(board);
		logger.info(">>> �� ����");
		
		return dao.updateBoard(board);
	}

	@Override
	public int deleteContent(BoardDTO board) {
		setBoardCon_div(board);
		logger.info(">>> ��  ����");
		
		return dao.deleteBoard(board);
	}

	/*
	 * @Override public List<BoardDTO> getSearchedBoardList(HashMap<String, Object>
	 * map) { SearchDTO sto = new SearchDTO(); sto = (SearchDTO) map.get("search");
	 * sto.setCon_div("01"); map.put("search", sto); logger.info(">>> ��  �˻�");
	 * 
	 * return dao.selectSearchBoard(map); }
	 */

	@Override
	public int countBoardList(SearchCriteria scri) {
		logger.info(">>> �Խù� �� ���� ��ȸ");
		
		setScriCon_div(scri);

		return dao.countBoardList(scri);		
	}
}
