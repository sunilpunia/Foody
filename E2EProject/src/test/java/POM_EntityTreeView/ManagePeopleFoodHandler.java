package POM_EntityTreeView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import resources.Helper;

public class ManagePeopleFoodHandler {

	
	public WebDriver driver;

	public ManagePeopleFoodHandler(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='accordion']/div[5]/div/h4/a")
	WebElement managePeopleMainFH;
	@FindBy(how=How.XPATH,using="//*[@id='foodHandler_accordionId']/h4/a")
	WebElement foodHandlerInformation;
	
	@FindBy(how=How.XPATH,using="//*[@id='partial_FoodHandlerSection']/div[1]/div[1]/div[3]/a")
	WebElement addFoodHandler_button;
	@FindBy(how=How.XPATH,using="//*[@id='partial_FoodHandlerSection']/div[1]/div[1]/div[2]/a")
	WebElement viewTrainingDetails_button;
	@FindBy(how=How.XPATH,using="//*[@id='partial_FoodHandlerSection']/div[1]/div[1]/div[1]/a")
	WebElement viewFoodHandlerInspectionHistory_button;
	
	@FindBy(how=How.XPATH,using="//input[@type='search']")
	WebElement searchTextField;
	
	
	//ACTION grid
		//============================================
		@FindBy(how=How.XPATH,using="//*[@id='tblNewFoodHandlerAdded']/tbody/tr[1]/td[9]/a[1]")
		WebElement editFoodHandlerButton_1stFH;
		@FindBy(how=How.XPATH,using="//*[@id='tblNewFoodHandlerAdded']/tbody/tr[1]/td[9]/a[2]")
		WebElement cancelFoodHandler_1stFH;
		@FindBy(how=How.XPATH,using="//*[@id='tblNewFoodHandlerAdded']/tbody/tr[1]/td[9]/a[3]")
		WebElement TrainingRequesFoodHandlert_1stFH;
		@FindBy(how=How.XPATH,using="//*[@id='tblNewFoodHandlerAdded']/tbody/tr[2]/td[9]/a[1]")
		WebElement editButtonFoodHandler_2stFH;
		@FindBy(how=How.XPATH,using="//*[@id='tblNewFoodHandlerAdded']/tbody/tr[2]/td[9]/a[2]")
		WebElement cancelFoodHandler_2stFH;
		@FindBy(how=How.XPATH,using="//*[@id='tblNewFoodHandlerAdded']/tbody/tr[2]/td[9]/a[3]")
		WebElement TrainingRequestFoodHandler_2stFH; 
		
		@FindBy(how=How.XPATH,using="//*[@id='tblNewFoodHandlerAdded']/tbody/tr[1]/td[8]")
		WebElement FoodHandler_1stRow_Uniform;
		@FindBy(how=How.XPATH,using="//*[@id='tblNewFoodHandlerAdded']/tbody/tr[1]/td[7]")
		WebElement FoodHandler_1stRow_PersonalHygiene;
		@FindBy(how=How.XPATH,using="//*[@id='tblNewFoodHandlerAdded']/tbody/tr[1]/td[9]")
		WebElement FoodHandler_1stRow_Illness;
		
		//XPath of Request a Training from Action GRID
		//-----------------------------------------------------------
		
		@FindBy(how=How.XPATH,using="//*[@id='ddlFHTrainingCenterForTraining']")
		WebElement selectTrainingCenterFH_dropDown;
		@FindBy(how=How.XPATH,using="//*[@id='txtFHPreferredDateofTraining']")
		WebElement prefferredDateOfTraining_calendar;
		@FindBy(how=How.XPATH,using="//*[@id='selectTrainingCourse1']")
		WebElement selectTrainingCourse_DropDown;
		@FindBy(how=How.XPATH,using="//*[@id='trainingNatureOfWork']")
		WebElement selectNatureOfWorkForTraining_dropDown;
		@FindBy(how=How.XPATH,using="//*[@id='btnFHSendRequestForTraining']")
		WebElement sendRequest_button;
	
	
	
