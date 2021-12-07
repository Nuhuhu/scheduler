package org.kpu.myweb.service;

import java.util.List;

import org.kpu.myweb.domain.AccountVO;
import org.kpu.myweb.domain.SchedulVO;
import org.kpu.myweb.domain.UserVO;
import org.kpu.myweb.persistence.CalendarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarServiceImpl implements CalendarSerivce {
	
	@Autowired
	private CalendarDAO calendarDAO;
	
	@Override
	public void createUser(UserVO userVo) throws Exception {
		// TODO Auto-generated method stub
		calendarDAO.userCreate(userVo);
	}

	@Override
	public UserVO readUser(AccountVO vo) throws Exception {
		// TODO Auto-generated method stub
		return calendarDAO.userRead(vo);
	}

	@Override
	public void updateUser(UserVO userVo) throws Exception {
		// TODO Auto-generated method stub
		calendarDAO.userUpdate(userVo);
	}

	@Override
	public void deleteUser(UserVO userVo) throws Exception {
		// TODO Auto-generated method stub
		calendarDAO.userDelete(userVo);
	}

	@Override
	public void createSchedul(SchedulVO schedulVo) throws Exception {
		// TODO Auto-generated method stub
		calendarDAO.schedulCreate(schedulVo);
	}

	@Override
	public List<SchedulVO> readAllSchedul(String id) throws Exception {
		// TODO Auto-generated method stub
		return calendarDAO.schedulReadAll(id);
	}


}
