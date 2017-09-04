package com.derun.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.derun.entity.Users;
import com.derun.entity.UsersMapper;

@Repository
public class UsersDAO implements UsersMapper{
	
	//@Autowired
	//@Qualifier("sqlSession")
	@Resource(name="sqlSession")
	private  SqlSession session;	
	private  UsersMapper mapper;
	
	@PostConstruct
	public void init(){
		mapper=session.getMapper(UsersMapper.class);
	}
	
	@Override
	public List<Users> findAll() {		
		return mapper.findAll();
	}
	
	@Override
	public List<Users> findBy(Users obj) {		
		return mapper.findBy(obj);
	}
	
	@Override
	public int InsertOne(Users obj) {		
		return mapper.InsertOne(obj);
	}
	
	@Override
	public int updateOne(Users obj) {		
		return mapper.updateOne(obj);
	}
	
	@Override
	public int deleteONE(Users obj) {		
		return mapper.deleteONE(obj);
	}

	@Override
	public String findByName(String user_name) {		
		return mapper.findByName(user_name);
	}

	@Override
	public List<String> findRoleByName(String user_name) {
		return mapper.findRoleByName(user_name);
	}

	@Override
	public String findAccountByName(String user_name) {
		return mapper.findAccountByName(user_name);
	}
}
