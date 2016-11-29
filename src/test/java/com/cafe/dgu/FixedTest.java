package com.cafe.dgu;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe.controller.FixedController;
import com.cafe.domain.FixedVO;
import com.cafe.persistence.FixedDAO;

/**
 * Test source for SQL of cafe
 * @author YJH
 * 2016.11.20.Sun
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class FixedTest {

	//FixedDAO
	@Inject
	private FixedDAO fixedDao;
	//log
	private static final Logger logger = LoggerFactory.getLogger(FixedController.class);
	
	//register fixed menu
	@Test
	public void testRegister() throws Exception{
		FixedVO fixed = new FixedVO();
		fixed.setCafeName("기숙사식당");
		fixed.setDetailName("A코너");
		fixed.setMenuName("짜장면");
		fixedDao.register(fixed);
	}
	
	//delete fixed menu
//	@Test
//	public void testDelete() throws Exception{
//		FixedVO fixed = new FixedVO();
//		fixed.setCafeName("");
//		fixed.setMenuName("");
//		fixedDao.remove(fixed);
//	}
	
	//display fixed menu list
	@Test
	public void testFixedList() throws Exception{
		String cafeName = "기숙사식당";
		List<FixedVO> list = fixedDao.fixedList(cafeName);
		for(int i=0; i<list.size(); i++){
			logger.info(fixedDao.fixedList(cafeName).get(i).toString());
		}
	}
	
	//search fixed menu test
	@Test
	public void testSearchFixed() throws Exception{
		String cafeName = "기숙사식당";
		String keyword = "짜";
		logger.info(fixedDao.fixedSearch(cafeName, keyword).toString());
	}
}
