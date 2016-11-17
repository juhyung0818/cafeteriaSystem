package com.cafe.dgu;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe.controller.CafeController;
import com.cafe.domain.CafeVO;
import com.cafe.persistence.CafeDAO;

/**
 * Test source for SQL of cafe
 * @author YJH
 * 2016.11.08.Tue
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class CafeTest {

	//CafeDAO생성
	@Inject
	private CafeDAO cafeDao;
	//log
	private static final Logger logger = LoggerFactory.getLogger(CafeController.class);

	/**
	 * Test source
	 * insert cafe in database
	 * @throws Exception 
	 */
	@Test
	public void testCafeRegister() throws Exception {
		logger.info("@Test cafe register");
		CafeVO cafe = new CafeVO();
		cafe.setCafeName("SangRokWon");
		cafe.setInfo("Hello Big Cafeteria NyamNyam");
		cafeDao.cafeRegister(cafe);
	}
	
	/**
	 * Test source
	 * insert cafe in database
	 * @throws Exception 
	 */
	@Test
	public void testCafeList() throws Exception{
		logger.info("@Test cafe list");
		List<CafeVO> cafes = new ArrayList<>();
		cafes = cafeDao.cafeList();
		for(int i=0; i<cafes.size(); i++){
			logger.info(cafes.get(i).toString());
		}
	}
}
