package com.base;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxBrowser {
	
	public FirefoxOptions getFirefoxOptions() {

		DesiredCapabilities firefox = DesiredCapabilities.firefox();

		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);

		FirefoxOptions firefoxOptions = new FirefoxOptions(firefox);
		// Linux
		if (System.getProperty("os.name").contains("Linux")) {
			firefoxOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		}
		return firefoxOptions;
	}

}
