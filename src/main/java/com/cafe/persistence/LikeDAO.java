package com.cafe.persistence;

import com.cafe.domain.LikeVO;

public interface LikeDAO {
	public int checkLike(LikeVO like) throws Exception;
	public void register(LikeVO like) throws Exception;
	public void delete(LikeVO like) throws Exception;
}
