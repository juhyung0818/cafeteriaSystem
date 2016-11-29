package com.cafe.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe.domain.ResultVO;
import com.cafe.domain.UserVO;
import com.cafe.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {

	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(WeeklyController.class);
	@Inject
	UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/check", method = RequestMethod.POST)
	public ResultVO checkPOST(@RequestBody UserVO user) throws Exception{
		logger.info("user check register...");
		userService.check(user);
		return new ResultVO();
	}	
}
