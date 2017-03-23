package com.derun.jvm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {

	public static void main(String[] args){
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("zhaijk","liaojing");		
		map.put("zhaihy","tiantian");		
		map.put("zhaijun","zhangqingxia");
		
		for(Entry<String,Object> obj:map.entrySet()){
			System.out.println(obj.getKey()+"-"+obj.getValue());			
		}
		for(String key:map.keySet()){
			System.out.println(key+"-"+map.get(key));
		}
	}
}
