package com.cafe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.domain.ResultVO;
import com.cafe.exception.NotAuthoriedException;
import com.cafe.exception.NotAuthorityException;
import com.cafe.exception.NotExistException;
import com.cafe.exception.NotExistResultException;
import com.cafe.exception.NotExistURLException;
import com.cafe.exception.PrimaryKeyDuplicatedException;

/**
 * Advice class for Exception handler
 * @author YJH
 * 2016.11.20.Sun
 */

@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception e) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/error_common");
		modelAndView.addObject("exception", e);

		return modelAndView;
	}


	/**
	 * alreay exist object 
	 * @param e
	 * @author YJH
	 */
	@ResponseBody
	@ExceptionHandler(PrimaryKeyDuplicatedException.class)
	public ModelAndView primaryKeyDuplicatedException(PrimaryKeyDuplicatedException e) {

		//error log
		logger.error(e.getMessage());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/exception_handler");
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}

	/**
	 * not eixst object
	 * @param e
	 * @author YJH
	 */
	@ResponseBody
	@ExceptionHandler(NotExistException.class)
	public ModelAndView notExistException(NotExistException e) {

		//error log
		logger.error(e.getMessage());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/exception_handler");
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	@ResponseBody
	@ExceptionHandler(NotExistResultException.class)
	public ModelAndView notExistResultException(NotExistResultException e) {

		//error log
		logger.error(e.getMessage());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/exception_handler");
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	@ResponseBody
	@ExceptionHandler(NotExistURLException.class)
	public ModelAndView notExistURLException(NotExistURLException e) {

		//error log
		logger.error(e.getMessage());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/exception_handler");
		modelAndView.addObject("code", e.getExceptionCode());

		return modelAndView;
	}
	
	@ResponseBody
	@ExceptionHandler(NotAuthoriedException.class)
	public ModelAndView notAuthoriedException(NotAuthoriedException e) {

		//error log
		logger.error(e.getMessage());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/exception/exception_handler");
		modelAndView.addObject("code", e.getExceptionCode());
		
		return modelAndView;
	}
}
