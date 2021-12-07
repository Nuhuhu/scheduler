package org.kpu.myweb.persistence;

import java.util.List;

import org.kpu.myweb.domain.AccountVO;
import org.kpu.myweb.domain.SchedulVO;
import org.kpu.myweb.domain.UserVO;

public interface CalendarDAO {
	public void userCreate(UserVO userVo) throws Exception;
	public UserVO userRead(AccountVO vo) throws Exception;
	public void userUpdate(UserVO userVo) throws Exception;
	public void userDelete(UserVO userVo) throws Exception;
	public void schedulCreate(SchedulVO schedulVo) throws Exception;
	public List<SchedulVO> schedulReadAll(String id) throws Exception;
}
