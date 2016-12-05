package com.cafe.dgu;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe.controller.CommentController;
import com.cafe.domain.CommentVO;
import com.cafe.persistence.CommentDAO;

/**
 * Test source of comment
 * @author YJH
 * 2016.11.30.Wed
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class CommentTest {

	//CafeDAO
	@Inject
	private CommentDAO commentDao;
	//log
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	//comment register test
	@Test
	public void testRegisterCommplain() throws Exception{
		CommentVO comment = new CommentVO();
		comment.setCafeName("기숙사식당");
		comment.setDetailName("뷔페");
		comment.setMenuName("조식뷔페");
		comment.setContents("넘나 맛난것~");
		comment.setUid("jh");
		commentDao.commentRegister(comment);
	}
	
	//read comment of a menu
	@Test
	public void testListComment() throws Exception{
		logger.info(commentDao.commentList("상록원", "강된장비빔밥", "솥앤누들").toString());
		
	}
}
