package POM_PermitManagement_TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import LeftMenu.LeftMenu;
import POM_EntityTreeView.GeneralInformation;
import POM_EntityTreeView.entityTreeView;
import POM_EntityTreeView.smartServices;
import POM_Login.loginScreen;
import POM_MyEntities.SearchOnEstablishNameAndLicenseNumber;
import POM_PermitManagement.SmartPermits_Requested;
import POM_SelfInspection.StartUpTempAndProcessMonitoring;
import resources.ExcelDataConfig;
import resources.Helper;
import resources.base;
import resources.manageConfigProperties;
import utility.Calender;

public class PermitManagementTestCases extends base {
	public ExcelDataConfig excel;
	//public WebDriver driver;
	
	@BeforeSuite
	public void setUpSuite() {
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
	}
	
	
	 // @Test(description="SmartPermit PermitType Approval of Internal Training Centre/Consultancy ApprovePermit PositiveCase")
	public void SmartPermit_PermitType_ApprovalOfInternalTrainingCentreConsultancy_ApprovePermit_PositiveCase_01(){

		loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
		LeftMenuObject.leftMenuClick();	
	SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
	SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
	
	String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
	
	SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
	
	//extra work start
	String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
	String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
	String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
	System.err.println(EntityName_withLicenseNo);
	//extra work end
	
	Helper.ClickUsingLinkText(driver, EntityName);
	entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
	entityTreeViewObject.ClickOnEntityTreeView();
	Helper.pause(3);
	GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
	GeneralInformationObject.ClickOnGeneralInformationTab();
	Helper.pause(1);
	smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
	smartServicesObject.smartServiceClick();
	smartServicesObject.smartPermitClick();
	smartServicesObject.approvalAndPermitsButtonClick();
	String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "Approval Of Internal Training Centre/Consultancy");
	Helper.pause(1);
	Helper.allDropDownValueOfSelectDropDown(driver,"TechUserId", 1);
	Helper.pause(1);
	smartServicesObject.sendRequestButtonInternalTrainingClick();
	Helper.pause(1);
	
	//this is only for test case-1
	String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
	System.err.println("Newly added record is present in Table grid");
	Helper.pause(1);
	Helper.scrollDownPage(driver, 0, 400);
	Helper.pause(1);
	String completeXpath=smartServicesObject.cancelButtonPermitTableGridClick(xpathPrint,"//following::td[4]/a");
	Helper.pause(1);
	Helper.acceptAlert(driver);
	Helper.pause(1);
	Helper.acceptAlert(driver);
	Helper.pause(1);
	Helper.scrollDownPage(driver, 0, 400);
	Helper.verifyDeletedItemNOTpresentInTableGrid(driver,completeXpath);  //this method is very slow taking a lot of time to execute.
	
	//----------------------------------end this is only for test case-1
	Helper.pause(1);
	smartServicesObject.approvalAndPermitsButtonClick();
	Helper.pause(1);
	Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", Permit_Name);
	Helper.pause(1);
	Helper.allDropDownValueOfSelectDropDown(driver,"TechUserId", 1);
	//Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
	Helper.pause(1);
	smartServicesObject.sendRequestButtonInternalTrainingClick();
	Helper.pause(1);
	xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
	System.err.println("Newly added record is present in Table grid");
	Helper.scrollTillElement(driver,"//*[text()='Logout']");
	loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
	loginScreenoObject.loginLinkTopRight();
		
