package project;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.utilities.ReadPropFile;

public class TestCase4 {
	
	public WebDriver driver;
	ReadPropFile readPropFile;
	TestBase testBase;
	
	@Test
	public void case3() throws Exception{
		readPropFile = new ReadPropFile();
		testBase = new TestBase();
		driver = testBase.launchBrowser(readPropFile.readProp().getProperty("browser"));
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://chandanachaitanya.github.io/selenium-practice-site/");
		String parentWinHandle = driver.getWindowHandle();
        System.out.println("Parent window handle: " + parentWinHandle);
        WebElement newWindowBtn = driver.findElement(By.id("win1"));
        newWindowBtn.click();
        Set<String> winHandles = driver.getWindowHandles();
        Thread.sleep(2000);
        for(String handle: winHandles){
        	if(!handle.equals(parentWinHandle)){
        		driver.switchTo().window(handle);
        		Thread.sleep(1000);
        		System.out.println("Title of the new window: " +driver.getTitle());
        		System.out.println("Closing the new window...");
        		driver.close();
        	}
        }
        driver.switchTo().window(parentWinHandle);
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
}