package org.kpu.myweb.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kpu.myweb.domain.AccountVO;
import org.kpu.myweb.domain.SchedulVO;
import org.kpu.myweb.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CalendarDAOImpl implements CalendarDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String usernamespace = "org.kpu.myweb.mappers.userMapper";
	private static final String schedulnamespace = "org.kpu.myweb.mappers.schedulMapper";
	
	@Transactional
	@Override
	public void userCreate(UserVO userVo) throws Exception {
		sqlSession.insert(usernamespace+".insert", userVo);
	}

	@Override
	public UserVO userRead(AccountVO vo) throws Exception {
		// TODO Auto-generated method stub
		UserVO userVo = sqlSession.selectOne(usernamespace+".userData",vo);
		return userVo;
	}
	
	@Transactional
	@Override
	public void userUpdate(UserVO userVo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(usernamespace+".update",userVo);
	}

	@Override
	public void userDelete(UserVO userVo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(usernamespace+".delete",userVo);
	}
	
	@Transactional
	@Override
	public void schedulCreate(SchedulVO schedulVo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(schedulnamespace+".insert",schedulVo);
	}

	@Override
	public List<SchedulVO> schedulReadAll(String id) throws Exception {
		// TODO Auto-generated method stub
		List<SchedulVO> list = new ArrayList<SchedulVO>();
		list = sqlSession.selectList(schedulnamespace+".selectAll",id);
		return list;
	}


}