	excel = new ExcelDataConfig(
			"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
	config = new manageConfigProperties();
	Helper.pause(2);
	logpge = PageFactory.initElements(driver, loginScreen.class);
	logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
	Helper.pause(2);
	LeftMenuObject.leftMenuClick();	
	SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
	SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

	SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
	
	Helper.pause(2);
	String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
	SmartPermitsRequestedObject.searchPermit(Permit_Name);
	Helper.pause(2);
	String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
	System.err.println("Permit request is coming successfully to Permit Officer");
	Helper.pause(2);
	SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
	Helper.getWindowTitle(driver);
	String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Approved");
	
	String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "B");
	Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "Low");
	Helper.scrollDownPage(driver, 0, 400);
	Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Approved by Inspection team");
	SmartPermitsRequestedObject.clickOnApprovePermitButton();
	Helper.pause(2);
	Helper.acceptAlert(driver);
	Helper.pause(2);
	
	//--Start verify that after approval smart permit has been removed from Requested section
	SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
	Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
	SmartPermitsRequestedObject.searchPermit(Permit_Name);
	Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
	// --End
	
	
	//--Start -verify newly approved smart permit is displaying under approved section
	Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
	//checking status of permit changes from requested to approved.
	Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,"Approved");
	System.err.println("After approval status of the Permit changes to Approved and is present under Approved section");
	//--End --
	Helper.pause(2);
	Helper.scrollTillElement(driver,"//*[text()='Logout']");
	
	loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
	loginScreenoObject.loginLinkTopRight();
		
	excel = new ExcelDataConfig(
			"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
	config = new manageConfigProperties();
	Helper.pause(2);
	logpge = PageFactory.initElements(driver, loginScreen.class);
	logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
	Helper.pause(1);
	LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
	LeftMenuObject.leftMenuClick();	
	SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
	SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
	SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
	SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
	Helper.ClickUsingLinkText(driver, EntityName);
	entityTreeViewObject.ClickOnEntityTreeView();
	Helper.pause(3);
	GeneralInformationObject.ClickOnGeneralInformationTab();
	Helper.pause(1);
	smartServicesObject.smartServiceClick();
	smartServicesObject.smartPermitClick();
	Helper.pause(2);
	Helper.scrollDownPage(driver, 0, 300);
	Helper.pause(1);
	Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);
	System.err.println("Permit approved successfully and displaying under Entity view Smart Permits");
	}	
	
	  
	  
	
	
	
	
	
	
	
	         // @Test(description="SmartPermit_PermitType_Approval of External Training Centre/Consultancy_ApprovePermit_PositiveCase_02")
		public void SmartPermitPermitTypeApprovalOfExternalTrainingCentreConsultancyApprovePermitPositiveCase_02(){

			loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
			logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
			LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
			LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		
		String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
		
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		
		//extra work start
		String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
		String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
		String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
		System.err.println(EntityName_withLicenseNo);
		//extra work end
		
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(3);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		smartServicesObject.approvalAndPermitsButtonClick();
		String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "Approval Of External Training Centre/Consultancy");
		Helper.pause(1);
		Helper.allDropDownValueOfSelectDropDown(driver,"TechUserId", 1);
		Helper.pause(1);
		smartServicesObject.sendRequestButtonInternalTrainingClick();
		Helper.pause(1);
		
		
		String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		Helper.pause(1);
		xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		System.err.println("Newly added record is present in Table grid");
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
		Helper.pause(2);
		LeftMenuObject.leftMenuClick();	
		SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
		SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		
		Helper.pause(2);
		String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.pause(2);
		String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
		System.err.println("Permit request is coming successfully to Permit Officer");
		Helper.pause(2);
		SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
		Helper.getWindowTitle(driver);
		String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Approved");
		
		String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "B");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "Low");
		Helper.scrollDownPage(driver, 0, 400);
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Approved by Inspection team");
		SmartPermitsRequestedObject.clickOnApprovePermitButton();
		Helper.pause(1);
		Helper.acceptAlert(driver);
		Helper.pause(1);
		
		//--Start verify that after approval smart permit has been removed from Requested section
		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
		// --End
		
		
		//--Start -verify newly approved smart permit is displaying under approved section
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
		//checking status of permit changes from requested to approved.
		Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,"Approved");
		System.err.println("After approval status of the Permit changes to Approved and is present under Approved section");
		//--End --
		Helper.pause(2);
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		Helper.pause(1);
		LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
		LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(2);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		Helper.pause(2);
		Helper.scrollDownPage(driver, 0, 300);
		Helper.pause(1);
		Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);
		System.err.println("Permit approved successfully and displaying under Entity view Smart Permits");
		}	
	
		
		
		           // @Test(description="SmartPermit PermitType Approval of Food Safety Trainer Internal ApprovePermit PositiveCase ")
				public void SmartPermitPermitTypeApprovalOfFoodSafetyTrainerInternalApprovePermitPositiveCase_03(){

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
					LeftMenuObject.leftMenuClick();	
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
				
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				
				//extra work start
				String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
				String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
				String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
				System.err.println(EntityName_withLicenseNo);
				//extra work end
				
				Helper.ClickUsingLinkText(driver, EntityName);
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
				smartServicesObject.smartServiceClick();
				smartServicesObject.smartPermitClick();
				smartServicesObject.approvalAndPermitsButtonClick();
				String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "Approval of Food Safety Trainer - Internal");
				Helper.pause(2);
				Helper.allDropDownValueOfSelectDropDown(driver,"TechUserId", 1);
				Helper.pause(2);
				Helper.allDropDownValueOfSelectDropDown(driver,"ddlTypeOfApproval", 1);
				Helper.pause(2);
				Helper.allDropDownValueOfSelectDropDown(driver,"ddlLegalPermits", 1);
				smartServicesObject.clickAddButtonFoodSafetyTrainerInternal();
				smartServicesObject.sendRequestButtonInternalTrainingClick();
				Helper.pause(2);
				
				
				String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
				Helper.pause(2);
				xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
				System.err.println("Newly added record is present in Table grid");
				Helper.scrollTillElement(driver,"//*[text()='Logout']");
				
				loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
				loginScreenoObject.loginLinkTopRight();
					
				excel = new ExcelDataConfig(
						"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
				config = new manageConfigProperties();
				Helper.pause(2);
				logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
				Helper.pause(2);
				LeftMenuObject.leftMenuClick();	
				SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
				SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

				SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
				
				Helper.pause(2);
				String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
				SmartPermitsRequestedObject.searchPermit(Permit_Name);
				Helper.pause(2);
				String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
				System.err.println("Permit request is coming successfully to Permit Officer");
				Helper.pause(2);
				SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
				Helper.getWindowTitle(driver);			
				String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Approved");
				String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "A");
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "Low");
				
				//--Start -only for food safety permit-internal
				SmartPermitsRequestedObject.clickOnPermitListButton();
				Helper.pause(2);
				SmartPermitsRequestedObject.clickOnPopUpOfPermitListDoneButton();
				Helper.pause(2);
				// --End
				Helper.scrollDownPage(driver, 0, 400);
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Approved by Inspection team");
				Helper.pause(2);
				SmartPermitsRequestedObject.clickOnApprovePermitButton();
				Helper.pause(3);
				Helper.acceptAlert(driver);
				Helper.pause(3);
				
				//--Start verify that after approval smart permit has been removed from Requested section
				SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
				SmartPermitsRequestedObject.searchPermit(Permit_Name);
				Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
				// --End
				
				
				//--Start -verify newly approved smart permit is displaying under approved section
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
				//checking status of permit changes from requested to approved.
				Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,"Approved");
				System.err.println("After approval status of the Permit changes to Approved and is present under Approved section");
				//--End --
				Helper.pause(2);
				Helper.scrollTillElement(driver,"//*[text()='Logout']");
				
				loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
				loginScreenoObject.loginLinkTopRight();
					
				excel = new ExcelDataConfig(
						"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
				config = new manageConfigProperties();
				Helper.pause(2);
				logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				Helper.pause(1);
				LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
				LeftMenuObject.leftMenuClick();	
				SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(2);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				smartServicesObject.smartServiceClick();
				smartServicesObject.smartPermitClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver, 0, 300);
				Helper.pause(1);
				Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);
				System.err.println("Permit approved successfully and displaying under Entity view Smart Permits");
				}	
			
	
	
	
	
	
	

		            //@Test(description="SmartPermit PermitType Approval of Food Safety Trainer External ApprovePermit PositiveCase ")
				public void SmartPermitPermitTypeApprovalOfFoodSafetyTrainerExternalApprovePermitPositiveCase_04(){

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
					LeftMenuObject.leftMenuClick();	
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
				
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				
				//extra work start
				String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
				String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
				String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
				System.err.println(EntityName_withLicenseNo);
				//extra work end
				
				Helper.ClickUsingLinkText(driver, EntityName);
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
				smartServicesObject.smartServiceClick();
				smartServicesObject.smartPermitClick();
				smartServicesObject.approvalAndPermitsButtonClick();
				String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "Approval of Food Safety Trainer - External");
				Helper.pause(2);
				Helper.allDropDownValueOfSelectDropDown(driver,"TechUserId", 1);
				Helper.pause(2);
				Helper.allDropDownValueOfSelectDropDown(driver,"ddlTypeOfApproval", 1);
				Helper.pause(2);
				Helper.allDropDownValueOfSelectDropDown(driver,"ddlLegalPermits", 1);
				smartServicesObject.clickAddButtonFoodSafetyTrainerInternal();
				smartServicesObject.sendRequestButtonInternalTrainingClick();
				Helper.pause(2);
				
				
				String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
				Helper.pause(2);
				xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
				System.err.println("Newly added record is present in Table grid");
				Helper.scrollTillElement(driver,"//*[text()='Logout']");
				
				loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
				loginScreenoObject.loginLinkTopRight();
					
				excel = new ExcelDataConfig(
						"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
				config = new manageConfigProperties();
				Helper.pause(2);
				logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
				Helper.pause(2);
				LeftMenuObject.leftMenuClick();	
				SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
				SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

				SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
				
				Helper.pause(2);
				String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
				SmartPermitsRequestedObject.searchPermit(Permit_Name);
				Helper.pause(2);
				String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
				System.err.println("Permit request is coming successfully to Permit Officer");
				Helper.pause(2);
				SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
				Helper.getWindowTitle(driver);			
				String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Approved");
				String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "A");
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "Low");
				
				//--Start -only for food safety permit-internal
				SmartPermitsRequestedObject.clickOnPermitListButton();
				Helper.pause(2);
				SmartPermitsRequestedObject.clickOnPopUpOfPermitListDoneButton();
				Helper.pause(2);
				// --End
				Helper.scrollDownPage(driver, 0, 400);
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Approved by Inspection team");
				Helper.pause(2);
				SmartPermitsRequestedObject.clickOnApprovePermitButton();
				Helper.pause(3);
				Helper.acceptAlert(driver);
				Helper.pause(3);
				
				//--Start verify that after approval smart permit has been removed from Requested section
				SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
				SmartPermitsRequestedObject.searchPermit(Permit_Name);
				Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
				// --End
				
				
				//--Start -verify newly approved smart permit is displaying under approved section
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
				//checking status of permit changes from requested to approved.
				Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,"Approved");
				System.err.println("After approval status of the Permit changes to Approved and is present under Approved section");
				//--End --
				Helper.pause(2);
				Helper.scrollTillElement(driver,"//*[text()='Logout']");
				
				loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
				loginScreenoObject.loginLinkTopRight();
					
				excel = new ExcelDataConfig(
						"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
				config = new manageConfigProperties();
				Helper.pause(2);
				logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				Helper.pause(1);
				LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
				LeftMenuObject.leftMenuClick();	
				SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(2);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				smartServicesObject.smartServiceClick();
				smartServicesObject.smartPermitClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver, 0, 300);
				Helper.pause(1);
				Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);
				System.err.println("Permit approved successfully and displaying under Entity view Smart Permits");
				
				}	
	
				
				
				

	               //@Test(description="SmartPermit PermitType FoodActivityatEvent ApprovePermit PositiveCase ")
				public void SmartPermit_PermitTypeFoodActivityatEventApprovePermitPositiveCase05(){

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
					LeftMenuObject.leftMenuClick();	
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
				
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				
				//extra work start
				String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
				String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
				String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
				System.err.println(EntityName_withLicenseNo);
				//extra work end
				
				Helper.ClickUsingLinkText(driver, EntityName);
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
				smartServicesObject.smartServiceClick();
				smartServicesObject.smartPermitClick();
				Helper.pause(1);
				smartServicesObject.approvalAndPermitsButtonClick();
				
				String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "Food Activity at Events");
				Helper.pause(2);
				String TodayDate=Calender.selectCalenderDateToday(driver,"//input[@id='StartDate']", "//div[@class='datepicker-days']/table/tbody/tr/td[@class='today day']");
				Helper.pause(2);
				Calender.selectCalenderDate(driver,"//input[@id='EndDate']", "//div[@class='datepicker-days']/table/tbody/tr/td[@class='day']",String.valueOf(Integer.parseInt(TodayDate)+20));
				smartServicesObject.enterEventName("Test Event");
				Helper.intelligentSearchAdvance(driver, "LocationFE", "ADAB","ADAB IRANIAN PRIVATE SCHOOL FOR BOYS[]" , "//ul[@class='typeahead dropdown-menu']/li/a");
				smartServicesObject.selectDoYouHaveEventPermitFromDTCMradioButtonYES();
				Helper.scrollDownPage(driver, 0, 350);
				Helper.pause(2);
				
				
				//uploading files
				Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile1']");
				Helper.pause(3);
				try {
					Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile2']");
				Helper.pause(3);
				try {
					Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
				} catch (Exception e) {
					e.printStackTrace();
				}
			
				Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile3']");
				Helper.pause(3);
				try {
					Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile4']");
				Helper.pause(3);
				try {
					Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
				} catch (Exception e) {
					e.printStackTrace();
				}
				// file upload end here.
				
				Helper.selectDropDownByTextValue(driver, "//select[@id='TypeOfFoodBusiness']/option", "Food Kiosk");
				Helper.pause(1);
				smartServicesObject.enterTotalFloorArea("900");
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlApplicableProcesses']/option", "Cooking");
				smartServicesObject.clickOnAddButton();
				smartServicesObject.clickreadyToEatFoodBroughtFromOtherEstablishmentYES();						
				smartServicesObject.enterValueInNumberOfStaffInFoodPreparationArea("550");
				Helper.intelligentSearchAdvance(driver, "txtsearch", "test", "TEST HABC TEST[Test12112]", "//div[@id='divOtherEstablishment']/div/ul/li/a");
				smartServicesObject.selectRadioButtonHandwashingFacilityIn20MetersYES();
				// 1 file upload start
				Helper.clickOnChooseFileButton(driver, "//input[@id='Uploadfloorplan']");
				Helper.pause(3);
				try {
					Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 1 file upload End
				smartServicesObject.notesEnterValue("This notes only for testing purpose");
				smartServicesObject.clickOnSendRequestButton();
				Helper.pause(3);
				
				
				String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
				Helper.pause(2);
				xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
				System.err.println("Newly added record is present in Table grid");
				Helper.scrollTillElement(driver,"//*[text()='Logout']");
				
				loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
				loginScreenoObject.loginLinkTopRight();
					
				excel = new ExcelDataConfig(
						"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
				config = new manageConfigProperties();
				Helper.pause(2);
				logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
				Helper.pause(2);
				LeftMenuObject.leftMenuClick();	
				SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
				SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

				SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
				
				Helper.pause(2);
				String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
				SmartPermitsRequestedObject.searchPermit(Permit_Name);
				Helper.pause(2);
				String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
				System.err.println("Permit request is coming successfully to Permit Officer");
				Helper.pause(2);
				SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
				Helper.getWindowTitle(driver);			
				String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Approved");
				String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "B");
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "Low");
				
				Helper.scrollDownPage(driver, 0, 400);
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Approved by Inspection team");
				Helper.pause(2);
				SmartPermitsRequestedObject.clickOnApprovePermitButton();
				Helper.pause(3);
				Helper.acceptAlert(driver);
				Helper.pause(3);
				
				//--Start verify that after approval smart permit has been removed from Requested section
				SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
				SmartPermitsRequestedObject.searchPermit(Permit_Name);
				Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
				// --End
				
				
				//--Start -verify newly approved smart permit is displaying under approved section
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
				//checking status of permit changes from requested to approved.
				Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,"Approved");
				System.err.println("After approval status of the Permit changes to Approved and is present under Approved section");
				//--End --
				Helper.pause(2);
				Helper.scrollTillElement(driver,"//*[text()='Logout']");
				
				loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
				loginScreenoObject.loginLinkTopRight();
					
				excel = new ExcelDataConfig(
						"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
				config = new manageConfigProperties();
				Helper.pause(2);
				logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				Helper.pause(1);
				LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
				LeftMenuObject.leftMenuClick();	
				SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(2);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				smartServicesObject.smartServiceClick();
				smartServicesObject.smartPermitClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver, 0, 300);
				Helper.pause(1);
				Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);
				System.err.println("Permit approved successfully and displaying under Entity view Smart Permits");
				
				}	
				
							
				

	            //@Test(description="SmartPermit PermitType NonHalalFoodACtivity ApprovePermit PositiveCase  ")
			public void SmartPermit_PermitType_NonHalalFoodACtivity_ApprovePermit_PositiveCase_06(){

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
				LeftMenuObject.leftMenuClick();	
			SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			
			String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
			
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
			
			//extra work start
			String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
			String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
			String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
			System.err.println(EntityName_withLicenseNo);
			//extra work end
			
			Helper.ClickUsingLinkText(driver, EntityName);
			entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
			smartServicesObject.smartServiceClick();
			smartServicesObject.smartPermitClick();
			Helper.pause(1);
			smartServicesObject.approvalAndPermitsButtonClick();
			
			String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "Non –Halal Food Activity");
			Helper.pause(2);
			String TodayDate=Calender.selectCalenderDateToday(driver,"//input[@id='StartDate']", "//div[@class='datepicker-days']/table/tbody/tr/td[@class='today day']");
			Helper.pause(2);
			Calender.selectCalenderDate(driver,"//input[@id='EndDate']", "//div[@class='datepicker-days']/table/tbody/tr/td[@class='day']",String.valueOf(Integer.parseInt(TodayDate)+20));
			
			Helper.selectDropDownByTextValue(driver, "//select[@id='NonHalalBusinessType']/option", "Hotel");
			smartServicesObject.enterTotalFoodAreaInSqFt("459");
			smartServicesObject.enterNonHalalFoodAreaInSqFt("780");
			Helper.selectDropDownByTextValue(driver, "//select[@id='ddlTypeOfOperation']/option", "Cooking");
			smartServicesObject.clickAddButtonNonHalalPermit();
			Helper.selectDropdownbyIndex(driver, "ddlTypeOfApproval", 1);
				
			//uploading files
			Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile1']");
			Helper.pause(3);
			try {
				Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile2']");
			Helper.pause(3);
			try {
				Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile3']");
			Helper.pause(3);
			try {
				Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile4']");
			Helper.pause(3);
			try {
				Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
			// file upload end here.
			
			
			
			
			smartServicesObject.clickOnSendRequestButton();
			Helper.pause(3);
			
			
			String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
			Helper.pause(2);
			xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
			System.err.println("Newly added record is present in Table grid");
			Helper.scrollTillElement(driver,"//*[text()='Logout']");
			
			loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
			loginScreenoObject.loginLinkTopRight();
				
			excel = new ExcelDataConfig(
					"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
			config = new manageConfigProperties();
			Helper.pause(2);
			logpge = PageFactory.initElements(driver, loginScreen.class);
			logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
			Helper.pause(2);
			LeftMenuObject.leftMenuClick();	
			SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
			SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

			SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
			
			Helper.pause(2);
			String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
			SmartPermitsRequestedObject.searchPermit(Permit_Name);
			Helper.pause(2);
			String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
			System.err.println("Permit request is coming successfully to Permit Officer");
			Helper.pause(2);
			SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
			Helper.getWindowTitle(driver);			
			String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Approved");
			String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "C");
			Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "Medium");
			
			Helper.scrollDownPage(driver, 0, 400);
			Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Approved by Inspection team");
			Helper.pause(2);
			SmartPermitsRequestedObject.clickOnApprovePermitButton();
			Helper.pause(3);
			Helper.acceptAlert(driver);
			Helper.pause(3);
			
			//--Start verify that after approval smart permit has been removed from Requested section
			SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
			Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
			SmartPermitsRequestedObject.searchPermit(Permit_Name);
			Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
			// --End
			
			
			//--Start -verify newly approved smart permit is displaying under approved section
			Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
			//checking status of permit changes from requested to approved.
			Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,"Approved");
			System.err.println("After approval status of the Permit changes to Approved and is present under Approved section");
			//--End --
			Helper.pause(2);
			Helper.scrollTillElement(driver,"//*[text()='Logout']");
			
			loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
			loginScreenoObject.loginLinkTopRight();
				
			excel = new ExcelDataConfig(
					"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
			config = new manageConfigProperties();
			Helper.pause(2);
			logpge = PageFactory.initElements(driver, loginScreen.class);
			logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
			Helper.pause(1);
			LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
			LeftMenuObject.leftMenuClick();	
			SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
			Helper.ClickUsingLinkText(driver, EntityName);
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(2);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			smartServicesObject.smartServiceClick();
			smartServicesObject.smartPermitClick();
			Helper.pause(2);
			Helper.scrollDownPage(driver, 0, 300);
			Helper.pause(1);
			Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);
			System.err.println("Permit approved successfully and displaying under Entity view Smart Permits");
			
			}		
	

           // @Test(description="SmartPermit PermitType SchoolSupplyPermit ApprovePermit PositiveCase 07  ")
		public void SmartPermit_PermitType_SchoolSupplyPermit_ApprovePermit_PositiveCase_07(){

			loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
			logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
			LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
			LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		
		String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
		
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		
		//extra work start
		String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
		String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
		String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
		System.err.println(EntityName_withLicenseNo);
		//extra work end
		
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(3);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		Helper.pause(1);
		smartServicesObject.approvalAndPermitsButtonClick();
		
		String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "School Supply Permit");
		Helper.pause(2);
		String TodayDate=Calender.selectCalenderDateToday(driver,"//input[@id='StartDate']", "//div[@class='datepicker-days']/table/tbody/tr/td[@class='today day']");
		Helper.pause(2);
		Calender.selectCalenderDate(driver,"//input[@id='EndDate']", "//div[@class='datepicker-days']/table/tbody/tr/td[@class='day']",String.valueOf(Integer.parseInt(TodayDate)+20));
		Helper.intelligentSearchAdvance(driver, "LocationSN", "sun and sky hotel alrigga","SUN AND SKY HOTEL ALRIGGA L.L.C[533539]" , "//ul[@class='typeahead dropdown-menu']/li/a");
		Helper.scrollDownPage(driver, 0, 250);		
		
		
		//uploading files
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile1']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile2']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile3']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile4']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// file upload end here.
		
		
		smartServicesObject.enterRemarksSchoolSupplyPermit("This is school permit for testing");
		smartServicesObject.clickOnSendRequestButton();
		Helper.pause(3);
		
		String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		Helper.pause(2);
		xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		System.err.println("Newly added record is present in Table grid");
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
		Helper.pause(2);
		LeftMenuObject.leftMenuClick();	
		SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
		SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		
		Helper.pause(2);
		String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.pause(2);
		String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
		System.err.println("Permit request is coming successfully to Permit Officer");
		Helper.pause(2);
		SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
		Helper.getWindowTitle(driver);			
		String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Approved");
		String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "B");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "High");
		
		Helper.scrollDownPage(driver, 0, 400);
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Approved by Inspection team");
		Helper.pause(2);
		SmartPermitsRequestedObject.clickOnApprovePermitButton();
		Helper.pause(3);
		Helper.acceptAlert(driver);
		Helper.pause(3);
		
		//--Start verify that after approval smart permit has been removed from Requested section
		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
		// --End
		
		
		//--Start -verify newly approved smart permit is displaying under approved section
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
		//checking status of permit changes from requested to approved.
		Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,"Approved");
		System.err.println("After approval status of the Permit changes to Approved and is present under Approved section");
		//--End --
		Helper.pause(2);
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		Helper.pause(1);
		LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
		LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(2);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		Helper.pause(2);
		Helper.scrollDownPage(driver, 0, 300);
		Helper.pause(1);
		Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);
		System.err.println("Permit approved successfully and displaying under Entity view Smart Permits");
		
		}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		 // @Test(description="SmartPermit PermitType VendingMachine ApprovePermit PositiveCase")
		public void SmartPermit_PermitType_VendingMachine_ApprovePermit_PositiveCase_08(){

			loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
			logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
			LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
			LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		
		String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
		
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		
		//extra work start
		String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
		String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
		String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
		System.err.println(EntityName_withLicenseNo);
		//extra work end
		
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(3);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		Helper.pause(1);
		smartServicesObject.approvalAndPermitsButtonClick();
		
		String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "Vending machine");
		Helper.pause(2);
		String TodayDate=Calender.selectCalenderDateToday(driver,"//input[@id='StartDate']", "//div[@class='datepicker-days']/table/tbody/tr/td[@class='today day']");
		Helper.pause(2);
		Calender.selectCalenderDate(driver,"//input[@id='EndDate']", "//div[@class='datepicker-days']/table/tbody/tr/td[@class='day']",String.valueOf(Integer.parseInt(TodayDate)+20));
		smartServicesObject.chooseLocationRadioButtonVendingMachine();	
		
		Helper.intelligentSearchAdvance(driver, "LocationVM", "sun bakery","SUN BAKERY[104988]" , "//ul[@class='typeahead dropdown-menu']/li/a");
		Helper.scrollDownPage(driver, 0, 250);
				
		
		//uploading files
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile1']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile2']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile3']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile4']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// file upload end here.
		
		
		
		smartServicesObject.clickOnSendRequestButton();
		Helper.pause(3);
		
		String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		Helper.pause(2);
		xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		System.err.println("Newly added record is present in Table grid");
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
		Helper.pause(2);
		LeftMenuObject.leftMenuClick();	
		SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
		SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		
		Helper.pause(2);
		String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.pause(2);
		String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
		System.err.println("Permit request is coming successfully to Permit Officer");
		Helper.pause(2);
		SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
		Helper.getWindowTitle(driver);			
		String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Approved");
		String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "A");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "Medium");
		
		Helper.scrollDownPage(driver, 0, 400);
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Approved by Inspection team");
		Helper.pause(2);
		SmartPermitsRequestedObject.clickOnApprovePermitButton();
		Helper.pause(3);
		Helper.acceptAlert(driver);
		Helper.pause(3);
		
		//--Start verify that after approval smart permit has been removed from Requested section
		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
		// --End
		
		
		//--Start -verify newly approved smart permit is displaying under approved section
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
		//checking status of permit changes from requested to approved.
		Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,"Approved");
		System.err.println("After approval status of the Permit changes to Approved and is present under Approved section");
		//--End --
		Helper.pause(2);
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		Helper.pause(1);
		LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
		LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(2);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		Helper.pause(2);
		Helper.scrollDownPage(driver, 0, 300);
		Helper.pause(1);
		Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);
		System.err.println("Permit approved successfully and displaying under Entity view Smart Permits");
		
		}	
	
	
	

		 // @Test(description="SmartPermit PermitType FoodPromotionPermit ApprovePermit PositiveCase")
		public void SmartPermit_PermitType_FoodPromotionPermit_ApprovePermit_PositiveCase_09(){

			loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
			logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
			LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
			LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		
		String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
		
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		
		//extra work start
		String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
		String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
		String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
		System.err.println(EntityName_withLicenseNo);
		//extra work end
		
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(3);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		Helper.pause(1);
		smartServicesObject.approvalAndPermitsButtonClick();
		
		String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "Food Promotion permit");
		Helper.pause(2);
		String TodayDate=Calender.selectCalenderDateToday(driver,"//input[@id='StartDate']", "//div[@class='datepicker-days']/table/tbody/tr/td[@class='today day']");
		Helper.pause(2);
		Calender.selectCalenderDate(driver,"//input[@id='EndDate']", "//div[@class='datepicker-days']/table/tbody/tr/td[@class='day']",String.valueOf(Integer.parseInt(TodayDate)+20));
		
		
		Helper.intelligentSearchAdvance(driver, "FoodName", "dubai arcadia mix70","Dubai Arcadia MIX70-1913,cookies with mixed nuts-4950000000000" , "//ul[@class='typeahead dropdown-menu']/li/a");
		smartServicesObject.clickFoodItemsADDbutton();
		Helper.scrollDownPage(driver, 0, 200);
		
		Helper.intelligentSearchAdvance(driver, "LocationFPP", "dubai amaravathi","DUBAI AMARAVATHI RESTAURANT[554474]" , "//ul[@class='typeahead dropdown-menu']/li/a");
		smartServicesObject.clickAddLocationsADDbutton();		
		
		smartServicesObject.clickOnSendRequestButton();
		Helper.pause(3);
		
		String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		Helper.pause(2);
		xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		System.err.println("Newly added record is present in Table grid");
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
		Helper.pause(2);
		LeftMenuObject.leftMenuClick();	
		SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
		SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		
		Helper.pause(2);
		String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.pause(2);
		String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
		System.err.println("Permit request is coming successfully to Permit Officer");
		Helper.pause(2);
		SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
		Helper.getWindowTitle(driver);			
		String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Approved");
		String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "A");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "Medium");
		
		Helper.scrollDownPage(driver, 0, 400);
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Approved by Inspection team");
		Helper.pause(2);
		SmartPermitsRequestedObject.clickOnApprovePermitButton();
		Helper.pause(3);
		Helper.acceptAlert(driver);
		Helper.pause(3);
		
		//--Start verify that after approval smart permit has been removed from Requested section
		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
		// --End
		
		
		//--Start -verify newly approved smart permit is displaying under approved section
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
		//checking status of permit changes from requested to approved.
		Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,"Approved");
		System.err.println("After approval status of the Permit changes to Approved and is present under Approved section");
		//--End --
		Helper.pause(2);
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		Helper.pause(1);
		LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
		LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(2);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServicesObject.smartServiceClick();
		Helper.pause(1);
		smartServicesObject.smartPermitClick();
		Helper.pause(2);
		Helper.scrollDownPage(driver, 0, 300);
		Helper.pause(1);
		Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);
		System.err.println("Permit approved successfully and displaying under Entity view Smart Permits");
		
		}	
								
		
		//@Test(description="SmartPermit PermitType TemporaryPermitForChanges ApprovePermit PositiveCase")
		public void SmartPermitPermitTypeTemporaryPermitForChangesApprovePermitPositiveCase10(){

			loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
			logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
			LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
			LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		
		String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
		
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		
		//extra work start
		String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
		String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
		String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
		System.err.println(EntityName_withLicenseNo);
		//extra work end
		
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(3);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		Helper.pause(1);
		smartServicesObject.approvalAndPermitsButtonClick();
		Helper.pause(1);
		String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "Temporary Permit for changes related to food label / packages");
		Helper.pause(2);	
		Helper.intelligentSearchAdvance(driver, "FoodName", "sindhi papad hot and spicy","Sindhi Papad Hot and Spicy,spicy papad-DM356060701195429" , "//ul[@class='typeahead dropdown-menu']/li/a");
		smartServicesObject.clickFoodItemsADDbutton();
		Helper.scrollDownPage(driver, 0, 250);
		Helper.pause(2);	
		
		smartServicesObject.requestedChangesEnterComment("This changes is only for testing full cycle of Temporary permit");
		smartServicesObject.remarksTemporaryPermit("This remarks is for automation of Foodwatch regression suite");
		
		//uploading files
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile1']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile2']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile3']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		smartServicesObject.clickOnSendRequestButton();
		Helper.pause(9);
		
		String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		Helper.pause(2);
		xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		System.err.println("Newly added record is present in Table grid");
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
		Helper.pause(2);
		LeftMenuObject.leftMenuClick();	
		SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
		SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		
		Helper.pause(2);
		String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.pause(2);
		String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
		System.err.println("Permit request is coming successfully to Permit Officer");
		Helper.pause(2);
		SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
		Helper.getWindowTitle(driver);			
		String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Approved");
		String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "A");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "Medium");
		
		Helper.scrollDownPage(driver, 0, 400);
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Approved by Inspection team");
		Helper.pause(2);
		SmartPermitsRequestedObject.clickOnApprovePermitButton();
		Helper.pause(3);
		Helper.acceptAlert(driver);
		Helper.pause(3);
		
		//--Start verify that after approval smart permit has been removed from Requested section
		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
		// --End
		
		
		//--Start -verify newly approved smart permit is displaying under approved section
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
		//checking status of permit changes from requested to approved.
		Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,"Approved");
		System.err.println("After approval status of the Permit changes to Approved and is present under Approved section");
		//--End --
		Helper.pause(2);
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		Helper.pause(1);
		LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
		LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(2);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServicesObject.smartServiceClick();
		Helper.pause(1);
		smartServicesObject.smartPermitClick();
		Helper.pause(2);
		Helper.scrollDownPage(driver, 0, 300);
		Helper.pause(1);
		Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);
		System.err.println("Permit approved successfully and displaying under Entity view Smart Permits");
		
		}	
		
		
		            
		
		
		
		
		  //@Test(description="SmartPermit PermitType FoodPromotionPermit NegativeCase DeniedPermit")
		public void SmartPermit_PermitType_FoodPromotionPermit_NegativeCase_DeniedPermit_11(){

			loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
			logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
			LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
			LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		
		String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
		
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		
		//extra work start
		String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
		String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
		String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
		System.err.println(EntityName_withLicenseNo);
		//extra work end
		
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(3);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		Helper.pause(1);
		smartServicesObject.approvalAndPermitsButtonClick();
		
		String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "Food Promotion permit");
		Helper.pause(2);
		String TodayDate=Calender.selectCalenderDateToday(driver,"//input[@id='StartDate']", "//div[@class='datepicker-days']/table/tbody/tr/td[@class='today day']");
		Helper.pause(2);
		Calender.selectCalenderDate(driver,"//input[@id='EndDate']", "//div[@class='datepicker-days']/table/tbody/tr/td[@class='day']",String.valueOf(Integer.parseInt(TodayDate)+10));
		
		
		Helper.intelligentSearchAdvance(driver, "FoodName", "dubai arcadia mix70","Dubai Arcadia MIX70-1913,cookies with mixed nuts-4950000000000" , "//ul[@class='typeahead dropdown-menu']/li/a");
		smartServicesObject.clickFoodItemsADDbutton();
		Helper.scrollDownPage(driver, 0, 200);
		
		Helper.intelligentSearchAdvance(driver, "LocationFPP", "dubai amaravathi","DUBAI AMARAVATHI RESTAURANT[554474]" , "//ul[@class='typeahead dropdown-menu']/li/a");
		smartServicesObject.clickAddLocationsADDbutton();		
		
		smartServicesObject.clickOnSendRequestButton();
		Helper.pause(3);
		
		String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		Helper.pause(2);
		xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		System.err.println("Newly added record is present in Table grid");
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
		Helper.pause(2);
		LeftMenuObject.leftMenuClick();	
		SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
		SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		
		Helper.pause(2);
		String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.pause(2);
		String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
		System.err.println("Permit request is coming successfully to Permit Officer");
		Helper.pause(2);
		SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
		Helper.getWindowTitle(driver);			
		String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Denied");
		String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "B");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "Low Risk");
		
		Helper.scrollDownPage(driver, 0, 400);
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Denied by Section Head");
		Helper.pause(2);
		//SmartPermitsRequestedObject.clickOnApprovePermitButton();
		SmartPermitsRequestedObject.clickOnUpdateFileButton();
		
		Helper.pause(3);
		Helper.acceptAlert(driver);
		Helper.pause(3);
		
		//--Start verify that after approval smart permit has been removed from Requested section
		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
		// --End
		
		
		//--Start -verify newly approved smart permit is displaying under approved section
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
		//checking status of permit changes from requested to approved.
		Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,"Approved");
		System.err.println("After approval status of the Permit changes to Denied and is present under Denied section");
		//--End --
		Helper.pause(2);
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		Helper.pause(1);
		LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
		LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(2);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServicesObject.smartServiceClick();
		Helper.pause(1);
		smartServicesObject.smartPermitClick();
		Helper.pause(2);
		Helper.scrollDownPage(driver, 0, 300);
		Helper.pause(1);
		//Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);
		
		Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1][contains(text(),'{2}')]",Permit_Name,permitGrade,PermitStatus_After);
		System.err.println("Permit denied successfully and displaying under Entity view Smart Permits");
		
		}	
								
		
		
		
		
		
		
		
		
		
		
		
		
		
		 // @Test(description="SmartPermit PermitType Approval of Internal Training Centre/Consultancy_ApprovePermit ProcessingPermit NegativeCase")
		public void SmartPermit_PermitTypeApprovalOfInternalTrainingCentreConsultancyApprovePermit_ProcessingPermit_NegativeCase12(){

			loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
			logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
			LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
			LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		
		String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
		
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		
		//extra work start
		String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
		String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
		String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
		System.err.println(EntityName_withLicenseNo);
		//extra work end
		
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(3);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		smartServicesObject.approvalAndPermitsButtonClick();
		String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "Approval Of Internal Training Centre/Consultancy");
		Helper.pause(1);
		Helper.allDropDownValueOfSelectDropDown(driver,"TechUserId", 1);
		Helper.pause(1);
		smartServicesObject.sendRequestButtonInternalTrainingClick();
		Helper.pause(1);
		
		//this is only for test case-1
		String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		System.err.println("Newly added record is present in Table grid");
		Helper.pause(1);
		Helper.scrollDownPage(driver, 0, 400);
		Helper.pause(1);
		String completeXpath=smartServicesObject.cancelButtonPermitTableGridClick(xpathPrint,"//following::td[4]/a");
		Helper.pause(1);
		Helper.acceptAlert(driver);
		Helper.pause(1);
		Helper.acceptAlert(driver);
		Helper.pause(1);
		Helper.scrollDownPage(driver, 0, 400);
		Helper.verifyDeletedItemNOTpresentInTableGrid(driver,completeXpath);  //this method is very slow taking a lot of time to execute.
		
		//----------------------------------end this is only for test case-1
		Helper.pause(1);
		smartServicesObject.approvalAndPermitsButtonClick();
		Helper.pause(1);
		Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", Permit_Name);
		Helper.pause(1);
		Helper.allDropDownValueOfSelectDropDown(driver,"TechUserId", 1);
		//Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
		Helper.pause(1);
		smartServicesObject.sendRequestButtonInternalTrainingClick();
		Helper.pause(1);
		xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		System.err.println("Newly added record is present in Table grid");
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
		Helper.pause(2);
		LeftMenuObject.leftMenuClick();	
		SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
		SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		
		Helper.pause(2);
		String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.pause(2);
		String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
		System.err.println("Permit request is coming successfully to Permit Officer");
		Helper.pause(2);
		SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
		Helper.getWindowTitle(driver);
		String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Processing");
		
		String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "B");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "Medium");
		Helper.scrollDownPage(driver, 0, 400);
		//Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Approved by Inspection team");
		//SmartPermitsRequestedObject.clickOnApprovePermitButton();
		SmartPermitsRequestedObject.clickOnUpdateFileButton();
		Helper.pause(2);
		Helper.acceptAlert(driver);
		Helper.pause(2);
		
		//--Start verify that after approval smart permit has been removed from Requested section
		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
		// --End
		
		
		//--Start -verify newly approved smart permit is displaying under approved section
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
		//checking status of permit changes from requested to approved.
		Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,PermitStatus_After);
		System.err.println("After approval status of the Permit changes to Processing and is present under Processing section");
		//--End --
		Helper.pause(2);
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		Helper.pause(1);
		LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
		LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(3);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		Helper.pause(2);
		Helper.scrollDownPage(driver, 0, 300);
		Helper.pause(1);
		//Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);
		Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1][contains(text(),'{2}')]",Permit_Name,permitGrade,PermitStatus_After);
		System.err.println("Permit status is Processing  and displaying under Entity view Smart Permits");
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		 // @Test(description="SmartPermit_PermitType_Approval of Internal Training Centre/Consultancy ApprovePermit UnderReviewPermit NegativeCase")
		public void SmartPermit_PermitTypeApprovalOfInternalTrainingCentreConsultancyApprovePermitUnderReviewPermit_NegativeCase13(){

			loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
			logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
			LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
			LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		
		String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
		
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		
		//extra work start
		String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
		String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
		String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
		System.err.println(EntityName_withLicenseNo);
		//extra work end
		
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(3);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		smartServicesObject.approvalAndPermitsButtonClick();
		String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "Approval Of Internal Training Centre/Consultancy");
		Helper.pause(1);
		Helper.allDropDownValueOfSelectDropDown(driver,"TechUserId", 1);
		Helper.pause(1);
		smartServicesObject.sendRequestButtonInternalTrainingClick();
		Helper.pause(1);
		
		//this is only for test case-1
		String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		System.err.println("Newly added record is present in Table grid");
		Helper.pause(1);
		Helper.scrollDownPage(driver, 0, 400);
		Helper.pause(1);
		String completeXpath=smartServicesObject.cancelButtonPermitTableGridClick(xpathPrint,"//following::td[4]/a");
		Helper.pause(1);
		Helper.acceptAlert(driver);
		Helper.pause(1);
		Helper.acceptAlert(driver);
		Helper.pause(1);
		Helper.scrollDownPage(driver, 0, 400);
		Helper.verifyDeletedItemNOTpresentInTableGrid(driver,completeXpath);  //this method is very slow taking a lot of time to execute.
		
		//----------------------------------end this is only for test case-1
		Helper.pause(1);
		smartServicesObject.approvalAndPermitsButtonClick();
		Helper.pause(1);
		Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", Permit_Name);
		Helper.pause(1);
		Helper.allDropDownValueOfSelectDropDown(driver,"TechUserId", 1);
		//Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
		Helper.pause(1);
		smartServicesObject.sendRequestButtonInternalTrainingClick();
		Helper.pause(1);
		xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		System.err.println("Newly added record is present in Table grid");
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
		Helper.pause(2);
		LeftMenuObject.leftMenuClick();	
		SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
		SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		
		Helper.pause(2);
		String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.pause(2);
		String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
		System.err.println("Permit request is coming successfully to Permit Officer");
		Helper.pause(2);
		SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
		Helper.getWindowTitle(driver);
		String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Under review");
		
		String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "C");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "Low");
		Helper.scrollDownPage(driver, 0, 400);
		//Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Approved by Inspection team");
		//SmartPermitsRequestedObject.clickOnApprovePermitButton();
		SmartPermitsRequestedObject.clickOnUpdateFileButton();
		Helper.pause(2);
		Helper.acceptAlert(driver);
		Helper.pause(2);
		
		//--Start verify that after approval smart permit has been removed from Requested section
		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
		// --End
		
		
		//--Start -verify newly approved smart permit is displaying under approved section
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
		//checking status of permit changes from requested to approved.
		Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,PermitStatus_After);
		System.err.println("After approval status of the Permit changes to Under Review and is present under Under Review section");
		//--End --
		Helper.pause(2);
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		Helper.pause(1);
		LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
		LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(3);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		Helper.pause(2);
		Helper.scrollDownPage(driver, 0, 300);
		Helper.pause(1);
		//Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);
		Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1][contains(text(),'{2}')]",Permit_Name,permitGrade,PermitStatus_After);
		System.err.println("Permit status is Under Review  and displaying under Entity view Smart Permits");
		}	
		
		
		
		
		
		// @Test(description="SmartPermit PermitType FoodActivityatEvent PendingAssessmentPermit NegativeCase")
		public void SmartPermitPermitTypeFoodActivityatEventPendingAssessmentPermit_NegativeCase14(){

			loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
			logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
			LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
			LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		
		String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
		
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		
		//extra work start
		String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
		String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
		String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
		System.err.println(EntityName_withLicenseNo);
		//extra work end
		
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(3);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		Helper.pause(1);
		smartServicesObject.approvalAndPermitsButtonClick();
		
		String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "Food Activity at Events");
		Helper.pause(2);
		String TodayDate=Calender.selectCalenderDateToday(driver,"//input[@id='StartDate']", "//div[@class='datepicker-days']/table/tbody/tr/td[@class='today day']");
		Helper.pause(2);
		Calender.selectCalenderDate(driver,"//input[@id='EndDate']", "//div[@class='datepicker-days']/table/tbody/tr/td[@class='day']",String.valueOf(Integer.parseInt(TodayDate)+10));
		smartServicesObject.enterEventName("Test Event");
		Helper.intelligentSearchAdvance(driver, "LocationFE", "ADAB","ADAB IRANIAN PRIVATE SCHOOL FOR BOYS[]" , "//ul[@class='typeahead dropdown-menu']/li/a");
		smartServicesObject.selectDoYouHaveEventPermitFromDTCMradioButtonYES();
		Helper.scrollDownPage(driver, 0, 350);
		Helper.pause(2);
		
		
		//uploading files
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile1']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile2']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile3']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile4']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// file upload end here.
		
		Helper.selectDropDownByTextValue(driver, "//select[@id='TypeOfFoodBusiness']/option", "Food Kiosk");
		Helper.pause(1);
		smartServicesObject.enterTotalFloorArea("900");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlApplicableProcesses']/option", "Cooking");
		smartServicesObject.clickOnAddButton();
		smartServicesObject.clickreadyToEatFoodBroughtFromOtherEstablishmentYES();						
		smartServicesObject.enterValueInNumberOfStaffInFoodPreparationArea("550");
		Helper.intelligentSearchAdvance(driver, "txtsearch", "test", "TEST HABC TEST[Test12112]", "//div[@id='divOtherEstablishment']/div/ul/li/a");
		smartServicesObject.selectRadioButtonHandwashingFacilityIn20MetersYES();
		// 1 file upload start
		Helper.clickOnChooseFileButton(driver, "//input[@id='Uploadfloorplan']");
		Helper.pause(3);
		try {
			Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 1 file upload End
		smartServicesObject.notesEnterValue("This notes only for testing purpose");
		smartServicesObject.clickOnSendRequestButton();
		Helper.pause(3);
		
		
		String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		Helper.pause(2);
		xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
		System.err.println("Newly added record is present in Table grid");
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
		Helper.pause(2);
		LeftMenuObject.leftMenuClick();	
		SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
		SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		
		Helper.pause(2);
		String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.pause(2);
		String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
		System.err.println("Permit request is coming successfully to Permit Officer");
		Helper.pause(2);
		SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
		Helper.getWindowTitle(driver);			
		String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Pending Assessment");
		String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "D");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "High");
		
		Helper.scrollDownPage(driver, 0, 400);
		//Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Approved by Inspection team");
		Helper.pause(2);
		//SmartPermitsRequestedObject.clickOnApprovePermitButton();
		SmartPermitsRequestedObject.clickOnUpdateFileButton();
		
		Helper.pause(3);
		Helper.acceptAlert(driver);
		Helper.pause(3);
		
		//--Start verify that after approval smart permit has been removed from Requested section
		SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
		SmartPermitsRequestedObject.searchPermit(Permit_Name);
		Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
		// --End
		
		
		//--Start -verify newly approved smart permit is displaying under approved section
		Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
		//checking status of permit changes from requested to Pending Assessment.
		Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,PermitStatus_After);
		System.err.println("After approval status of the Permit changes to Pending Assessment and is present under Pending Assessment section");
		//--End --
		Helper.pause(2);
		Helper.scrollTillElement(driver,"//*[text()='Logout']");
		
		loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
		loginScreenoObject.loginLinkTopRight();
			
		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();
		Helper.pause(2);
		logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		Helper.pause(1);
		LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
		LeftMenuObject.leftMenuClick();	
		SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, EntityName);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(2);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		smartServicesObject.smartServiceClick();
		smartServicesObject.smartPermitClick();
		Helper.pause(2);
		Helper.scrollDownPage(driver, 0, 300);
		Helper.pause(1);
		//Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);
		Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1][contains(text(),'{2}')]",Permit_Name,permitGrade,PermitStatus_After);
		System.err.println("Permit status changed to Pending Assessment successfully and displaying under Entity view Smart Permits");
		
		}					
		
		
		
		            @Test(description="SmartPermit PermitType Temporary Permit For Changes UnderAppeal NegativeCase")
				public void SmartPermitPermitTypeTemporaryPermitForChanges_UnderAppeal_NegativeCase15(){

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					LeftMenu LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
					LeftMenuObject.leftMenuClick();	
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU");
				
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				
				//extra work start
				String LicenseNo_Xpath=Helper.dynamicXpath("//table[@id='tbllandingpageUrl']/tbody/tr/td[3]/a[contains(text(),' {0}')]//following::td[5]",EntityName);
				String LicenseNumber=Helper.getLinkTextOfXpath(driver, LicenseNo_Xpath);
				String EntityName_withLicenseNo=EntityName+" ["+LicenseNumber+"]";
				System.err.println(EntityName_withLicenseNo);
				//extra work end
				
				Helper.ClickUsingLinkText(driver, EntityName);
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				smartServices smartServicesObject = PageFactory.initElements(driver, smartServices.class);
				smartServicesObject.smartServiceClick();
				smartServicesObject.smartPermitClick();
				Helper.pause(1);
				smartServicesObject.approvalAndPermitsButtonClick();
				Helper.pause(1);
				String Permit_Name=Helper.selectDropDownByTextValue(driver, "//select[@id='EntityBusinessActivityId']/option", "Temporary Permit for changes related to food label / packages");
				Helper.pause(2);	
				Helper.intelligentSearchAdvance(driver, "FoodName", "sindhi papad hot and spicy","Sindhi Papad Hot and Spicy,spicy papad-DM356060701195429" , "//ul[@class='typeahead dropdown-menu']/li/a");
				smartServicesObject.clickFoodItemsADDbutton();
				Helper.scrollDownPage(driver, 0, 250);
				Helper.pause(2);	
				
				smartServicesObject.requestedChangesEnterComment("This changes is only for testing full cycle of Temporary permit");
				smartServicesObject.remarksTemporaryPermit("This remarks is for -ve test case testing of Temp Permit of Foodwatch regression suite");
				
				//uploading files
				Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile1']");
				Helper.pause(3);
				try {
					Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
				} catch (Exception e) {
					e.printStackTrace();
				}		
				
				Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile2']");
				Helper.pause(3);
				try {
					Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
				} catch (Exception e) {
					e.printStackTrace();
				}
			
				Helper.clickOnChooseFileButton(driver, "//input[@id='UploadFile3']");
				Helper.pause(3);
				try {
					Helper.uploadFileUsingAUTOIT("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\FoodwatchSmartPermit_FoodActivityAtEvents.exe");
				} catch (Exception e) {
					e.printStackTrace();
				}
						
				smartServicesObject.clickOnSendRequestButton();
				Helper.pause(9);
				
				String xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
				Helper.pause(2);
				xpathPrint=Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[4][contains(text(),'{1}')]", Permit_Name,"Requested");
				System.err.println("Newly added record is present in Table grid");
				Helper.scrollTillElement(driver,"//*[text()='Logout']");
				
				loginScreen loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
				loginScreenoObject.loginLinkTopRight();
					
				excel = new ExcelDataConfig(
						"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
				config = new manageConfigProperties();
				Helper.pause(2);
				logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 4, 0), excel.readExcelDataString("login", 4, 1));
				Helper.pause(2);
				LeftMenuObject.leftMenuClick();	
				SmartPermits_Requested SmartPermitsRequestedObject = PageFactory.initElements(driver,SmartPermits_Requested.class);
				SmartPermitsRequestedObject.mouseOverPermitManagementAndClickSmartPermit();	

				SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
				
				Helper.pause(2);
				String PermitStatus_Initial=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", "Requested");
				SmartPermitsRequestedObject.searchPermit(Permit_Name);
				Helper.pause(2);
				String xPath_permitRequestComing=Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]",EntityName,Permit_Name);
				System.err.println("Permit request is coming successfully to Permit Officer");
				Helper.pause(2);
				SmartPermitsRequestedObject.clickOnRequestButton(xPath_permitRequestComing, "//following::td[13]/button");
				Helper.getWindowTitle(driver);			
				String PermitStatus_After=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatus']/option", "Under Appeal");
				String permitGrade=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlGrade']/option", "C");
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlRiskLevel']/option", "Not Applicable");
				Helper.scrollDownPage(driver, 0, 400);
				//Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectorComment']/option", "Approved by Inspection team");
				Helper.pause(2);
				//SmartPermitsRequestedObject.clickOnApprovePermitButton();
				SmartPermitsRequestedObject.clickOnUpdateFileButton();
				Helper.pause(3);
				Helper.acceptAlert(driver);
				Helper.pause(3);
				
				//--Start verify that after approval smart permit has been removed from Requested section
				SmartPermitsRequestedObject.clickOnSmartPermitSearchbyIntelligentSearch("txtsearch", EntityName, EntityName_withLicenseNo, "//div[@class='col-sm-6 col-md-5']/ul/li/a");
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_Initial);
				SmartPermitsRequestedObject.searchPermit(Permit_Name);
				Helper.verifyDeletedItemNOTpresentInTableGrid(driver, xPath_permitRequestComing);
				// --End
				
				
				//--Start -verify newly approved smart permit is displaying under approved section
				Helper.selectDropDownByTextValue(driver, "//select[@id='ddlStatusId']/option", PermitStatus_After);
				//checking status of permit changes from requested to approved.
				Helper.dynamicXpath("//table[@id='tblEntityPermitList']/tbody/tr/td[1][contains(text(),'{0}')]//following::td[2][contains(text(),'{1}')]//following::td[13]/button[contains(text(),'{2}')]",EntityName,Permit_Name,PermitStatus_After);
				System.err.println("After approval status of the Permit changes to Under Appeal and is present under Under Appeal section");
				//--End --
				Helper.pause(2);
				Helper.scrollTillElement(driver,"//*[text()='Logout']");
				
				loginScreenoObject=PageFactory.initElements(driver, loginScreen.class);	
				loginScreenoObject.loginLinkTopRight();
					
				excel = new ExcelDataConfig(
						"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
				config = new manageConfigProperties();
				Helper.pause(2);
				logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				Helper.pause(1);
				LeftMenuObject = PageFactory.initElements(driver,LeftMenu.class);
				LeftMenuObject.leftMenuClick();	
				SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(2);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				smartServicesObject.smartServiceClick();
				Helper.pause(1);
				smartServicesObject.smartPermitClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver, 0, 300);
				Helper.pause(1);
				//Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1]/img",Permit_Name,permitGrade);			
				Helper.dynamicXpath("//table[@id='tblEntityPermits']/tbody/tr/td[2][contains(text(),'{0}')]//following::td[3][contains(text(),'{1}')]//following::td[1][contains(text(),'{2}')]",Permit_Name,permitGrade,PermitStatus_After);
				System.err.println("Permit approved successfully and displaying under Entity view Smart Permits");
				
				}	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
}
