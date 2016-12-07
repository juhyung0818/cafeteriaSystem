package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.MenuVO;
import com.cafe.dto.MenuDTO;
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
	// diplay corner menu list
	public List<MenuVO> menuList(String cafeName, String detailName) throws Exception;
	// delete a menu
	public void deleteMenu(String cafeName, String detailName, String menuName) throws Exception;
	//menu search
	public List<MenuVO> searchMenu(String cafeName, String keyword) throws Exception;
	public List<MenuVO> searchMenu(String cafeName, String detailName, String keyword) throws Exception;
	//menu check exist of not
	public int checkMenu(String cafeName, String detailName, String menuName) throws Exception;
	/**
	 * app : show top10 menu list order by like
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.29.Tue
	 */
	public List<MenuDTO> top10Like() throws Exception;
	/**
	 * app : show top10 menu list order by point
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.29.Tue
	 */
	public List<MenuDTO> top10Point() throws Exception;
	
	public List<MenuDTO> searchApp(String keyword) throws Exception;
	
	public void count(String cafeName, String detailName, String menuName)throws Exception;
	public void discount(String cafeName, String detailName, String menuName)throws Exception;
	public int checkLikeNum(String cafeName, String detailName, String menuName)throws Exception;
	public void setPoint(String cafeName, String detailName, String menuName, float point)throws Exception;
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
	/**
	 * number of comment
	 * @author YJH
	 */
	public int getCommentCnt(String cafeName, String detailName, String menuName) throws Exception;
	//chekc menu
	public int check(String cafeName, String detailName, String menuName) throws Exception;
}
