package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.basicactions.JavaScriptHelper;
import com.utilities.ReadPropFile;

public class TestCase5 {
	
	public WebDriver driver;
	ReadPropFile readPropFile;
	TestBase testBase;
	JavaScriptHelper javaScriptHelper;
	
	@Test
	public void makeMyTrip() throws Throwable{
		readPropFile = new ReadPropFile();
		testBase = new TestBase();
		driver = testBase.launchBrowser(readPropFile.readProp().getProperty("browser"));
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://makemytrip.com"); 
		String fromCity = "London";
		String toCity = "Delhi";
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(fromCity);
		driver.findElement(By.xpath("//li[@role='option']//p[contains(text(),'"+fromCity+"')]")).click();
		Thread.sleep(1000);
		javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.clickElement(driver.findElement(By.xpath("//input[@id='toCity']")));
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(toCity);
		driver.findElement(By.xpath("//li[@role='option']//p[contains(text(),'"+toCity+"')]")).click();
	}
}
