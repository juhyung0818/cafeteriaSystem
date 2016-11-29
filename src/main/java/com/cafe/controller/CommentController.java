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

import com.cafe.domain.CommentVO;
import com.cafe.domain.ResultVO;
import com.cafe.service.CommentService;

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
	
	@Inject
	private CommentService commentService;

	/**
	 * app : register comment
	 * @param cafe
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.24.thu
	 */
	@ResponseBody
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResultVO regist(@RequestBody CommentVO comment) throws Exception{
		logger.info("comment register post.......");

		commentService.commentRegister(comment);
		return new ResultVO();
	}
	/**
	 * app : delete comment
	 * @param cafe
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.24.thu
	 */
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ResultVO delete(@RequestBody CommentVO comment) throws Exception{
		logger.info("comment delete post.......");

		commentService.commentDelete(comment.getCommentNum());
		return new ResultVO();
	}
	/**
	 * app : show each menu's comment list
	 * @param cafe
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.24.thu
	 */
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public ResultVO list(@RequestBody CommentVO comment) throws Exception{
		logger.info("comment list post.......");

		List<CommentVO> list = new ArrayList<CommentVO>();

		list=commentService.commentList(comment.getCafeName(), comment.getMenuName(), comment.getDetailName());
		return new ResultVO<>(list);
	}

}