package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.NoticeVO;
import com.cafe.persistence.NoticeDAO;
@Service
public class NoticeServiceImpl implements NoticeService{

	@Inject
	NoticeDAO noticeDao;
	@Override
	public List<NoticeVO> listApp() throws Exception {

		return noticeDao.listApp();
	}

}
