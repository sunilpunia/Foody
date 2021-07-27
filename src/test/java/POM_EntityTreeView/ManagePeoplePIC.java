package POM_EntityTreeView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ManagePeoplePIC {

	
	public WebDriver driver;

	public ManagePeoplePIC(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='accordion']/div[5]/div/h4")
	WebElement managePeopleMainP;
	@FindBy(how=How.XPATH,using="//*[@id='pic_accordionId']/h4")
	WebElement picUserInformation;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='partial_PICSection']/div[1]/div[1]/div[2]/a")
	WebElement addPICUserButton;
	@FindBy(how=How.XPATH,using="//*[@id='partial_PICSection']/div[1]/div[1]/div[1]/a")
	WebElement viewTrainingDetailsButton;
	
	
	
	
	
	
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='tblNewPICAdded']/tbody/tr[1]/td[7]/a[2]")
	WebElement cancelButton_1st;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewPICAdded']/tbody/tr[2]/td[7]/a[2]")
	WebElement cancelButton_2nd;
	
	//Sending Training request from PIC
	@FindBy(how=How.XPATH,using="//*[@id='tblNewPICAdded']/tbody/tr[1]/td[7]/a[3]")
	WebElement trainingRequestIcon_1st;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewPICAdded']/tbody/tr[2]/td[7]/a[3]")
	WebElement trainingRequestIcon_2nd;
	@FindBy(how=How.XPATH,using="//*[@id='ddlTrainingCenterForTraining']")
	WebElement selectTrainingCenterDropDown;
	@FindBy(how=How.XPATH,using="//*[@id='txtPreferredDateofTraining']")
	WebElement prefferedDAteOfTraining;
	@FindBy(how=How.XPATH,using="//*[@id='selectTrainingCourse']")
	WebElement selectTrainingCourse;
	@FindBy(how=How.XPATH,using="//*[@id='btnSendRequestForTraining']")
	WebElement sendRequest;
	@FindBy(how=How.XPATH,using="//*[@id='popDiv1']/div/div/div/button")
	WebElement popupCloseButton;
	
	
	
	
	
	
	
	//Add PIC User screen in new tab
	//..................................................................
	@FindBy(how=How.XPATH,using="//*[@id='txtEmiratesId']")
	WebElement EmiratesId_searchField;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddChainMangTeamExistingUser']")
	WebElement addExistingPICuser_button;
	@FindBy(how=How.XPATH,using="//*[@id='tblAddedUser']/tbody/tr[1]/td[2]/input")
	WebElement deleteButton_1st;
	@FindBy(how=How.XPATH,using="//*[@id='tblAddedUser']/tbody/tr[2]/td[2]/input")
	WebElement deleteButton_2st;
	@FindBy(how=How.XPATH,using="//*[@id='tblAddedUser']/tbody/tr[3]/td[2]/input")
	WebElement deleteButton_3st;
	@FindBy(how=How.XPATH,using="//*[@id='btnDoneclose']")
	WebElement doneButton_AddPIC;
	
	@FindBy(how=How.XPATH,using="//*[@id='btnAddChainMangTeam']")
	WebElement addNewPICuser_button;
	
	//step-1
	@FindBy(how=How.XPATH,using="//*[@id='AccountEmailAddress']")
	WebElement account_email;
	@FindBy(how=How.XPATH,using="//*[@id='ConfirmEmailAccount']")
	WebElement confirmEmail_account;
	@FindBy(how=How.XPATH,using="//*[@id='Password']")
	WebElement Password;
	@FindBy(how=How.XPATH,using="//*[@id='ConfirmPassword']")
	WebElement confirm_password;
	@FindBy(how=How.XPATH,using="//*[@id='frm-register-1']/div/div[6]/input")
	WebElement next_button;
	
	//step-2
	@FindBy(how=How.XPATH,using="//*[@id='FirstName']")
	WebElement first_name;
	@FindBy(how=How.XPATH,using="//*[@id='MiddleName']")
	WebElement middle_name;
	@FindBy(how=How.XPATH,using="//*[@id='LastName']")
	WebElement last_name;
	@FindBy(how=How.XPATH,using="//*[@id='BirthDay']")
	WebElement birth_day;
	@FindBy(how=How.XPATH,using="//*[@id='EmiratesIdVal']")
	WebElement emirates_id;
	@FindBy(how=How.XPATH,using="//*[@id='EmiratesIdUrl']")
	WebElement uploadAcopyOfEmiratesID_upload;
	@FindBy(how=How.XPATH,using="//*[@id='IsFakeEmiratesId']")
	WebElement emiratesID_checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='frm-register-2']/div/div[6]/div/span[1]")
	WebElement gender_female;
	@FindBy(how=How.XPATH,using="//*[@id='frm-register-2']/div/div[6]/div/span[2]")
	WebElement gender_male;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='CountryCode']")
	WebElement phone_countryCode;
	@FindBy(how=How.XPATH,using="//*[@id='MobilePhone']")
	WebElement phone_phoneNumber;
	@FindBy(how=How.XPATH,using="//*[@id='input-file-preview']")
	WebElement profilePICurl_browse;
	@FindBy(how=How.XPATH,using="//*[@id='Nationality']")
	WebElement nationality_dropDown_step2;
	@FindBy(how=How.XPATH,using="//*[@id='frm-register-2']/div/div[10]/input")
	WebElement nextbutton_step2;
	
	
	//Step -3 add pic
	@FindBy(how=How.XPATH,using="//*[@id='PreferredLanguageId']")
	WebElement preferred_language;
	@FindBy(how=How.XPATH,using="//*[@id='SecondLanguageId']")
	WebElement secondary_language;
	@FindBy(how=How.XPATH,using="//*[@id='selectLanguage']")
	WebElement addLanguageSkills_select;
	@FindBy(how=How.XPATH,using="//*[@id='writeLanguage']")
	WebElement language_write;
	@FindBy(how=How.XPATH,using="//*[@id='readLanguage']")
	WebElement language_read;
	@FindBy(how=How.XPATH,using="//*[@id='speaksLanguage']")
	WebElement language_speaks;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddLangSkill']")
	WebElement add_button_step3;
	@FindBy(how=How.XPATH,using="//*[@id='btnNext-3']")
	WebElement nextButton_step3;
	
	//step-4 
	@FindBy(how=How.XPATH,using="//*[@id='LinkedCompany']")
	WebElement companyLicenseNr_IntDrpDown;
	@FindBy(how=How.XPATH,using="//*[@id='txtsearchByNameOrLicense']")
	WebElement searchSubEntitybyNameOrLicenseNo;
	@FindBy(how=How.XPATH,using="//*[@id='btnSearchSubEntity']")
	WebElement searchButton_step4;
	@FindBy(how=How.XPATH,using="//*[@id='btnNext-4']")
	WebElement nextButton_step4;
	
	//step-6                                                                  Step-5 do not have any value so in future we need to change xpath
	@FindBy(how=How.XPATH,using="//*[@id='RoleId']")
	WebElement userRoles_step6;
	@FindBy(how=How.XPATH,using="//*[@id='MandatoryAtDMpremises']")
	WebElement MandatoryAtDMpremises_checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='Active']")
	WebElement isActive_checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='btnRegister']")
	WebElement register_step6;

	
	//Edit screen in the PIC grid
	@FindBy(how=How.XPATH,using="//*[@id='RoleId']")
	WebElement userRolesdropDown; 
	@FindBy(how=How.XPATH,using="//*[@id='UserTypeId']")
	WebElement registerAsdropDown;
	@FindBy(how=How.XPATH,using="//*[@id='MandatoryAtDMpremises']")
	WebElement mandatoryAtDMPremises_Checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='Active'][1]")
	WebElement active_Checkbox;
	
	@FindBy(how=How.XPATH,using="//*[@id='ADname']")
	WebElement AD_Name;
	@FindBy(how=How.XPATH,using="//*[@id='FirstName']")
	WebElement First_Name;
	@FindBy(how=How.XPATH,using="//*[@id='MiddleName']")
	WebElement Middle_Name;
	@FindBy(how=How.XPATH,using="//*[@id='LastName']")
	WebElement Last_Name;
	@FindBy(how=How.XPATH,using="//*[@id='reset-password']")
	WebElement clickHereToReset_Password;
	@FindBy(how=How.XPATH,using="//*[@id='GenderId'][1]")
	WebElement genderRadioButton_Female;
	@FindBy(how=How.XPATH,using="//*[@id='GenderId'][2]")
	WebElement genderRadioButton_Male;
	
	@FindBy(how=How.XPATH,using="//*[@id='BirthDay']")
	WebElement birthday_Calendar;
	@FindBy(how=How.XPATH,using="//*[@id='MobilePhone']")
	WebElement phone_Number;
	@FindBy(how=How.XPATH,using="//*[@id='EmiratesIdVal']")
	WebElement Emirates_ID;
	@FindBy(how=How.XPATH,using="//*[@id='LandLine']")
	WebElement land_Line;
	@FindBy(how=How.XPATH,using="//*[@id='AccountEmail']")
	WebElement Account_Email;
	@FindBy(how=How.XPATH,using="//*[@id='Nationality']")
	WebElement nationality_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='PreferredLanguageId']")
	WebElement preferred_Language;
	@FindBy(how=How.XPATH,using="//*[@id='SecondLanguageId']")
	WebElement secondary_Language;
	
	//add language skills
	@FindBy(how=How.XPATH,using="//*[@id='selectLanguage']")
	WebElement select_LanguageDropDown;
	@FindBy(how=How.XPATH,using="//*[@id='writeLanguage']")
	WebElement write_language;
	@FindBy(how=How.XPATH,using="//*[@id='readLanguage']")
	WebElement read_language;
	@FindBy(how=How.XPATH,using="//*[@id='speaksLanguage']")
	WebElement speak_language;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddLangSkill']")
	WebElement add_button;
	@FindBy(how=How.XPATH,using="//*[@id='submit_btn']")
	WebElement submit_button;
	@FindBy(how=How.XPATH,using="//*[@class='col-md-12 col'][2]/div/button[1]")
	WebElement save_button;
	@FindBy(how=How.XPATH,using="//*[@class='col-md-12 col'][2]/div/button[2]")
	WebElement cancel_button;
	@FindBy(how=How.XPATH,using="//*[@id='tblLangSkillList']/tbody/tr[1]/td[7]/a")
	WebElement actionsDelete_1stButton;
	@FindBy(how=How.XPATH,using="//*[@id='tblLangSkillList']/tbody/tr[2]/td[7]/a")
	WebElement actionsDelete_2stButton;
	

		
	
	
	
}
