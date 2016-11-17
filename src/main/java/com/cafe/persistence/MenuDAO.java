package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.MenuVO;

public interface MenuDAO {

	public void menuRegister(MenuVO menu) throws Exception;
	public List<MenuVO> menuList() throws Exception;
}
