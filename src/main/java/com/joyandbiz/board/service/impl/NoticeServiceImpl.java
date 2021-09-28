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
	
	public BoardDTO setBoardCon_div(BoardDTO board) { // 게시판 구분자 지정 메소드
		board.setCon_div("01");
		logger.info(">>> 게시판 구분자 : Board 01 : 설정");
		
		return board;
	}
	
	public SearchCriteria setScriCon_div(SearchCriteria scri) { // 게시판  검색 구분자 지정 메소드
		scri.setCon_div("01");
		logger.info(">>> 게시판 구분자 Scri 01 : 설정");
		
		return scri;
	}
	
	@Override
	public List<BoardDTO> getBoardList(SearchCriteria scri) {
		logger.info(">>> 게시판 리스트 가져오기");
		
		setScriCon_div(scri);
		
		return dao.getBoardList(scri);
	}

	@Override
	public BoardDTO getContentByCon_No(BoardDTO board) {
		// 게시물 조회수 카운팅
		setBoardCon_div(board);
		dao.plusReadCount(board);
		logger.info(">>> 게시판 상세보기");
		
		return dao.getContentByCon_No(board);
	}

	@Override
	public int writeBoard(HttpServletRequest request, BoardDTO board) {
		IPConfig ip = new IPConfig();
		String yourIP = ip.getIPConfig(request);

		setBoardCon_div(board);
		board.setReg_ip(yourIP);
		logger.info(">>> 게시판 글쓰기");
		
		return dao.insertBoard(board);
	}

	@Override
	public boolean checkIdentify(BoardDTO board) {
		setBoardCon_div(board);
		logger.info(">>> 신원 확인"+ board.toString() );
		
		return dao.isCheckIdentify(board);
	}

	@Override
	public int editContent(BoardDTO board) {
		setBoardCon_div(board);
		logger.info(">>> 글 수정");
		
		return dao.updateBoard(board);
	}

	@Override
	public int deleteContent(BoardDTO board) {
		setBoardCon_div(board);
		logger.info(">>> 글  삭제");
		
		return dao.deleteBoard(board);
	}

	/*
	 * @Override public List<BoardDTO> getSearchedBoardList(HashMap<String, Object>
	 * map) { SearchDTO sto = new SearchDTO(); sto = (SearchDTO) map.get("search");
	 * sto.setCon_div("01"); map.put("search", sto); logger.info(">>> 글  검색");
	 * 
	 * return dao.selectSearchBoard(map); }
	 */

	@Override
	public int countBoardList(SearchCriteria scri) {
		logger.info(">>> 게시물 총 갯수 조회");
		
		setScriCon_div(scri);

		return dao.countBoardList(scri);		
	}
}
