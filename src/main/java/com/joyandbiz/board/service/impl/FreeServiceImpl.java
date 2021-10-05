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
	
	private int page = 1; // ����������
	private int perPageNum = 10; // �Խñ��� ��
	private int displayPageNum = 5; // ȭ�鿡 ǥ�õ� �������� ��
	private int startPage; // ���ٿ� ǥ�õǴ� ������ ���� 
	private int endPage;  
	private int rowStart; // DB�� ���۵� �Խñ� ����
	private int rowEnd;
	private boolean prev;
	private boolean next;
	private int totalCount = 0;
	
	public HashMap<String, Object> setCon_div(HashMap<String, Object> board) { // �Խ��� ������ ���� �޼ҵ�
		board.put("con_div", "02");
		logger.info(">>> �Խ��� ������ HashMap 02 : ����");
		
		return board;
	}
	
	public HashMap<String, Object> calRowStartEnd(HashMap<String, Object> board) {
		// DB ������ �� �˻��� ���� ����ϴ� Method
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
		// View �ܿ��� �������� ��Ÿ���ֱ� ���� ����ϴ� Method
		endPage = (int) Math.ceil(page / (double) displayPageNum) * displayPageNum;
		startPage = (endPage - displayPageNum) + 1;	
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double) perPageNum));
		if (endPage > tempEndPage) { // �� �������� �ʿ��� �� ���������� ũ�ԵǸ� �� �� ���������� �ʿ���� �����ϴ� If��
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
		
		// DB�� �� �Խñ� ���۰� �� ( ����  ) ���� ���
		board = calRowStartEnd(board);
		
		logger.info(">>> �Խ��� ����Ʈ ��������" + board.toString());	
		
		// �˻��ǰų� ��ü ��� �Խù� ����Ʈ �ҷ�����
		List<HashMap<String, Object>> BoardList = dao.getBoardList(board); 
		
		if (BoardList.size() != 0) { // �˻��� �� ������ ���� ���
			totalCount = Integer.parseInt(String.valueOf(BoardList.get(0).get("TOTALCOUNT"))); 	
		}
		
		// view�ܿ� ��Ÿ���� ������ ���
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
		// �Խù� ��ȸ�� ī����
		dao.plusReadCount(board);
		logger.info(">>> �Խ��� �󼼺��� : " + board.toString());
		
		return dao.getContentByCon_No(board);
	}

	@Override
	public int writeBoard( /*BoardDTO board*/ HttpServletRequest request, HashMap<String, Object> board) {
		IPConfig ip = new IPConfig();
		String yourIP = ip.getIPConfig(request);

		setCon_div(board);
		board.put("reg_ip", yourIP);
		logger.info(">>> �Խ��� �۾���");
		
		return dao.insertBoard(board);
	}

	@Override
	public boolean checkIdentify(HashMap<String, Object> board) {
		setCon_div(board);
		logger.info(">>> �ſ� Ȯ��"+ board.toString() );
		
		return dao.isCheckIdentify(board);
	}

	@Override
	public int editContent(HashMap<String, Object> board) {
		setCon_div(board);
		logger.info(">>> �� ����");
		
		return dao.updateBoard(board);
	}

	@Override
	public int deleteContent(HashMap<String, Object> board) {
		setCon_div(board);
		logger.info(">>> ��  ����");
		
		return dao.deleteBoard(board);
	}
}