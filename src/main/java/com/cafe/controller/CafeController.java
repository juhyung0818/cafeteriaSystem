package com.cafe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe.domain.CafeVO;
import com.cafe.domain.DetailVO;
import com.cafe.service.CafeService;
import com.cafe.service.DetailService;

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
	@Inject
	private DetailService detailService;
	
	/**
	 * display cafe list
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void cafeListGET(Model model) throws Exception {
		logger.info("Cafeteria list....");
		
		List<CafeVO> cafes= cafeService.cafeList();
		model.addAttribute("cafes", cafes);
		
		//cafeteria and detail matching
		List<DetailVO> details = new ArrayList<>();
		for(CafeVO cafe : cafes){
			List<DetailVO> temp = new ArrayList<>();
			temp = detailService.detailList(cafe.getCafeName());
			for(DetailVO detail : temp){
				details.add(detail);
			}
		}
		model.addAttribute("details", details);
		model.addAttribute("list", cafeService.cafeList());

	}
}
