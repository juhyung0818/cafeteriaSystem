package com.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.CommentVO;
import com.cafe.exception.NotAuthorityException;
import com.cafe.persistence.CommentDAO;
import com.cafe.persistence.UserDAO;
/**
 * 
 * @author kwom
 * 2016.11.24.thu
 */
@Service
public class CommentServiceImpl implements CommentService{

	@Inject
	CommentDAO commentDao;
	@Inject
	UserDAO userDao;
	@Override
	public void commentRegister(CommentVO comment) throws Exception {
		commentDao.commentRegister(comment);
	}

	@Override
	public List<CommentVO> commentList(String cafeName, String menuName, String detailName) throws Exception {
		List<CommentVO> list = new ArrayList<CommentVO>();
		list=commentDao.commentList(cafeName, menuName, detailName);
		
		for (CommentVO commentVO : list) {
			commentVO.setNick(userDao.getUserNick(commentVO.getUid()));
		}
		return list;
	}

	@Override
	public void commentDelete(int commentNum, String uid) throws Exception {
		
		if(commentDao.checkAuth(commentNum, uid)>0)
			commentDao.commentDelete(commentNum, uid);
		else
			throw new NotAuthorityException();
	}

	/**
	 * @author YJH
	 */
	@Override
	public void commentDelete(int commentNum) throws Exception {
		commentDao.commentDelete(commentNum);
	}

}
