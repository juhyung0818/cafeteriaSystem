package com.cafe.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe.service.WeeklyService;

@Controller
@RequestMapping("/weekly/*")
public class WeeklyController {
	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(WeeklyController.class);
	@Inject
	private WeeklyService weekly;
	
	//TODO register, delete, reset, list

}
