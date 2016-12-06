package com.cafe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe.domain.NoticeVO;
import com.cafe.domain.ResultVO;
import com.cafe.service.CafeService;
import com.cafe.service.NoticeService;

/**
 * Menu Controller class
 * @author kwon, YJH 
 * 2016.11.29.Tue
 */
@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);
	
	@Inject
	private NoticeService noticeService;
	@Inject
	private CafeService cafeService;
	
	@ResponseBody
	@RequestMapping(value="/listApp", method=RequestMethod.POST)
	public ResultVO<List<NoticeVO>> listApp(@RequestBody NoticeVO notice) throws Exception{
		logger.info("notice list post.......");

		List<NoticeVO> list = new ArrayList<NoticeVO>();

		list=noticeService.list();
		
		return new ResultVO<>(list);
	}

	/**
	 * display notice list
	 * this url use only Web Application
	 * @author YJH
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void noticeListGET(Model model) throws Exception {
		logger.info("notice list web...");
		model.addAttribute("list", cafeService.cafeList()); //list for menu bar
		List<NoticeVO> notices = noticeService.list();
		model.addAttribute("notices", notices);
	}

	/**
	 * read notice
	 * this url use only Web Application
	 * @author YJH
	 */
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void noticeReadGET(@RequestParam("noticeNum") int noticeNum, Model model) throws Exception {
		logger.info("notice read...");
		model.addAttribute("list", cafeService.cafeList()); //list for menu bar
		model.addAttribute("notice", noticeService.read(noticeNum));
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String noticeDeletePOST(@RequestParam("noticeNum") int noticeNum, Model model) throws Exception {
		
		logger.info("notice delete...");
		noticeService.delete(noticeNum);
			
		return "redirect:/notice/list";
	}
	
	/**
	 * register notice GET method
	 * this url use only Web Application
	 * @author YJH
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void noticeRegisterGET(NoticeVO notice, Model model) throws Exception {
		
		logger.info("notice read...");
		model.addAttribute("list", cafeService.cafeList()); //list for menu bar
	}
	
	/**
	 * register notice POST method
	 * this url use only Web Application
	 * @author YJH
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String noticeRegisterPOST(NoticeVO notice, Model model) throws Exception {
		
		logger.info("notice read...");
		noticeService.register(notice);
		
		return "redirect:/notice/list";
	}

	@ResponseBody
	@RequestMapping(value = "/readApp", method = RequestMethod.POST)
	public ResultVO<NoticeVO> readApp(@RequestBody NoticeVO notice) throws Exception {
		logger.info("notice read post.......");

		NoticeVO one = new NoticeVO();

		one = noticeService.read(notice.getNoticeNum());

		return new ResultVO<>(one);
	}
	
}
