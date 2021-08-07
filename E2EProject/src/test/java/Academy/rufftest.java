package Academy;

import java.awt.Checkbox;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.classfile.Constant;
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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.internal.AbstractParallelWorker.Arguments;

import POM_EntityTreeView.GeneralInformation;
import POM_EntityTreeView.entityTreeView;
import POM_EntityTreeView.foodSafetyManagement;
import POM_Login.loginScreen;
import POM_MyEntities.SearchOnEstablishNameAndLicenseNumber;
import POM_SelfInspection.StartUpTempAndProcessMonitoring;
import resources.base;
import resources.manageConfigProperties;
import resources.ExcelDataConfig;
import resources.Helper;
import utility.Exceldata;
public class rufftest extends base {
	public static WebDriver driver;
	public ExcelDataConfig excel;

	
	
	@BeforeClass
	public void setUpSuite() {

		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();

	}
	
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.0.76:82/Account/Login");
		
		driver.findElement(By.id("username")).sendKeys("abcdefghijk@abcd.acd");
		driver.findElement(By.id("nopend")).sendKeys("200sresu@1966");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	 StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
	 StartUpTempAndProcessMonitoringObject.LeftMenuClick();
	 SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
	 String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(5);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();
	 
		foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
		Helper.pause(1);
		foodSafetyManagementObject.ClickFoodSafetyManagement();
		Helper.pause(1);
		foodSafetyManagementObject.ClickfoodDetails();
		String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
		String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
	    Helper.switchToMainWindow(driver, parentWindowHandle);
	 

	    
		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
		Helper.ClickUsingLinkText(driver, EntityName);
	    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
	    Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Cooking [Cooking ] [Temp °C]");
	  
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
		
			 //Switch to new tab and work on it.
			public static String switchToNewTab(WebDriver driver,String clickXpath) {				
			 String parentWindow=driver.getWindowHandle();				
			 driver.findElement(By.xpath(clickXpath)).click();			
			 Set<String> allWindows= driver.getWindowHandles();
			 
			    for(String child:allWindows) {
				
				 if(!parentWindow.equalsIgnoreCase(child)) {
					driver.switchTo().window(child);
					Helper.pause(2);
				
					
				}				
			}
			    return parentWindow;			
			}
			
		
					
	//Filter the table record with one table row or column and return the Text value of other column or row.
			public static String  RowTextActiveYes(String xpathActivefieldFilterField,String compareToText, String xpathToGetText) {
										
				List<WebElement> Active_Status=driver.findElements(By.xpath(xpathActivefieldFilterField));
				
				 String FirstActivePerson ="";
				for(int i=0;i<Active_Status.size();i++) {
					   String print= Active_Status.get(i).getText();	
					if(print.equalsIgnoreCase(compareToText)) {	
						List<WebElement> allColumn=driver.findElements(By.xpath(xpathToGetText));
						String productName=allColumn.get(i).getText();
						FirstActivePerson=productName;
						break;
					}
					
				}
				//System.err.println("Product Name is--"+FirstActivePerson);
				return FirstActivePerson;
			}
			
			
			
			
			
			
			
			
		
	
	

	
	
	
	
			}
	

