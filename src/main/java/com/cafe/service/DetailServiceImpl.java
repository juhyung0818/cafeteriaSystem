package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.DetailVO;
import com.cafe.exception.PrimaryKeyDuplicatedException;
import com.cafe.persistence.DetailDAO;

/**
 * Detail service class
 * @author YJH
 * 2016.11.21.Mon
 */
@Service
public class DetailServiceImpl implements DetailService{

	//create detail dao
	@Inject
	private DetailDAO detailDao;
		
	@Override
	public void registerDetail(String cafeName, String detailName) throws Exception {
		if(detailDao.detailCheck(detailName) > 0){
			throw new PrimaryKeyDuplicatedException();
		}
		detailDao.registerDetail(cafeName, detailName);
	}

	@Override
	public List<DetailVO> detailList(String cafeName) throws Exception {
		return detailDao.detailList(cafeName);
	}

	@Override
	public void deleteDetail(String cafeName, String detailName) throws Exception {
		detailDao.deleteDetail(cafeName, detailName);
	}

	@Override
	public List<DetailVO> detailSearch(String cafeName, String keyword) throws Exception {
		return detailDao.detailSearch(cafeName, keyword);
	}


}
