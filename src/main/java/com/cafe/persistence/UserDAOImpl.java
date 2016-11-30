package com.cafe.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.AdminVO;
import com.cafe.domain.UserVO;
import com.cafe.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Inject 
	private SqlSession session;
	private String namespace = "com.cafe.mapper.UserMapper";
	
	@Override
	public void register(UserVO user) throws Exception {
		
		session.insert(namespace+".register", user);
	}

	@Override
	public int check(UserVO user) throws Exception {
		
		return session.selectOne(namespace+".check", user);
	}

	@Override
	public String getUserNick(String uid) throws Exception {
		
		return session.selectOne(namespace+".getUserNick", uid);
	}

	@Override
	public AdminVO login(LoginDTO dto) throws Exception {

		return session.selectOne(namespace+".login", dto);
	}
}
