package com.joyandbiz.board.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joyandbiz.board.IPConfig;
import com.joyandbiz.board.PageMaker;
import com.joyandbiz.board.SearchCriteria;
import com.joyandbiz.board.repository.NoticeRepository;
import com.joyandbiz.board.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeRepository dao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*
	 * public BoardDTO setBoardCon_div(BoardDTO board) { // 게시판 구분자 지정 메소드
	 * board.setCon_div("01"); logger.info(">>> 게시판 구분자 : Board 01 : 설정");
	 * 
	 * return board; }
	 */
	
	public HashMap<String, Object> setCon_div(HashMap<String, Object> board) { // 게시판 구분자 지정 메소드
		board.put("con_div", "01");
		logger.info(">>> 게시판 구분자 HashMap 01 : 설정");
		
		return board;
	}
	public SearchCriteria setScriCon_div(SearchCriteria scri) { // 게시판  검색 구분자 지정 메소드
		scri.setCon_div("01");
		logger.info(">>> 게시판 구분자 Scri 01 : 설정");
		
		return scri;
	}
	
//	@Override
//	public HashMap<String, Object> getBoardList(SearchCriteria scri) {  // Criteria 페이징 사용
//		logger.info(">>> 게시판 리스트 가져오기");
//
//		setScriCon_div(scri);
//		
//		HashMap<String, Object> BoardListMap = new HashMap<String, Object>();
//		List<HashMap<String, Object>> BoardList = dao.getBoardList(scri);
//		// oracle 데이터 형식 때문에 TotalCount (게시물 총 개수) 정수로 변환
//		int totalCount = 0;
//		if (BoardList.size() != 0) {
//			totalCount = Integer.parseInt(String.valueOf(BoardList.get(0).get("TOTALCOUNT"))); 	
//		}
//		
//		PageMaker pageMaker = new PageMaker();
//		
//		pageMaker.setCri(scri);
//		pageMaker.setTotalCount(totalCount);
//		
//		BoardListMap.put("BoardList", BoardList);
//		BoardListMap.put("pageMaker", pageMaker);
//		BoardListMap.put("searchData", scri);
//		
//		logger.info(">>> result Map : " + BoardListMap.get("BoardList").toString());
//		logger.info(">>> result 게시물 총 갯수 : " + totalCount);
//		
//		return BoardListMap;
//	}
	
	@Override
	public HashMap<String, Object> getBoardList(HashMap<String, Object> board) {
		logger.info(">>> 게시판 리스트 가져오기");
		setCon_div(board);
		
		List<HashMap<String, Object>> BoardList = dao.getBoardList(board);
		board.put("BoardList", BoardList);
		board.put("searchData", board);
		
		return board;
	}

	@Override
	public HashMap<String, Object> getContentByCon_No(/* BoardDTO board */ HashMap<String, Object> board) {
		setCon_div(board);
		// 게시물 조회수 카운팅
		dao.plusReadCount(board);
		logger.info(">>> 게시판 상세보기 : " + board.toString());
		
		return dao.getContentByCon_No(board);
	}

	@Override
	public int writeBoard( /*BoardDTO board*/ HttpServletRequest request, HashMap<String, Object> board) {
		IPConfig ip = new IPConfig();
		String yourIP = ip.getIPConfig(request);

		setCon_div(board);
		board.put("reg_ip", yourIP);
		logger.info(">>> 게시판 글쓰기");
		
		return dao.insertBoard(board);
	}

	@Override
	public boolean checkIdentify(HashMap<String, Object> board) {
		setCon_div(board);
		logger.info(">>> 신원 확인"+ board.toString() );
		
		return dao.isCheckIdentify(board);
	}

	@Override
	public int editContent(HashMap<String, Object> board) {
		setCon_div(board);
		logger.info(">>> 글 수정");
		
		return dao.updateBoard(board);
	}

	@Override
	public int deleteContent(HashMap<String, Object> board) {
		setCon_div(board);
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

	/*
	 * @Override public int countBoardList(SearchCriteria scri) {
	 * logger.info(">>> 게시물 총 갯수 조회");
	 * 
	 * setScriCon_div(scri);
	 * 
	 * return dao.countBoardList(scri); }
	 */
}
