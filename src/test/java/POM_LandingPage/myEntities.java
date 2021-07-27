package POM_LandingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class myEntities {
	
public WebDriver driver;
	
	public myEntities(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-bars topbarmenu']")
	WebElement menu_drpdown;
	@FindBy(how = How.NAME, using = "//input[@name='SearchKey']")
	WebElement estab_licenseSearch_Textbox;
	@FindBy(how = How.XPATH, using = "//input[@value='Search']")
	WebElement searchButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"tbllandingpageUrl\"]/tbody/tr[1]/td[3]/a")
	WebElement myEntitytable_searchResult;
	@FindBy(how = How.XPATH, using = "//*[@name='SearchKey']")
	WebElement searchTextBox;
	
	@FindBy(how = How.XPATH, using = "//a[@class='dropdown-toggle bwWrapper active']")
	WebElement my_entities;
	@FindBy(how = How.XPATH, using = "//*[@id='RegisterLink_2']")
	WebElement FoodSafetyandNutritionInformation;
	@FindBy(how = How.XPATH, using = "//*[@id='RegisterLink_1015']")
	WebElement manageFoodStock;
	@FindBy(how = How.XPATH, using = "//*[@id='RegisterLink_1004']")
	WebElement selfInspection;
	@FindBy(how = How.XPATH, using = "//*[@id='RegisterLink_1005']")
	WebElement trainingRequest;
	@FindBy(how = How.XPATH, using = "//*[@id='RegisterLink_1006']")
	WebElement manageSupplier;
	@FindBy(how = How.XPATH, using = "//*[@id='RegisterLink_1009']")
	WebElement pendingTasksandRequest;
	@FindBy(how = How.XPATH, using = "//*[@id='RegisterLink_3']")
	WebElement smartSchool;
	@FindBy(how = How.XPATH, using = "//*[@id='RegisterLink_1012']")
	WebElement paymentRenewal;
	@FindBy(how = How.XPATH, using = "//*[@id='RegisterLink_1013']")
	WebElement permitManagement;
	@FindBy(how = How.XPATH, using = "//*[@id='RegisterLink_1017']")
	WebElement currentCertification;
	@FindBy(how = How.XPATH, using = "//*[@id='RegisterLink_1018']")
	WebElement E_learning;
	@FindBy(how = How.XPATH, using = "//*[@id='RegisterLink_2018']")
	WebElement scheduleTasks;
	@FindBy(how = How.XPATH, using = "//*[@id='RegisterLink_2020']")
	WebElement selfLifeApproval;
	@FindBy(how = How.XPATH, using = "//a[@href='https://www.dubaiway.ae/']")
	WebElement DTCMTrainingLogin;
	@FindBy(how = How.XPATH, using = "//*[@id='RegisterLink_3023']")
	WebElement MyFoodwatchConnect;
	
	@FindBy(how = How.XPATH, using = "//*[span='Messages']")
	WebElement messages;
	@FindBy(how = How.XPATH, using = "//*[span='Search']")
	WebElement Search;
	@FindBy(how = How.XPATH, using = "//*[span='Administrator']")
	WebElement administrator;
	@FindBy(how = How.XPATH, using = "//*[span='Logout']")
	WebElement logOut;
	
	public void clickLeftMenu() {
		menu_drpdown.click();
	}

	public void clickEntitiesTableGrid() {
		myEntitytable_searchResult.click();
	}

	public void enterSearchTxtBox(String entertxt) {
		searchTextBox.sendKeys(entertxt);
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public void clickLogout() {
		logOut.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

