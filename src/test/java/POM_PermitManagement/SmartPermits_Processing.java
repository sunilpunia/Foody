package POM_PermitManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SmartPermits_Processing {

	
	public WebDriver driver;

	public SmartPermits_Processing(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	
	
	

	
	
	//Smart Permit Search
		//...............................................................
		@FindBy(how=How.XPATH,using="//input[@id='txtsearch']")
		WebElement SearchUsingNameORLicenseNo;
		@FindBy(how=How.XPATH,using="//input[@id='bttnClick']")
		WebElement searchButton;
		@FindBy(how=How.XPATH,using="//select[@id='ddlStatusId']/option[5]")
		WebElement searchByStatus_Processing;
		@FindBy(how=How.XPATH,using="//input[@id='txtPermitSearch']")
		WebElement searchMin3Char;
		
		
		
		//Permits grid
		//------------------------------------
		@FindBy(how=How.XPATH,using="//*[@id='ViewPartialEntityPermit']/div[1]/div[1]/div/table/tbody/tr[1]/td[16]/button")
		WebElement ProcessingButton_1stRow;
		@FindBy(how=How.XPATH,using="//*[@id='ViewPartialEntityPermit']/div[1]/div[1]/div/table/tbody/tr[1]/td[17]")
		WebElement CancelButton_1stRow;
		
		@FindBy(how=How.XPATH,using="//*[@id='ViewPartialEntityPermit']/div[1]/div[1]/div/table/tbody/tr[2]/td[16]/button")
		WebElement ProcessingButton_2ndRow;
		@FindBy(how=How.XPATH,using="//*[@id='ViewPartialEntityPermit']/div[1]/div[1]/div/table/tbody/tr[2]/td[17]")
		WebElement CancelButton_2ndRow;
		
		@FindBy(how=How.XPATH,using="//*[@id='ViewPartialEntityPermit']/div[1]/div[1]/div/table/tbody/tr[3]/td[16]/button")
		WebElement ProcessingButton_3rdRow;
		@FindBy(how=How.XPATH,using="//*[@id='ViewPartialEntityPermit']/div[1]/div[1]/div/table/tbody/tr[3]/td[17]")
		WebElement CancelButton_3rdRow;
		
		
		
		//Permit Cancellation Remark popup
		@FindBy(how=How.XPATH,using="//input[@id='edtRemark']")
		WebElement cancellationRemark_textfield;
		@FindBy(how=How.XPATH,using="//input[@id='btnClosePopup']")
		WebElement closeButton;
		@FindBy(how=How.XPATH,using="//input[@id='btnSubmit']")
		WebElement SubmitButton;
		
		
		
		
		//Requested Screen coming after clicking on "Requested Button"
		//..............................................................................
		
		//status
		@FindBy(how=How.XPATH,using="//select[@id='ddlStatus']/option[5]")
		WebElement Status_Processing;
		
		
		@FindBy(how=How.XPATH,using="//input[contains(@id,'btnEstablishment')]")
		WebElement Establishment_EntityName;
		@FindBy(how=How.XPATH,using="//textarea[@id='txtAreaComment']")
		WebElement Comment_TextArea;
		
		//inspector comment
		@FindBy(how=How.XPATH,using="//select[@id='ddlInspectorComment']/option")
		WebElement InspectorComment_AllValues;
		
		
		
		@FindBy(how=How.XPATH,using="//input[@id='btnUpdateFile']")
		WebElement UpdateFile_Button;
		@FindBy(how=How.XPATH,using="//input[@id='btnApprovePermit']")
		WebElement ApprovePermit_Button;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
