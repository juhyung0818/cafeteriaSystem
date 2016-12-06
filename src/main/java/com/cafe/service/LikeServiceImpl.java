package com.cafe.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe.domain.LikeVO;
import com.cafe.persistence.LikeDAO;
import com.cafe.persistence.MenuDAO;

@Service
public class LikeServiceImpl implements LikeService{

	@Inject
	LikeDAO likeDao;
	@Inject
	MenuDAO menuDao; 
	
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

}
