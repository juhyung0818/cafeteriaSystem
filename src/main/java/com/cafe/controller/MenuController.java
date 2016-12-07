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

import com.cafe.domain.CafeVO;
import com.cafe.domain.CommentVO;
import com.cafe.domain.DetailVO;
import com.cafe.domain.MenuVO;
import com.cafe.domain.ResultVO;
import com.cafe.domain.SearchKeywordVO;
import com.cafe.dto.MenuDTO;
import com.cafe.dto.searchDTO;
import com.cafe.service.CafeService;
import com.cafe.service.CommentService;
import com.cafe.service.DetailService;
import com.cafe.service.MenuService;
import com.cafe.service.UserService;

/**
 * Menu Controller class
 * @author YJH 
 * 2016.11.09.Wed
 */
@Controller
@RequestMapping("/menu/*")
public class MenuController {

	// use log4j
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	@Inject
	private MenuService menuService;
	@Inject
	private DetailService detailService;
	@Inject
	private CafeService cafeService;
	@Inject
	private CommentService commentService;
	@Inject
	private UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void menuListGET(@RequestParam("cafeName") String cafeName,
			@RequestParam("keyword") String keyword, Model model) throws Exception {
		logger.info("menu list....");
		List<MenuVO> menus = menuService.searchMenu(cafeName, keyword);
		model.addAttribute("menus", menus);
		List<DetailVO> details = detailService.detailList(cafeName);
		model.addAttribute("details", details);
		model.addAttribute("detailSize", details.size());
		model.addAttribute("cafeName", cafeName);
		model.addAttribute("keyword", keyword);
		model.addAttribute("list", cafeService.cafeList());
	}
	
	/**
	 * app : show menu list
	 * @param cafe
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.24.Thu
	 */
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public ResultVO<List<MenuVO>> listAll(@RequestBody CafeVO cafe) throws Exception
	{
		logger.info("menu list.....");
		
		List<MenuVO> list = new ArrayList<MenuVO>();
		list = menuService.menuList(cafe.getCafeName());
		
		return new ResultVO<>(list);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String menuRegisterPOST(@RequestParam("cafeName") String cafeName, 
			@RequestParam("detailName") String detailName,
			@RequestParam("menuName") String menuName,
			@RequestParam("price") int price,
			Model model, SearchKeywordVO key, RedirectAttributes rttr) throws Exception {
		logger.info("menu register....");
		MenuVO menu = new MenuVO();
		menu.setCafeName(cafeName);
		menu.setDetailName(detailName);
		menu.setMenuName(menuName);
		menu.setPrice(price);
		menuService.menuRegister(menu);
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", key.getKeyword());

		return "redirect:/menu/list";
	}

	//delete menu
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String menuDeletePOST(@RequestParam("cafeName") String cafeName, 
			@RequestParam("detailName") String detailName,
			@RequestParam("menuName") String menuName,
			Model model, SearchKeywordVO key, RedirectAttributes rttr) throws Exception {
		logger.info("menu delete....");
		menuService.deleteMenu(cafeName, detailName, menuName);
		//redirect attributes
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", "");
		return "redirect:/menu/list";
	}
	
	//modify menu price
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String menuModifyPOST(@RequestParam("cafeName") String cafeName, 
			@RequestParam("detailName") String detailName,
			@RequestParam("menuName") String menuName,
			@RequestParam("price") int price,
			Model model, SearchKeywordVO key, RedirectAttributes rttr) throws Exception {
		
		logger.info("menu modify....");
		menuService.modify(cafeName, detailName, menuName, price);
		//redirect attributes
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", key.getKeyword());
		return "redirect:/menu/list";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String menuSearhPOST(@RequestParam("cafeName") String cafeName, @RequestParam("keyword") String keyword,
			Model model, RedirectAttributes rttr) throws Exception {
		logger.info("menu search....");
		rttr.addAttribute("cafeName", cafeName);
		rttr.addAttribute("keyword", keyword);
		return "redirect:/menu/list";
	}
	
	/**
	 * app : show top10 menu list order by like
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.29.Tue
	 */
	@ResponseBody
	@RequestMapping(value="/top10LikeApp", method=RequestMethod.POST)
	public ResultVO<List<MenuDTO>> top10LikeApp(@RequestBody MenuDTO menu) throws Exception
	{
		logger.info("top 10 like..");
		
		List<MenuDTO> list = new ArrayList<MenuDTO>();
		list = menuService.top10Like(menu.getUid());
		
		return new ResultVO<>(list);
	}
	/**
	 * app : show top10 menu list order by point
	 * @return
	 * @throws Exception
	 * @author kwon
	 * 2016.11.29.Tue
	 */
	@ResponseBody
	@RequestMapping(value="/top10PointApp", method=RequestMethod.POST)
	public ResultVO<List<MenuDTO>> top10PointApp(@RequestBody MenuDTO menu) throws Exception
	{
		logger.info("top 10 like..");
		
		List<MenuDTO> list = new ArrayList<MenuDTO>();
		list = menuService.top10Point(menu.getUid());
		
		return new ResultVO<>(list);
	}

	@ResponseBody
	@RequestMapping(value="/searchApp", method=RequestMethod.POST)
	public ResultVO<List<MenuDTO>> searchApp(@RequestBody searchDTO menu) throws Exception
	{
		logger.info("search menu app..");
		
		List<MenuDTO> list = new ArrayList<MenuDTO>();
		//list = menuService.top10Point(menu.getUid());
		list=menuService.searchApp(menu.getUid(), menu.getKeyword());
		logger.info(list.toString());
		return new ResultVO<>(list);
	}
	
	/**
	 * web : admin read comment of menu
	 * @param comment
	 * @throws Exception
	 * @author YJH
	 */
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void readWeb(@RequestParam("cafeName") String cafeName,
			@RequestParam("detailName") String detailName,
			@RequestParam("menuName") String menuName,
			Model model)throws Exception{
		logger.info("menu read get.......");
		
		//comments of a menu
		List<CommentVO> comments = commentService.commentList(cafeName, menuName, detailName);
		model.addAttribute("comments", comments);
		// select menu to show comment
		MenuVO menu = menuService.getMenu(cafeName, detailName, menuName);
		model.addAttribute("menu", menu);
		model.addAttribute("list", cafeService.cafeList());
	}	
}
