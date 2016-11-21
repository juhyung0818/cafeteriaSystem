package com.cafe.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe.domain.MenuVO;
import com.cafe.domain.SearchKeywordVO;
import com.cafe.service.MenuService;

/**
 * Menu Controller class
 * 
 * @author YJH 2016.11.09.Wed
 */
@Controller
@RequestMapping("/menu/*")
public class MenuController {

	// use log4j
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	@Inject
	private MenuService menuService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void menuListGET(@RequestParam("cafeName") String cafeName,
			@RequestParam("keyword") String keyword, Model model) throws Exception {
		logger.info("menu register....");
		List<MenuVO> list = menuService.searchMenu(cafeName, keyword);

		model.addAttribute("list", list);
		model.addAttribute("cafeName", cafeName);
		model.addAttribute("keyword", keyword);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String menuRegisterPOST(@RequestParam("cafeName") String cafeName, @RequestParam("menuName") String menuName,
			@RequestParam("price") int price,
			Model model, SearchKeywordVO key, RedirectAttributes rttr) throws Exception {
		logger.info("menu register....");
		MenuVO menu = new MenuVO();
		menu.setCafeName(cafeName);
		menu.setMenuName(menuName);
		menu.setPrice(price);
		menuService.menuRegister(menu);
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", key.getKeyword());

		return "redirect:/menu/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String menuDeletePOST(@RequestParam("cafeName") String cafeName, @RequestParam("menuName") String menuName,
			Model model, SearchKeywordVO key, RedirectAttributes rttr) throws Exception {
		logger.info("menu search....");
		MenuVO menu = new MenuVO();
		menu.setCafeName(cafeName);
		menu.setMenuName(menuName);
		menuService.deleteMenu(cafeName, menuName);
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", key.getKeyword());
		return "redirect:/menu/list";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String menuSearhPOST(@RequestParam("cafeName") String cafeName, @RequestParam("keyword") String keyword,
			Model model, RedirectAttributes rttr) throws Exception {
		logger.info("menu search....");
//		menuService.searchMenu(cafeName, key);
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", keyword);
		return "redirect:/menu/list";
	}

}
