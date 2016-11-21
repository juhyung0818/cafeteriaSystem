package com.cafe.dgu;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe.controller.ComplainController;
import com.cafe.domain.ComplainVO;
import com.cafe.persistence.ComplainDAO;

/**
 * Test source for SQL of complain board
 * @author YJH
 * 2016.11.21.Mon
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ComplainTest {

	//CafeDAO생성
	@Inject
	private ComplainDAO complainDao;
	//log
	private static final Logger logger = LoggerFactory.getLogger(ComplainController.class);
	
	//complain register test
	@Test
	public void testComplainRegister() throws Exception{
		ComplainVO complain = new ComplainVO();
		complain.setTitle("title");
		complain.setContent("content");
		complain.setUid("user");
		
		complainDao.register(complain);
	}
	
	//display complain list test
	@Test
	public void testComplainList() throws Exception{
		List<ComplainVO> list = complainDao.complainList();
		for(ComplainVO vo : list){
			logger.info("complain list" + vo.toString());
		}
	}
	
	//read complain test
	@Test
	public void testComplainRead() throws Exception{
		ComplainVO complain = complainDao.complainRead(1);
		logger.info(complain.toString());
	}
	
	//register reply test
	@Test
	public void testRegisterReply() throws Exception{
		int complainNum =1;
		String reply = "hello";
		complainDao.registerReply(complainNum, reply);
	}
	
	//delete reply test
	@Test
	public void testDeleteReply() throws Exception{
		int complainNum =2;
		complainDao.deleteReply(complainNum);
	}
}
