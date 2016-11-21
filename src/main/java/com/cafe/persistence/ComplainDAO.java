package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.ComplainVO;
/**
 * Complain board dao interface
 * @author YJH
 * 2016.11.21.Mon
 * register, list, read
 */
public interface ComplainDAO {

	//customer register complain
	public void register(ComplainVO complain) throws Exception;
	//delete complain
	public void delete(int complainNum) throws Exception;
	//display complain board list
	public List<ComplainVO> complainList() throws Exception;
	//read complain
	public ComplainVO complainRead(int complainNum) throws Exception;
	//register reply
	public void registerReply(int complainNum, String reply) throws Exception;
	//delete reply
	public void deleteReply(int complainNum) throws Exception;
}
