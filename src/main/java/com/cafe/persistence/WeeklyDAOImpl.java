package com.cafe.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.MenuVO;
import com.cafe.domain.WeeklyVO;
import com.cafe.dto.WeeklyDTO;
import com.cafe.flag.WeeklyFlag;

/**
 * Weekly menu dao class
 * @author YJH
 * 2016.11.19.Sat
 */
@Repository
public class WeeklyDAOImpl implements WeeklyDAO{

	@Inject 
	private SqlSession session;
	private String namespace = "com.cafe.mapper.WeeklyMapper";
	
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
	public void delete(WeeklyVO weekly) throws Exception {
		session.delete(namespace + ".delete", weekly);
	}

	@Override
	public List<WeeklyVO> weeklyList(String cafeName) throws Exception {

		return session.selectList(namespace + ".weeklyList", cafeName);
	}

	@Override
	public List<WeeklyDTO> weeklyListApp(String cafeName, WeeklyFlag wflag) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("cafeName", cafeName);
		param.put("wFlag", wflag);

		List<WeeklyDTO> list=session.selectList(namespace+".weeklyListApp", param);
		return list;
	}

	/**
	 * check exist or not
	 * @author YJH
	 */
	@Override
	public int check(WeeklyVO weekly) throws Exception {
		return session.selectOne(namespace + ".check", weekly);
	}
	
}
