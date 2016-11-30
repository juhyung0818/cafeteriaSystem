package com.cafe.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe.domain.AdminVO;
import com.cafe.domain.ResultVO;
import com.cafe.domain.UserVO;
import com.cafe.dto.LoginDTO;
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
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto){
		
	}
	
	@RequestMapping(value="/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception{
		
		AdminVO vo=userService.login(dto);
		
		if(vo==null)
			return;
		
		model.addAttribute("userVO", vo);
	}
}
