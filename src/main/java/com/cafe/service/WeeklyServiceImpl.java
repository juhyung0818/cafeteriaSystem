package com.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.LikeVO;
import com.cafe.domain.ScoreVO;
import com.cafe.domain.WeeklyVO;
import com.cafe.dto.WeeklyDTO;
import com.cafe.exception.PrimaryKeyDuplicatedException;
import com.cafe.flag.WeeklyFlag;
import com.cafe.persistence.LikeDAO;
import com.cafe.persistence.WeeklyDAO;

/**
 * Weekly menu Service class
 * @author YJH
 * 2016.11.19.Sat
 * register, delete, list, search
 */
@Service
public class WeeklyServiceImpl implements WeeklyService{

	@Inject
	private WeeklyDAO weeklyDao;
	
	@Inject
	private LikeDAO likeDao;
	
	@Override
	public void register(WeeklyVO weekly) throws Exception {
		if(weeklyDao.check(weekly) > 0){
			throw new PrimaryKeyDuplicatedException();
		}
		weeklyDao.register(weekly);
	}

	@Override
	public void clearWeekly() throws Exception {
		weeklyDao.clearWeekly();
	}

	@Override
	public void delete(WeeklyVO weekly) throws Exception {
		weeklyDao.delete(weekly);
	}

	/**
	 * weekly menu list
	 */
	@Override
	public List<WeeklyVO> weeklyList(String cafeName) throws Exception {
		List<WeeklyVO> weeklis = new ArrayList<>();
		weeklis =  weeklyDao.weeklyList(cafeName);
//		for(WeeklyVO weekly : weeklis){
//			weekly.setDateFlag(DateFlag.valueOF(weekly.getDateFlag()));
//			weekly.setwFlag(WeeklyFlag.valueOf(weekly.getwFlag()));
//		}
		return weeklis;
	}

	@Override
	public List<WeeklyDTO> weeklyListApp(String cafeName, WeeklyFlag wFlag, String uid) throws Exception {
		
		List<WeeklyDTO> list = weeklyDao.weeklyListApp(cafeName, wFlag);
		
		for (WeeklyDTO weeklyDTO : list) {
			LikeVO testLike=new LikeVO();
			
			testLike.setCafeName(weeklyDTO.getCafeName());
			testLike.setDetailName(weeklyDTO.getDetailName());
			testLike.setMenuName(weeklyDTO.getMenuName());
			testLike.setUid(uid);
			
			if(likeDao.checkLike(testLike)<1)
			{
				weeklyDTO.setIsLike(false);
			}
			else
			{
				weeklyDTO.setIsLike(true);
			}
		}

		return list;
	}

}
