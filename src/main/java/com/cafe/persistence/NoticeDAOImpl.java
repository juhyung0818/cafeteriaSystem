package com.cafe.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.domain.NoticeVO;
@Repository
public class NoticeDAOImpl implements NoticeDAO{

	@Inject
	SqlSession session;
	
	private String namespace = "com.cafe.mapper.NoticeMapper";
	
	@Override
	public List<NoticeVO> list() throws Exception {
		return session.selectList(namespace+".list");
	}

	//delete notice
	@Override
	public void delete(int noticeNum) throws Exception {
		session.delete(namespace + ".delete", noticeNum);
	}

	//read a notice
	@Override
	public NoticeVO read(int noticeNum) throws Exception {
		return session.selectOne(namespace + ".read", noticeNum);
	}

	//register notice
	@Override
	public void register(NoticeVO notice) throws Exception {
		session.insert(namespace + ".register", notice);
	}

}
