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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe.domain.ComplainVO;
import com.cafe.domain.ResultVO;
import com.cafe.dto.ComplainDTO;
import com.cafe.service.CafeService;
import com.cafe.service.ComplainService;

/**
 * Complain board Controller class
 * @author YJH
 * 2016.11.21.Mon
 */
@Controller
@RequestMapping("/complain/*")
public class ComplainController {

	//use log4j
	private static final Logger logger = LoggerFactory.getLogger(ComplainController.class);
		
	@Inject
	private ComplainService complainService;
	@Inject
	private CafeService cafeService;
	
	/**
	 * complains are registered by customers
	 * this url use only mobile Application
	 * @param complain 
	 * @return resultVO object
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResultVO regist(@RequestBody ComplainVO complain, Model model) throws Exception{
		logger.info("complain register ......");
//		complainService.register(complain);
		model.addAttribute("list", cafeService.cafeList());
		return new ResultVO();
	}
	
	/**
	 * send complain list to Client
	 * this url use only mobile Application
	 * @param complain
	 * @return resultVO object
	 * @throws Exception
	 */
//	@ResponseBody
//	@RequestMapping(value="/listApp", method=RequestMethod.POST)
//	public ResultVO<List<ComplainVO>> listAll(@RequestBody ComplainVO complain) throws Exception{
//		List<ComplainVO> list = new ArrayList<ComplainVO>();
//		list = complainService.complainList();
//		logger.info("complain list...");
//		return new ResultVO<>(list);
//	}
	
	/**
	 * send complain list to Client
	 * this url use only Web Application
	 * @param model -send attribute to jsp
	 * @param rttr -redirect
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void complainListGET(Model model, RedirectAttributes rttr) throws Exception {
		logger.info("complain list...");
		model.addAttribute("list", cafeService.cafeList());
		List<ComplainVO> list = complainService.complainList();
		model.addAttribute("complains", list);
	}

	/**
	 * send complain to Client
	 * this url use only Web Application
	 * @param model -send attribute to jsp
	 * @param rttr -redirect
	 * @throws Exception
	 */
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void complainReadGET(@RequestParam("complainNum") int complainNum,
			Model model, RedirectAttributes rttr) throws Exception {
		logger.info("complain read...");
		model.addAttribute("complainVO", complainService.complainRead(complainNum));
	}
	/**
	 * 
	 * @param complainNum
	 * @param reply
	 * @param model
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/inReply", method = RequestMethod.POST)
	public String replyRegisterPOST(@RequestParam("complainNum") int complainNum,
			@RequestParam("reply") String reply,
			Model model, RedirectAttributes rttr) throws Exception {
		logger.info("menu register....");
		complainService.registerReply(complainNum, reply);
		rttr.addAttribute("complainNum", complainNum);
		return "redirect:/complain/read";
	}
	
	/**
	 * 
	 * @param complainNum
	 * @param model
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/outReply", method = RequestMethod.POST)
	public String replyDeletePOST(@RequestParam("complainNum") int complainNum,
			Model model, RedirectAttributes rttr) throws Exception {
		logger.info("menu register....");
		complainService.deleteReply(complainNum);
		rttr.addAttribute("complainNum", complainNum);
		return "redirect:/complain/read";
	}
	
	/**
	 * 
	 * @param cafeName
	 * @param menuName
	 * @param model
	 * @param key
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String complainDeletePOST(@RequestParam("complainNum") int complainNum,
			Model model, RedirectAttributes rttr) throws Exception {
		logger.info("complain delete....");
		complainService.delete(complainNum);
		rttr.addAttribute("complainNum", complainNum);
		return "redirect:/complain/list";
	}
	
	/**
	 * app : register complain
	 * @param complain
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.25.Fri
	 */
	@ResponseBody
	@RequestMapping(value="/registerApp", method=RequestMethod.POST)
	public ResultVO registerAppPOST(@RequestBody ComplainVO complain) throws Exception{
		
		logger.info("complain register app post.......");
		complainService.registerApp(complain);
		return new ResultVO();
	}

	/**
	 * app : delete complain
	 * @param comment
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.25.Fri
	 */
	@ResponseBody
	@RequestMapping(value="/deleteApp", method=RequestMethod.POST)
	public ResultVO deleteAppPOST(@RequestBody ComplainVO complain) throws Exception{
		logger.info("complain delete app post.......");

		complainService.deleteApp(complain);
		return new ResultVO();
	}
	
	/**
	 * app : show complaint list
	 * @param complain
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.25.Fri
	 */
	@ResponseBody
	@RequestMapping(value="/listApp", method=RequestMethod.POST)
	public ResultVO<List<ComplainDTO>> listApp() throws Exception{
		List<ComplainDTO> list = new ArrayList<ComplainDTO>();
		
		list = complainService.complainListApp();
		logger.info("complain list...");
		return new ResultVO<>(list);
	}

}
