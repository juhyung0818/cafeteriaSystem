package com.cafe.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.cafe.domain.CommentVO;

public class CommentDAOImpl implements CommentDAO{

	@Inject
	private SqlSession session;
	private String namespace = "com.cafe.mapper.CommentMapper";
	@Override
	public void cafeRegister(CommentVO comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CommentVO> commentList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cafeDelete(int commentNum) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
