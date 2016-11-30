package com.cafe.service;

import com.cafe.domain.AdminVO;
import com.cafe.domain.UserVO;
import com.cafe.dto.LoginDTO;

public interface UserService {

	public void register(UserVO user)throws Exception;
	public void check(UserVO user)throws Exception;
	
	public AdminVO login(LoginDTO dto) throws Exception;
}
