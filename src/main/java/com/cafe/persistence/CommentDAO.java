package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.CommentVO;



public interface CommentDAO {
	public void cafeRegister(CommentVO comment) throws Exception;
	public List<CommentVO> commentList() throws Exception;
	public void cafeDelete(int commentNum)throws Exception;
}
