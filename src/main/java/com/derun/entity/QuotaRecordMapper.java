package com.derun.entity;

import java.util.List;
import java.util.Map;

public interface QuotaRecordMapper {

	public List<CardPutout> findBY(Map<String,Object> map);
}
