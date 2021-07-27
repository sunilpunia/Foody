package POM_EntityTreeView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ManagePeopleTechnicalExpert {

	public WebDriver driver;

	public ManagePeopleTechnicalExpert(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	
	@FindBy(how=How.XPATH,using="//*[@id='accordion']/div[5]/div/h4")
	WebElement managePeopleMain;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='accordion-reference-people']/div/div[5]/div[1]/h4/span")
	WebElement addTechnicalExpert_Main;
	@FindBy(how=How.XPATH,using="//*[@id='editTechicalExpert']/div/div[1]/div[3]/a")
	WebElement technicalStatus_button;
	@FindBy(how=How.XPATH,using="//*[@id='editTechicalExpert']/div/div[1]/div[2]/a")
	WebElement AddTechnicalExpert_button;
	@FindBy(how=How.XPATH,using="//*[@id='editTechicalExpert']/div/div[1]/div[1]/a")
	WebElement viewTrainingDetails;
	
	
	
	//actions buttons in the table grid.
	@FindBy(how=How.XPATH,using="//*[@id='tblNewTechnicalExpertUserAdded']/tbody/tr[1]/td[9]/a[1]")
	WebElement EditTechExpert_1stbutton;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewTechnicalExpertUserAdded']/tbody/tr[1]/td[9]/a[2]")
	WebElement cancelTechExpert_1stbutton;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewTechnicalExpertUserAdded']/tbody/tr[1]/td[9]/a[3]")
	WebElement TrainingTechExpert_1stbutton;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewTechnicalExpertUserAdded']/tbody/tr[2]/td[9]/a[1]")
	WebElement EditTechExpert_2ndbutton;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewTechnicalExpertUserAdded']/tbody/tr[2]/td[9]/a[2]")
	WebElement cancelTechExpert_2ndbutton;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewTechnicalExpertUserAdded']/tbody/tr[2]/td[9]/a[3]")
	WebElement TrainingTechExpert_2ndbutton;
	
	
	
	//Technical Status screen coming after clicking on "Technical Status" button
	@FindBy(how=How.XPATH,using="//*[@id='TechnicalUserId']")
	WebElement technicalExpert_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='TechnicalStatus']")
	WebElement status_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='ChangeTechnicalProfileStatus']")
	WebElement approveStatus_button;
	
	
	
	
	
	
	//Request a Training
	@FindBy(how=How.XPATH,using="//*[@id='ddlTETrainingCenterForTraining']")
	WebElement selectTrainingCenter_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='txtTEPreferredDateofTraining']")
	WebElement preferredDateOfTraining_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='selectTrainingCourseTE']")
	WebElement selectTrainingCourse_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='btnTESendRequestForTraining']")
	WebElement sendRequest_button;
	
	
	
	
	//ADD Technical Expert Screen
	@FindBy(how=How.XPATH,using="//*[@id='txtEmiratesId']")
	WebElement searchByEmiratesID;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddChainMangTeamExistingUser']")
	WebElement addUser_button;
	@FindBy(how=How.XPATH,using="//*[@id='tblAddedUser']/tbody/tr[1]/td[2]/input")
	WebElement deleteUser_1stbutton;
	@FindBy(how=How.XPATH,using="//*[@id='tblAddedUser']/tbody/tr[2]/td[2]/input")
	WebElement deleteUser_2ndbutton;
	@FindBy(how=How.XPATH,using="//*[@id='btnDoneclose']")
	WebElement doneButton_AtBottomOfScreen;
	
	
	
	
	//Add Technical Expert Screen from Step1 to 6
	

	//Step-1
	//-------------------------------------------------------
	@FindBy(how=How.XPATH,using="//*[@id='AccountEmailAddress']")
	WebElement accountEmail;
	@FindBy(how=How.XPATH,using="//*[@id='ConfirmEmailAccount']")
	WebElement confirmEmailAccount;
	@FindBy(how=How.XPATH,using="//*[@id='Password']")
	WebElement password;
	@FindBy(how=How.XPATH,using="//*[@id='ConfirmPassword']")
	WebElement confirmPassword;
	@FindBy(how=How.XPATH,using="//*[@id='frm-register-1']/div/div[6]/input")
	WebElement nextButton_step1;
	
	
	
	//Step-2
	//..............................................................
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
	  //..................................................................................
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
	
	
	
	
	//STEP-5
	//.......................................................................
	
	@FindBy(how=How.XPATH,using="//*[@id='SelectTechnicalExpertType']")
	WebElement expertType_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='txtDateofApproval']")
	WebElement dateOfApproval;
	@FindBy(how=How.XPATH,using="//*[@id='txtDateofExpiration']")
	WebElement dateOfExpiration;
	
	
	//Legal Permit References
	@FindBy(how=How.XPATH,using="//*[@id='SelectPermitType']")
	WebElement permitType_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='inputfilePermit']")
	WebElement addDocument_browse;
	@FindBy(how=How.XPATH,using="//*[@id='txtPermitImageDescription']")
	WebElement addImageDescription;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddFoodrelatedPermit']")
	WebElement addbutton;
	
	
	//Degree
	@FindBy(how=How.XPATH,using="//*[@id='SelectDegree']")
	WebElement selectDegree_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='txtDegreeSubject']")
	WebElement subject_degree;
	@FindBy(how=How.XPATH,using="//*[@id='txtDegreeYearOfComplettion']")
	WebElement yearOfCompletion_degree;
	@FindBy(how=How.XPATH,using="//*[@id='txtDegreeUnivercity']")
	WebElement university;
	@FindBy(how=How.XPATH,using="//*[@id='SelectDegreeCountry']")
	WebElement selectCountry;
	@FindBy(how=How.XPATH,using="//*[@id='SelectMajor']")
	WebElement majorDropDown;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddMajors']")
	WebElement addMajorButton;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddDegree']")
	WebElement addDegree;
	
	
	
	//Add Diploma
	
	@FindBy(how=How.XPATH,using="//*[@id='txtdiplomaSubject']")
	WebElement subject_diploma;
	@FindBy(how=How.XPATH,using="//*[@id='txtdiplomaYearOfComplettion']")
	WebElement yearOfCompletion_diploma;
	@FindBy(how=How.XPATH,using="//*[@id='txtdiplomaUnivercity']")
	WebElement university_diploma;
	@FindBy(how=How.XPATH,using="//*[@id='SelectdiplomaCountry']")
	WebElement selectCountry_diploma;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddDiploma']")
	WebElement addButton_diploma;
	
	
	
	
	//Continuous Professional Development Program
	@FindBy(how=How.XPATH,using="//*[@id='SelectuserqualiTechExpertQualiType']")
	WebElement selectQualificationType;
	@FindBy(how=How.XPATH,using="//*[@id='txtuserqualiCourseTitle']")
	WebElement courseTitle;
	@FindBy(how=How.XPATH,using="//*[@id='txtuserqualiNoOfHours']")
	WebElement NoOfHours;
	@FindBy(how=How.XPATH,using="//*[@id='txtuserqualiUnivercity']")
	WebElement publisher;
	@FindBy(how=How.XPATH,using="//*[@id='txtSelectuserqualiTrainingProvider']")
	WebElement trainingProvider;
	@FindBy(how=How.XPATH,using="//*[@id='txtSelectuserqualiCertificationProvider']")
	WebElement certificationProvider; 
	@FindBy(how=How.XPATH,using="//*[@id='txtuserqualiYearOfCompletion']")
	WebElement yearOfCompletion;
	@FindBy(how=How.XPATH,using="//*[@id='btnaddTechExpertQualification']")
	WebElement addButton_ContnProDevProgram;
	
	
	
	//Qualification
	@FindBy(how=How.XPATH,using="//*[@id='txtuserpersonalcertificationtitle']")
	WebElement certificationTitle;
	@FindBy(how=How.XPATH,using="//*[@id='txtSelectusercertificationTrainingProvider']")
	WebElement trainingProvider_qualification;
	@FindBy(how=How.XPATH,using="//*[@id='txtSelectuserCertificationProvider']")
	WebElement certificationProvider_qulification;
	@FindBy(how=How.XPATH,using="//*[@id='txtusercertificationYrOfcompletion']")
	WebElement yearOfCompletion_qualification;
	@FindBy(how=How.XPATH,using="//*[@id='txtUserCertificationValidUntil']")
	WebElement certificationValidUntil;	
	@FindBy(how=How.XPATH,using="//*[@id='btnaddUserPersonalCertification']")
	WebElement addButton_qualification;
	
	
	
	//Add User Experience
	@FindBy(how=How.XPATH,using="//*[@id='txtuserexpOrgnisationname']")
	WebElement organisationName;
	@FindBy(how=How.XPATH,using="//*[@id='SelectuserexperienceIndustryType']")
	WebElement industryType;
	@FindBy(how=How.XPATH,using="//*[@id='SelectuserexperienceRole']")
	WebElement role;
	//Responsibility
	@FindBy(how=How.XPATH,using="//*[@id='SelectuserexperienceResponsibility']/option[1]")
	WebElement Auditing;
	@FindBy(how=How.XPATH,using="//*[@id='SelectuserexperienceResponsibility']/option[2]")
	WebElement Consultancy;
	@FindBy(how=How.XPATH,using="//*[@id='SelectuserexperienceResponsibility']/option[3]")
	WebElement LaboratoryandTesting;
	@FindBy(how=How.XPATH,using="//*[@id='SelectuserexperienceResponsibility']/option[4]")
	WebElement Other;
	@FindBy(how=How.XPATH,using="//*[@id='SelectuserexperienceResponsibility']/option[5]")
	WebElement Production;
	@FindBy(how=How.XPATH,using="//*[@id='SelectuserexperienceResponsibility']/option[6]")
	WebElement QualityAssurance;
	@FindBy(how=How.XPATH,using="//*[@id='SelectuserexperienceResponsibility']/option[7]")
	WebElement RegulatoryInspection;
	@FindBy(how=How.XPATH,using="//*[@id='SelectuserexperienceResponsibility']/option[8]")
	WebElement Training;
	//------------------------------------------------------
	@FindBy(how=How.XPATH,using="//*[@id='txtuserexperienceNoOfYears']")
	WebElement noOfYears;
	@FindBy(how=How.XPATH,using="//*[@id='txtuserExperienceFrom']")
	WebElement fromDate;
	@FindBy(how=How.XPATH,using="//*[@id='txtuserExperienceTo']")
	WebElement toDate;
	@FindBy(how=How.XPATH,using="//*[@id='btnaddUserExperience']")
	WebElement addButton_addUserExperience;
	
	
	
	//Add food Process Familarity
	//...............................................................
	
	@FindBy(how=How.XPATH,using="//*[@id='SelectFoodprocessType']")
	WebElement foodProcessType;
	@FindBy(how=How.XPATH,using="//*[@id='SelectFoodProcessFamilarity']")
	WebElement competence_Food;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddUserFoodProcessFamilarity']")
	WebElement addButton_AddFoodProcessFamilarity;
	
	
	
	//Add Cuisine Process Familarity
	@FindBy(how=How.XPATH,using="//*[@id='SelectCuisineprocessType']")
	WebElement cuisineProcessType;
	@FindBy(how=How.XPATH,using="//*[@id='SelectCuisineProcessFamilarity']")
	WebElement competence_cuisine;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddUserCuisineFamilarity']")
	WebElement addButton_cuisine;
	
	
	
	
	//Add Images
	//...........................................
	@FindBy(how=How.XPATH,using="//*[@id='UploadTechnicalExpertImages']")
	WebElement uploadImages_browse;
	@FindBy(how=How.XPATH,using="//*[@id='txtImageDescription']")
	WebElement imageDescription;
	@FindBy(how=How.XPATH,using="//*[@id='btnImageUpload']")
	WebElement uploadImages;
	
	
	
	
	
	//Add User Technical Expert Audio
	//..............................................................
	@FindBy(how=How.XPATH,using="//*[@id='TechnicalExpertuploadaudio']")
	WebElement uploadAudio_chooseFile;
	@FindBy(how=How.XPATH,using="//*[@id='txtAudioDescription']")
	WebElement audioDescription;
	@FindBy(how=How.XPATH,using="//*[@id='btnAudioUpload']")
	WebElement uploadAudio;
	
	
	
	
	//Technical Expert Profile and Training Request
	//.................................................................................
	
	@FindBy(how=How.XPATH,using="//*[@id='rdTrainingTE']")
	WebElement requestTraing_checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='selectTrainingCenter']")
	WebElement selectTrainingCenterDropDown;
	@FindBy(how=How.XPATH,using="//*[@id='trainingStartDate']")
	WebElement preferredDateOfTraining;
	@FindBy(how=How.XPATH,using="//*[@id='selectTrainingCourse']")
	WebElement selectTrainingCourseDropDown;
	
		
	@FindBy(how=How.XPATH,using="//*[@id='btnNext-5-TechExpertProfile']")
	WebElement AddUserButton_step5;
	
	
	
	//Step-6 Admin Settings
	//............................................................................................
	@FindBy(how=How.XPATH,using="//*[@id='RoleId']")
	WebElement userRoles_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='MandatoryAtDMpremises']")
	WebElement mandatoryAtDMPremises_checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='Active']")
	WebElement IsActive_checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='btnRegister']")
	WebElement RegisterButton;
	
	
	
	

	
	
	
	
	
	
	
	
}
