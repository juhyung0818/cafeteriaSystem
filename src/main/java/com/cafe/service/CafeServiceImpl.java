package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.CafeVO;
import com.cafe.persistence.CafeDAO;
/**
 * Cafeteria Service class
 * @author YJH
 * 2016.11.08.Tue
 * register, list
 */
@Service
public class CafeServiceImpl implements CafeService{

	@Inject
	private CafeDAO cafeDao;
	
	@Override
	public void cafeRegister(CafeVO cafe) throws Exception {
		cafeDao.cafeRegister(cafe);
	}

	@Override
	public List<CafeVO> cafeList() throws Exception {
		return cafeDao.cafeList();
	}

}
