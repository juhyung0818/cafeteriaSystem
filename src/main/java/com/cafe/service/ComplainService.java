package com.cafe.service;

import java.util.List;

import com.cafe.domain.ComplainVO;
import com.cafe.dto.ComplainDTO;
/**
 * Complain board service interface
 * @author YJH
 * 2016.11.21.Mon
 */
public interface ComplainService {
	
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
	
	/**
	 * app
	 * @return
	 * @throws Exception
	 *  @author kwom
	 * 2016.11.25.Fri
	 */
	public List<ComplainDTO> complainListApp() throws Exception;
	
	/**
	 * app
	 * @param complain
	 * @throws Exception
	 * @author kwom
	 * 2016.11.25.Fri
	 */
	public void registerApp(ComplainVO complain) throws Exception;
	/**
	 * app
	 * @param complain
	 * @throws Exception
	 * @author kwom
	 * 2016.11.25.Fri
	 */
	public void deleteApp(ComplainVO complain) throws Exception;
}
