package com.derun.commnuication;

import org.apache.log4j.Logger;

public class logger {
	static Logger log = Logger.getLogger("");
	
	public static void debugLog(String info){
		log.info(info);
	}
			
}
