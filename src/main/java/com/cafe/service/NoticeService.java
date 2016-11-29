package com.cafe.service;

import java.util.List;

import com.cafe.domain.NoticeVO;

public interface NoticeService {
	
	public List<NoticeVO> listApp()throws Exception;
}
