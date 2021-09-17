package com.joyandbiz.board.repository.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joyandbiz.board.domain.BoardDTO;
import com.joyandbiz.board.repository.NoticeRepository;

@Repository
public class NoticeMybatis implements NoticeRepository{

	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeMapper.";
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<BoardDTO> getBoardList(BoardDTO board) {
		return sqlSession.selectList(NAMESPACE+"getBoardList", board);
	}

	@Override
	public BoardDTO getContentByCon_No(BoardDTO board) {
		return sqlSession.selectOne(NAMESPACE+"getContentByCon_No", board);
	}

	@Override
	public int plusReadCount(BoardDTO board) {
		logger.info(">>> 게시판 조회수 카운팅");
		return sqlSession.update(NAMESPACE+"plusReadCount", board);	
	}

	@Override
	public int insertBoard(BoardDTO board) {
		return sqlSession.insert(NAMESPACE+"insertBoard", board);
	}

	@Override
	public boolean isCheckIdentify(BoardDTO board) {
		return sqlSession.selectOne(NAMESPACE+"isCheckIdentify", board);
	}

	@Override
	public int updateBoard(BoardDTO board) {
		return sqlSession.update(NAMESPACE+"updateBoard", board);
	}

	@Override
	public int deleteBoard(BoardDTO board) {
		return sqlSession.delete(NAMESPACE+"deleteBoard", board);
	}
}