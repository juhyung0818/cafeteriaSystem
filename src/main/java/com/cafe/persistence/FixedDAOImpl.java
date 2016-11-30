package com.cafe.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.FixedVO;
import com.cafe.domain.MenuVO;

/**
 * Fixed menu dao class
 * @author YJH
 * 2016.11.20.Sun
 */
@Repository
public class FixedDAOImpl implements FixedDAO{

	@Inject
	private SqlSession session;
	private String namespace = "com.cafe.mapper.FixedMapper";

	
	@Override
	public void register(FixedVO fixed) throws Exception {
		session.insert(namespace + ".register", fixed);
	}

	@Override
	public void delete(FixedVO fixed) throws Exception {
		session.delete(namespace+".delete", fixed);
	}

	@Override
	public List<FixedVO> fixedList(String cafeName) throws Exception {
		return session.selectList(namespace + ".fixedList", cafeName);
	}

	@Override
	public List<FixedVO> fixedSearch(String cafeName, String keyword) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", cafeName);
		param.put("keyword", keyword);
		return session.selectList(namespace + ".searchFixed", param);
	}

	@Override
	public List<MenuVO> fixedListApp(String cafeName) throws Exception {

		return session.selectList(namespace+".fixedListApp", cafeName);
	}
	
	

}
