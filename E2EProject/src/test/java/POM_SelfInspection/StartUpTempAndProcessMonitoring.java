package POM_SelfInspection;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import resources.Helper;

public class StartUpTempAndProcessMonitoring {
public   WebDriver driver;

	public StartUpTempAndProcessMonitoring(WebDriver sdriver) {
		this.driver = sdriver;
	
	}
	
	
	@FindBy(how=How.XPATH,using="//i[@class='fa fa-bars topbarmenu']")
	WebElement LeftMenuClick; 
	
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Self Inspection')]")
	WebElement Inspection_MouseOver; 
	
	
	@FindBy(how=How.XPATH,using="//ul[@class='nav navbar-nav mcd-menu']/li[4]/ul/li/a")
	WebElement Inspection_DropDownList;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Start up, Temperature & Process Monitoring')]")
	WebElement Inspection_DropDown_StartupTempMontrng;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Vehicle Monitoring')]")
	WebElement Inspection_DropDown_VehicleMonitoring; 
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Pest Activity Monitoring')]")
	WebElement Inspection_DropDown_PestActivityMonitrng; 
	
	
	
	
	
	
	//List of entities for PIC
	//....................................................................
	@FindBy(how=How.XPATH,using="//input[@type='search']")
	WebElement search_textField; 
	
	
	@FindBy(how=How.XPATH,using="//*[@id='7']/td[2]/a")
	WebElement company_1stRecordTableGrid;
	
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'UNU')]")    ///this xpath is hard coded for UNU entity 
	WebElement companyUNU_1stRecordTableGrid;
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='8']/td[2]/a")
	WebElement company_2ndRecordTableGrid;
	
	
	
	
	
	
	
	
	//Start Up, Temperature & Process Monitoring >> SCREEN
	@FindBy(how=How.XPATH,using="//input[@id='1']")
	WebElement AllfoodhandlersAreFreeOfAnySymptomsOfFoodborneIllness_checkbox;
	@FindBy(how=How.XPATH,using="//input[@id='2']")
	WebElement AllFoodHandlersHaveCleanUniforms;
	
	@FindBy(how=How.XPATH,using="//input[@id='3']")
	WebElement AllFoodHandlersAreWellGroomedAndClean;
	
	@FindBy(how=How.XPATH,using="//input[@id='4']")
	WebElement HandwashingFacilityIsFullyEquiped;
	
	@FindBy(how=How.XPATH,using="//input[@id='5']")
	WebElement PestActivityReported;
	@FindBy(how=How.XPATH,using="//input[@id='6']")
	WebElement AllFoodAreasAreClean;
	@FindBy(how=How.XPATH,using="//input[@id='7']")
	WebElement CleaningAndDisinfectionOfPremisesCarriedOut;
	
	@FindBy(how=How.XPATH,using="//input[@id='36']")
	WebElement StartupAdditionforTestingPurpose;
	
	@FindBy(how=How.XPATH,using="//*[@id='btnsavestartup']")
	WebElement DoneButton_StartUp;
	
	
	@FindBy(how=How.XPATH,using="//input[@id='uploadFile4']")
	WebElement UploadPicture_1st;
	@FindBy(how=How.XPATH,using="//input[@id='uploadFile5']")
	WebElement UploadPicture_2st;
	@FindBy(how=How.XPATH,using="//input[@id='uploadFile6']")
	WebElement UploadPicture_3st;
	@FindBy(how=How.XPATH,using="//input[@id='uploadFile7']")
	WebElement UploadPicture_4st;
	
	
	
	
	
	//ADD FOOD HANDLERS POP-UP
    //===============================================================================================
	@FindBy(how=How.XPATH,using="//select[@id='ddlFoodHandler']/option")
	WebElement SelectYourFoodHandler_dropDownAllValues;
	
	@FindBy(how=How.XPATH,using="//select[@id='ddlStartUpInspectionItem']/option")
	WebElement SelectStartUpItems_AllDropDownValues;
	
	@FindBy(how=How.XPATH,using="//select[@id='ddlStartUpInspectionItem']/option[2]")
	WebElement AllFoodHandlers_freeFrom_illness;
	@FindBy(how=How.XPATH,using="//select[@id='ddlStartUpInspectionItem']/option[3]")
	WebElement AllFoodHandlers_cleanUniforms;
	@FindBy(how=How.XPATH,using="//select[@id='ddlStartUpInspectionItem']/option[4]")
	WebElement AllFoodHandlers_WellGroomedAndClean;
	
	
	@FindBy(how=How.XPATH,using="//button[@id='btnAddFoodHandler']")
	WebElement Addbutton;
	@FindBy(how=How.XPATH,using="//*[@id='foodHandlerModel']/div/div/div[2]/div/div[2]/button[2]")
	WebElement CloseButton;
	@FindBy(how=How.XPATH,using="//button[@id='btnFinalize']")
	WebElement FinalizeButton;
	
	//grid Action
	@FindBy(how=How.XPATH,using="//*[@id='foodHandlerContent']/tr[1]/td[6]")
	WebElement CancelButton_1stRow;
	@FindBy(how=How.XPATH,using="//*[@id='foodHandlerContent']/tr[2]/td[6]")
	WebElement CancelButton_2stRow;
	@FindBy(how=How.XPATH,using="//*[@id='foodHandlerContent']/tr[3]/td[6]")
	WebElement CancelButton_3stRow;
	
	
	
	//Add Food Areas PopUP
	//................................................................................
	@FindBy(how=How.XPATH,using="//select[@id='ddlPreoperationalFoodArea']/option")
	WebElement FoodArea_DropDownAllValues;
	@FindBy(how=How.XPATH,using="//button[@id='btnAddFoodArea']")
	WebElement AddButton_FoodArea;
	@FindBy(how=How.XPATH,using="//div[@id='foodAreaModel']/div/div/div[2]/div/div[2]/button[2]")
	WebElement CloseButton_AddFoodArea;
	@FindBy(how=How.XPATH,using="//button[@id='btnFoodAreaFinalize']")
	WebElement FinalizeButton_AddFoodArea;
	
	@FindBy(how=How.XPATH,using="//tbody[@id='foodAreaContent']/tr[1]/td[4]")
	WebElement CancelButton_1stRowFoodArea;
	@FindBy(how=How.XPATH,using="//tbody[@id='foodAreaContent']/tr[2]/td[4]")
	WebElement CancelButton_2ndRowFoodArea;
	@FindBy(how=How.XPATH,using="//tbody[@id='foodAreaContent']/tr[3]/td[4]")
	WebElement CancelButton_3rdRowFoodArea;
	
	
	
	
	//Select Your contracted Pest Control Company SCREEN
	//...........................................................................................
	
	@FindBy(how=How.XPATH,using="//select[@id='ddlPestControlCompany']/option")
	WebElement DropDown_PestControlCompany_AllValues;
	@FindBy(how=How.XPATH,using="//button[@id='btnconfirm']")
	WebElement ConfirmYourSelection_button;
	@FindBy(how=How.XPATH,using="//button[@id='btncancle']")
	WebElement CloseButton_PestControlScreen;
	
	
	

	

	
	
	
	
	//Process Check
	//..............................................................................
	@FindBy(how=How.XPATH,using="//input[@id='txtGeneric']")
	WebElement selectFood_Plan;
	@FindBy(how=How.XPATH,using="//input[@id='numbertakeTemprature']")
	WebElement Temperature_Do;
	@FindBy(how=How.XPATH,using="//input[@id='txtVerifyTempLimit']")
	WebElement ControlLimit_Check;
	
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionAction']/option[2]")
	WebElement TakeAction_DiscardFood;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionAction']/option[3]")
	WebElement TakeAction_ReheatFood;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionAction']/option[4]")
	WebElement TakeAction_MoveFood;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionAction']/option[5]")
	WebElement TakeAction_NoActionRequired;
	
	
	//select Process drop down
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionProcess']/option[2]")
	WebElement SelectProcessDropDown_Cooking;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionProcess']/option[3]")
	WebElement SelectProcessDropDown_Hot_Holding;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionProcess']/option[4]")
	WebElement SelectProcessDropDown_Cold_Holding;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionProcess']/option[5]")
	WebElement SelectProcessDropDown_Freezing;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionProcess']/option[6]")
	WebElement SelectProcessDropDown_Cooling_Start;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionProcess']/option[7]")
	WebElement SelectProcessDropDown_Cooling_End;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionProcess']/option[8]")
	WebElement SelectProcessDropDown_Reheating;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionProcess']/option[9]")
	WebElement SelectProcessDropDown_Defrosting_Thawing;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionProcess']/option[10]")
	WebElement SelectProcessDropDown_Acidification;
	
	@FindBy(how=How.XPATH,using="//span[@id='bttnPreoperational']")
	WebElement DoneButton_ProcessCheck;
	
	
	
	
	
	
	
	
	
	//Equipment Check
	//===========================================================================================================
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionCallEquipmentEQUIP2']")
	WebElement SelectEquipment_DropDown;
	
	//for select Area go to Add Food Preparation Area screen
	
	
	//Status
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionStatusEQUIP3']/option[2]")
	WebElement Status_Clean;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionStatusEQUIP3']/option[3]")
	WebElement Status_VisiblyDirty;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionStatusEQUIP3']/option[4]")
	WebElement Status_Calibrated;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionStatusEQUIP3']/option[5]")
	WebElement Status_NotWorking;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionStatusEQUIP3']/option[6]")
	WebElement Status_WorkingProperly;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionStatusEQUIP3']/option[7]")
	WebElement Status_CleanAmpDisinfected;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionStatusEQUIP3']/option[8]")
	WebElement Status_RightTemperature;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionStatusEQUIP3']/option[9]")
	WebElement Status_WrongTemperature;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionStatusEQUIP3']/option[10]")
	WebElement Status_FoodCompromised;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionStatusEQUIP3']/option[11]")
	WebElement Status_PoorStorage;
	@FindBy(how=How.XPATH,using="//select[@id='ddlInspectionStatusEQUIP3']/option[12]")
	WebElement Status_WrongPlacement;
	
	
	
	@FindBy(how=How.XPATH,using="//input[@id='eqpTempratureEQUIP6']")
	WebElement EquipmentCheck_Temperature;
	@FindBy(how=How.XPATH,using="//input[@id='txtTempValuedataanalysisEQUIP4']")
	WebElement EquipmentCheck_Deviation;
	
	
	//action taken drop down
	@FindBy(how=How.XPATH,using="//select[@id='ddlEqupmentActionEQUIP5']/option[2]")
	WebElement ActionTaken_EquipmentScheduledForImmediateCleaningDisinfection;
	@FindBy(how=How.XPATH,using="//select[@id='ddlEqupmentActionEQUIP5']/option[3]")
	WebElement ActionTaken_EquipmentScheduledForMaintenance;
	@FindBy(how=How.XPATH,using="//select[@id='ddlEqupmentActionEQUIP5']/option[4]")
	WebElement ActionTaken_EquipmentScheduledForReplacement;
	@FindBy(how=How.XPATH,using="//select[@id='ddlEqupmentActionEQUIP5']/option[5]")
	WebElement ActionTaken_NoActionTaken;
	
	
	
	@FindBy(how=How.XPATH,using="//span[@id='btnEqipment']")
	WebElement EquipmentCheck_DoneButton;
	
	
	
	
	
	
	
	//========================================================================================================================
	
	public void LeftMenuClick() {
		
		LeftMenuClick.click();
	}
	
	
	public void StartUpDoneButtonClick() {
		DoneButton_StartUp.click();
		
	}
	
	public String searchInspectionEntityinTableGrid(String EntityName) {
		
		search_textField.sendKeys(EntityName);
		//companyUNU_1stRecordTableGrid.click();
		driver.findElement(By.linkText(EntityName)).click();
		return EntityName;
	}
	
	//......................................................
	public void AllFoodhandlersFreeIllnessClick() {
		AllfoodhandlersAreFreeOfAnySymptomsOfFoodborneIllness_checkbox.click();
	}
	
	
	public void AllFoodHandlersHaveCleanUniformsClick() {
		AllFoodHandlersHaveCleanUniforms.click();
	}
	
	
	public void AllFoodHandlersAreWellGroomedAndCleanClick() {
		AllFoodHandlersAreWellGroomedAndClean.click();
	}
	
	public void HandwashingFacilityIsFullyEquipedClick() {
		HandwashingFacilityIsFullyEquiped.click();
	}
	
	
	public void PestActivityReportedClick() {
		PestActivityReported.click();
	}
	
	public void AllFoodAreasAreCleanClick() {
		AllFoodAreasAreClean.click();
	}
	
	
	public void CleaningAndDisinfectionOfPremisesCarriedOutClick() {
		CleaningAndDisinfectionOfPremisesCarriedOut.click();
	}
	
	
	
	public void StartupAdditionforTestingPurposeClick() {
		StartupAdditionforTestingPurpose.click();
	}
	
	
	public String getValueOfControlLimit_Check() {
		 return ControlLimit_Check.getText();
	}
	
	public String enterValueOfControlLimit(String EnterValue) {
		ControlLimit_Check.sendKeys(EnterValue);
		return EnterValue;
	}
	
	public String enterValueInTemperature_Do(String EnterValue) {
		Temperature_Do.sendKeys(EnterValue);
		return EnterValue;
	}
	
	public void FinalValueInTemperature_Do(String EnterFinal) {
		Temperature_Do.sendKeys(EnterFinal);
		
	}
	
	public void DoneButton_ProcessCheckClick() {
		DoneButton_ProcessCheck.click();
		
	}
	
	//Equipment
