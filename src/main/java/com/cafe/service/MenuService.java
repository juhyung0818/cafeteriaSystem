package com.cafe.service;

import java.util.List;

import com.cafe.domain.MenuVO;
import com.cafe.dto.MenuDTO;
/**
 * Menu service interface
 * @author YJH
 * 2016.11.08.Tue
 */
public interface MenuService {

	public void menuRegister(MenuVO menu) throws Exception;
	public List<MenuVO> menuList(String cafeName) throws Exception;
	//menu search
	public List<MenuVO> searchMenu(String cafeName, String keyword) throws Exception;
	public List<MenuVO> searchMenu(String cafeName, String detailName, String keyword) throws Exception;
	//delete a menu
	public void deleteMenu(String cafeName, String detailName, String menuName) throws Exception;
	
	/**
	 * app : show top10 menu list order by like
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.29.Tue
	 */
	public List<MenuDTO> top10Like(String uid) throws Exception;
	/**
	 * app : show top10 menu list order by point
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.29.Tue
	 */
	public List<MenuDTO> top10Point(String uid) throws Exception;
	
	public List<MenuDTO> searchApp(String uid, String keyword) throws Exception;
	/**
	 * menu price modify
	 * @author YJH
	 */
	public void modify(String cafeName, String detailName, String menuName, int price) throws Exception;
	/**
	 * get a menu data all
	 * @author YJH
	 */
	public MenuVO getMenu(String cafeName, String detailName, String menuName) throws Exception;
}
