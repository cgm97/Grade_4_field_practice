package com.joyandbiz.board.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.joyandbiz.board.MemberRepository;
import com.joyandbiz.board.domain.MemberDTO;

@Repository
public class MemberMybatis implements MemberRepository{

	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "memberMapper.";
	
	@Override
	public List<MemberDTO> getListMember() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getListMember");
	}
}