package com.joyandbiz.board.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joyandbiz.board.IPConfig;
import com.joyandbiz.board.repository.BoardRepository;
import com.joyandbiz.board.service.BoardService;

@Service
public class FreeServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository dao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private int page = 1; // 현재페이지
	private int perPageNum = 10; // 게시글의 수
	private int displayPageNum = 5; // 화면에 표시될 페이지의 수
	private int startPage; // 한줄에 표시되는 페이지 범위 
	private int endPage;  
	private int rowStart; // DB에 전송될 게시글 범위
	private int rowEnd;
	private boolean prev;
	private boolean next;
	private int totalCount = 0;
	
	public HashMap<String, Object> setCon_div(HashMap<String, Object> board) { // 게시판 구분자 지정 메소드
		board.put("con_div", "02");
		logger.info(">>> 게시판 구분자 HashMap 02 : 설정");
		
		return board;
	}
	
	public HashMap<String, Object> calRowStartEnd(HashMap<String, Object> board) {
		// DB 페이지 별 검색을 위한 계산하는 Method
		if (board.get("page") != null) {
			this.page = Integer.valueOf((String) board.get("page"));
		}

		rowStart = ((page - 1) * perPageNum) + 1;
		rowEnd = rowStart + perPageNum -1;
				
		board.put("rowStart", rowStart);
		board.put("rowEnd", rowEnd);
		
		return board;
	}
	
	public HashMap<String, Object> calPageStartEnd(HashMap<String, Object> board, int totalCount) {
		// View 단에서 페이지별 나타내주기 위한 계산하는 Method
		endPage = (int) Math.ceil(page / (double) displayPageNum) * displayPageNum;
		startPage = (endPage - displayPageNum) + 1;	
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double) perPageNum));
		if (endPage > tempEndPage) { // 끝 페이지가 필요한 총 페이지보다 크게되면 그 뒤 페이지들은 필요없어 제거하는 If문
			endPage = tempEndPage;
		}
		
		board.put("startPage", startPage);
		board.put("endPage", endPage);
		
		return board;
	}
	
	@Override
	public HashMap<String, Object> getBoardList(HashMap<String, Object> board) {
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		setCon_div(board);
		
		// DB에 들어갈 게시글 시작과 끝 ( 범위  ) 숫자 계산
		board = calRowStartEnd(board);
		
		logger.info(">>> 게시판 리스트 가져오기" + board.toString());	
		
		// 검색되거나 전체 목록 게시물 리스트 불러오기
		List<HashMap<String, Object>> BoardList = dao.getBoardList(board); 
		
		if (BoardList.size() != 0) { // 검색된 총 페이지 개수 계산
			totalCount = Integer.parseInt(String.valueOf(BoardList.get(0).get("TOTALCOUNT"))); 	
		}
		
		// view단에 나타나는 페이지 계산
		board = calPageStartEnd(board, totalCount);
			
		prev = startPage == 1 ? false : true;
		next = endPage * perPageNum >= totalCount ? false : true;
		
		
		result.put("prev", prev);
		result.put("next", next);
		result.put("BoardList", BoardList);
		result.put("SearchAndPagingData", board);
		
		 	
		return result;
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
}