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
	
	/**
	 * add cafe
	 * @author YJH
	 */
	@Override
	public void cafeRegister(CafeVO cafe) throws Exception {
		session.insert(namespace + ".register", cafe);
	}

	/**
	 * display cafe
	 * @author YJH
	 */
	@Override
	public List<CafeVO> cafeList() throws Exception {
		return session.selectList(namespace+".cafeList");
	}

	/**
	 * remove cafe 
	 * @author YJH
	 */
	@Override
	public void deleteCafe(String cafeName) throws Exception {
		session.delete(namespace + ".delete", cafeName);
	}

	/**
	 * search cafe in list
	 * @author YJH
	 */
	@Override
	public List<CafeVO> cafeSearch(String keyword) throws Exception {
		return session.selectList(namespace + ".searchCafe", keyword);
	}

	@Override
	public int cafeCheck(String cafeName) throws Exception {
		return session.selectOne(namespace + ".check", cafeName);
	}

}
