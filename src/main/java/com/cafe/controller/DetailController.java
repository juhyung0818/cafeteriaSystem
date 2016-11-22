package com.cafe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Cafeteria Controller class
 * @author YJH
 * 2016.11.08.Tue
 */
@Controller
@RequestMapping("/detail/*")
public class DetailController {

	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(DetailController.class);
		
//	@Inject
//	private CafeService cafeService;
}
