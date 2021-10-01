package com.joyandbiz.board.repository.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.joyandbiz.board.repository.NoticeRepository;

@Repository
public class NoticeMybatis implements NoticeRepository{

	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeMapper.";
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<HashMap<String, Object>> getBoardList(HashMap<String, Object> board) {
		return sqlSession.selectList(NAMESPACE+"getBoardList", board);
	}
	
	/*
	 * @Override public List<BoardDTO> selectSearchBoard(HashMap<String, Object>
	 * map) { return sqlSession.selectList(NAMESPACE+"selectSearchBoardList", map);
	 * }
	 */
	
	@Override
	public HashMap<String, Object> getContentByCon_No(HashMap<String, Object> board) {
		return sqlSession.selectOne(NAMESPACE+"getContentByCon_No", board);
	}

	@Override
	public int plusReadCount(HashMap<String, Object> board) {
		logger.info(">>> 게시판 조회수 카운팅");
		return sqlSession.update(NAMESPACE+"plusReadCount", board);	
	}

	@Override
	public int insertBoard(HashMap<String, Object> board) {
		return sqlSession.insert(NAMESPACE+"insertBoard", board);
	}

	@Override
	public boolean isCheckIdentify(HashMap<String, Object> board) {
		return sqlSession.selectOne(NAMESPACE+"isCheckIdentify", board);
	}

	@Override
	public int updateBoard(HashMap<String, Object> board) {
		return sqlSession.update(NAMESPACE+"updateBoard", board);
	}

	@Override
	public int deleteBoard(HashMap<String, Object> board) {
		return sqlSession.delete(NAMESPACE+"deleteBoard", board);
	}

	/*
	 * @Override public int countBoardList(SearchCriteria scri) { return
	 * sqlSession.selectOne(NAMESPACE+"countBoardList", scri); }
	 */
}