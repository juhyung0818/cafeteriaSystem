package com.cafe.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.util.WebUtils;

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
	
	/**
	 * admin login 
	 * @author YJH
	 */
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto, Model model, HttpSession session){
		logger.info("user login...");
		UserVO user = (UserVO)session.getAttribute("login");
		model.addAttribute("user", user.getUid());
	}
	
	@RequestMapping(value="/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, Model model) throws Exception{
		
		AdminVO vo=userService.login(dto);
		
		if(vo==null)
			return;
		
		model.addAttribute("userVO", vo);
	}
	
	/**
	 * web : user logout
	 * @throws Exception
	 * @author YJH
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String longout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		
		logger.info("user logout...");

		Object adminObj;
		adminObj = session.getAttribute("login");

		// session 
		if (adminObj != null) {

			session.removeAttribute("login");
			session.invalidate();

			Cookie userCookie = WebUtils.getCookie(request, "userCookie");

			if (userCookie != null) {
				userCookie.setPath("/");
				userCookie.setMaxAge(0);
				response.addCookie(userCookie);
			}
		}
		return "redirect:/";
	}

}
