package com.derun.dao;

import java.util.List;

import com.derun.entity.Roles;
import com.derun.entity.RolesMapper;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class RolesDAO implements RolesMapper{

	//@Autowired
	//@Qualifier("sqlSession")
	@Resource(name="sqlSession")
	private SqlSession  session;	
	private RolesMapper mapper;
	
	@PostConstruct
	private void init(){
		mapper=session.getMapper(RolesMapper.class);
	}
	@Override
	public List<Roles> findALL() {		
		return mapper.findALL();
	}
	@Override
	public List<Roles> findBy(Roles obj) {		
		return mapper.findBy(obj);
	}
	@Override
	public int updateOne(Roles obj) {		
		return mapper.updateOne(obj);
	}
	@Override
	public int insertONE(Roles obj) {		
		return mapper.insertONE(obj);
	}
	@Override
	public int deleteONE(Roles obj) {		
		return mapper.deleteONE(obj);
	}
}
