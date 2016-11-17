package com.cafe.service;

import java.util.List;

import com.cafe.domain.CafeVO;

public interface CafeService {
	
	public void cafeRegister(CafeVO cafe) throws Exception;
	public List<CafeVO> cafeList() throws Exception;
}
