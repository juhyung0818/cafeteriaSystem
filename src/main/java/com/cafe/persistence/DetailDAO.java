package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.DetailVO;

/**
 * Detail dao interface
 * @author YJH
 * 2016.11.21.Mon
 */
public interface DetailDAO {

	//register detail
	public void registerDetail(String cafeName, String detailName) throws Exception;
	//list detail
	public List<DetailVO> detailList(String cafeName) throws Exception;
	//delete detail
	public void deleteDetail(String cafeName, String detailName) throws Exception;
}
