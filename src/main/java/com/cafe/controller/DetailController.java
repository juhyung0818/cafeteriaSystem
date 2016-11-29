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

import com.cafe.domain.DetailVO;
import com.cafe.domain.SearchKeywordVO;
import com.cafe.service.CafeService;
import com.cafe.service.DetailService;

/**
 * Detail of cafeteria Controller class
 * @author YJH
 * 2016.11.22.Tue
 */
@Controller
@RequestMapping("/detail/*")
public class DetailController {

	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(DetailController.class);
	//create datail service object
	@Inject
	private DetailService detailService;
	//create cafe service object
	@Inject
	private CafeService cafeService;
	
	/**
	 * display detail list of cafeteria
	 * @param cafeName
	 * @param model
	 * @throws Exception
	 * @author YJH
	 */
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void readDetailGET(@RequestParam("cafeName") String cafeName,
			@RequestParam("keyword") String keyword, Model model) throws Exception{
		model.addAttribute("list", cafeService.cafeList());
		List<DetailVO> list = detailService.detailSearch(cafeName, keyword);
		model.addAttribute("cafeName", cafeName);
		model.addAttribute("details", list);
		model.addAttribute("keyword", keyword);

	}
	
	/**
	 * web :add detail cafeteria(corner)
	 * @param cafeName
	 * @param detailName
	 * @param key
	 * @param rttr
	 * @param model
	 * @throws Exception
	 * @author YJH
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerDetailPOST(@RequestParam("cafeName") String cafeName,
			@RequestParam("detailName") String detailName,SearchKeywordVO key,
			RedirectAttributes rttr, Model model) throws Exception {
		
		logger.info("Detail register....");
		
		DetailVO detail = new DetailVO();
		detail.setCafeName(cafeName);
		detail.setDetailName(detailName);
		detailService.registerDetail(cafeName, detailName);
		
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", key.getKeyword());
		
		return "redirect:/detail/list";
	}
	
	/**
	 * web :remove detail cafeteria(corner)
	 * @param cafeName
	 * @param detailName
	 * @param key
	 * @param rttr
	 * @param model
	 * @throws Exception
	 * @author YJH
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteDetailPOST(@RequestParam("cafeName") String cafeName,
			@RequestParam("detailName") String detailName, SearchKeywordVO key,
			RedirectAttributes rttr, Model model) throws Exception{
		
		logger.info("Detail delete....");
		
		detailService.deleteDetail(cafeName, detailName);
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", key.getKeyword());

		return "redirect:/detail/list";
	}

	/**
	 * web :search detail cafeteria(corner)
	 * @param cafeName
	 * @param keyword
	 * @param model
	 * @param rttr
	 * @throws Exception
	 * @author YJH
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String menuSearhPOST(@RequestParam("cafeName") String cafeName,
			@RequestParam("keyword") String keyword,
			Model model, RedirectAttributes rttr) throws Exception {
		
		logger.info("Detail search....");
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", keyword);
		
		return "redirect:/detail/list";
	}
	
}