	//Add Food Handler screen in new tab
	@FindBy(how=How.XPATH,using="//*[@id='btnAddChainMangTeam']")
	WebElement addFoodHandlerButton;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddChainMangTeamExisting']")
	WebElement addExistingFoodHandler;
	@FindBy(how=How.XPATH,using="//*[@id='btnDoneclose']")
	WebElement done_Button;
	
	
	//Add existing food Handler screen (using button)
	@FindBy(how=How.XPATH,using="//*[@id='User']")
	WebElement searchUserByEmiratesID;
	
//nature of work all drop down values
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[1]")
	WebElement natureOfWork_Driver;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[2]")
	WebElement natureOfWork_Steward;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[4]")
	WebElement natureOfWork_Chef;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[5]")
	WebElement natureOfWork_Cashier;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[6]")
	WebElement natureOfWork_Delivery;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[7]")
	WebElement natureOfWork_Supervisor;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[8]")
	WebElement natureOfWork_Manager;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[9]")
	WebElement natureOfWork_Not_Specified;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[10]")
	WebElement natureOfWork_Kitchen_Assistant;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[11]")
	WebElement natureOfWork_Store_Keeping;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[12]")
	WebElement natureOfWork_Waiter;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[15]")
	WebElement natureOfWork_PIC;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[16]")
	WebElement natureOfWork_TechnicalExpert;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[17]")
	WebElement natureOfWork_TechnicalContact;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[19]")
	WebElement natureOfWork_grewre;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[20]")
	WebElement natureOfWork_cfdscfd;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[21]")
	WebElement natureOfWork_de2dre2;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[22]")
	WebElement natureOfWork_Acting_CR;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[23]")
	WebElement natureOfWork_Check_In_Check_Out_Clerk;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[24]")
	WebElement natureOfWork_CO2_Plant_Operator;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[25]")
	WebElement natureOfWork_Cooler_Technician;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[26]")
	WebElement natureOfWork_Customer_Representative;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[27]")
	WebElement natureOfWork_Delivery_Truck_Driver;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[28]")
	WebElement natureOfWork_Electrical_Engineer;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[29]")
	WebElement natureOfWork_Electrical_Technician;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[30]")
	WebElement natureOfWork_Electrician_Supervisor;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[31]")
	WebElement natureOfWork_Forklift_Operator;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[32]")
	WebElement natureOfWork_Greaser;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[33]")
	WebElement natureOfWork_Helper;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[34]")
	WebElement natureOfWork_Line_Mechanic;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[35]")
	WebElement natureOfWork_Machine_Operator;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[36]")
	WebElement natureOfWork_Machinist;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[37]")
	WebElement natureOfWork_Maintenance_Team_Leader;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[38]")
	WebElement natureOfWork_Mechanic;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[39]")
	WebElement natureOfWork_Mechanic_Supervisor;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[40]")
	WebElement natureOfWork_Postmix_Technician;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[41]")
	WebElement natureOfWork_Presell_Driver;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[42]")
	WebElement natureOfWork_QC_Chemist;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[43]")
	WebElement natureOfWork_Reliever;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[44]")
	WebElement natureOfWork_Senior_Machine_Operator;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[45]")
	WebElement natureOfWork_Senior_Postmix_Technician;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[46]")
	WebElement natureOfWork_Senior_Syrup_Room_Operator;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[47]")
	WebElement natureOfWork_Senior_Utility_Technician;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[48]")
	WebElement natureOfWork_Senior_Vending_Technician;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[49]")
	WebElement natureOfWork_Senior_Water_Treatment_Operator;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[50]")
	WebElement natureOfWork_Skilled_Reliever;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[51]")
	WebElement natureOfWork_Spare_Parts_Coordinator;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[52]")
	WebElement natureOfWork_Syrup_Room_Operator;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[53]")
	WebElement natureOfWork_Team_Leader_Postmix;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[54]")
	WebElement natureOfWork_Utility_Engineer;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[55]")
	WebElement natureOfWork_Utility_Technician;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[56]")
	WebElement natureOfWork_Waste_Water_Treatment_Operator;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfWork']/option[57]")
	WebElement natureOfWork_Water_Treatment_Operator;
	
