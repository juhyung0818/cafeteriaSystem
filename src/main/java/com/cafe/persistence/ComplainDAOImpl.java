package com.cafe.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.ComplainVO;
import com.cafe.dto.ComplainDTO;
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

	//delete complain
	@Override
	public void delete(int complainNum) throws Exception {
		session.delete(namespace + ".delete", complainNum);
	}

	@Override
	public List<ComplainDTO> complainListApp() throws Exception {
	
		List<ComplainDTO> returnList=session.selectList(namespace+".listApp");
		
		for (ComplainDTO complainDTO : returnList) {
			String temp=session.selectOne(namespace+".isReply", complainDTO.getComplainNum());
			
			try {
				if(temp.equals("") || temp.equals(null))
					complainDTO.setIsReply(false);
				else
					complainDTO.setIsReply(true);
			} catch (Exception e) {
				complainDTO.setIsReply(false);
			}
			
		}
			
		return returnList;
	}

	@Override
	public void registerApp(ComplainVO complain) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("title", complain.getTitle());
		param.put("content", complain.getContent());
		param.put("uid", complain.getUid());
		
		session.insert(namespace+".registerApp", param);
	}

	@Override
	public int complainCheck(int complainNum, String uid) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("complainNum", complainNum);
		param.put("uid", uid);
		
		return session.selectOne(namespace+".check", param);
	}
}
