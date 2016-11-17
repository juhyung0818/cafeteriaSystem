package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.MenuVO;
import com.cafe.persistence.MenuDAO;

@Service
public class MenuServiceImpl implements MenuService{

	@Inject
	private MenuDAO menuDao;
	
	@Override
	public void menuRegister(MenuVO menu) throws Exception {
		menuDao.menuRegister(menu);
	}

	@Override
	public List<MenuVO> menuList() throws Exception {
		return menuDao.menuList();
	}
	
}
