package com.cafe.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.WeeklyVO;
import com.cafe.flag.DateFlag;
import com.cafe.flag.WeeklyFlag;

@Repository

public class WeeklyDAOImpl implements WeeklyDAO{

	@Inject 
	private SqlSession session;
	private String namespace = "com.cafe.mapper.FlagMapper";
	
	@Override
	public void register(WeeklyVO weekly) throws Exception {
		session.insert(namespace+".register", weekly);
	}

	/**
	 * all delete in weekly
	 */
	@Override
	public void clearWeekly() throws Exception {
		session.delete(namespace+".clear");
	}

	@Override
	public void delete(String menuName, WeeklyFlag wFlag, DateFlag dateFlag) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("wFlag", wFlag.getNum());
		param.put("dateFlag", dateFlag.getNum());
		session.delete(namespace + ".delete", param);
	}
	
}
