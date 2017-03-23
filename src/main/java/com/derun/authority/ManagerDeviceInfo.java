package com.derun.authority;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.derun.dao.CheerinfoDAO;
import com.derun.entity.cheerMachine;

@Service
public class ManagerDeviceInfo {

	@Autowired 
	private  CheerinfoDAO dao;
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=SQLException.class)
	public int insertONE(cheerMachine obj){
		dao.insertOne(obj);	
		throw new RuntimeException("º””Õª˙≤Â»Î ß∞‹");	
	}
}
