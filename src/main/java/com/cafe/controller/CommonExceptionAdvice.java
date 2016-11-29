package com.cafe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.domain.ResultVO;
import com.cafe.exception.InvalidTypeException;
import com.cafe.exception.NotAuthoriedException;
import com.cafe.exception.NotAuthorityException;
import com.cafe.exception.NotExistException;
import com.cafe.exception.PrimaryKeyDuplicatedException;

/**
 * Advice class for Exception handler
 * @author YJH
 * 2016.11.20.Sun
 */

@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

	// @ExceptionHandler(Exception.class)
	public String common(Exception e) {

		logger.info(e.toString());

		return "error_common";
	}
	
//	@ExceptionHandler(Exception.class)
//	private ModelAndView errorModelAndView(Exception e) {
//
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("/error_common");
//		modelAndView.addObject("exception", e);
//
//		return modelAndView;
//	}

	@ResponseBody
	@ExceptionHandler(PrimaryKeyDuplicatedException.class)
	public ModelAndView highfiveException(PrimaryKeyDuplicatedException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/primary_key_duplication");
		modelAndView.addObject("exception", e);

		return modelAndView;
	}

	@ResponseBody
	@ExceptionHandler(InvalidTypeException.class)
	public ModelAndView invalidFormatException(InvalidTypeException e) {

		logger.error(e.getMessage(), e.getStackTrace());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error_common");
		modelAndView.addObject("exception", e);

		return modelAndView;

	}

	@ResponseBody
	@ExceptionHandler(NotExistException.class)
	public ModelAndView notExistException(NotExistException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error_common");
		modelAndView.addObject("exception", e);

		return modelAndView;
	}

	@ResponseBody
	@ExceptionHandler(NotAuthoriedException.class)
	public ModelAndView notAuthoriedException(NotAuthoriedException e) {

		logger.error(e.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error_common");
		modelAndView.addObject("exception", e);

		return modelAndView;
	}
	
	@ResponseBody
	@ExceptionHandler(NotAuthorityException.class)
	public ResultVO notAuthorityException(NotAuthorityException e) {

		logger.error(e.getMessage());
		ResultVO result = new ResultVO<>();
		result.setCode(e.getExceptionCode().getCode());
		result.setMessage(e.getExceptionCode().getMessage());
		return result;
	}
}
