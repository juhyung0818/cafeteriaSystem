package com.cafe.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.CafeVO;
import com.cafe.domain.CommentVO;
import com.cafe.persistence.CommentDAO;
/**
 * 
 * @author kwom
 * 2016.11.24.thu
 */
@Service
public class CommentServiceImpl implements CommentService{

	@Inject
	CommentDAO commentDao;
	
	@Override
	public void commentRegister(CommentVO comment) throws Exception {
		
		commentDao.commentRegister(comment);
	}

	@Override
	public List<CommentVO> commentList(String cafeName, String menuName, String detailName) throws Exception {
		List<CommentVO> list = new ArrayList<CommentVO>();
		list=commentDao.commentList(cafeName, menuName, detailName);
		
//		while(list.iterator().hasNext())
//		{
//		
//			Timestamp.valueOf(arg0)
//			dateFormat.format(date)
//			list.iterator().next().getRegDate();
//		}
		return list;
	}

	@Override
	public void commentDelete(int commentNum) throws Exception {
		commentDao.commentDelete(commentNum);
	}

	@Override
	public CommentVO read(int commnetNum) throws Exception {
		
		return commentDao.read(commnetNum);
	}

}
