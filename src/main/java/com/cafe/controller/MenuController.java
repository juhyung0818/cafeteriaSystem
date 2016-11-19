package com.cafe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Menu Controller class
 * @author YJH
 * 2016.11.09.Wed
 */
@Controller
@RequestMapping("/menu/*")
public class MenuController {

	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	
}
