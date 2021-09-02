package com.joyandbiz.board;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joyandbiz.board.domain.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository dao;

	public List<MemberDTO> getListMember() throws Exception {
		return dao.getListMember();
	}
}
