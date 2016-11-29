package com.cafe.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe.service.CafeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private CafeService cafeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String cafeListGET(Model model) throws Exception {
		logger.info("Cafeteria list ....");
		model.addAttribute("list", cafeService.cafeList());
		return "/home";
	}
	
}
