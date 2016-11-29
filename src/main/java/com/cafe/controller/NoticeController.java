package com.cafe.controller;

//
//@Controller
//@RequestMapping("/cafe/*")
//public class CafeController {
//
//	//use log4j
//	private static final Logger logger = LoggerFactory.getLogger(CafeController.class);
//	
//	//create services
//	@Inject
//	
//			model.addAttribute("list", cafeService.cafeList());

//
//	/**
//	 * app : show cafeteria list
//	 * @param model
//	 * @throws Exception
//	 * @author kwon
//	 * 2016.11.24.Thu
//	 */
//	@ResponseBody
//	@RequestMapping(value="/list", method=RequestMethod.POST)
//	public ResultVO<List<CafeVO>> listAll(@RequestBody MenuVO menu) throws Exception
//	{	
//		List<CafeVO> list = new ArrayList<CafeVO>();
//		list = cafeService.cafeList();
//		logger.info("cafeteria list.....");
//		return new ResultVO<>(list);
//	}
//
//}
