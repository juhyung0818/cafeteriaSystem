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

import com.cafe.domain.CafeVO;
import com.cafe.domain.SearchKeywordVO;
import com.cafe.service.CafeService;

/**
 * Cafeteria Controller class
 * @author Cho, YJH
 * 2016.11.22.Tue
 */

@Controller
@RequestMapping("/cafe/*")
public class CafeController {

	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(CafeController.class);
	
	//create services
	@Inject
	private CafeService cafeService;
	
	/**
	 * display cafe list
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void cafeListGET(@RequestParam("keyword") String keyword, Model model) throws Exception {
		
		logger.info("Cafeteria list....");
		
		List<CafeVO> cafes = cafeService.cafeSearch(keyword);
		model.addAttribute("cafes", cafes);
		model.addAttribute("keyword", keyword);

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String menuRegisterPOST(@RequestParam("cafeName") String cafeName, 
			Model model, SearchKeywordVO key, RedirectAttributes rttr) throws Exception {
		
		logger.info("Cafeteria register....");
		
		CafeVO cafe = new CafeVO();
		cafe.setCafeName(cafeName);
		cafe.setInfo("");
		cafeService.cafeRegister(cafe);
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", key.getKeyword());
		
		return "redirect:/cafe/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String menuDeletePOST(@RequestParam("cafeName") String cafeName, 
			Model model, SearchKeywordVO key, RedirectAttributes rttr) throws Exception {
		
		logger.info("Cafeteria delete....");
		
		cafeService.deleteCafe(cafeName);
		rttr.addAttribute("keyword", key.getKeyword());
		
		return "redirect:/cafe/list";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String menuSearhPOST(@RequestParam("keyword") String keyword,
			Model model, RedirectAttributes rttr) throws Exception {
		
		logger.info("Cafeteria search....");
		rttr.addAttribute("keyword", keyword);
		
		return "redirect:/cafe/list";
	}

}
