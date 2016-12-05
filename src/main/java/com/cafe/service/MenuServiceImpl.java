package com.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.MenuVO;
import com.cafe.exception.NotExistResultException;
import com.cafe.exception.PrimaryKeyDuplicatedException;
import com.cafe.persistence.DetailDAO;
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
	@Inject
	private DetailDAO detailDao;
	
	@Override
	public void menuRegister(MenuVO menu) throws Exception {
		if(menuDao.checkMenu(menu.getCafeName(), menu.getDetailName(), menu.getMenuName()) == 0){
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
	 * search menu in cafeteria
	 * @author YJH
	 */
	@Override
	public List<MenuVO> searchMenu(String cafeName, String keyword) throws Exception {
		List<MenuVO> searchList = menuDao.searchMenu(cafeName, keyword);
		List<MenuVO> list = menuDao.menuList(cafeName);

		if(list.size() > 0){//list is exist case
			if(searchList.size() > 0){
				return searchList;
			}else{ //list is exist && search list is not exist
				throw new NotExistResultException();
			}
		}else{ //list is not exist
			return list;
		}
	}

	@Override
	public void deleteMenu(String cafeName, String detailName, String menuName) throws Exception {
		menuDao.deleteMenu(cafeName, detailName, menuName);
	}
	@Override
	public List<MenuVO> top10Like() throws Exception{
		List<MenuVO> list = new ArrayList<>();
		list= menuDao.top10Like();
		//show top 10
		list=list.subList(0, 9);
		return list;
	}

	@Override
	public List<MenuVO> top10Point() throws Exception {
		
		List<MenuVO> list = new ArrayList<>();
		list= menuDao.top10Point();
		//show top 10
		list=list.subList(0, 9);
		return list;
	}

	/**
	 * search menu in corner
	 * @author YJH
	 */
	@Override
	public List<MenuVO> searchMenu(String cafeName, String detailName, String keyword) throws Exception {
//		List<MenuVO> searchList =
				return menuDao.searchMenu(cafeName, detailName, keyword);
//		List<MenuVO> list = menuDao.menuList(cafeName, detailName);

//		if(list.size() > 0){//list is exist case
//			if(searchList.size() > 0){
//				return searchList;
//			}else{ //list is exist && search list is not exist
//				throw new NotExistResultException();
//			}
//		}else{ //list is not exist
//			return list;
//		}
	}

	/**
	 * menu price modify
	 * @author YJH
	 */
	@Override
	public void modify(String cafeName, String detailName, String menuName, int price) throws Exception {
		menuDao.modify(cafeName, detailName, menuName, price);
		
	}

	@Override
	public MenuVO getMenu(String cafeName, String detailName, String menuName) throws Exception {
		return menuDao.getMenu(cafeName, detailName, menuName)
				;
	}
}
