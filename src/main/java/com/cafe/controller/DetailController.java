package com.cafe.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe.domain.DetailVO;
import com.cafe.service.DetailService;

/**
 * Detail of cafeteria Controller class
 * @author YJH
 * 2016.11.22.Tue
 */
@Controller
@RequestMapping("/detail/*")
public class DetailController {

	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(DetailController.class);
	//create datail service object
	@Inject
	private DetailService detailService;
	
	/**
	 * display detail list of cafeteria
	 * @param cafeName
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void readDetailGET(@RequestParam("cafeName") String cafeName, Model model) throws Exception{
		model.addAttribute("cafeName", cafeName);
		List<DetailVO> list = detailService.detailList(cafeName);
		model.addAttribute("list", list);
		model.addAttribute("cafeName", cafeName);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteDetailPOST(@RequestParam("cafeName") String cafeName,
			@RequestParam("detailName") String detailName, RedirectAttributes rttr, Model model) throws Exception{
		
		detailService.deleteDetail(cafeName, detailName);
		rttr.addFlashAttribute(cafeName);
		return "redirect:/detail/list";
	}
	
	
}