	//request training section
	@FindBy(how=How.XPATH,using="//*[@id='rdTrainingTC']")
	WebElement requestTraining_checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='TrainingCenter']")
	WebElement selectTrainingCenter_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='DateOfTraining']")
	WebElement preferredDateOfTraining;
	@FindBy(how=How.XPATH,using="//*[@id='selectTrainingCourse']")
	WebElement selectTrainingCourse_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='trainingNatureOfWork']")
	WebElement selectNatureOfWorkForTraining;
	@FindBy(how=How.XPATH,using="//*[@id='btnCreateUser']")
	WebElement DoneButtonFoodHandler_Existing;
	
	
	
	//Add Food Handler screen coming from add food handler button
	
	//Step-1
	@FindBy(how=How.XPATH,using="//*[@id='FirstName']")
	WebElement FirstName_FH;
	@FindBy(how=How.XPATH,using="//*[@id='MiddleName']")
	WebElement middleName_FH;
	@FindBy(how=How.XPATH,using="//*[@id='LastName']")
	WebElement lastName_FH;
	@FindBy(how=How.XPATH,using="//*[@id='AccountEmail']")
	WebElement accountEmail;
	@FindBy(how=How.XPATH,using="//*[@id='BirthDay']")
	WebElement birthday;
	@FindBy(how=How.XPATH,using="//*[@id='GenderId'][1]")
	WebElement gender_Female;
	@FindBy(how=How.XPATH,using="//*[@id='GenderId'][2]")
	WebElement gender_Male;
	@FindBy(how=How.XPATH,using="//*[@id='EmiratesIdVal']")
	WebElement Emirates_id;
	@FindBy(how=How.XPATH,using="//*[@id='CountryCode']")
	WebElement phone_countryCode;
	@FindBy(how=How.XPATH,using="//*[@id='MobilePhone']")
	WebElement phone_PhoneNumber;
	@FindBy(how=How.XPATH,using="//*[@id='input-file-preview']")
	WebElement profilePicURL_Browse;
	@FindBy(how=How.XPATH,using="//*[@id='IsFakeEmiratesId']")
	WebElement withoutValidEmiratesID_checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='Nationality']")
	WebElement nationality_dropDown;
	
	//Nature of Work drop down xpath is same as above xpath(existing food handler screen)
	
	//Request Training section have same xpath as above(request training section of existing food handler)
	
	@FindBy(how=How.XPATH,using="//*[@id='frm-User-Step1']/div[8]/div/input")
	WebElement Next_button;
	
	
	//Step 2 adding new Food Handler
	
	//Language
	
	@FindBy(how=How.XPATH,using="//*[@id='PreferredLanguageId']")
	WebElement preferred_language;
	@FindBy(how=How.XPATH,using="//*[@id='SecondLanguageId']")
	WebElement second_language;
	@FindBy(how=How.XPATH,using="//*[@id='selectLanguage']")
	WebElement addLanguageskills_select;
	
	@FindBy(how=How.XPATH,using="//*[@id='writeLanguage']")
	WebElement addLanguageSkills_Write;
	@FindBy(how=How.XPATH,using="//*[@id='readLanguage']")
	WebElement addLanguageSkills_Read;
	@FindBy(how=How.XPATH,using="//*[@id='speaksLanguage']")
	WebElement addLanguageSkills_Speaks;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddLangSkillnew']")
	WebElement add_Button;
	@FindBy(how=How.XPATH,using="//*[@id='btnCreateUser']")
	WebElement done_Button_Step2End;
	
	
	
	
	
	
	
	public void ClickManagePeopleAndFoodHandlerTab(WebDriver driver) {
		managePeopleMainFH.click();
		foodHandlerInformation.click();
	}
	
	public void SearchFoodHandlerTable(String nameOfFoodHandler) {
		searchTextField.sendKeys(nameOfFoodHandler);
	}
	
	
	public void GetColorOfUniform() {
		
		FoodHandler_1stRow_Uniform.getAttribute("style");
		
	}
	
	
	//verify Food Handlers Color
	public void VerifyFhUniformColor() {
		
		Helper.CSSColorValue(driver,"//*[@id='tblNewFoodHandlerAdded']/tbody/tr[1]/td[8]","rgba(248, 215, 218, 1)");
	}
	
	
public void VerifyPersonalHygieneColor() {
		
		Helper.CSSColorValue(driver,"//*[@id='tblNewFoodHandlerAdded']/tbody/tr[1]/td[7]","rgba(248, 215, 218, 1)");
	}
	

public void VerifyillnessColor() {
	
	Helper.CSSColorValue(driver,"//*[@id='tblNewFoodHandlerAdded']/tbody/tr[1]/td[9]","rgba(248, 215, 218, 1)");
}
	
	
public void VerifyillnessColor34543543() {
	
	Helper.CSSColorValue(driver,"//*[@id='tblNewFoodHandlerAdded']/tbody/tr[1]/td[9]","rgba(248, 215, 218, 1)");
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
