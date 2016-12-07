package com.cafe.service;

import java.util.List;

import com.cafe.domain.LikeVO;
import com.cafe.dto.MenuDTO;

public interface LikeService {
	public String checkLike(LikeVO like) throws Exception;
	public List<MenuDTO> myList(String uid) throws Exception;
}
