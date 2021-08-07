package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class takeScreenshotOfFailedTestCases {

	WebDriver driver;
	
	@Test
	public void captureScreenshot() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.0.76:82/Account/Login");	
		driver.findElement(By.xpath("lksjdfls")).click();
	}
	
	@AfterMethod
	public void captureScreenshotForEachMethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			Helper.takeScreenShot(driver, result.getName());
			System.err.println("This is the test Print"+result);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
