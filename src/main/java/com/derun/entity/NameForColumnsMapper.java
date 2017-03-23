package com.derun.entity;

import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface NameForColumnsMapper {
	@Select("select *  from tk_xt_bjg")
	public List<NameForColumns> findALL();
	
	@Select("select *  from tk_xt_bjg where zddm=#{name}")
	public NameForColumns totalCounter(String name);
	
}
