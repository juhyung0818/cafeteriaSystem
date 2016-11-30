package com.cafe.persistence;

import com.cafe.domain.AdminVO;
import com.cafe.domain.UserVO;
import com.cafe.dto.LoginDTO;

public interface UserDAO {
	
	public void register(UserVO user)throws Exception;
	public int check(UserVO user)throws Exception;
	public String getUserNick(String uid)throws Exception;
	
	public AdminVO login(LoginDTO dto)throws Exception;
}
