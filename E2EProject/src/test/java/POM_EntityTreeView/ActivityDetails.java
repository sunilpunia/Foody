package POM_EntityTreeView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ActivityDetails {

	
	public WebDriver driver;

	public ActivityDetails(WebDriver sdriver) {
		this.driver = sdriver;
	}
	

	
	@FindBy(how=How.XPATH,using="//*[@id='geninform_GroupId']")
	WebElement group_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='geninform_SubGroupId']")
	WebElement subgroup_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='geninform_MainActivityID']")
	WebElement mainActivityDrpDown;
	@FindBy(how=How.XPATH,using="//*[@id='geninform_SubActivityID']")
	WebElement addSubActivityDropDown;
	@FindBy(how=How.XPATH,using="//*[@id='collapse4']/div/div/div[4]/div/div/div/input[2]")
	WebElement Add_button;
	@FindBy(how=How.XPATH,using="//*[@id='tblActivityDetails']/tbody/tr[1]/td[4]/a")
	WebElement cancelButton_1stRow;
	@FindBy(how=How.XPATH,using="//*[@id='tblActivityDetails']/tbody/tr[2]/td[4]/a")
	WebElement cancelButton_2ndRow;
	
	@FindBy(how=How.XPATH,using="//*[@id='btnActivityDetails']")
	WebElement update_button;
	
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='dvMainActivityWorkHrs']/div[1]/button")
	WebElement editActivityHours_button;
	
	//Activity Hours screen
	//.....................................................
	
	
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[1]/div[1]/input")
	WebElement Hours_12amTo4am;
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[1]/div[2]/input")
	WebElement Employee_12amTo4am;
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[1]/div[3]/input")
	WebElement FoodHandler_12amTo4am;
	
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[2]/div[1]/input")
	WebElement Hours_4amTo8am;
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[2]/div[2]/input")
	WebElement Employee_4amTo8am;
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[2]/div[3]/input")
	WebElement Foodhandler_4amTo8am;
	
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[3]/div[1]/input")
	WebElement Hours_8amTo12pm;
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[3]/div[2]/input")
	WebElement Employee_8amTo12pm;
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[3]/div[3]/input")
	WebElement Foodhandler_8amTo12pm;
	
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[4]/div[1]/input")
	WebElement Hours_12pmTo4pm;
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[4]/div[2]/input")
	WebElement Employee_12pmTo4pm;
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[4]/div[3]/input")
	WebElement Foodhandler_12pmTo4pm;
	
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[5]/div[1]/input")
	WebElement Hours_4pmTo8pm;
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[5]/div[2]/input")
	WebElement Employee_4pmTo8pm;
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[5]/div[3]/input")
	WebElement Foodhandler_4pmTo8pm;
	
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[6]/div[1]/input")
	WebElement Hours_8pmTo12am;
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[6]/div[2]/input")
	WebElement Employee_8pmTo12am;
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[6]/div[3]/input")
	WebElement Foodhandler_8pmTo12am;
	
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[7]/div[1]/input")
	WebElement Hours_24hours;
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[7]/div[2]/input")
	WebElement Employee_24hours;
	@FindBy(how=How.XPATH,using="//*[@id='dvEditActivityWorkingHrs']/div[2]/div/div[1]/div[2]/div[7]/div[3]/input")
	WebElement Foodhandler_24hours;
	
	
	//office hours
	//.........................................
	@FindBy(how=How.XPATH,using="//*[@id='OfficeHrsFromTime']")
	WebElement from_officehour;
	@FindBy(how=How.XPATH,using="//*[@id='OfficeHrsToTime']")
	WebElement To_officehour;
	@FindBy(how=How.XPATH,using="//*[@id='btnActivityWorkHrs']")
	WebElement updateButton;
	@FindBy(how=How.XPATH,using="//*[@id='dvUpdateActivityWorkingHrs']/input[2]")
	WebElement cancelButton;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
