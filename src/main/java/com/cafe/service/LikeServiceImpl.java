package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe.domain.LikeVO;
import com.cafe.dto.MenuDTO;
import com.cafe.persistence.CommentDAO;
import com.cafe.persistence.LikeDAO;
import com.cafe.persistence.MenuDAO;

@Service
public class LikeServiceImpl implements LikeService{

	@Inject
	LikeDAO likeDao;
	@Inject
	MenuDAO menuDao; 
	@Inject
	CommentDAO commentDao;
	
	@Transactional
	@Override
	public String checkLike(LikeVO like) throws Exception {
		int temp=likeDao.checkLike(like);
		if(temp<1)
		{
			menuDao.count(like.getCafeName(), like.getDetailName(), like.getMenuName());
			likeDao.register(like);
			return "0";
		}
		else
		{
			//if likeNum is more than 0 then discount
			if(menuDao.checkLikeNum(like.getCafeName(), like.getDetailName(), like.getMenuName())>0)
			{
				menuDao.discount(like.getCafeName(), like.getDetailName(), like.getMenuName());
				likeDao.delete(like);
			}
			return "1";
		}
	}

	@Override
	public List<MenuDTO> myList(String uid) throws Exception {

		List<MenuDTO> list=likeDao.myList(uid);
		for (MenuDTO menuDTO : list) {
			menuDTO.setUid(uid);
			//set commentNum
			menuDTO.setCommentCnt(commentDao.commentList(menuDTO.getCafeName(), menuDTO.getDetailName(), menuDTO.getMenuName()).size());
			//set isLike
			LikeVO like=new LikeVO();
			like.setCafeName(menuDTO.getCafeName());
			like.setDetailName(menuDTO.getDetailName());
			like.setMenuName(menuDTO.getMenuName());
			like.setUid(uid);
			
			int temp=likeDao.checkLike(like);
			
			if(temp<1)
				menuDTO.setIsLike(false);
			else
				menuDTO.setIsLike(true);
		}
		return list;
	}
}
