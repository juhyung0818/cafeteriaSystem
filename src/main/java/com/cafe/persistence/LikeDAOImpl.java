package com.cafe.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.LikeVO;
import com.cafe.dto.MenuDTO;

@Repository
public class LikeDAOImpl implements LikeDAO{

	@Inject
	private SqlSession session;
	private String namespace = "com.cafe.mapper.LikeMapper";
	
	
	@Override
	public int checkLike(LikeVO like) throws Exception {
		
		return session.selectOne(namespace+".checkLike", like);
	}


	@Override
	public void register(LikeVO like) throws Exception {
		
		session.insert(namespace+".register", like);	
	}


	@Override
	public void delete(LikeVO like) throws Exception {

		session.insert(namespace+".delete", like);
	}


	@Override
	public double getLike(String uid) throws Exception {

		return session.selectOne(namespace+".getLike", uid);
	}


	@Override
	public List<MenuDTO> myList(String uid) throws Exception {

		return session.selectList(namespace+".mylist",uid);
	}
	
}
