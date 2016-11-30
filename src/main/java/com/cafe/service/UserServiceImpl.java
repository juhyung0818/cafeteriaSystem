package com.cafe.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.AdminVO;
import com.cafe.domain.UserVO;
import com.cafe.dto.LoginDTO;
import com.cafe.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	UserDAO userDao;
	
	@Override
	public void register(UserVO user) throws Exception {
		
		userDao.register(user);
	}

	@Override
	public void check(UserVO user) throws Exception {

		if(userDao.check(user)<1)
			userDao.register(user);
			
	}

	@Override
	public AdminVO login(LoginDTO dto) throws Exception {

		return userDao.login(dto);
	}

}
