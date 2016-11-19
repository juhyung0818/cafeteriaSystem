package com.cafe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weekly/*")
public class Weekly {
	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(Weekly.class);
	
	
}
