package org.kpu.myweb.service;

import java.util.List;

import org.kpu.myweb.domain.AccountVO;
import org.kpu.myweb.domain.SchedulVO;
import org.kpu.myweb.domain.UserVO;

public interface CalendarSerivce {
	public void createUser(UserVO userVo) throws Exception;
	public UserVO readUser(AccountVO vo) throws Exception;
	public void updateUser(UserVO userVo) throws Exception;
	public void deleteUser(UserVO userVo) throws Exception;
	public void createSchedul(SchedulVO schedulVo) throws Exception;
	public List<SchedulVO> readAllSchedul(String id) throws Exception;
}
