package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.ComplainVO;
import com.cafe.persistence.ComplainDAO;

/**
 * Complain board service class
 * @author YJH
 * 2016.11.22.Mon
 */
@Service
public class ComplainServiceImpl implements ComplainService{

	//create complain dao
	@Inject
	private ComplainDAO complainDao;
	
	@Override
	public void register(ComplainVO complain) throws Exception {
		complainDao.register(complain);
	}

	@Override
	public List<ComplainVO> complainList() throws Exception {
		return complainDao.complainList();
	}

	//read a complain
	@Override
	public ComplainVO complainRead(int complainNum) throws Exception {
		return complainDao.complainRead(complainNum);
	}
	
	//register reply
	@Override
	public void registerReply(int complainNum, String reply) throws Exception {
		complainDao.registerReply(complainNum, reply);
	}

}
