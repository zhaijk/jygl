package com.derun.entity;

import java.util.List;

public interface CardtradeinfoMapper {
	public List<cardtrade> findALL();
	public int insertOne(cardtrade arg);
	public int totalCounter();
}
