package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.basicactions.JavaScriptHelper;
import com.utilities.ReadPropFile;

public class TestCase2 {
	
	public WebDriver driver;
	ReadPropFile readPropFile;
	TestBase testBase;
	JavaScriptHelper javaScriptHelper;
	
	@Test
	public void verifyTitle() throws Throwable{
		readPropFile = new ReadPropFile();
		testBase = new TestBase();
		driver = testBase.launchBrowser(readPropFile.readProp().getProperty("browser"));
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		
		System.out.println("test");
		
		
//		WebElement departure = driver.findElement(By.id("ctl00_mainContent_view_date1"));
		
		String date ="15/12";
		
		String script = "document.getElementById('ctl00_mainContent_view_date1').value='"+date+"';";
		javaScriptHelper = new JavaScriptHelper(driver);
		
		javaScriptHelper.executeScript(script);
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].setAttribute('value', '"+date+"');", departure);
		
//		js.executeScript("document.getElementById('ctl00_mainContent_view_date1').value='"+date+"';");
		
		Thread.sleep(5000);
		
		driver.close();
	}

}
