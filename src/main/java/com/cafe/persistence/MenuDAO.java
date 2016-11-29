package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.MenuVO;
/**
 * Cafeteria dao interface
 * @author YJH
 * 2016.11.08.Tue
 */
public interface MenuDAO {

	// insert a menu 
	public void menuRegister(MenuVO menu) throws Exception;
	// diplay all menu list
	public List<MenuVO> menuList(String cafeName) throws Exception;
	// delete a menu
	public void deleteMenu(String cafeName, String menuName) throws Exception;
	//menu search
	public List<MenuVO> searchMenu(String cafeName, String keyword) throws Exception;
	//menu check exist of not
	public int checkMenu(String cafeName, String menuName) throws Exception;
	/**
	 * app : show top10 menu list order by like
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.29.Tue
	 */
	public List<MenuVO> top10Like() throws Exception;
	/**
	 * app : show top10 menu list order by point
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.29.Tue
	 */
	public List<MenuVO> top10Point() throws Exception;
	
	public void count(String cafeName, String detailName, String menuName)throws Exception;
	public void discount(String cafeName, String detailName, String menuName)throws Exception;
	public int checkLikeNum(String cafeName, String detailName, String menuName)throws Exception;
	
}
