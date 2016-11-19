package com.cafe.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe.domain.MenuVO;
import com.cafe.service.MenuService;

/**
 * Menu Controller class
 * @author YJH
 * 2016.11.09.Wed
 */
@Controller
@RequestMapping("/menu/*")
public class MenuController {

	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	@Inject
	private MenuService menuService;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void menuRegisterGET(@RequestParam("cafeName") String cafeName, Model model) throws Exception{
		logger.info("menu register....");
//		List<MenuVO> list = menuService.menuList();
//		model.addAttribute("list", list);
		
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String menuRegisterPOST(@RequestParam("cafeName") String cafeName, 
			@RequestParam("menuName") String menuName, Model model) throws Exception{
		logger.info("menu register....");
		MenuVO menu = new MenuVO();
		menu.setCafeName(cafeName);
		menu.setMenuName(menuName);
		menuService.menuRegister(menu);
		return "home";
	}
	
}
