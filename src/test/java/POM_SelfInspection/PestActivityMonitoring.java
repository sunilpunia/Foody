package POM_SelfInspection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PestActivityMonitoring {

	
	
	public WebDriver driver;

	public PestActivityMonitoring(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='txtsearch']")
	WebElement searchByNameORlicenseNo;
	@FindBy(how=How.XPATH,using="//*[@id='btnSearchPestFlaggedEntities']")
	WebElement searchButton;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='lblFlaggedEntities']")
	WebElement Flagged_EntitiesButton;
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='tblPestActivityCheck']/tbody/tr[1]/td[2]/a")
	WebElement TableGrid_1stResultXpathPest;
	@FindBy(how=How.XPATH,using="//*[@id='tblPestActivityCheck']/tbody/tr[2]/td[2]/a")
	WebElement TableGrid_2ndResultXpathPest;
	
	
	
	//Edit Pest Activity Check
	//................................................................
	//select Food Area
	@FindBy(how=How.XPATH,using="//select[@id='ddlFoodAreaList']/option[2]")
	WebElement Warehouse_Layout;
	@FindBy(how=How.XPATH,using="//select[@id='ddlFoodAreaList']/option[3]")
	WebElement LayoutOfTheGroceryStore;
	@FindBy(how=How.XPATH,using="//select[@id='ddlFoodAreaList']/option[4]")
	WebElement KebabGrill;
	
	
	
	//Select Pest
	//............................................
	@FindBy(how=How.XPATH,using="//select[@id='ddlPestsList']/option[2]")
	WebElement German_Cockroach;
	@FindBy(how=How.XPATH,using="//select[@id='ddlPestsList']/option[3]")
	WebElement American_Cockroach;
	@FindBy(how=How.XPATH,using="//select[@id='ddlPestsList']/option[4]")
	WebElement Roof_Rat;
	@FindBy(how=How.XPATH,using="//select[@id='ddlPestsList']/option[5]")
	WebElement Rat;
	@FindBy(how=How.XPATH,using="//select[@id='ddlPestsList']/option[6]")
	WebElement Mice;
	@FindBy(how=How.XPATH,using="//select[@id='ddlPestsList']/option[7]")
	WebElement House_Fly;
	@FindBy(how=How.XPATH,using="//select[@id='ddlPestsList']/option[8]")
	WebElement Drain_fly;
	@FindBy(how=How.XPATH,using="//select[@id='ddlPestsList']/option[9]")
	WebElement Pigeon;
	@FindBy(how=How.XPATH,using="//select[@id='ddlPestsList']/option[10]")
	WebElement Cats;
	
	
	
	//Select Cause
	//........................................................
	@FindBy(how=How.XPATH,using="//select[@id='ddlCausesList']/option[2]")
	WebElement PoorBuildingMaintenance;
	@FindBy(how=How.XPATH,using="//select[@id='ddlCausesList']/option[3]")
	WebElement PoorWasteManagement;
	@FindBy(how=How.XPATH,using="//select[@id='ddlCausesList']/option[4]")
	WebElement UnrestrictedEntry;
	@FindBy(how=How.XPATH,using="//select[@id='ddlCausesList']/option[5]")
	WebElement ExternalFactors;
	@FindBy(how=How.XPATH,using="//select[@id='ddlCausesList']/option[6]")
	WebElement NA_option;
	
	
	
	// Action Taken
	//.................................................................................
	@FindBy(how=How.XPATH,using="//select[@id='ddlActionsList']/option[2]")
	WebElement Insecticide_Treatment;
	@FindBy(how=How.XPATH,using="//select[@id='ddlActionsList']/option[3]")
	WebElement Rodenticide_Treatment;
	@FindBy(how=How.XPATH,using="//select[@id='ddlActionsList']/option[4]")
	WebElement Pre_requisite_Management;
	@FindBy(how=How.XPATH,using="//select[@id='ddlActionsList']/option[5]")
	WebElement MechanicalControl_Measures;
	@FindBy(how=How.XPATH,using="//select[@id='ddlActionsList']/option[6]")
	WebElement Hormone_Traps;
	
	
	//Pesticide Used
	//...........................................
	@FindBy(how=How.XPATH,using="//select[@id='ddlPesticidesList']")
	WebElement Pesticide_Used_DropDownALL;
	
	
	
	@FindBy(how=How.XPATH,using="//input[@id='btnSubmitPestActivity']")
	WebElement DoneButton_AtLastOfScreen;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


