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

import com.cafe.domain.MenuVO;
import com.cafe.domain.ResultVO;
import com.cafe.domain.WeeklyVO;
import com.cafe.flag.DateFlag;
import com.cafe.flag.WeeklyFlag;
import com.cafe.service.CafeService;
import com.cafe.service.DetailService;
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
	@Inject
	private WeeklyService weeklyService;
	@Inject
	private CafeService cafeService;
	@Inject
	private DetailService detailService;

	@RequestMapping(value="/weeklyList", method = RequestMethod.GET)
	public void tableGET(@RequestParam("cafeName") String cafeName, Model model) throws Exception{
		logger.info("Weekly table...");
		List<WeeklyVO> weeklis = weeklyService.weeklyList(cafeName);
		model.addAttribute("weeklis", weeklis);
		model.addAttribute("cafeName", cafeName);
		
		
		model.addAttribute("list", cafeService.cafeList()); // list for menu bar 
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerPOST(@RequestParam("cafeName") String cafeName, 
			@RequestParam("menuName") String menuName,
			@RequestParam("wFlag") int wFlag,
			@RequestParam("dateFlag") int dateFlag,
			Model model) throws Exception{
		logger.info("Weekly register...");
		
		List<WeeklyVO> list = weeklyService.weeklyList(cafeName);
		model.addAttribute("list", list);
		return "redirect:/weekly/weeklyList";
	}	
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String deletePOST(@RequestParam("cafeName") String cafeName, 
			@RequestParam("menuName") String menuName,
			@RequestParam("wFlag") WeeklyFlag wFlag,
			@RequestParam("dateFlag") DateFlag dateFlag,
			Model model, RedirectAttributes rttr) throws Exception{
		logger.info("Weekly delete...");
		WeeklyVO weekly = new WeeklyVO();
		weekly.setCafeName(cafeName);
		weekly.setMenuName(menuName);
		weekly.setwFlag(wFlag);
		weekly.setDateFlag(dateFlag);
		weeklyService.delete(weekly);
		rttr.addAttribute("cafeName", cafeName);
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
	public ResultVO listApp(@RequestBody WeeklyVO week) throws Exception{
		logger.info("weekly list post.......");

		List<WeeklyVO> list = new ArrayList<WeeklyVO>();

		list=weeklyService.weeklyList(week.getCafeName());
		return new ResultVO<>(list);
	}
}
