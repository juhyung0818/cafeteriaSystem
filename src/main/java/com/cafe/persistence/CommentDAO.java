package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.CommentVO;


/**
 * 
 * @author kwom
 * 2016.11.24.thu
 */
public interface CommentDAO {
	public void commentRegister(CommentVO comment) throws Exception;
	public List<CommentVO> commentList(String cafeName, String menuName, String detailName) throws Exception;
	public void commentDelete(int commentNum, String uid)throws Exception;
	
	public CommentVO read(int commnetNum)throws Exception;
}
