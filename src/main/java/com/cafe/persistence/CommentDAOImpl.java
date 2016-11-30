package com.cafe.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.CommentVO;

/**
 * 
 * @author kwom
 * 2016.11.24.thu
 */
@Repository
public class CommentDAOImpl implements CommentDAO{

	@Inject
	private SqlSession session;
	private String namespace = "com.cafe.mapper.CommentMapper";
	
	/**
	 * @author kwon
	 * 2016.11.24.thu
	 */
	@Override
	public void commentRegister(CommentVO comment) throws Exception
	{
		session.insert(namespace+".register", comment);
	}
	
	/**
	 * @author kwon
	 * 2016.11.24.thu
	 */
	@Override
	public List<CommentVO> commentList(String CafeName, String menuName, String detailName) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cafeName", CafeName);
		param.put("menuName", menuName);
		param.put("detailName", detailName);
		return session.selectList(namespace+".list", param);
	}

	/**
	 * TODO : must not delete others' comment 
	 * @author kwon
	 * 2016.11.24.thu
	 */
	@Override
	public void commentDelete(int commentNum, String uid) throws Exception 
	{
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("commentNum", commentNum);
		param.put("uid", uid);
		session.insert(namespace+".delete", param);
	}

	@Override
	public CommentVO read(int commnetNum) throws Exception {
		return session.selectOne(namespace+"readApp", commnetNum);
	}

	@Override
	public int checkAuth(int commentNum, String uid) throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("commentNum", commentNum);
		param.put("uid", uid);
		return session.selectOne(namespace+".checkAuth", param);
	}

	@Override
	public void commentDelete(int commentNum) throws Exception {
		session.delete(namespace + ".deleteAdmin", commentNum);
	}

}
