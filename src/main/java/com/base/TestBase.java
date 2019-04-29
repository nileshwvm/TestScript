package com.base;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.basicactions.LoggerHelp;
import com.utilities.Paths;

public class TestBase{

	public static WebDriver driver;
	Logger log = LoggerHelp.getLogger(TestBase.class);

	public WebDriver launchBrowser(String BrowserName){
		if (BrowserName.equals("chrome")) {
			ChromeBrowser cap = new ChromeBrowser();
			ChromeOptions options = cap.getChromeOptions();
			log.info("***************Launching Chrome browser***************");
			System.setProperty("webdriver.chrome.driver",Paths.CHROME_DRIVER);
			driver = new ChromeDriver(options);
			log.info("***************Chrome browser launched***************");
		} else if (BrowserName.equals("firefox")) {
			FirefoxBrowser cap = new FirefoxBrowser();
			FirefoxOptions options = cap.getFirefoxOptions(); 
			log.info("***************Launching Firefox browser***************");
			System.setProperty("webdriver.gecko.driver",Paths.GECKO_DRIVER_FF);
			driver = new FirefoxDriver(options);
			log.info("***************Firefox browser launched***************");
		} else if (BrowserName.equals("ie")) {
			IExploreBrowser cap = new IExploreBrowser();
			InternetExplorerOptions options = cap.getIExplorerCapabilities();
			log.info("********************Initialize internet explorer browser********************");
			System.setProperty("webdriver.ie.driver",Paths.IE_DRIVER);
			driver = new InternetExplorerDriver(options);
			log.info("********************Launched internet explorer browser********************");
		} else {
			System.out.println(BrowserName + ": is not proper browser name ");
			try {
				throw new Exception("No Browser found exception");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return driver;
	}

}
