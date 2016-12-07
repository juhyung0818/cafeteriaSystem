package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.LikeVO;
import com.cafe.dto.MenuDTO;

public interface LikeDAO {
	public int checkLike(LikeVO like) throws Exception;
	public void register(LikeVO like) throws Exception;
	public void delete(LikeVO like) throws Exception;
	
	public double getLike(String uid) throws Exception;
	public List<MenuDTO> myList(String uid) throws Exception;
}
