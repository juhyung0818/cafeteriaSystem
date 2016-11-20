package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.cafe.domain.MenuVO;
import com.cafe.exception.PrimaryKeyDuplicatedException;
import com.cafe.persistence.MenuDAO;
/**
 * Menu Service class
 * @author YJH
 * 2016.11.08.Tue
 * register, delete, list, search
 */
@Service
public class MenuServiceImpl implements MenuService{

	@Inject
	private MenuDAO menuDao;
	
	@Override
	public void menuRegister(MenuVO menu) throws Exception {
		if(menuDao.checkMenu(menu.getCafeName(), menu.getMenuName()) == 0){
			menuDao.menuRegister(menu);
		}else{
			throw new PrimaryKeyDuplicatedException();
		}
	}

	@Override
	public List<MenuVO> menuList(String cafeName) throws Exception {
		return menuDao.menuList(cafeName);
	}
	
	/**
	 * 
	 */
	@Override
	public List<MenuVO> searchMenu(String cafeName, String keyword) throws Exception {
		return menuDao.searchMenu(cafeName, keyword);
	}

	@Override
	public void deleteMenu(String cafeName, String menuName) throws Exception {
		menuDao.deleteMenu(cafeName, menuName);
	}
	
}
