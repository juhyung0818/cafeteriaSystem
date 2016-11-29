package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.FixedVO;
import com.cafe.domain.MenuVO;
import com.cafe.exception.NotExistResultException;
import com.cafe.exception.PrimaryKeyDuplicatedException;
import com.cafe.persistence.FixedDAO;

/**
 * Fixed menu service class
 * @author YJH
 * 2016.11.20.Sun
 */
@Service
public class FixedServiceImpl implements FixedService{

	//data access object about fixed menu
	@Inject
	private FixedDAO fixedDao;
	
	/**
	 * add fixed menu
	 * @author YJH
	 */
	@Override
	public void register(FixedVO fixed) throws Exception {
		if(fixedDao.check(fixed) > 0){
			throw new PrimaryKeyDuplicatedException();
		}
		fixedDao.register(fixed);
	}

	/**
	 * add fixed menu
	 * @author YJH
	 */
	@Override
	public void delete(FixedVO fixed) throws Exception {
		fixedDao.delete(fixed);
	}

	/**
	 * diplay fixed menu list
	 * @author YJH
	 */
	@Override
	public List<FixedVO> fixedList(String cafeName) throws Exception {
		return fixedDao.fixedList(cafeName);
	}

	/**
	 * diplay result of fixed menu search 
	 * @author YJH
	 */
	@Override
	public List<FixedVO> fixedSearch(String cafeName, String keyword) throws Exception {
		
		List<FixedVO> list = fixedDao.fixedList(cafeName);
		List<FixedVO> searchList = fixedDao.fixedSearch(cafeName, keyword);
		
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
