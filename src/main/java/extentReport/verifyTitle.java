package extentReport;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import resources.Helper;
import resources.base;

public class verifyTitle {

	ExtentReports report;
	WebDriver driver;
	ExtentTest logger;

	@Test
	public void verifyTitle() {

		report = new ExtentReports("C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\/ExtentReport_Folder/Report.html");
		logger = report.startTest("verifyTitle");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Browser Started");
		driver.get("http://192.168.0.76:82/");
		logger.log(LogStatus.INFO, "Application is up and running");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Sunil"));
		logger.log(LogStatus.PASS, "Title is verified");

	}

	//Take screenshot of Failed Test Cases and add screenshot to extent report.
	@AfterMethod
	public void addScreenshotToExtentReportFailedTC(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {

			String screenshot_path = Helper.takeScreenShot(driver, result.getName());
			String image=logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Title verification", image);	
		}
		report.endTest(logger);
		report.flush();
		driver.get("C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\/ExtentReport_Folder/Title.html");

	}

}






















