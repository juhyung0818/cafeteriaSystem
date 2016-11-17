package com.cafe.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.MenuVO;

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

}
