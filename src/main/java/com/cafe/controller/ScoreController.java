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
import com.cafe.domain.ScoreVO;
import com.cafe.service.ScoreService;

/**
 * 
 * @author kwon
 * 2016.11.25.Fri
 */
@Controller
@RequestMapping("/score/*")
public class ScoreController {

	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);
	
	//create services
	@Inject
	ScoreService scoreService;
	
	/**
	 * app : register score
	 * @param score
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.25.Fri
	 */
	@ResponseBody
	@RequestMapping(value="/registerApp", method=RequestMethod.POST)
	public ResultVO scoreRegisterPOST(@RequestBody ScoreVO score) throws Exception{
		logger.info("score register post.......");

		scoreService.scoreRegister(score);
		return new ResultVO<>();
	}
	
	@ResponseBody
	@RequestMapping(value="/getScoreApp", method=RequestMethod.POST)
	public ResultVO<Double> getScoreApp(@RequestBody ScoreVO score) throws Exception{
		logger.info("get score post.......");

		double result =scoreService.getScore(score.getUid());
		return new ResultVO<>(result);
	}
	
}
