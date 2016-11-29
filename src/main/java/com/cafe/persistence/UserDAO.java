package com.cafe.persistence;

import com.cafe.domain.UserVO;

public interface UserDAO {
	
	public void register(UserVO user)throws Exception;
	public int check(UserVO user)throws Exception;
	public String getUserNick(String uid)throws Exception;
}
