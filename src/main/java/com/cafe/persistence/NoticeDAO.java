package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.NoticeVO;

/**
 * data access object
 * @author YJH, kwon
 * 2016.11.30.Wed
 */
public interface NoticeDAO {
	public List<NoticeVO> list() throws Exception;
	
	// delete notice
	public void delete(int noticeNum) throws Exception;
	// read a notice
	public NoticeVO read (int noticeNum) throws Exception;
	// insert notice
	public void register(NoticeVO notice) throws Exception;
}
