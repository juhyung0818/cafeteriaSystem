package com.cafe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe.domain.CafeVO;
import com.cafe.domain.ResultVO;
import com.cafe.service.CafeService;

/**
 * Comment Controller class
 * @author kwon
 * 2016.11.19.Sat
 */

@Controller
@RequestMapping("/comment/*")
public class CommentController {

	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
//	@Inject
//	private CafeService cafeService;
//
//	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public void registGET(Model model) throws Exception {
//		logger.info("Cafeteria list....");
//		model.addAttribute("list", cafeService.cafeList());
//	}
//	
//	
//	@ResponseBody
//	@RequestMapping(value="/register", method=RequestMethod.POST)
//	public ResultVO regist(@RequestBody CafeVO cafe) throws Exception{
//		logger.info("cafeteria register post.......");
//
//		cafeService.cafeRegister(cafe);
//		return new ResultVO();
//	}
//	
//	@ResponseBody
//	@RequestMapping(value="/delete", method=RequestMethod.POST)
//	public ResultVO delete(@RequestBody CafeVO cafe) throws Exception{
//		logger.info("cafeteria register post.......");
//
//		cafeService.cafeDelete(cafe.getCafeName());
//		return new ResultVO();
//	}
//	
//	@ResponseBody
//	@RequestMapping(value="/list", method=RequestMethod.POST)
//	public ResultVO list(@RequestBody CafeVO cafe) throws Exception{
//		logger.info("cafeteria register post.......");
//
//		List<CafeVO> list = new ArrayList<CafeVO>();
//
//		list=cafeService.cafeList();
//		return new ResultVO<>(list);
//	}

}
