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

	@Inject
	private FixedDAO fixedDao;
	
	@Override
	public void register(FixedVO fixed) throws Exception {
		fixedDao.register(fixed);
	}

	@Override
	public void remove(FixedVO fixed) throws Exception {
		fixedDao.remove(fixed);
	}

	@Override
	public List<FixedVO> fixedList(String cafeName) throws Exception {
		return fixedDao.fixedList(cafeName);
	}

}
