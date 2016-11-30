package com.cafe.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.LikeVO;

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
	
}
