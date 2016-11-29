package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.NoticeVO;

public interface NoticeDAO {
	public List<NoticeVO> listApp() throws Exception;
}
