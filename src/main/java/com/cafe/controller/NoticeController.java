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

import com.cafe.domain.NoticeVO;
import com.cafe.domain.ResultVO;
import com.cafe.service.NoticeService;

/**
 * Menu Controller class
 * @author YJH, kwon 
 * 2016.11.29.Tue
 */
@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);
	
	@Inject
	NoticeService noticeService;
	
	@ResponseBody
	@RequestMapping(value="/listApp", method=RequestMethod.POST)
	public ResultVO<List<NoticeVO>> listApp(@RequestBody NoticeVO notice) throws Exception{
		logger.info("notice list post.......");

		List<NoticeVO> list = new ArrayList<NoticeVO>();

		list=noticeService.listApp();
		
		return new ResultVO<>(list);
	}
}
