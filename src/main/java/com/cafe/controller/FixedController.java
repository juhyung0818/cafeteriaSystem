package com.cafe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe.domain.FixedVO;
import com.cafe.domain.ResultVO;
import com.cafe.service.FixedService;

@Controller
@RequestMapping("/fixed/*")
public class FixedController {

	@Inject
	FixedService fixedService;
	
	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(FixedController.class);
	
	/**
	 * app : show fixed menu list
	 * @param score
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.29.Tue
	 */
	@ResponseBody
	@RequestMapping(value="/listApp", method=RequestMethod.POST)
	public ResultVO listApp(@RequestBody FixedVO fix) throws Exception{
		logger.info("fixed menu list post.......");

		List<FixedVO> list = new ArrayList<FixedVO>();

		list=fixedService.fixedList(fix.getCafeName());
		return new ResultVO<>(list);
	}
	
//	model.addAttribute("list", cafeService.cafeList());


}
