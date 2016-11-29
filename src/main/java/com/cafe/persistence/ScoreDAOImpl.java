package com.cafe.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.ScoreVO;

/**
 * 
 * @author kwom
 * 2016.11.24.thu
 */
@Repository
public class ScoreDAOImpl implements ScoreDAO{

	@Inject
	SqlSession session;
	
	private String namespace = "com.cafe.mapper.ScoreMapper";
	
	@Override
	public void scoreRegister(ScoreVO score) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", score.getCafeName());
		param.put("detailName", score.getDetailName());
		param.put("menuName", score.getMenuName());
		param.put("uid", score.getUid());
		param.put("score", score.getScore());
		
		session.insert(namespace+".register", param);
	}

	@Override
	public void scoreDelete(ScoreVO score) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", score.getCafeName());
		param.put("detailName", score.getDetailName());
		param.put("menuName", score.getMenuName());
		param.put("uid", score.getUid());
		param.put("score", score.getScore());
		
		session.delete(namespace+".delete", param);
	}

	@Override
	public void scoreUpdate(ScoreVO score) throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", score.getCafeName());
		param.put("detailName", score.getDetailName());
		param.put("menuName", score.getMenuName());
		param.put("uid", score.getUid());
		param.put("score", score.getScore());
		
		session.update(namespace+".update", param);
	}

	@Override
	public int isScored(ScoreVO score) throws Exception {
	
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", score.getCafeName());
		param.put("detailName", score.getDetailName());
		param.put("menuName", score.getMenuName());
		param.put("uid", score.getUid());
		
		return session.selectOne(namespace+".isScored", param);		
	}

}
