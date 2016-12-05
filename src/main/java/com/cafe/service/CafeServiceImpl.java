package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.CafeVO;
import com.cafe.domain.MenuVO;
import com.cafe.exception.NotExistResultException;
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

	//create service
	@Inject
	private CafeDAO cafeDao;
	
	/**
	 * insert cafeteria
	 * @author YJH
	 */
	@Override
	public void cafeRegister(CafeVO cafe) throws Exception {
		
		//already exist case
		if(cafeDao.cafeCheck(cafe.getCafeName()) > 0){
			throw new PrimaryKeyDuplicatedException();
		}
		cafeDao.cafeRegister(cafe);
	}

	/**
	 * display cafeteria list
	 * @author YJH
	 */
	@Override
	public List<CafeVO> cafeList() throws Exception {
		return cafeDao.cafeList();
	}

	/**
	 * remove cafeteria
	 * @author YJH
	 */
	@Override
	public void deleteCafe(String cafeName) throws Exception {
		cafeDao.deleteCafe(cafeName);
	}

	/**
	 * search cafeteria
	 * @author YJH
	 */
	@Override
	public List<CafeVO> cafeSearch(String keyword) throws Exception {
		List<CafeVO> searchList = cafeDao.cafeSearch(keyword);
		List<CafeVO> list = cafeDao.cafeList();

		if(list.size() > 0){//list is exist case
			if(searchList.size() > 0){
				return searchList;
			}else{ //list is exist && search list is not exist
				throw new NotExistResultException();
			}
		}else{ //list is not exist
			return list;
		}
	}


}
