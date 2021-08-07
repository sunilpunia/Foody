package POM_PermitManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SmartPermits_Cancelled {

	
	public WebDriver driver;

	public SmartPermits_Cancelled(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	


	
	    //Smart Permit Search
		//...............................................................
		@FindBy(how=How.XPATH,using="//input[@id='txtsearch']")
		WebElement SearchUsingNameORLicenseNo;
		@FindBy(how=How.XPATH,using="//input[@id='bttnClick']")
		WebElement searchButton;
		@FindBy(how=How.XPATH,using="//select[@id='ddlStatusId']/option[6]")
		WebElement searchByStatus_Processing;
		@FindBy(how=How.XPATH,using="//input[@id='txtPermitSearch']")
		WebElement searchMin3Char;
		
		
		
		
	
	

	
	
	
	
	
	
}
