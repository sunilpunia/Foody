package POM_EntityTreeView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ManagePeopleTechnicalContact {

	
	
	public WebDriver driver;

	public ManagePeopleTechnicalContact(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='accordion']/div[5]/div/h4")
	WebElement managePeopleMain;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='accordion-reference-people']/div/div[4]/div[1]/h4/span")
	WebElement entity_addTechnicalContact_Main;
	@FindBy(how=How.XPATH,using="//*[@id='editTechicalContact']/div/div[1]/div[2]/a")
	WebElement addTechnicalContact_button;
	@FindBy(how=How.XPATH,using="//*[@id='editTechicalContact']/div/div[1]/div[1]/a")
	WebElement viewTrainingDetails_button;
	
	
	//actions grid 
	//--------------------------
	@FindBy(how=How.XPATH,using="//*[@id='tblNewTechnicalUserAdded']/tbody/tr[1]/td[6]/a[1]")
	WebElement editTechContact_1st;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewTechnicalUserAdded']/tbody/tr[1]/td[6]/a[2]")
	WebElement cancelTechContact_1st;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewTechnicalUserAdded']/tbody/tr[1]/td[6]/a[3]")
	WebElement trainingTechContact_1st;

	@FindBy(how=How.XPATH,using="//*[@id='tblNewTechnicalUserAdded']/tbody/tr[2]/td[6]/a[1]")
	WebElement editTechContact_2st;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewTechnicalUserAdded']/tbody/tr[2]/td[6]/a[2]")
	WebElement cancelTechContact_2st;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewTechnicalUserAdded']/tbody/tr[2]/td[6]/a[3]")
	WebElement trainingTechContact_2st;
	
	
	//Request a training 
	//----------------------------
	@FindBy(how=How.XPATH,using="//*[@id='ddlTCTrainingCenterForTraining']")
	WebElement selectTrainingCenterDropDown_TechContact;
	@FindBy(how=How.XPATH,using="//*[@id='txtTCPreferredDateofTraining']")
	WebElement preferredDateOfTrainingCalendar_TechContact;
	@FindBy(how=How.XPATH,using="//*[@id='selectTrainingCourseTC']")
	WebElement selectTrainingCourseDropDown_TechContact;
	@FindBy(how=How.XPATH,using="//*[@id='btnTCSendRequestForTraining']")
	WebElement sendRequestButton_TechContact;
	
	
	
	
	
	
	
	
	//Add Technical Contact screen
	//------------------------------------------
	
	@FindBy(how=How.XPATH,using="//*[@id='btnAddChainMangTeam']")
	WebElement AddUser_AddTechnicalContact;
	@FindBy(how=How.XPATH,using="//*[@id='txtEmiratesId']")
	WebElement searchByEmiratesID;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddChainMangTeamExistingUser']")
	WebElement addUserButton_NearSearchEmiratesID;
	@FindBy(how=How.XPATH,using="//*[@id='tblAddedUser']/tbody/tr[1]/td[2]")
	WebElement deleteButton_1st;
	@FindBy(how=How.XPATH,using="//*[@id='tblAddedUser']/tbody/tr[2]/td[2]")
	WebElement deleteButton_2st;
	@FindBy(how=How.XPATH,using="//*[@id='btnDoneclose']")
	WebElement doneButton_AtLastOfTechContact;
	
	
	
	//Add Technical Contact screen from Step 1 to 6
	//=====================================================
	
	
	//step-1
	@FindBy(how=How.XPATH,using="//*[@id='AccountEmailAddress']")
	WebElement accountEmail;
	@FindBy(how=How.XPATH,using="//*[@id='ConfirmEmailAccount']")
	WebElement confirmEmailAccount;
	@FindBy(how=How.XPATH,using="//*[@id='Password']")
	WebElement password;
	@FindBy(how=How.XPATH,using="//*[@id='ConfirmPassword']")
	WebElement confirm_Password;
	@FindBy(how=How.XPATH,using="//*[@id='frm-register-1']/div/div[6]/input")
	WebElement nextButton_step1;
	
	//step-2
	@FindBy(how=How.XPATH,using="//*[@id='FirstName']")
	WebElement firstName;
	@FindBy(how=How.XPATH,using="//*[@id='MiddleName']")
	WebElement middleName;
	@FindBy(how=How.XPATH,using="//*[@id='LastName']")
	WebElement lastName;
	@FindBy(how=How.XPATH,using="//*[@id='BirthDay']")
	WebElement birthDay;
	@FindBy(how=How.XPATH,using="//*[@id='EmiratesIdVal']")
	WebElement emirates;
	@FindBy(how=How.XPATH,using="//*[@id='EmiratesIdUrl']")
	WebElement uploadACopyOfEmiratesIdBrowse;
	@FindBy(how=How.XPATH,using="//*[@id='IsFakeEmiratesId']")
	WebElement WithoutEmiratesID_checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='frm-register-2']/div/div[6]/div/span[1]/input")
	WebElement gender_Female;
	@FindBy(how=How.XPATH,using="//*[@id='frm-register-2']/div/div[6]/div/span[2]/input")
	WebElement gender_Male;
	@FindBy(how=How.XPATH,using="//*[@id='CountryCode']")
	WebElement phone_countryCode;
	@FindBy(how=How.XPATH,using="//*[@id='MobilePhone']")
	WebElement phone_phoneNumber;
	@FindBy(how=How.XPATH,using="//*[@id='input-file-preview']")
	WebElement profilePicUrl_Browse;
	@FindBy(how=How.XPATH,using="//*[@id='Nationality']")
	WebElement nationality_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='frm-register-2']/div/div[10]/input")
	WebElement nextButton_step2;
	
	//step-3
	@FindBy(how=How.XPATH,using="//*[@id='PreferredLanguageId']")
	WebElement preferred_Language;
	@FindBy(how=How.XPATH,using="//*[@id='SecondLanguageId']")
	WebElement secondary_Language;
	@FindBy(how=How.XPATH,using="//*[@id='selectLanguage']")
	WebElement addLanguageSkills_select;
	@FindBy(how=How.XPATH,using="//*[@id='writeLanguage']")
	WebElement language_write;
	@FindBy(how=How.XPATH,using="//*[@id='readLanguage']")
	WebElement language_read;
	@FindBy(how=How.XPATH,using="//*[@id='speaksLanguage']")
	WebElement language_speaks;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddLangSkill']")
	WebElement addButton;
	@FindBy(how=How.XPATH,using="//*[@id='btnNext-3']")
	WebElement nextButton_step3;
	
	
	
	
	//Step-4
	//------------------------------------------------
	
	@FindBy(how=How.XPATH,using="//*[@id='LinkedCompany']")
	WebElement company_LicenseNo;
	@FindBy(how=How.XPATH,using="//*[@id='txtsearchByNameOrLicense']")
	WebElement search_subEntityByNameOrLicenseNo;
	@FindBy(how=How.XPATH,using="//*[@id='btnSearchSubEntity']")
	WebElement searchButton_step4;
	@FindBy(how=How.XPATH,using="//*[@id='btnNext-4']")
	WebElement nextButton_step4;
	
	
	//Step-5
    //------------------------------------------------
	
	@FindBy(how=How.XPATH,using="//*[@id='designation']")
	WebElement designationDropDown;
	@FindBy(how=How.XPATH,using="//*[@id='btnaddDMApproveLetter']")
	WebElement AddDMapprovalLetter_upload;
	@FindBy(how=How.XPATH,using="//*[@id='dmApprovalStartDate']")
	WebElement StartDate;
	@FindBy(how=How.XPATH,using="//*[@id='dmApprovalStopdate']")
	WebElement EndDate;
	
	
	//training section
	@FindBy(how=How.XPATH,using="//*[@id='rdTrainingTC']")
	WebElement requestTraining_checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='selectTrainingCenter']")
	WebElement selectTrainingCenter;
	@FindBy(how=How.XPATH,using="//*[@id='trainingStartDate']")
	WebElement preferredDateOfTraining;
	@FindBy(how=How.XPATH,using="//*[@id='selectTrainingCourse']")
	WebElement selectTrainingCourse;
	@FindBy(how=How.XPATH,using="//*[@id='trainingConfirmDate']")
	WebElement confirmedDateOfTraining;
	
	@FindBy(how=How.XPATH,using="//*[@id='btnNext-5-TechProfile']")
	WebElement addUser_button;
	
	
	
	
	
	//Step-6
	//------------------------------------------------------------------------------
	@FindBy(how=How.XPATH,using="//*[@id='RoleId']")
	WebElement userRolesDropDown;
	@FindBy(how=How.XPATH,using="//*[@id='MandatoryAtDMpremises']")
	WebElement mandatoryAtDMpremises;
	@FindBy(how=How.XPATH,using="//*[@id='Active']")
	WebElement IsActive_checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='btnRegister']")
	WebElement register_button;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
