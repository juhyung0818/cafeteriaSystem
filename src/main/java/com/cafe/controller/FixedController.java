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

import com.cafe.domain.FixedVO;
import com.cafe.domain.MenuVO;
import com.cafe.domain.ResultVO;
import com.cafe.service.CafeService;
import com.cafe.service.FixedService;
import com.cafe.service.MenuService;
/**
 * Detail of cafeteria Controller class
 * @author YJH, Kown
 * 2016.11.21.Mon
 */
@Controller
@RequestMapping("/fixed/*")
public class FixedController {

	//create Services objects
	@Inject
	CafeService cafeService;
	@Inject
	MenuService menuService;
	@Inject
	FixedService fixedService;
	
	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(FixedController.class);
	
	/**
	 * app : show fixed menu list
	 * @param score
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.29.Tue
	 */
	@ResponseBody
	@RequestMapping(value="/listApp", method=RequestMethod.POST)
	public ResultVO listApp(@RequestBody FixedVO fix) throws Exception{
		logger.info("fixed menu list post.......");

		List<FixedVO> list = new ArrayList<FixedVO>();

		list=fixedService.fixedList(fix.getCafeName());
		return new ResultVO<>(list);
	}
	
	/**
	 * web :display fixed menu list
	 * @param cafeName
	 * @param keyword
	 * @param model
	 * @throws Exception
	 * @author YJH
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listGET(@RequestParam("cafeName") String cafeName, 
			@RequestParam("keyword") String keyword, Model model) throws Exception{
		logger.info("fixed menu list get.......");

		//fixed menu list
		List<FixedVO> fixeds = new ArrayList<FixedVO>();
		fixeds = fixedService.fixedSearch(cafeName, keyword);
		
		//send data to view
		model.addAttribute("fixeds", fixeds);
		model.addAttribute("cafeName", cafeName);
		model.addAttribute("keyword", keyword);
		model.addAttribute("list", cafeService.cafeList()); //list for menu bar
	}
	
	/**
	 * web : search fixed menu
	 * @param cafeName
	 * @param keyword
	 * @param rttr
	 * @param model
	 * @throws Exception
	 * @author YJH
	 */
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchPOST(@RequestParam("cafeName") String cafeName, 
			@RequestParam("keyword") String keyword,
			RedirectAttributes rttr, Model model) throws Exception{
		logger.info("fixed menu list get.......");

		//send data to view
		model.addAttribute("list", cafeService.cafeList()); //list for menu bar
		model.addAttribute("cafeName", cafeName);
		model.addAttribute("keyword", keyword);
		
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", keyword);
		
		return "redirect:/fixed/list";
	}
	
	/**
	 * web : register view for fixed menu
	 * @param cafeName
	 * @param keyword
	 * @param rttr
	 * @param model
	 * @throws Exception
	 * @author YJH
	 */
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET(@RequestParam("cafeName") String cafeName,
			@RequestParam("keyword") String keyword,
			RedirectAttributes rttr, Model model) throws Exception{
		logger.info("fixed menu register get.......");

		//this cafeteria has menus
		List<MenuVO> menus = menuService.searchMenu(cafeName, keyword);
		model.addAttribute("menus", menus);
		model.addAttribute("cafeName", cafeName);
		model.addAttribute("keyword", keyword);
		model.addAttribute("list", cafeService.cafeList()); //list for menu bar
		
	}
	
	/**
	 * web : register post for fixed menu
	 * @param cafeName
	 * @param detailName
	 * @param menuName
	 * @param keyword
	 * @param rttr
	 * @param model
	 * @throws Exception
	 * @author YJH
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPOST(@RequestParam("cafeName") String cafeName,
			@RequestParam("detailName") String detailName,
			@RequestParam("menuName") String menuName,
			@RequestParam("keyword") String keyword,
			RedirectAttributes rttr, Model model) throws Exception{
		logger.info("fixed menu register post.......");

		model.addAttribute("list", cafeService.cafeList()); //list for menu bar
		
		FixedVO fixed = new FixedVO();
		fixed.setCafeName(cafeName);
		fixed.setDetailName(detailName);
		fixed.setMenuName(menuName);
		fixedService.register(fixed);
		//send data to view
		model.addAttribute("cafeName", cafeName);
		model.addAttribute("keyword", keyword);
		//redirect attribute
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", "");
		
		return "redirect:/fixed/list";
	}
	
	@RequestMapping(value="/searchMenu", method=RequestMethod.POST)
	public String searchMenuPOST(@RequestParam("cafeName") String cafeName, 
			@RequestParam("keyword") String keyword,
			RedirectAttributes rttr, Model model) throws Exception{
		logger.info("search menu list post.......");

		//send data to view
		model.addAttribute("list", cafeService.cafeList()); //list for menu bar
		model.addAttribute("cafeName", cafeName);
		model.addAttribute("keyword", keyword);
		
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", keyword);
		
		return "redirect:/fixed/register";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deletePOST(@RequestParam("cafeName") String cafeName,
			@RequestParam("detailName") String detailName,
			@RequestParam("menuName") String menuName,
			@RequestParam("keyword") String keyword,
			RedirectAttributes rttr, Model model) throws Exception{
		logger.info("fixed menu delete get.......");

		model.addAttribute("list", cafeService.cafeList()); //list for menu bar
		
		FixedVO fixed = new FixedVO();
		fixed.setCafeName(cafeName);
		fixed.setDetailName(detailName);
		fixed.setMenuName(menuName);
		fixedService.delete(fixed);
		
		//send data to view
		model.addAttribute("cafeName", cafeName);
		model.addAttribute("keyword", keyword);
		
		//redirect attribute
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", "");
		
		return "redirect:/fixed/list";
	}
}
