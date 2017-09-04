package com.derun.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.derun.entity.ResourceMapper;


@Repository
public class ResourceDAO implements ResourceMapper{

	//@Autowired
	//@Qualifier("sqlSession")
	
	@javax.annotation.Resource(name="sqlSession")
	private SqlSession session;
	private ResourceMapper mapper;
	
	@PostConstruct
	private void init(){
		mapper=session.getMapper(ResourceMapper.class);
	}	
	@Override
	public List<com.derun.entity.Resource> findAll() {		
		return mapper.findAll();
	}
	@Override
	public List<com.derun.entity.Resource> findOne(com.derun.entity.Resource obj) {		
		return	mapper.findOne(obj);
	}
	@Override
	public int updateOne(com.derun.entity.Resource obj) {
		return mapper.updateOne(obj);
	}
	@Override
	public int deleteOne(com.derun.entity.Resource obj) {		
		return mapper.deleteOne(obj);
	}
	@Override
	public int insertOne(com.derun.entity.Resource obj) {		
		return mapper.insertOne(obj);
	}
	@Override
	public List<String> findBy(String resource_id) {		
		return mapper.findBy(resource_id);
	}

}
