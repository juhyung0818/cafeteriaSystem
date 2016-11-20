package com.cafe.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.ComplainVO;
/**
 * Complain board dao class
 * @author YJH
 * 2016.11.21.Mon
 */
@Repository
public class ComplainDAOImpl implements ComplainDAO{

	@Inject
	private SqlSession session;
	private String namespace = "com.cafe.mapper.ComplainMapper";
	
	@Override
	public void register(ComplainVO complain) throws Exception {
		session.insert(namespace + ".register", complain);
	}

	@Override
	public List<ComplainVO> complainList() throws Exception {
		return session.selectList(namespace + ".complainList");
	}

	//read complain
	@Override
	public ComplainVO complainRead(int complainNum) throws Exception {
		return session.selectOne(namespace + ".read", complainNum);
	}

	//register reply
	@Override
	public void registerReply(int complainNum, String reply) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("complainNum", complainNum);
		param.put("reply", reply);
		session.insert(namespace + ".registerReply", param);
	}

	@Override
	public void deleteReply(int complainNum) throws Exception {
		session.delete(namespace + ".deleteReply", complainNum);
	}

}
