package com.cafe.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.WeeklyVO;

@Repository

public class FlagDAOImpl implements FlagDAO{

	@Inject 
	private SqlSession session;
	private String namespace = "com.cafe.mapper.FlagMapper";
	
	@Override
	public void register(WeeklyVO weekly) throws Exception {
		session.insert(namespace+".register", weekly);
	}

	
}