//==========================================================================================	
	
	
	public void DoneButton_EquipmentCheckClick() {
		EquipmentCheck_DoneButton.click();
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getEquipmentText(String str) {
		
		 return str.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\,", "");
	}
	
	
	
	//Subtraction Method NOT working Do not use this method
public static void SubtractionTwoStrings(WebDriver driver,String firstvalue, String Secondvalue,int putFinalValue) {
	
	
		String value1= firstvalue;
		String value2= Secondvalue;
		
		int Finalvalue=Integer.parseInt(value2)-Integer.parseInt(value1);
		 //driver.findElement(By.xpath(Temperature_Do)).sendKeys("fgdf");
		
	}
	
	
	
	
	
	public void ClickAddAndFinalizeButtonFHpopup() {
		Addbutton.click();	
		FinalizeButton.click();
	}
	
	public void ClickAddandFinalizeButtonFoodAreaPopup() {
		AddButton_FoodArea.click();
		FinalizeButton_AddFoodArea.click();
		
	}
	
	public void ClickOnConfirmYourSelectionButtonPestControl() {
		ConfirmYourSelection_button.click();
	}
	
	
	public void mouseOverInspectionStartUpAndClick() {

		Actions act = new Actions(driver);
		
		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'Self Inspection')]"));
		
		act.moveToElement(web).build().perform();
		List<WebElement> drop_down_List = driver.findElements(By.xpath("//ul[@class='nav navbar-nav mcd-menu']/li[3]/ul/li/a"));
		for (int i = 0; i < drop_down_List.size(); i++) {
			WebElement drpValue = drop_down_List.get(i);
			String drp_down_text = drpValue.getText();
			  Boolean link_Status=drpValue.isEnabled();
			  System.err.println("This is the link status--"+ link_Status);
			 // ReqDrpValue=driver.findElement(By.xpath("//a[contains(text(),'Start up, Temperature & Process Monitoring')]"));
			if (drp_down_text.equalsIgnoreCase("Start up, Temperature & Process Monitoring")) {
				drpValue.click();
				break;
			}
		}
	}
	
	

	
	
	
}
