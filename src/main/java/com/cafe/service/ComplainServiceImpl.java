package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.ComplainVO;
import com.cafe.dto.ComplainDTO;
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

	//delete reply
	@Override
	public void deleteReply(int complainNum) throws Exception {
		complainDao.deleteReply(complainNum);
	}

	//delete complain
	@Override
	public void delete(int complainNum) throws Exception {
		complainDao.delete(complainNum);
	}

	@Override
	public List<ComplainDTO> complainListApp() throws Exception {
		
		return complainDao.complainListApp();
	}

	@Override
	public void registerApp(ComplainVO complain) throws Exception {
		
		complainDao.registerApp(complain);
	}

	@Override
	public void deleteApp(ComplainVO complain) throws Exception {
		
		int check=complainDao.complainCheck(complain.getComplainNum(), complain.getUid());
		
		if(check!=0)
		{
			complainDao.delete(complain.getComplainNum());
		}
		//else
			//TODO exception
	}

}
