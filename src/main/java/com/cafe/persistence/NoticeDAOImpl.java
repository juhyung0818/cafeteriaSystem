package com.cafe.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.NoticeVO;
@Repository
public class NoticeDAOImpl implements NoticeDAO{

	@Inject
	SqlSession session;
	
	private String namespace = "com.cafe.mapper.NoticeMapper";
	
	@Override
	public List<NoticeVO> listApp() throws Exception {
		
		return session.selectList(namespace+".listApp");
	}

}
