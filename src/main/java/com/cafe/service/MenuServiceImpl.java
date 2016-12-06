package com.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.LikeVO;
import com.cafe.domain.MenuVO;
import com.cafe.dto.MenuDTO;
import com.cafe.exception.NotExistResultException;
import com.cafe.exception.PrimaryKeyDuplicatedException;
import com.cafe.persistence.DetailDAO;
import com.cafe.persistence.LikeDAO;
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
	@Inject
	private LikeDAO likeDao;
	
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
	public List<MenuDTO> top10Like(String uid) throws Exception{
		List<MenuDTO> list = new ArrayList<>();
		list= menuDao.top10Like();
		
		for (MenuDTO menuDTO : list) {
			menuDTO.setCommentCnt(menuDao.getCommentCnt(menuDTO.getCafeName(), menuDTO.getDetailName(), menuDTO.getMenuName()));
			
			LikeVO tempLike=new LikeVO();
			
			tempLike.setCafeName(menuDTO.getCafeName());
			tempLike.setDetailName(menuDTO.getDetailName());
			tempLike.setMenuName(menuDTO.getMenuName());
			tempLike.setUid(uid);
			int temp=likeDao.checkLike(tempLike);
			if(temp<1)
				menuDTO.setIsLike(false);
			else
				menuDTO.setIsLike(true);
		}
		//show top 10
		return list;
	}

	@Override
	public List<MenuDTO> top10Point(String uid) throws Exception {
		
		List<MenuDTO> list = new ArrayList<>();
		list= menuDao.top10Point();
		
		for (MenuDTO menuDTO : list) {
			LikeVO tempLike=new LikeVO();
			
			tempLike.setCafeName(menuDTO.getCafeName());
			tempLike.setDetailName(menuDTO.getDetailName());
			tempLike.setMenuName(menuDTO.getMenuName());
			tempLike.setUid(uid);
			int temp=likeDao.checkLike(tempLike);
			if(temp<1)
				menuDTO.setIsLike(false);
			else
				menuDTO.setIsLike(true);
		}
		//show top 10
		return list;
	}

	/**
	 * search menu in corner
	 * @author YJH
	 */
	@Override
	public List<MenuVO> searchMenu(String cafeName, String detailName, String keyword) throws Exception {
				return menuDao.searchMenu(cafeName, detailName, keyword);
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

	@Override
	public List<MenuDTO> searchApp(String uid, String keyword) throws Exception {

		List<MenuDTO> list = new ArrayList<>();
		list=menuDao.searchApp(keyword);

		for (MenuDTO menuDTO : list) {
			LikeVO tempLike=new LikeVO();
			
			tempLike.setCafeName(menuDTO.getCafeName());
			tempLike.setDetailName(menuDTO.getDetailName());
			tempLike.setMenuName(menuDTO.getMenuName());
			tempLike.setUid(uid);
			int temp=likeDao.checkLike(tempLike);
			if(temp<1)
				menuDTO.setIsLike(false);
			else
				menuDTO.setIsLike(true);
		}
		return list;
	}
}
