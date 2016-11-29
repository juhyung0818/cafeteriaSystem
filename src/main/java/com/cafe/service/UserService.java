package com.cafe.service;

import com.cafe.domain.UserVO;

public interface UserService {

	public void register(UserVO user)throws Exception;
	public void check(UserVO user)throws Exception;
}
