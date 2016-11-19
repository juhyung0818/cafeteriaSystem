package com.cafe.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.MenuVO;
/**
 * Menu dao class
 * @author YJH
 * 2016.11.08.Tue
 */
@Repository
public class MenuDAOImpl implements MenuDAO{

	@Inject
	private SqlSession session;
	private String namespace = "com.cafe.mapper.MenuMapper";
	
	@Override
	public void menuRegister(MenuVO menu) throws Exception {
		session.insert(namespace + ".register", menu);
	}

	@Override
	public List<MenuVO> menuList() throws Exception {
		return session.selectList(namespace + ".menuList");
	}

	/**
	 * search menu in menu table
	 * return : menu list contain keyword
	 */
	@Override
	public List<MenuVO> searchMenu(String cafeName, String keyword) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", cafeName);
		param.put("keyword", keyword);
		return session.selectList(namespace + ".searchMenu", param);
	}

}
