package com.cafe.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.DetailVO;

/**
 * Detail dao class
 * @author YJH
 * 2016.11.21.Mon
 */
@Repository
public class DetailDAOImpl implements DetailDAO{

	//create sql session
	@Inject
	private SqlSession session;
	private String namespace = "com.cafe.mapper.DetailMapper";
	
	@Override
	public void registerDetail(String cafeName, String detailName) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", cafeName);
		param.put("detailName", detailName);
		session.insert(namespace + ".register", param);
	}

	@Override
	public List<DetailVO> detailList(String cafeName) throws Exception {
		return session.selectList(namespace + ".detailList", cafeName);
	}

}