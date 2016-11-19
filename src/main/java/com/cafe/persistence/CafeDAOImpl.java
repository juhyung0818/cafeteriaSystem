package com.cafe.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.CafeVO;
/**
 * Menu dao class
 * @author YJH
 * 2016.11.08.Tue
 */
@Repository
public class CafeDAOImpl implements CafeDAO{

	@Inject
	private SqlSession session;
	private String namespace = "com.cafe.mapper.CafeteriaMapper";
	
	@Override
	public void cafeRegister(CafeVO cafe) throws Exception {
		session.insert(namespace + ".register", cafe);
	}

	@Override
	public List<CafeVO> cafeList() throws Exception {
		return session.selectList(namespace+".cafeList");
	}

}
