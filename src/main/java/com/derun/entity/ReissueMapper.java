package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface ReissueMapper {
	
	@Select("select * from reissue_info")
	public List<Reissue> findALL();
	
	@Select("select * from reissue_info where high=#{high}")
	public Reissue findBY(int high);
	
	@Insert("insert into reissue_info values(#{high},#{capability})")
	public int insertONE(Reissue obj);
		
}
