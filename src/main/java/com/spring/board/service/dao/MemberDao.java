package com.spring.board.service.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface MemberDao {
	
	public void add(Member m);
	
	public void add(List<Member> members);
	
	public void deleteAll();
	
	@Transactional(readOnly=true)
	public long count();
}
