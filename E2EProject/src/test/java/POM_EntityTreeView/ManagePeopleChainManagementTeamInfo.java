package POM_EntityTreeView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ManagePeopleChainManagementTeamInfo {

	
	public WebDriver driver;

	public ManagePeopleChainManagementTeamInfo(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	
	@FindBy(how=How.XPATH,using="//*[@id='accordion']/div[5]/div/h4")
	WebElement managePeopleMain;
	@FindBy(how=How.XPATH,using="//*[@id='accordion-reference-people']/div/div[3]/div[1]/h4/a")
	WebElement EntityChainManagementTeamInformation_click;
	
	
	//Actions button in the grid.
	
	@FindBy(how=How.XPATH,using="//*[@id='tblNewChainUserAdded']/tbody/tr[1]/td[6]/a[1]")
	WebElement editButton_1st;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewChainUserAdded']/tbody/tr[1]/td[6]/a[2]")
	WebElement cancelButton_1st;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewChainUserAdded']/tbody/tr[2]/td[6]/a[1]")
	WebElement editButton_2st;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewChainUserAdded']/tbody/tr[2]/td[6]/a[2]")
	WebElement cancelButton_2st;
	
	
	
	//Add Chain Management team screen after clicking on button-add chain management team contact.
	
	//Step-1
	//-----------------
	@FindBy(how=How.XPATH,using="//*[@id='btnAddChainMangTeam']")
	WebElement addUserButton_ChainManagement;
	@FindBy(how=How.XPATH,using="//*[@id='FirstName']")
	WebElement FirstName;
	@FindBy(how=How.XPATH,using="//*[@id='MiddleName']")
	WebElement middle_Name;
	@FindBy(how=How.XPATH,using="//*[@id='LastName']")
	WebElement lastName;
	@FindBy(how=How.XPATH,using="//*[@id='AccountEmail']")
	WebElement account_Email;
	@FindBy(how=How.XPATH,using="//*[@id='BirthDay']")
	WebElement birth_Day;
	@FindBy(how=How.XPATH,using="//*[@id='GenderId'][1]")
	WebElement gender_Female;
	@FindBy(how=How.XPATH,using="//*[@id='GenderId'][2]")
	WebElement gender_Male;
	@FindBy(how=How.XPATH,using="//*[@id='EmiratesIdVal']")
	WebElement emiratesID;
	@FindBy(how=How.XPATH,using="//*[@id='CountryCode']")
	WebElement phone_countryCode;
	@FindBy(how=How.XPATH,using="//*[@id='MobilePhone']")
	WebElement phone_phoneNumber ;
	@FindBy(how=How.XPATH,using="//*[@id='input-file-preview']")
	WebElement profilePicUrl_Browse;
	@FindBy(how=How.XPATH,using="//*[@id='IsFakeEmiratesId']")
	WebElement withoutValidEmiratesId_checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='Nationality']")
	WebElement nationality_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='frm-User-Step1']/div[5]/div/input")
	WebElement nextButton_chainManagement;
	
	
	
	//Step-2
	//---------------------------------------
	
	@FindBy(how=How.XPATH,using="//*[@id='PreferredLanguageId']")
	WebElement preferredLanguage;
	@FindBy(how=How.XPATH,using="//*[@id='SecondLanguageId']")
	WebElement secondaryLanguage;
	@FindBy(how=How.XPATH,using="//*[@id='selectLanguage']")
	WebElement preferredLanguage_Select;
	@FindBy(how=How.XPATH,using="//*[@id='writeLanguage']")
	WebElement preferredLanguage_write;
	@FindBy(how=How.XPATH,using="//*[@id='readLanguage']")
	WebElement preferredLanguage_read;
	@FindBy(how=How.XPATH,using="//*[@id='speaksLanguage']")
	WebElement preferredLanguage_speaks;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddLangSkill']")
	WebElement addButton_step2ChainManagement;
	@FindBy(how=How.XPATH,using="//*[@id='btnCreateUser']")
	WebElement doneButton_step2ChainManagement;
	@FindBy(how=How.XPATH,using="//*[@id='btnDoneclose']")
	WebElement doneButton_BottomOfpage4AddingRecord;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
