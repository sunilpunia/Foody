package POM_SelfInspection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class VehicleMonitoring {

	
	
	public WebDriver driver;

	public VehicleMonitoring(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='RegisterLink_1004']")
	WebElement Self_Inspection;
	
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='txtsearch']")
	WebElement searchByNameOrLicenseNo;
	@FindBy(how=How.XPATH,using="//*[@id='btnSearchVehicleMonitoringEntities']")
	WebElement search_button;
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='tblVehicleMonitoringEntity']/tbody/tr[1]/td[2]/a")
	WebElement TableGrid_1stResultXpath;
	@FindBy(how=How.XPATH,using="//*[@id='tblVehicleMonitoringEntity']/tbody/tr[2]/td[2]/a")
	WebElement TableGrid_2ndResultXpath;
	
	
	
	
	//Vehicle monitoring details
	//....................................................................
	@FindBy(how=How.XPATH,using="//*[@id='VehicleNo']")
	WebElement vehicle_plateNumber;
	
	//status
	@FindBy(how=How.XPATH,using="//label[contains(text(),'Delivery Accepted')]//following::input[1]")
	WebElement delivery_Accepted;
	@FindBy(how=How.XPATH,using="//label[contains(text(),'Delivery Accepted')]//following::input[2]")
	WebElement delivery_Rejected;
	
	
	
	//Reason for Rejection
	@FindBy(how=How.XPATH,using="//label[contains(text(),'Delivery Accepted')]//following::input[3]")
	WebElement Food_Temperature;
	@FindBy(how=How.XPATH,using="//label[contains(text(),'Delivery Accepted')]//following::input[4]")
	WebElement Food_Packaging;
	@FindBy(how=How.XPATH,using="//label[contains(text(),'Delivery Accepted')]//following::input[5]")
	WebElement Food_Expired;
	@FindBy(how=How.XPATH,using="//label[contains(text(),'Delivery Accepted')]//following::input[6]")
	WebElement Dirty_Vehicle;
	@FindBy(how=How.XPATH,using="//label[contains(text(),'Delivery Accepted')]//following::input[7]")
	WebElement Poor_Maintenance;
	
	
	
	//Action Taken
	@FindBy(how=How.XPATH,using="//*[@id='ddlInspectionActionsVehicles']/option[2]")
	WebElement Food_Rejected;
	@FindBy(how=How.XPATH,using="//*[@id='ddlInspectionActionsVehicles']/option[3]")
	WebElement Food_Accepted_Conditionally;
	
	
	
	
	
	@FindBy(how=How.XPATH,using="//label[contains(text(),'Delivery Accepted')]//following::input[8]")
	WebElement DoneButton_LastOfPage;
	
	
	
	
	
	
	
	

	
	
	
	
	
}
