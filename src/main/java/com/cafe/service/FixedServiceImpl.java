package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.FixedVO;
import com.cafe.domain.MenuVO;
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
		fixedDao.register(fixed);
	}

	/**
	 * add fixed menu
	 * @author YJH
	 */
	@Override
	public void remove(FixedVO fixed) throws Exception {
		fixedDao.remove(fixed);
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
		return fixedDao.fixedSearch(cafeName, keyword);
	}

}
