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

import com.cafe.domain.DetailVO;
import com.cafe.domain.MenuVO;
import com.cafe.domain.ResultVO;
import com.cafe.domain.WeeklyVO;
import com.cafe.dto.WeeklyDTO;
import com.cafe.exception.NotExistResultException;
import com.cafe.flag.DateFlag;
import com.cafe.flag.WeeklyFlag;
import com.cafe.service.CafeService;
import com.cafe.service.DetailService;
import com.cafe.service.MenuService;
import com.cafe.service.WeeklyService;

/**
 * Weekly menu Controller class
 * @author YJH
 * 2016.11.20.SUN
 */
@Controller
@RequestMapping("/weekly/*")
public class WeeklyController {
	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(WeeklyController.class);
	//inject needed service 
	@Inject
	private WeeklyService weeklyService;
	@Inject
	private CafeService cafeService;
	@Inject
	private MenuService menuService;
	@Inject
	private DetailService detailService;


	@RequestMapping(value="/weeklyList", method = RequestMethod.GET)
	public void weeklyListGET(@RequestParam("cafeName") String cafeName,
			@RequestParam("detailName") String detailName,
			@RequestParam("keyword") String keyword,
			Model model) throws Exception{
		
		logger.info("Weekly list...");

		List<WeeklyVO> weeklis = weeklyService.weeklyList(cafeName);
		model.addAttribute("weeklis", weeklis);
		if(weeklis.size() == 0){
			model.addAttribute("weekSize", 1);
		}else{
			model.addAttribute("weekSize", weeklis.size());
		}
		model.addAttribute("cafeName", cafeName);
		model.addAttribute("list", cafeService.cafeList()); // list for menu bar 
		List<DetailVO> details = detailService.detailList(cafeName);
		model.addAttribute("details", details);
		model.addAttribute("size", details.size());

	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String deletePOST(@RequestParam("cafeName") String cafeName,
			@RequestParam("detailName") String detailName,
			@RequestParam("menuName") String menuName,
			@RequestParam("wFlag") int wFlag,
			@RequestParam("dateFlag") int dateFlag,
			@RequestParam("keyword") String keyword,
			Model model, RedirectAttributes rttr) throws Exception{
		
		logger.info("Weekly delete...");
		
		WeeklyVO weekly = new WeeklyVO();
		weekly.setCafeName(cafeName);
		weekly.setDetailName(detailName);
		weekly.setMenuName(menuName);
		weekly.setwFlag(WeeklyFlag.valueOf(wFlag));
		weekly.setDateFlag(DateFlag.valueOF(dateFlag));
		weeklyService.delete(weekly);
		
		//rediret attribute
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("detailName", detailName);
		rttr.addAttribute("keyword", "");
		return "redirect:/weekly/weeklyList";
	}
	
	/**
	 * app : show weekly menu list
	 * @param score
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.29.Tue
	 */
	@ResponseBody
	@RequestMapping(value="/listApp", method=RequestMethod.POST)
	public ResultVO<List<WeeklyDTO>> listApp(@RequestBody WeeklyVO week) throws Exception{
		logger.info("weekly list post.......");

		List<WeeklyDTO> list = new ArrayList<WeeklyDTO>();

		list=weeklyService.weeklyListApp(week.getCafeName(), week.getwFlag());
		
		return new ResultVO<>(list);
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void weeklySearchListGET(@RequestParam("cafeName") String cafeName, 
			@RequestParam("detailName") String detailName,
			@RequestParam("keyword") String keyword,
			@RequestParam("wFlag") int wFlag,
			@RequestParam("dateFlag") int dateFlag,
			Model model) throws Exception {
		
		logger.info("weeklt list....");
		List<MenuVO> menus = menuService.searchMenu(cafeName, detailName, keyword);
		model.addAttribute("menus", menus);
		model.addAttribute("cafeName", cafeName);
		model.addAttribute("detailName", detailName);
		model.addAttribute("keyword", keyword);
		model.addAttribute("wFlag", wFlag);
		model.addAttribute("dateFlag", dateFlag);
		model.addAttribute("list", cafeService.cafeList());
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String weeklySearhPOST(@RequestParam("cafeName") String cafeName, 
			@RequestParam("detailName") String detailName,
			@RequestParam("keyword") String keyword,
			@RequestParam("wFlag") int wFlag,
			@RequestParam("dateFlag") int dateFlag,
			Model model, RedirectAttributes rttr) throws Exception {
		
		logger.info("weekly search ....");
		
		model.addAttribute("cafeName", cafeName);
		model.addAttribute("detailName", detailName);
		model.addAttribute("keyword", keyword);
		model.addAttribute("wFlag", wFlag);
		model.addAttribute("dateFlag", dateFlag);
		
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("detailName", detailName);
		rttr.addAttribute("keyword", keyword);
		rttr.addAttribute("wFlag", wFlag);
		rttr.addAttribute("dateFlag", dateFlag);
		return "redirect:/weekly/list";
	}
	
	//add weekly
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerPOST(@RequestParam("cafeName") String cafeName, 
			@RequestParam("detailName") String detailName,
			@RequestParam("menuName") String menuName,
			@RequestParam("keyword") String keyword,
			@RequestParam("wFlag") int wFlag,
			@RequestParam("dateFlag") int dateFlag,
	Model model, RedirectAttributes rttr) throws Exception{
		logger.info("Weekly register...");
		
		//insert weekly to db
		WeeklyVO weekly = new WeeklyVO();
		weekly.setCafeName(cafeName);
		weekly.setDetailName(detailName);
		weekly.setMenuName(menuName);
		weekly.setwFlag(WeeklyFlag.valueOf(wFlag));
		weekly.setDateFlag(DateFlag.valueOF(dateFlag));
		weeklyService.register(weekly);
		
		//redirect attributes
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("detailName", detailName);
		rttr.addAttribute("keyword", keyword);
		return "redirect:/weekly/weeklyList";
	}	
}
