package com.cafe.dgu;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe.controller.MenuController;
import com.cafe.domain.NoticeVO;
import com.cafe.persistence.NoticeDAO;

/**
 * Test source for SQL of notice
 * @author YJH
 * 2016.11.30.Wed
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class NoticeTest {

	// create DAO
	@Inject
	private NoticeDAO noticeDao;
	// log
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
		
	//register
	@Test
	public void testRegisterNotice() throws Exception{
		NoticeVO notice = new NoticeVO();
		notice.setTitle("title");
		notice.setContent("content");
		noticeDao.register(notice);
	}
	
	//delete
	@Test
	public void testDeleteNotice() throws Exception{
		noticeDao.delete(1);
	}
	
	//read
	@Test
	public void testReadNotice() throws Exception{
		logger.info(noticeDao.read(2).toString());
	}
	
	//list
	@Test
	public void testNoticeList() throws Exception{
		List<NoticeVO> list = noticeDao.list();
		for(NoticeVO notice : list){
			logger.info(notice.toString());
		}
	}
	
}
