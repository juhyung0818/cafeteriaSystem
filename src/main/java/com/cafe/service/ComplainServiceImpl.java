package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.ComplainVO;
import com.cafe.dto.ComplainDTO;
import com.cafe.exception.NotExistException;
import com.cafe.exception.NotExistURLException;
import com.cafe.persistence.ComplainDAO;
import com.cafe.persistence.UserDAO;

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
	@Inject
	private UserDAO userDao;

	@Override
	public List<ComplainVO> complainList() throws Exception {
		return complainDao.complainList();
	}

	//read a complain
	@Override
	public ComplainVO complainRead(int complainNum) throws Exception {
		if(complainDao.check(complainNum) == 0){
			throw new NotExistURLException();
		}else{
			return complainDao.complainRead(complainNum);
		}
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
		
		List<ComplainDTO> list= complainDao.complainListApp();
		
		for (ComplainDTO complainDTO : list) {
			complainDTO.setName(userDao.getUserNick(complainDTO.getUid()));
		}
		
		return list;
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

	@Override
	public ComplainDTO readOne(int complainNum) throws Exception {
		
//		return complainDao.complainRead(complainNum);
		ComplainVO vo=complainDao.readOne(complainNum);
		ComplainDTO dto=new ComplainDTO();
		
		//vo�� null�ΰ�� ����
		try {
			dto.setComplainNum(complainNum);
			dto.setTitle(vo.getTitle());
			dto.setContent(vo.getContent());
			dto.setUid(vo.getUid());
			dto.setName(userDao.getUserNick(vo.getUid()));
			dto.setRegDate(vo.getRegDate().toString());
			
			try {
				if(vo.getReply()!=null || !vo.getReply().equals(""))
				{
					dto.setIsReply(true);
					dto.setReply(vo.getReply());
					dto.setReplyDate(vo.getReplyDate().toString());
				}
				else
				{
					dto.setIsReply(false);
					dto.setReply("");
					dto.setReplyDate("");
				}
			} catch (Exception e) {
				dto.setIsReply(false);
				dto.setReply("");
				dto.setReplyDate("");

			}
		} catch (Exception e) {
			System.out.println("vo�� null");
		}
		
		return dto;

	}

}
