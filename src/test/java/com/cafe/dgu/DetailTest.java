package com.cafe.dgu;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe.controller.DetailController;
import com.cafe.domain.DetailVO;
import com.cafe.persistence.DetailDAO;

/**
 * Test source for SQL of detail
 * @author YJH
 * 2016.11.21.Mon
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DetailTest {

	//CafeDAO생성
	@Inject
	private DetailDAO detailDao;
	//log
	private static final Logger logger = LoggerFactory.getLogger(DetailController.class);
	
	/**
	 * register detail test
	 * @throws Exception
	 */
	@Test
	public void testRegisterDetail() throws Exception{
		String cafeName="기숙사식당";
		String detailName="일품";
		DetailVO detail = new DetailVO();
		detail.setCafeName(cafeName);
		detail.setDetailName(detailName);
		
		detailDao.registerDetail(cafeName, detailName);
	}
	
	/**
	 * detail list
	 * @throws Exception
	 */
	@Test
	public void testDetailList() throws Exception{
		List<DetailVO> list= detailDao.detailList("기숙사식당");
		for(DetailVO detail : list){
			logger.info(detail.toString());
		}
	}
}
