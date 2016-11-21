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
 * Cafeteria Controller class
 * @author YJH
 * 2016.11.08.Tue
 */

@Controller
@RequestMapping("/cafe/*")
public class CafeController {

	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(CafeController.class);
	
	@Inject
	private CafeService cafeService;

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void registGET(Model model) throws Exception {
		logger.info("Cafeteria register....");
		model.addAttribute("list", cafeService.cafeList());
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public void mainGET(Model model) throws Exception {
		logger.info("Cafeteria register....");
	}	
	
	@RequestMapping(value = "/addmenu", method = RequestMethod.GET)
	public void addmenuGet(Model model) throws Exception {
		logger.info("addmenu....");
	}
	
	@RequestMapping(value = "/menulist", method = RequestMethod.GET)
	public void menulistGet(Model model) throws Exception {
		logger.info("menulist....");
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public void reviewGet(Model model) throws Exception {
		logger.info("review....");
	}
	
	@RequestMapping(value = "/complain", method = RequestMethod.GET)
	public void complainGet(Model model) throws Exception {
		logger.info("review....");
	}
}
