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
	public List<MenuVO> menuList(String cafeName) throws Exception {
		return session.selectList(namespace + ".menuList", cafeName);
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

	@Override
	public int checkMenu(String cafeName, String menuName) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", cafeName);
		param.put("menuName", menuName);
		return session.selectOne(namespace + ".check", param);
	}

	@Override
	public void deleteMenu(String cafeName, String detailName, String menuName) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", cafeName);
		param.put("detailName", detailName);
		param.put("menuName", menuName);
		session.update(namespace + ".delete", param);
	}

	@Override
	public List<MenuVO> top10Like() throws Exception {
		
		return session.selectList(namespace+".top10Like");
	}

	@Override
	public List<MenuVO> top10Point() throws Exception {
		
		return session.selectList(namespace+".top10Point");
	}

	@Override
	public void count(String cafeName, String detailName, String menuName) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", cafeName);
		param.put("detailName", detailName);
		param.put("menuName", menuName);
		
		session.update(namespace+".count", param);
	}

	
	@Override
	public void discount(String cafeName, String detailName, String menuName) throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", cafeName);
		param.put("detailName", detailName);
		param.put("menuName", menuName);
		
		session.update(namespace+".discount", param);
	}

	@Override
	public int checkLikeNum(String cafeName, String detailName, String menuName) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", cafeName);
		param.put("detailName", detailName);
		param.put("menuName", menuName);
		
		return session.selectOne(namespace+".checkLikeNum", param);
	}


	/**
	 * cafeteria + detail search
	 */
	@Override
	public List<MenuVO> searchMenu(String cafeName, String detailName, String keyword) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", cafeName);
		param.put("detailName", detailName);
		param.put("keyword", keyword);
		return session.selectList(namespace + ".searchDetailMenu", param);
	}

	@Override
	public void setPoint(String cafeName, String detailName, String menuName, float point) throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", cafeName);
		param.put("detailName", detailName);
		param.put("menuName", menuName);
		param.put("point", point);
		
		session.update(namespace+".setPoint", param);
		
	}

}
