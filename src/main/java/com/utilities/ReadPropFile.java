package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.utilities.Paths;

public class ReadPropFile {
	
	public Properties prop;
	
	public Properties readProp() {
		prop = new Properties();
		try {
			FileInputStream fi = new FileInputStream(Paths.CONFIG_PROPERTIES_FILE);
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
