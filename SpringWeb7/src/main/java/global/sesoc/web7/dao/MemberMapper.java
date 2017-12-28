package global.sesoc.web7.dao;

import java.util.ArrayList;

import global.sesoc.web7.vo.Member;

public interface MemberMapper {
	int insert(Member member);
	
	Member selectOne(String id);
	
	ArrayList<Member> selectList();
	
	int deleteOne(String id);

	int update(Member member);
}
