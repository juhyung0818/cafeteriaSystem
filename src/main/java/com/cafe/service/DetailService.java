package com.cafe.service;

import java.util.List;

import com.cafe.domain.DetailVO;
/**
 * Detail service interface
 * @author YJH
 * 2016.11.21.Mon
 */
public interface DetailService {

	//register detail
	public void registerDetail(String cafeName, String detailName) throws Exception;
	//list detail
	public List<DetailVO> detailList(String cafeName) throws Exception;
	//delete detail
	public void deleteDetail(String cafeName, String detailName) throws Exception;
	//search detail
	public List<DetailVO> detailSearch(String cafeName, String keyword) throws Exception;

}
