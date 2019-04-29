package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.utilities.ReadPropFile;
import com.base.TestBase;

public class TestCase1 {
	
	public WebDriver driver;
	ReadPropFile readPropFile;
	TestBase testBase;
	
		
	@Test
	public void verifyTitle() throws Throwable{
		readPropFile = new ReadPropFile();
		testBase = new TestBase();
		driver = testBase.launchBrowser(readPropFile.readProp().getProperty("browser"));
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://simplypeard.devdigdev.com/");
		driver.findElement(By.name("username")).sendKeys("sagar.qamagic@gmail.com");
		driver.findElement(By.id("PASSWORD")).sendKeys("tester");
		driver.findElement(By.id("submit_btn")).click();
		Thread.sleep(3000);
		String newurl = "http://simplypeard.devdigdev.com/index.php?route=common/lead/loadAddEdit";
		driver.navigate().to(newurl);
		driver.findElement(By.xpath("//span[@id='select2-lead_source_id-container']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("The Daily Bugle Newspaper"+Keys.ENTER);
		Thread.sleep(3000);
//		WebElement enterPhoneNumber = driver.findElement(By.id("phone"));
//		enterPhoneNumber.click();
//		
//		enterPhoneNumber.sendKeys(Keys.HOME+"1111111111");
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].value='1111111111';", enterPhoneNumber);
		driver.quit();
	}

}
