package com.basicactions;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

import com.utilities.Paths;



public class LoggerHelp {

private static boolean root=false;
	
	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class cls){
		if(root){
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(Paths.LOG_PROPERTIES_FILE);
		root = true;
		return Logger.getLogger(cls);
	}
	
}
