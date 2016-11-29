package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.CafeVO;
import com.cafe.exception.PrimaryKeyDuplicatedException;
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
		
		if(cafeDao.cafeCheck(cafe.getCafeName()) > 0){
			//already exist case
			throw new PrimaryKeyDuplicatedException();
		}
		cafeDao.cafeRegister(cafe);
	}

	@Override
	public List<CafeVO> cafeList() throws Exception {
		return cafeDao.cafeList();
	}

	@Override
	public void deleteCafe(String cafeName) throws Exception {
		cafeDao.deleteCafe(cafeName);
	}

	@Override
	public List<CafeVO> cafeSearch(String keyword) throws Exception {
		return cafeDao.cafeSearch(keyword);
	}


}
