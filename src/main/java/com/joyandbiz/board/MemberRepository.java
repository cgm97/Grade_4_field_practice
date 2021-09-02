package com.joyandbiz.board;

import java.util.List;
import com.joyandbiz.board.domain.MemberDTO;

public interface MemberRepository {
	public List<MemberDTO> getListMember() throws Exception;
}
