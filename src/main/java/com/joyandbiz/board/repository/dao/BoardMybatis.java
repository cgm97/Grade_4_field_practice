package com.joyandbiz.board.repository.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joyandbiz.board.domain.BoardDTO;
import com.joyandbiz.board.repository.BoardRepository;

@Repository
public class BoardMybatis implements BoardRepository{

	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "boardMapper.";
	
	@Override
	public List<BoardDTO> getBoardList() {
		return sqlSession.selectList(NAMESPACE+"getBoardList");
	}

	@Override
	public BoardDTO getContentByCon_No(String con_no) {
		return sqlSession.selectOne(NAMESPACE+"getContentByCon_No", con_no);
	}

	@Override
	public int plusReadCount(String con_no) {
		return sqlSession.update(NAMESPACE+"plusReadCount", con_no);	
	}

	@Override
	public int insertBoard(BoardDTO board) {
		return sqlSession.insert(NAMESPACE+"insertBoard", board);
	}
}