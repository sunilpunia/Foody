package POM_Login_TC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import POM_Login.loginScreen;
import POM_SelfInspection.StartUpTempAndProcessMonitoring;
import resources.BrowserFactory;
import resources.base;
import resources.manageConfigProperties;
import resources.ExcelDataConfig;
import resources.Helper;


public class TC_loginScreen extends base {
	
	public ExcelDataConfig excel;
	

	
	@BeforeMethod
	public void setUpMethod() {
    	excel=new ExcelDataConfig("C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
	    config=new manageConfigProperties();
	
	}
	

	@Test
	public void login() {	
		loginScreen logpge=PageFactory.initElements(driver,loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
       driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();			
				
	}

	
	
	
	
	

	
	
	
	
	
	
	
}








