package com.cafe.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe.domain.LikeVO;
import com.cafe.domain.ResultVO;
import com.cafe.service.LikeService;

@Controller
@RequestMapping("/like/*")
public class LikeController {

	// use log4j
	private static final Logger logger = LoggerFactory.getLogger(LikeController.class);
	
	@Inject
	private LikeService likeService;
	
	@ResponseBody
	@RequestMapping(value="/checkLike", method=RequestMethod.POST)
	public ResultVO registerAppPOST(@RequestBody LikeVO like) throws Exception{
		
		logger.info("check like app post.......");
		likeService.checkLike(like);
		
		return new ResultVO();
	}
}
