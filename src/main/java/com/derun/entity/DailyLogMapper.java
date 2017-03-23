package com.derun.entity;

import java.util.List;
import java.util.Map;

public interface DailyLogMapper {

	public List<DailyRecord> findBy(Map<String,Object> map);
}
