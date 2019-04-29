package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.utilities.ReadPropFile;

public class TestCase3 {
	
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
		
		driver.get("http://onlyheart.devdigdev.com/login");
		driver.findElement(By.id("email")).sendKeys("mansi.desai@devdigital.com");
		driver.findElement(By.name("password")).sendKeys("Md@123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='btn-group text-center']")).click();
		driver.findElement(By.xpath("//a[text()='My Campaigns']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='Edit'])[1]")).click();
		
		Thread.sleep(1000);
		WebElement preview = driver.findElement(By.xpath("//*[text()='Preview']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", preview);
		preview.click();
		Thread.sleep(1000);
		WebElement submitpay = driver.findElement(By.xpath("//*[text()='SUBMIT & PAY']"));
		js.executeScript("arguments[0].scrollIntoView()", submitpay);
		submitpay.click();
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@name='stripe_checkout_app']"));
		driver.switchTo().frame(frameElement);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("digvijay@gmail.com");;
		Thread.sleep(5000);
		driver.close();
	}
}