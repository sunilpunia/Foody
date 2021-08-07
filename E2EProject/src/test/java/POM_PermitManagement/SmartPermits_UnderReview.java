package POM_PermitManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SmartPermits_UnderReview {

	
	public WebDriver driver;

	public SmartPermits_UnderReview(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	
	

	
	        //Smart Permit Search
			//...............................................................
			@FindBy(how=How.XPATH,using="//input[@id='txtsearch']")
			WebElement SearchUsingNameORLicenseNo;
			@FindBy(how=How.XPATH,using="//input[@id='bttnClick']")
			WebElement searchButton;
			@FindBy(how=How.XPATH,using="//select[@id='ddlStatusId']/option[7]")
			WebElement searchByStatus_Processing;
			@FindBy(how=How.XPATH,using="//input[@id='txtPermitSearch']")
			WebElement searchMin3Char;
	
	
	
			//Permits grid
			//------------------------------------
			@FindBy(how=How.XPATH,using="//*[@id='ViewPartialEntityPermit']/div[1]/div[1]/div/table/tbody/tr[1]/td[16]/button")
			WebElement UnderReview_1stRow;
			@FindBy(how=How.XPATH,using="//*[@id='ViewPartialEntityPermit']/div[1]/div[1]/div/table/tbody/tr[2]/td[16]/button")
			WebElement UnderReview_2ndRow;
			@FindBy(how=How.XPATH,using="//*[@id='ViewPartialEntityPermit']/div[1]/div[1]/div/table/tbody/tr[3]/td[16]/button")
			WebElement UnderReview_3rdRow;
		
	
	
	
	
			//Requested Screen coming after clicking on "Requested Button"
			//..............................................................................
			
			//status
			@FindBy(how=How.XPATH,using="//select[@id='ddlStatus']/option[6]")
			WebElement Status_Processing;
			
			
			@FindBy(how=How.XPATH,using="//input[contains(@id,'btnEstablishment')]")
			WebElement Establishment_EntityName;
		
			
			//inspector comment
			@FindBy(how=How.XPATH,using="//select[@id='ddlInspectorComment']/option")
			WebElement InspectorComment_AllValues;
			
			
			
			@FindBy(how=How.XPATH,using="//input[@id='btnUpdateFile']")
			WebElement UpdateFile_Button;
			@FindBy(how=How.XPATH,using="//input[@id='btnApprovePermit']")
			WebElement ApprovePermit_Button;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
