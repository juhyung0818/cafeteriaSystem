package com.cafe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe.domain.CafeVO;
import com.cafe.domain.DetailVO;
import com.cafe.domain.MenuVO;
import com.cafe.domain.ResultVO;
import com.cafe.domain.SearchKeywordVO;
import com.cafe.service.CafeService;
import com.cafe.service.DetailService;
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
	@Inject
	private DetailService detailService;
	@Inject
	private CafeService cafeService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void menuListGET(@RequestParam("cafeName") String cafeName,
			@RequestParam("keyword") String keyword, Model model) throws Exception {
		logger.info("menu list....");
		List<MenuVO> menus = menuService.searchMenu(cafeName, keyword);
		model.addAttribute("menus", menus);
		List<DetailVO> details = detailService.detailList(cafeName);
		model.addAttribute("details", details);
		model.addAttribute("detailSize", details.size());
		model.addAttribute("cafeName", cafeName);
		model.addAttribute("keyword", keyword);
		model.addAttribute("list", cafeService.cafeList());
	}
	
	/**
	 * app : show menu list
	 * @param cafe
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.24.Thu
	 */
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public ResultVO<List<MenuVO>> listAll(@RequestBody CafeVO cafe) throws Exception
	{
		logger.info("menu list.....");
		
		List<MenuVO> list = new ArrayList<MenuVO>();
		list = menuService.menuList(cafe.getCafeName());
		
		return new ResultVO<>(list);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String menuRegisterPOST(@RequestParam("cafeName") String cafeName, 
			@RequestParam("detailName") String detailName,
			@RequestParam("menuName") String menuName,
			@RequestParam("price") int price,
			Model model, SearchKeywordVO key, RedirectAttributes rttr) throws Exception {
		logger.info("menu register....");
		MenuVO menu = new MenuVO();
		menu.setCafeName(cafeName);
		menu.setDetailName(detailName);
		menu.setMenuName(menuName);
		menu.setPrice(price);
		menuService.menuRegister(menu);
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", key.getKeyword());

		return "redirect:/menu/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String menuDeletePOST(@RequestParam("cafeName") String cafeName, 
			@RequestParam("detailName") String detailName,
			@RequestParam("menuName") String menuName,
			Model model, SearchKeywordVO key, RedirectAttributes rttr) throws Exception {
		logger.info("menu delete....");
		MenuVO menu = new MenuVO();
		menu.setCafeName(cafeName);
		menu.setDetailName(detailName);
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
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", keyword);
		return "redirect:/menu/list";
	}
	
	/**
	 * app : show top10 menu list order by like
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.29.Tue
	 */
	@ResponseBody
	@RequestMapping(value="/top10LikeApp", method=RequestMethod.POST)
	public ResultVO<List<MenuVO>> top10LikeApp() throws Exception
	{
		logger.info("top 10 like..");
		
		List<MenuVO> list = new ArrayList<MenuVO>();
		list = menuService.top10Like();
		
		return new ResultVO<>(list);
	}
	/**
	 * app : show top10 menu list order by point
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.29.Tue
	 */
	@ResponseBody
	@RequestMapping(value="/top10PointApp", method=RequestMethod.POST)
	public ResultVO<List<MenuVO>> top10PointApp() throws Exception
	{
		logger.info("top 10 like..");
		
		List<MenuVO> list = new ArrayList<MenuVO>();
		list = menuService.top10Point();
		
		return new ResultVO<>(list);
	}

}
