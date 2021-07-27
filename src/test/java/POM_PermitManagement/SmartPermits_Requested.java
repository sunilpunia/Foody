package POM_PermitManagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import resources.Helper;

public class SmartPermits_Requested {

	
	public WebDriver driver;

	public SmartPermits_Requested(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	
	
	
	
	//Smart Permit Search
	//...............................................................
	@FindBy(how=How.XPATH,using="//input[@id='txtsearch']")
	WebElement SearchUsingNameORLicenseNo;
	@FindBy(how=How.XPATH,using="//input[@id='bttnClick']")
	WebElement searchButton;
	@FindBy(how=How.XPATH,using="//select[@id='ddlStatusId']/option[2]")
	WebElement searchByStatus_Requested;
	@FindBy(how=How.XPATH,using="//input[@id='txtPermitSearch']")
	WebElement searchMin3Char;
	
	//Permits grid
	//------------------------------------
	@FindBy(how=How.XPATH,using="//*[@id=\"//input[@id='txtPermitSearch']\"]")
	WebElement RequestedButton_1stRow;
	@FindBy(how=How.XPATH,using="//*[@id='ViewPartialEntityPermit']/div[1]/div[1]/div/table/tbody/tr[1]/td[17]")
	WebElement CancelButton_1stRow;
	
	@FindBy(how=How.XPATH,using="//*[@id='ViewPartialEntityPermit']/div[1]/div[1]/div/table/tbody/tr[2]/td[16]/button")
	WebElement RequestedButton_2ndRow;
	@FindBy(how=How.XPATH,using="//*[@id='ViewPartialEntityPermit']/div[1]/div[1]/div/table/tbody/tr[2]/td[17]")
	WebElement CancelButton_2ndRow;
	
	@FindBy(how=How.XPATH,using="//*[@id='ViewPartialEntityPermit']/div[1]/div[1]/div/table/tbody/tr[3]/td[16]/button")
	WebElement RequestedButton_3rdRow;
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
	@FindBy(how=How.XPATH,using="//select[@id='ddlStatus']/option[2]")
	WebElement Status_Requested;
	@FindBy(how=How.XPATH,using="//select[@id='ddlStatus']/option[3]")
	WebElement Status_Approved;
	@FindBy(how=How.XPATH,using="//select[@id='ddlStatus']/option[4]")
	WebElement Status_Denied;
	@FindBy(how=How.XPATH,using="//select[@id='ddlStatus']/option[5]")
	WebElement Status_Processing;
	@FindBy(how=How.XPATH,using="//select[@id='ddlStatus']/option[6]")
	WebElement Status_UnderReview;
	@FindBy(how=How.XPATH,using="//select[@id='ddlStatus']/option[7]")
	WebElement Status_PendingAssessment;
	@FindBy(how=How.XPATH,using="//select[@id='ddlStatus']/option[8]")
	WebElement Status_UnderAppeal;
	
	
	
	//Permit List button
	@FindBy(how=How.XPATH,using="//*[@id='tempPermitList']")
	WebElement PermitListButton;
	@FindBy(how=How.XPATH,using="//button[text()='Done']")
	WebElement PopUp_permitList_DoneButton;
	
	

	
	//Risk Level
	@FindBy(how=How.XPATH,using="//select[@id='ddlRiskLevel']/option")
	WebElement RiskLevel_AllValues;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'btnEstablishment')]")
	WebElement Establishment_EntityName;
	@FindBy(how=How.XPATH,using="//textarea[@id='txtAreaComment']")
	WebElement Comment_TextArea;
	
	//inspector comment
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectorComment']/option[2]")
	WebElement DeniedBySectionHead;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectorComment']/option[3]")
	WebElement ApprovedByInspectionTeam;
	
	
	@FindBy(how=How.XPATH,using="//input[@id='btnUpdateFile']")
	WebElement UpdateFile_Button;
	@FindBy(how=How.XPATH,using="//input[@id='btnApprovePermit']")
	WebElement ApprovePermit_Button;
	
	
	
	//------------------------------------------------------------------
		
	public void searchPermit(String searchValue) {
		searchMin3Char.sendKeys(searchValue);
	}
	
	public String clickOnRequestButton(String xpathPartial,String followingXpathButton) {
		String fullxPathOfReqButton= xpathPartial+followingXpathButton;
		 driver.findElement(By.xpath(fullxPathOfReqButton)).click();
		return fullxPathOfReqButton;
		
	}
	public void clickOnApprovePermitButton() {
		ApprovePermit_Button.click();
	}
	
	
	public void clickOnUpdateFileButton() {
		UpdateFile_Button.click();
	}
	

	
	
	public void clickOnSmartPermitSearchButton() {
		searchButton.click();
	}
	
	
	//only for food safety trainer-internal
	public void clickOnPermitListButton() {
		PermitListButton.click();
	}
	
	public void clickOnPopUpOfPermitListDoneButton() {
		PopUp_permitList_DoneButton.click();
	}
	
	
	

	
	
	
	//Example xpath=//div[@class='col-sm-6 col-md-5']/ul/li/a
	public void clickOnSmartPermitSearchbyIntelligentSearch(String id,String SearchValue, String compareWith,String xpath) {
		
			driver.findElement(By.id(id)).sendKeys(SearchValue);
			Helper.pause(2);
		    List<WebElement> list=	driver.findElements(By.xpath(xpath));
	    	Helper.pause(2);
		
		   for(int i=0;i<list.size();i++) {
		    	String textOfSearchResult=  list.get(i).getText();
			    System.err.println( "Total dropDownValues-"+ " "+list.size()+"DropDown values are-"+textOfSearchResult);
			    if(textOfSearchResult.equalsIgnoreCase(compareWith)) {
			   	list.get(i).click();
				 break;
			}
		}		
	}
		
	
	
	public void searchSmartPermitByNameORLicenseNo(String searchValue) {
		
		SearchUsingNameORLicenseNo.sendKeys(searchValue);
		Helper.highlightColorUsingXpath(driver, SearchUsingNameORLicenseNo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void mouseOverPermitManagementAndClickSmartPermit() {

		Actions act = new Actions(driver);
		
		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'Permit Management')]"));
		
		act.moveToElement(web).build().perform();
		List<WebElement> drop_down_List = driver.findElements(By.xpath("//ul[@class='nav navbar-nav mcd-menu']/li[10]/ul/li/a"));
		for (int i = 0; i < drop_down_List.size(); i++) {
			WebElement drpValue = drop_down_List.get(i);
			String drp_down_text = drpValue.getText();
			  Boolean link_Status=drpValue.isEnabled();
			  System.err.println("This is the link status--"+ link_Status);
			 // ReqDrpValue=driver.findElement(By.xpath("//a[contains(text(),'Start up, Temperature & Process Monitoring')]"));
			if (drp_down_text.equalsIgnoreCase("Smart Permits")) {
				drpValue.click();
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
