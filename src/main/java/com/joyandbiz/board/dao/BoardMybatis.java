package com.joyandbiz.board.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.joyandbiz.board.BoardRepository;
import com.joyandbiz.board.domain.BoardDTO;

@Repository
public class BoardMybatis implements BoardRepository{

	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "boardMapper.";
	
	@Override
	public List<BoardDTO> getBoardList() {
		return sqlSession.selectList(NAMESPACE+"getBoardList");
	}
}