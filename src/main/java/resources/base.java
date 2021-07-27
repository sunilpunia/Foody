package resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
//import java.awt.List;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;





public class base {

	public  static WebDriver driver;
	public Properties prop;
	public ExcelDataConfig excel;
	public manageConfigProperties config;	
	public ExtentReports report;
	//ExtentHtmlReporter html;
	
	@BeforeSuite
	public void setUpSuite() {
	excel=new ExcelDataConfig("C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
	config=new manageConfigProperties();
	
	//html=new ExtentHtmlReporter("Extent.html");
	
	}
	
	//test
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//" + result + "screenshot.png"));

	}
	
	
	@BeforeClass
	public void setup() {
		 driver=BrowserFactory.startApplication(driver,config.getBrowser() ,config.getTestUrl());	
	}
	
	
	
	//@AfterClass
	public void tearDown() {
	BrowserFactory.quitBrowser(driver);
		
	}
	
	
	@AfterMethod
public void captureScreenshotForEachMethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			Helper.takeScreenShot(driver, result.getName());
			System.err.println("This is the test Print"+result);
		}
}
	
	
	
	
	
	public static void simplelogin(String URL) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	
	//Log file is not working. Need to write code for log file
	
	
	
	
}
	
	


