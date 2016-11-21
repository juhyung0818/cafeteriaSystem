package com.cafe.service;

import java.util.List;

import com.cafe.domain.ComplainVO;
/**
 * Complain board service interface
 * @author YJH
 * 2016.11.21.Mon
 */
public interface ComplainService {
	
	//customer register complain
	public void register(ComplainVO complain) throws Exception;
	//display complain board list
	public List<ComplainVO> complainList() throws Exception;
	//read complain
	public ComplainVO complainRead(int complainNum) throws Exception;
	//register reply
	public void registerReply(int complainNum, String reply) throws Exception;
	//delete reply
	public void deleteReply(int complainNum) throws Exception;
	//delete complain
	public void delete(int complainNum) throws Exception;
}
