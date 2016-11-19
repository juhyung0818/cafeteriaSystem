package com.cafe.dgu;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe.controller.Weekly;
import com.cafe.domain.WeeklyVO;
import com.cafe.flag.DateFlag;
import com.cafe.flag.WeeklyFlag;
import com.cafe.persistence.WeeklyDAO;

/**
 * Test source for SQL of Weekly
 * @author YJH
 * 2016.11.19.Sat
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class WeeklyTest {
	
	// FlagDAO생성
	@Inject
	private WeeklyDAO flagDao;
	// log
	private static final Logger logger = LoggerFactory.getLogger(Weekly.class);
	
	//register weekly
	@Test
	public void testRegister() throws Exception{
		WeeklyVO weekly = new WeeklyVO();
		weekly.setCafeName("기숙사식당");
		weekly.setMenuName("조식뷔페");
		weekly.setwFlag(WeeklyFlag.SUNDAY);
		weekly.setDateFlag(DateFlag.DINER);
		flagDao.register(weekly);
	}
	
	//clear weekly
	@Test
	public void testClear() throws Exception{
		flagDao.clearWeekly();
	}
	
	//delete a weekly menu
	@Test
	public void testDelete() throws Exception{
		String menuName = "조식뷔페";
		flagDao.delete(menuName, WeeklyFlag.SUNDAY, DateFlag.DINER);
	}

}
