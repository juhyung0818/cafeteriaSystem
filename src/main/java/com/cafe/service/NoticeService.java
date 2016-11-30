package com.cafe.service;

import java.util.List;

import com.cafe.domain.NoticeVO;

public interface NoticeService {
	
	public List<NoticeVO> list()throws Exception;
	// delete notice
	public void delete(int noticeNum) throws Exception;
	// read a notice
	public NoticeVO read (int noticeNum) throws Exception;
	// insert notice
	public void register(NoticeVO notice) throws Exception;
}
