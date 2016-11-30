package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.cafe.domain.NoticeVO;
import com.cafe.persistence.NoticeDAO;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Inject
	NoticeDAO noticeDao;
	
	@Override
	public List<NoticeVO> list() throws Exception {
		return noticeDao.list();
	}

	//delete notice
	@Override
	public void delete(int noticeNum) throws Exception {
		noticeDao.delete(noticeNum);
	}

	//read a notice
	@Override
	public NoticeVO read(int noticeNum) throws Exception {
		return noticeDao.read(noticeNum);
	}

	//add notice
	@Override
	public void register(NoticeVO notice) throws Exception {
		noticeDao.register(notice);
		
	}

}
