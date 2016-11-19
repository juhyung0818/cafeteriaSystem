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

import com.cafe.controller.MenuController;
import com.cafe.domain.MenuVO;
import com.cafe.persistence.MenuDAO;

/**
 * Test source for SQL of menu
 * @author YJH
 * 2016.11.09.Wed
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MenuTest {

	// MenuDAO생성
	@Inject
	private MenuDAO menuDao;
	// log
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
		
	/**
	 * insert menu in database
	 * @throws Exception 
	 */
	@Test
	public void testMenuRegister() throws Exception{
		
		MenuVO menu = new MenuVO();
		menu.setCafeName("상록원");
		menu.setMenuName("치즈돈까스");

		menuDao.menuRegister(menu);
	}
	
	/**
	 * select menu list in database
	 * @throws Exception 
	 */
	@Test
	public void testMenuList() throws Exception{
		List<MenuVO> list = new ArrayList<>();
		list = menuDao.menuList();
		for(int i=0; i<list.size(); i++){
			logger.info(list.get(i).toString());
		}
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	public void testSearchMenu() throws Exception{
		List<MenuVO> list = new ArrayList<>();
		list = menuDao.searchMenu("기숙사식당", "식");
		for(int i=0; i<list.size(); i++){
			logger.info(list.get(i).toString());
		}
	}
}
