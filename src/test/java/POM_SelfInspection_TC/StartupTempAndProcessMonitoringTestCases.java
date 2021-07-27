package POM_SelfInspection_TC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import POM_EntityTreeView.GeneralInformation;
import POM_EntityTreeView.ManagePeopleFoodHandler;
import POM_EntityTreeView.entityTreeView;
import POM_EntityTreeView.foodSafetyManagement;
import POM_Login.loginScreen;
import POM_MyEntities.SearchOnEstablishNameAndLicenseNumber;
import POM_SelfInspection.StartUpTempAndProcessMonitoring;
import resources.ExcelDataConfig;
import resources.Helper;
import resources.base;
import resources.manageConfigProperties;

public class StartupTempAndProcessMonitoringTestCases extends base {

	public ExcelDataConfig excel;
	// WebDriver driver;

	@BeforeSuite
	public void setUpSuite() {

		excel = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");
		config = new manageConfigProperties();

	}

	//@Test(description = "Verify color of 1 FoodArea and 1 foodHandler when illness checkbox is checked ")
	public void verifyColor_FoodArea_FoodHandler_illnessChecked_UniformColor_001() {

		loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
		StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();

		String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC

		StartUpTempAndProcessMonitoringObject.AllFoodhandlersFreeIllnessClick();
		StartUpTempAndProcessMonitoringObject.StartUpDoneButtonClick();

		Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 1);
		String foodHandlername = Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 1); //// DYNAMIC
																										//// VALUE

		Helper.allDropDownValueOfSelectDropDown(driver, "ddlStartUpInspectionItem", 1);
		StartUpTempAndProcessMonitoringObject.ClickAddAndFinalizeButtonFHpopup();
		Helper.selectDropdownbyIndex(driver, "ddlPreoperationalFoodArea", 1);
		StartUpTempAndProcessMonitoringObject.ClickAddandFinalizeButtonFoodAreaPopup();
		Helper.pause(5);
		Helper.selectDropdownbyIndex(driver, "ddlPestControlCompany", 1);
		StartUpTempAndProcessMonitoringObject.ClickOnConfirmYourSelectionButtonPestControl();
		Helper.pause(5);
		Helper.acceptAlert(driver);
		Helper.pause(2);

		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory
				.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, "UNU");

		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(10);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();

		ManagePeopleFoodHandler ManagePeopleFoodHandlerObject = PageFactory.initElements(driver,
				ManagePeopleFoodHandler.class);
		Helper.pause(2);
		ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
		Helper.pause(2);
		ManagePeopleFoodHandlerObject.SearchFoodHandlerTable(foodHandlername);
		ManagePeopleFoodHandlerObject.VerifyFhUniformColor();
		ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
		// verify color of food Area.
		foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
		foodSafetyManagementObject.ClickFoodSafetyManagement();
		foodSafetyManagementObject.ClickFoodPreparationArea();
		foodSafetyManagementObject.VerifyFoodAreaColor();

	}

	// @Test(description="Verify color of 1 FoodArea and 1 foodHandler when
	// clean-Uniform checkbox is checked ")
	public void verifyColor_FoodArea_FoodHandler_cleanUniformChecked_PersonalHygiene_002() {

		loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
		StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();

		String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
		StartUpTempAndProcessMonitoringObject.AllFoodHandlersHaveCleanUniformsClick();
		StartUpTempAndProcessMonitoringObject.StartUpDoneButtonClick();

		Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 1);
		String foodHandlername = Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 1); //// DYNAMIC
																										//// VALUE
		String dropDownValue = Helper.selectDropdownbyIndex(driver, "ddlFoodHandler", 1);
		System.err.println("DropDown values are " + dropDownValue);
		Helper.selectDropdownbyIndex(driver, "ddlStartUpInspectionItem", 2);
		StartUpTempAndProcessMonitoringObject.ClickAddAndFinalizeButtonFHpopup();

		Helper.selectDropdownbyIndex(driver, "ddlPreoperationalFoodArea", 1);
		StartUpTempAndProcessMonitoringObject.ClickAddandFinalizeButtonFoodAreaPopup();
		Helper.pause(2);
		Helper.selectDropdownbyIndex(driver, "ddlPestControlCompany", 1);
		StartUpTempAndProcessMonitoringObject.ClickOnConfirmYourSelectionButtonPestControl();

		Helper.pause(2);
		Helper.acceptAlert(driver);
		Helper.pause(2);

		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory
				.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, "UNU");

		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(10);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();

		ManagePeopleFoodHandler ManagePeopleFoodHandlerObject = PageFactory.initElements(driver,
				ManagePeopleFoodHandler.class);
		Helper.pause(2);
		ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
		Helper.pause(2);
		ManagePeopleFoodHandlerObject.SearchFoodHandlerTable(foodHandlername);
		ManagePeopleFoodHandlerObject.VerifyPersonalHygieneColor();
		ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
		// verify color of food Area.
		foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
		foodSafetyManagementObject.ClickFoodSafetyManagement();
		foodSafetyManagementObject.ClickFoodPreparationArea();
		foodSafetyManagementObject.VerifyFoodAreaColor();

	}

	// @Test(description="Verify color of 1 FoodArea and 1 foodHandler when
	// clean-Uniform checkbox is checked ")
	public void verifyColor_FoodArea_FoodHandler_GroomedCleanChecked_illness_003() {

		loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
		StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
		// StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");
		String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC

		StartUpTempAndProcessMonitoringObject.AllFoodHandlersAreWellGroomedAndCleanClick();
		StartUpTempAndProcessMonitoringObject.StartUpDoneButtonClick();

		Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 1);
		String foodHandlername = Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 1); //// DYNAMIC
																										//// VALUE
		String dropDownValue = Helper.selectDropdownbyIndex(driver, "ddlFoodHandler", 1);
		System.err.println("DropDown values are " + dropDownValue);
		Helper.selectDropdownbyIndex(driver, "ddlStartUpInspectionItem", 1); // select drop down value- All food
																				// handlers are free of any symptoms of
																				// foodborne illness
		StartUpTempAndProcessMonitoringObject.ClickAddAndFinalizeButtonFHpopup();
		Helper.selectDropdownbyIndex(driver, "ddlPreoperationalFoodArea", 1);
		StartUpTempAndProcessMonitoringObject.ClickAddandFinalizeButtonFoodAreaPopup();
		Helper.pause(2);
		Helper.selectDropdownbyIndex(driver, "ddlPestControlCompany", 1);
		StartUpTempAndProcessMonitoringObject.ClickOnConfirmYourSelectionButtonPestControl();
		Helper.pause(2);
		Helper.acceptAlert(driver);
		Helper.pause(2);

		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory
				.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName);
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, "UNU");

		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(10);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();

		ManagePeopleFoodHandler ManagePeopleFoodHandlerObject = PageFactory.initElements(driver,
				ManagePeopleFoodHandler.class);
		Helper.pause(2);
		ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
		Helper.pause(2);
		ManagePeopleFoodHandlerObject.SearchFoodHandlerTable(foodHandlername);
		ManagePeopleFoodHandlerObject.VerifyillnessColor();
		ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
		// verify color of food Area.
		foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
		foodSafetyManagementObject.ClickFoodSafetyManagement();
		foodSafetyManagementObject.ClickFoodPreparationArea();
		foodSafetyManagementObject.VerifyFoodAreaColor();

	}

	//@Test(description="Verify color of 1 FoodArea and 1 foodHandler when Handwashing checkbox is checked ")
	public void verifyColor_FoodArea_FoodHandler_HandwashingChecked_illness_004() {

		loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
		StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
		// StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");

		String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC

		StartUpTempAndProcessMonitoringObject.HandwashingFacilityIsFullyEquipedClick();//
		StartUpTempAndProcessMonitoringObject.StartUpDoneButtonClick();

		Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 1);

		String foodHandlername = Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 1); //// DYNAMIC
																										//// VALUE

		Helper.allDropDownValueOfSelectDropDown(driver, "ddlStartUpInspectionItem", 1); // select drop down value- All
																						// food handlers are free of any
																						// symptoms of foodborne illness
		StartUpTempAndProcessMonitoringObject.ClickAddAndFinalizeButtonFHpopup();
		Helper.allDropDownValueOfSelectDropDown(driver, "ddlPreoperationalFoodArea", 2); // select 2nd drop down value

		String FoodAreaValue = Helper.allDropDownValueOfSelectDropDown(driver, "ddlPreoperationalFoodArea", 2); // THIS
																												// IS
																												// FOOD
																												// AREA
																												// VALUE
		StartUpTempAndProcessMonitoringObject.ClickAddandFinalizeButtonFoodAreaPopup();
		Helper.pause(2);
		Helper.selectDropdownbyIndex(driver, "ddlPestControlCompany", 1);
		StartUpTempAndProcessMonitoringObject.ClickOnConfirmYourSelectionButtonPestControl();
		Helper.pause(2);
		Helper.acceptAlert(driver);
		Helper.pause(2);

		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory
				.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, "UNU"); // need to check for dynamic

		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(10);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();

		ManagePeopleFoodHandler ManagePeopleFoodHandlerObject = PageFactory.initElements(driver,
				ManagePeopleFoodHandler.class);
		Helper.pause(2);
		ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
		Helper.pause(2);
		ManagePeopleFoodHandlerObject.SearchFoodHandlerTable(foodHandlername); // 2nd drop down value selected from the
																				// food handler drop down
		ManagePeopleFoodHandlerObject.VerifyillnessColor();
		ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
		// verify color of food Area.
		foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
		foodSafetyManagementObject.ClickFoodSafetyManagement();
		foodSafetyManagementObject.ClickFoodPreparationArea();
		foodSafetyManagementObject.VerifyFoodAreaColor2ndDropDown(); // 2nd Food Area in the table grid

	}

	
	
	
	//@Test(description="Verify color of 1 FoodArea and 1 foodHandler when No pest activity checkbox is checked ")
		public void verifyColor_FoodArea_FoodHandler_NoPestActivityChecked_illness_005() {

			loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
			logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
			// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
			//StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("SKYE & WALKER");

			String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("SKYE & WALKER");/// DYNAMIC

			StartUpTempAndProcessMonitoringObject.PestActivityReportedClick();//
			StartUpTempAndProcessMonitoringObject.StartUpDoneButtonClick();

			Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 1);

			String foodHandlername = Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 1); //// DYNAMIC
																											//// VALUE

			Helper.allDropDownValueOfSelectDropDown(driver, "ddlStartUpInspectionItem", 1); // select drop down value- All
																							// food handlers are free of any
																							// symptoms of foodborne illness
			StartUpTempAndProcessMonitoringObject.ClickAddAndFinalizeButtonFHpopup();
			Helper.allDropDownValueOfSelectDropDown(driver, "ddlPreoperationalFoodArea", 1); // select 2nd drop down value

			String FoodAreaValue = Helper.allDropDownValueOfSelectDropDown(driver, "ddlPreoperationalFoodArea", 1); // THIS
																													// IS
																													// FOOD
																													// AREA
																													// VALUE
			StartUpTempAndProcessMonitoringObject.ClickAddandFinalizeButtonFoodAreaPopup();
			Helper.pause(2);
			Helper.selectDropdownbyIndex(driver, "ddlPestControlCompany", 1);
			StartUpTempAndProcessMonitoringObject.ClickOnConfirmYourSelectionButtonPestControl();
			Helper.pause(2);
			Helper.acceptAlert(driver);
			Helper.pause(2);

			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

			entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(10);
			GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
			GeneralInformationObject.ClickOnGeneralInformationTab();

			ManagePeopleFoodHandler ManagePeopleFoodHandlerObject = PageFactory.initElements(driver,
					ManagePeopleFoodHandler.class);
			Helper.pause(2);
			ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
			Helper.pause(2);
			ManagePeopleFoodHandlerObject.SearchFoodHandlerTable(foodHandlername); // 2nd drop down value selected from the
																					// food handler drop down
			ManagePeopleFoodHandlerObject.VerifyillnessColor();
			ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
			// verify color of food Area.
			foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			foodSafetyManagementObject.ClickFoodPreparationArea();
			foodSafetyManagementObject.VerifyFoodAreaColor(); // 2nd Food Area in the table grid

		}
	
	
	
	
	
	//@Test(description="Verify color of 1 FoodArea and 1 foodHandler when All food areas are clean checkbox is checked ")
	public void verifyColor_FoodArea_FoodHandler_AllFoordAreasAreClean_AllFoodHandlersCleanAndGroomed_006() {

		loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
		StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
		//StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("SKYE & WALKER");

		String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
		StartUpTempAndProcessMonitoringObject.AllFoodAreasAreCleanClick();
		StartUpTempAndProcessMonitoringObject.StartUpDoneButtonClick();

		Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 2); //selecting 2nd dropdown value of FoodHandler
		String foodHandlername = Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 2); //// DYNAMIC VALUE																							
		Helper.allDropDownValueOfSelectDropDown(driver, "ddlStartUpInspectionItem", 3); //food handlers are groomed and Clean																																										
		StartUpTempAndProcessMonitoringObject.ClickAddAndFinalizeButtonFHpopup();
		Helper.pause(2);
		Helper.acceptAlert(driver);
		Helper.pause(2);

	
		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(5);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();

		ManagePeopleFoodHandler ManagePeopleFoodHandlerObject = PageFactory.initElements(driver,ManagePeopleFoodHandler.class);
		Helper.pause(1);
		ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
		Helper.pause(1);
		ManagePeopleFoodHandlerObject.SearchFoodHandlerTable(foodHandlername); 																	
		ManagePeopleFoodHandlerObject.VerifyPersonalHygieneColor();
		ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
	}
	
	
	
	
	         //  @Test(description="Verify color of 1 FoodArea and 1 foodHandler when 'Cleaning and Disinfection of Premises Carried Out' checkbox is checked")
		    	public void verifyColor_FoodArea_FoodHandler_CleaningDisinfectionCarriedOut_illness_007() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				//StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("SKYE & WALKER");

				String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
				StartUpTempAndProcessMonitoringObject.CleaningAndDisinfectionOfPremisesCarriedOutClick();//
				
				StartUpTempAndProcessMonitoringObject.StartUpDoneButtonClick();								
				Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 3);

				String foodHandlername = Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 3); //// DYNAMIC 
																												
				Helper.allDropDownValueOfSelectDropDown(driver, "ddlStartUpInspectionItem", 1); // select drop down value- All food handlers are free of any symptoms of foodborne illness																																														 
				StartUpTempAndProcessMonitoringObject.ClickAddAndFinalizeButtonFHpopup();
				
				Helper.allDropDownValueOfSelectDropDown(driver, "ddlPreoperationalFoodArea", 1); // select 1st drop down value
				String FoodAreaValue = Helper.allDropDownValueOfSelectDropDown(driver, "ddlPreoperationalFoodArea", 1); // THIS IS FOOD AREA VALUE																																																																																									
																														
				StartUpTempAndProcessMonitoringObject.ClickAddandFinalizeButtonFoodAreaPopup();
				Helper.pause(2);
				Helper.acceptAlert(driver);
				Helper.pause(2);

				
				
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				//SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(10);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();

				ManagePeopleFoodHandler ManagePeopleFoodHandlerObject = PageFactory.initElements(driver,
						ManagePeopleFoodHandler.class);
				Helper.pause(2);
				ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
				Helper.pause(2);
				ManagePeopleFoodHandlerObject.SearchFoodHandlerTable(foodHandlername); // 2nd drop down value selected from the																						// food handler drop down
				ManagePeopleFoodHandlerObject.VerifyillnessColor();
				
				
				ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
				// verify color of food Area.
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				foodSafetyManagementObject.ClickFoodPreparationArea();
				foodSafetyManagementObject.VerifyFoodAreaColor(); // 2nd Food Area in the table grid

			}
	
	
	
	
	
	
	          // @Test(description="Verify color of 1 FoodArea and 1 foodHandler when 'StartUp Addition for testing purpose' checkbox is checked")
		    	public void verifyColor_FoodArea_FoodHandler_StartupAdditionForTestingPurposeChecked_CleanUniform_008() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				//StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");

				String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
				StartUpTempAndProcessMonitoringObject.StartupAdditionforTestingPurposeClick();//
				
				StartUpTempAndProcessMonitoringObject.StartUpDoneButtonClick();								
				Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 3);

				String foodHandlername = Helper.allDropDownValueOfSelectDropDown(driver, "ddlFoodHandler", 3); //// DYNAMIC 
																												
				Helper.allDropDownValueOfSelectDropDown(driver, "ddlStartUpInspectionItem", 2); // select drop down value- All food handlers are clean uniform																																														 
				StartUpTempAndProcessMonitoringObject.ClickAddAndFinalizeButtonFHpopup();
				
				Helper.allDropDownValueOfSelectDropDown(driver, "ddlPreoperationalFoodArea", 1); // select 1st drop down value
				String FoodAreaValue = Helper.allDropDownValueOfSelectDropDown(driver, "ddlPreoperationalFoodArea", 1); // THIS IS FOOD AREA VALUE																																																																																									
																														
				StartUpTempAndProcessMonitoringObject.ClickAddandFinalizeButtonFoodAreaPopup();
				Helper.pause(2);
				Helper.acceptAlert(driver);
				Helper.pause(2);
							
				
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				//SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(5);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();

				ManagePeopleFoodHandler ManagePeopleFoodHandlerObject = PageFactory.initElements(driver,ManagePeopleFoodHandler.class);					
				Helper.pause(2);
				ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
				Helper.pause(2);
				ManagePeopleFoodHandlerObject.SearchFoodHandlerTable(foodHandlername); // 2nd drop down value selected from the																						// food handler drop down
				ManagePeopleFoodHandlerObject.VerifyFhUniformColor();
								
				ManagePeopleFoodHandlerObject.ClickManagePeopleAndFoodHandlerTab(driver);
				// verify color of food Area.
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				foodSafetyManagementObject.ClickFoodPreparationArea();
				foodSafetyManagementObject.VerifyFoodAreaColor(); // 1st Food Area in the table grid

			}
	
	
		    	
		    	
		    	
		    	

//PROCESS CHECK TEST CASES
//============================================================================================================================
//============================================================================================================================
		    	
		    	
		 // @Test(description="Verify the process check Cooking -ve values")
		public void SelfInspection_ProcessCheck_01_Cooking_NegativeCase() {

		loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
	   
		StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(3);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
		foodSafetyManagementObject.ClickFoodSafetyManagement();
		Helper.pause(1);
		foodSafetyManagementObject.ClickfoodDetails();
		//foodSafetyManagementObject.ClickquickUploadButton();
	 
		String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
		String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
	    Helper.switchToMainWindow(driver, parentWindowHandle);
	 
	    
		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
		Helper.ClickUsingLinkText(driver, EntityName);
	    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
	  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Cooking [Cooking ] [Temp °C]");
	//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.

	String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("30");
	String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "Move food");
	StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
	Helper.pause(1);
	Helper.acceptAlert(driver);
	Helper.pause(2);
	
	
	
	
	StartUpTempAndProcessMonitoringObject.LeftMenuClick();
	SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
	SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
	SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
	Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
	entityTreeViewObject.ClickOnEntityTreeView();
	Helper.pause(3);
	GeneralInformationObject.ClickOnGeneralInformationTab();
	Helper.pause(1);
	foodSafetyManagementObject.ClickFoodSafetyManagement();
	Helper.pause(1);
	foodSafetyManagementObject.ClickProcessDetails();
	
	
	String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
	
	String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
	//System.err.println(print);
	Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");
	
	String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
	Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
	
		  }
		  
		  
		  
		  
		  
		  
		// @Test(description="Verify the process check Cooking +ve values")
		public void SelfInspection_ProcessCheck_02_Cooking_Positive() {

		loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
		logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
		// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
	   
		StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
		SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
		String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
		SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
		Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

		entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
		entityTreeViewObject.ClickOnEntityTreeView();
		Helper.pause(3);
		GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
		GeneralInformationObject.ClickOnGeneralInformationTab();
		Helper.pause(1);
		foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
		foodSafetyManagementObject.ClickFoodSafetyManagement();
		Helper.pause(1);
		foodSafetyManagementObject.ClickfoodDetails();
		//foodSafetyManagementObject.ClickquickUploadButton();
	 
		String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
		String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
	    Helper.switchToMainWindow(driver, parentWindowHandle);
	 
	    
		StartUpTempAndProcessMonitoringObject.LeftMenuClick();
		StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
		Helper.ClickUsingLinkText(driver, EntityName);
	    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
	  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Cooking [Cooking ] [Temp °C]");
	//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.

	String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("75");
	Helper.pause(3);
	String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "No Action required");
	StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
	Helper.pause(1);
	Helper.acceptAlert(driver);
	Helper.pause(2);
	
	
	
	
	StartUpTempAndProcessMonitoringObject.LeftMenuClick();
	SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
	SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
	SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
	Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
	entityTreeViewObject.ClickOnEntityTreeView();
	Helper.pause(3);
	GeneralInformationObject.ClickOnGeneralInformationTab();
	Helper.pause(1);
	foodSafetyManagementObject.ClickFoodSafetyManagement();
	Helper.pause(1);
	foodSafetyManagementObject.ClickProcessDetails();
	
	
	String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
	
	String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
	//System.err.println(print);
	Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(212, 237, 218, 1)");
	
	String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
	Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
	
		  }
		    
		  
		  
		  
		         // @Test(description="Verify SelfInspection_ProcessCheck_03_HotHolding_Negative Case")
				public void SelfInspection_ProcessCheck_03_HotHolding_Negative_Case() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Hot Holding[Heat food] [Temp °C]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.

			String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("30");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "Discard Food");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }  
		  
		  
		  
		  
		  
		  
				 // @Test(description="Verify SelfInspection ProcessCheck 04 HotHolding Positive Case")
				public void SelfInspection_ProcessCheck_04_HotHolding_PositiveCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Hot Holding[Heat food] [Temp °C]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.

			String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("60");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "No Action required");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(212, 237, 218, 1)");
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }  
		  
		  
		  
		  
		  
		  
		  
				 //@Test(description="Verify SelfInspection ProcessCheck ColdHolding NegativeCase Case")
				public void SelfInspection_ProcessCheck_05_ColdHolding_NegativeCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Cold Holding[Cold Holding] [Temp °C]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.

			String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("50");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "Reheat food");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }    
		  
		  
		  
		  
		  
		  
				// @Test(description="Verify SelfInspection ProcessCheck ColdHolding PositiveCase Case")
				public void SelfInspection_ProcessCheck_06_ColdHolding_PositiveCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Cold Holding[Cold Holding] [Temp °C]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.

			String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("5");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "Move food");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(212, 237, 218, 1)");
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }      
		  
		  		  		  
				//@Test(description="Verify SelfInspection ProcessCheck Freezing_Negative  Case")
				public void SelfInspection_ProcessCheck_07_Freezing_NegativeCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Freezing[Freezing] [Temp °C]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.

			String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("50");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "Move food");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			Helper.pause(1);
			Helper.scrollDownPage(driver,0, 600);
			Helper.pause(3);
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");   //+ve means green color=212, 237
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }      
				
				
				
				
				
				//@Test(description="Verify SelfInspection ProcessCheck Freezing Positive  Case")
				public void SelfInspection_ProcessCheck_08_Freezing_PositiveCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Freezing[Freezing] [Temp °C]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.

			String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("-18");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "No Action required");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			Helper.pause(1);
			Helper.scrollDownPage(driver,0, 600);
			Helper.pause(3);
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(212, 237, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }      		
				
				
				
				
				
				
				
				
				//@Test(description="Verify SelfInspection ProcessCheck CoolingStart_Negative Case")
				public void SelfInspection_ProcessCheck_09_CoolingStart_NegativeCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Cooling Start[Cooling Start] [Temp °C]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.

			String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("25");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "Discard Food");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			Helper.pause(1);
			Helper.scrollDownPage(driver,0, 600);
			Helper.pause(3);
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }      		
						
				
				
				
				
				
				//@Test(description="Verify SelfInspection ProcessCheck CoolingStart Positive Case")
				public void SelfInspection_ProcessCheck_10_CoolingStart_PositiveCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Cooling Start[Cooling Start] [Temp °C]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.

			String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("55");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "No Action required");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			Helper.pause(1);
			Helper.scrollDownPage(driver,0, 600);
			Helper.pause(3);
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(212, 237, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }      				
				
				
				
				
				
				
				//@Test(description="Verify SelfInspection ProcessCheck CoolingEnd Negative Case")
				public void SelfInspection_ProcessCheck_11__CoolingEnd_NegativeCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Cooling End[Cooling End] [Temp °C]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.

			String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("100");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "Reheat food");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			Helper.pause(1);
			Helper.scrollDownPage(driver,0, 600);
			Helper.pause(3);
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }      				
						
				
				
				
				
				
				
				 // @Test(description="Verify SelfInspection ProcessCheck CoolingEnd Positive Case")
				public void SelfInspection_ProcessCheck_12__CoolingEnd_PositiveCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Cooling End[Cooling End] [Temp °C]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.

			String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("10");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "Move food");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			Helper.pause(1);
			Helper.scrollDownPage(driver,0, 600);
			Helper.pause(3);
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(212, 237, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }      					
				
				
				
				
				
				
				
				
				
				
				 // @Test(description="Verify SelfInspection ProcessCheck Reheating Negative Case")
				public void SelfInspection_ProcessCheck_13__Reheating_NegativeCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Reheating[Reheating] [Temp °C]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.

			String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("25");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "Discard Food");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			Helper.pause(1);
			Helper.scrollDownPage(driver,0, 600);
			Helper.pause(3);
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }      				
				
				
				
				
				
				
				 // @Test(description="Verify SelfInspection ProcessCheck Reheating Positive Case")
				public void SelfInspection_ProcessCheck_14__Reheating_PositiveCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Reheating[Reheating] [Temp °C]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.

			String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("75");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "No Action required");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			Helper.pause(1);
			Helper.scrollDownPage(driver,0, 600);
			Helper.pause(3);
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(212, 237, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }      						
				
				
				
				
				
				
				
				
				
				 // @Test(description="Verify SelfInspection ProcessCheck Reheating Negative Case")
				public void SelfInspection_ProcessCheck_15__Reheating_NegativeCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Defrosting (thawing)[Defrosting (thawing)] [Temp °C]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.
			  String Control_Limit= StartUpTempAndProcessMonitoringObject.enterValueOfControlLimit("10");
			String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("50");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "Discard Food");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			Helper.pause(1);
			Helper.scrollDownPage(driver,0, 600);
			Helper.pause(3);
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }      				
				
				
				
				
				
				
				
				
				
				 // @Test(description="Verify SelfInspection ProcessCheck Reheating Positive Case")
				public void SelfInspection_ProcessCheck_16__Reheating_PositiveCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Defrosting (thawing)[Defrosting (thawing)] [Temp °C]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.
			  String Control_Limit= StartUpTempAndProcessMonitoringObject.enterValueOfControlLimit("100");
			String cooking_Temp= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("100");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "No Action required");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			Helper.pause(1);
			Helper.scrollDownPage(driver,0, 600);
			Helper.pause(3);
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(212, 237, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }      				
				
				
				
				
				
				 // @Test(description="Verify SelfInspection ProcessCheck Acidification Negative Case")
				public void SelfInspection_ProcessCheck_17__Acidification_NegativeCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Acidification[Acidification] [PH Value]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.
			  String Control_Limit= StartUpTempAndProcessMonitoringObject.enterValueOfControlLimit("60");
			String PH_Value= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("70");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "Reheat food");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			Helper.pause(1);
			Helper.scrollDownPage(driver,0, 600);
			Helper.pause(3);
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }      					
				
				
				
				
				
				
				
				 // @Test(description="Verify SelfInspection ProcessCheck Acidification Positive Case")
				public void SelfInspection_ProcessCheck_18__Acidification_PositiveCase() {

				loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
				logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
				// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();
			   
				StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				String EntityName=SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField("UNU"); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic

				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.ClickfoodDetails();
				//foodSafetyManagementObject.ClickquickUploadButton();
			 
				String parentWindowHandle=Helper.switchToNewTab(driver, "//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]");  //From here control  has been moved to this TAB. ///here path is hard coded need to enhance the code.
				String product_name=Helper.RowTextActiveYes( driver,"//*[@id='DivQuickProduct']/table/tbody/tr/td[4]", "yes", "//*[@id='DivQuickProduct']/table/tbody/tr/td[2]");		
			    Helper.switchToMainWindow(driver, parentWindowHandle);
			 
			    
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
				Helper.ClickUsingLinkText(driver, EntityName);
			    Helper.intelligentSearch(driver,"txtGeneric", product_name, "//ul[@id='ui-id-1']/li");
			  String select_Process=  Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionProcess']/option", "Acidification[Acidification] [PH Value]");
			//String control_limit=  StartUpTempAndProcessMonitoringObject.getValueOfControlLimit_Check();   integer value is not returning Need to check this code.
			  String Control_Limit= StartUpTempAndProcessMonitoringObject.enterValueOfControlLimit("-2");
			String PH_Value= StartUpTempAndProcessMonitoringObject.enterValueInTemperature_Do("-2");
			Helper.pause(3);
			String TakeAction_textvalue=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionAction']/option", "No Action required");
			StartUpTempAndProcessMonitoringObject.DoneButton_ProcessCheckClick();
			Helper.pause(1);
			Helper.acceptAlert(driver);
			Helper.pause(2);
			
			
			StartUpTempAndProcessMonitoringObject.LeftMenuClick();
			SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
			SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
			SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
			Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
			entityTreeViewObject.ClickOnEntityTreeView();
			Helper.pause(3);
			GeneralInformationObject.ClickOnGeneralInformationTab();
			Helper.pause(1);
			foodSafetyManagementObject.ClickFoodSafetyManagement();
			Helper.pause(1);
			foodSafetyManagementObject.ClickProcessDetails();
			Helper.pause(1);
			Helper.scrollDownPage(driver,0, 600);
			Helper.pause(3);
			
			String select_ProcessFinalText=Helper.getStringFromStart(select_Process,"[");
			
			String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]//following::td[1]", select_ProcessFinalText);
			//System.err.println(print);
			Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(212, 237, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
			
			String lastAction_ActualText=foodSafetyManagementObject.getTextOflastActionField(driver, TakeAction_textvalue);
			Helper.compareTwoStringValues(lastAction_ActualText, TakeAction_textvalue);
			
				  }      					
				
				
	
				  
				  
				
				  
				
// EQUIPMENT TEST CASES
//======================================================================================================================				  
				
				
				       // @Test(description="Verify SelfInspection EquipmentCheck  Positive Case")
					public void SelfInspection_EquipmentCheck_01_PositiveCase() {

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();					
					StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
					StartUpTempAndProcessMonitoringObject.LeftMenuClick();
					StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
					String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
							
					String equpmentTextComplete=Helper.allDropDownValueOfSelectDropDown(driver, "ddlInspectionCallEquipmentEQUIP2", 1);
				
				     String textAfterRemove=  Helper.getStringAfterRemoveFrom(equpmentTextComplete, "[");
				     String Equipment_TextFinal=StartUpTempAndProcessMonitoringObject.getEquipmentText(textAfterRemove);
				     
				
				 String Equipment_Status=	Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionStatusEQUIP3']/option", "Clean");
				 
				 Helper.clearTextValueWithXpathAndEnterNewValue(driver,"//input[@id='eqpTempratureEQUIP6']","10");
				 				
				 String ActionRequired_text= Helper.selectDropDownByTextValue(driver, "//select[@id='ddlEqupmentActionEQUIP5']/option", "No action taken");
				 
				StartUpTempAndProcessMonitoringObject.DoneButton_EquipmentCheckClick();
				Helper.pause(2);
				Helper.acceptAlert(driver);												
				Helper.pause(3);
				
				
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.equipmentDetailsClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver,0, 800);
				Helper.pause(2);
				
				String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblEquipmentList']/tbody/tr/td[contains(text(),'{0}')]//following::td[3]", Equipment_TextFinal);
				Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(212, 237, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
				
				String ActionRequired_ActualValue=foodSafetyManagementObject.getTextOfActionRequiredInEquipment(driver, Equipment_TextFinal);	
				Helper.compareTwoStringValues(ActionRequired_ActualValue, ActionRequired_text);
				  
}
	
					
				       // @Test(description="Verify SelfInspection EquipmentCheck  Negative Case")
					public void SelfInspection_EquipmentCheck_02_NegativeCase() {

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();					
					StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
					StartUpTempAndProcessMonitoringObject.LeftMenuClick();
					StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
					String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
							
					String equpmentTextComplete=Helper.allDropDownValueOfSelectDropDown(driver, "ddlInspectionCallEquipmentEQUIP2", 1);
				
				     String textAfterRemove=  Helper.getStringAfterRemoveFrom(equpmentTextComplete, "[");
				     String Equipment_TextFinal=StartUpTempAndProcessMonitoringObject.getEquipmentText(textAfterRemove);
				     
				
				 String Equipment_Status=	Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionStatusEQUIP3']/option", "Visibility Dirty");
				 
				 Helper.clearTextValueWithXpathAndEnterNewValue(driver,"//input[@id='eqpTempratureEQUIP6']","50");
				 				
				 String ActionRequired_text= Helper.selectDropDownByTextValue(driver, "//select[@id='ddlEqupmentActionEQUIP5']/option", "Equipment for Maintenance");
				 
				StartUpTempAndProcessMonitoringObject.DoneButton_EquipmentCheckClick();
				Helper.pause(2);
				Helper.acceptAlert(driver);												
				Helper.pause(3);
				
				
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.equipmentDetailsClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver,0, 800);
				Helper.pause(2);
				
				String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblEquipmentList']/tbody/tr/td[contains(text(),'{0}')]//following::td[3]", Equipment_TextFinal);
				Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
				
				String ActionRequired_ActualValue=foodSafetyManagementObject.getTextOfActionRequiredInEquipment(driver, Equipment_TextFinal);	
				Helper.compareTwoStringValues(ActionRequired_ActualValue, ActionRequired_text);			
}
	
		    	
		    	
		    	

				       // @Test(description="Verify SelfInspection EquipmentCheck  Positive Case")
					public void SelfInspection_EquipmentCheck_03_PositiveCase() {

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();					
					StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
					StartUpTempAndProcessMonitoringObject.LeftMenuClick();
					StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
					String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
							
					String equpmentTextComplete=Helper.allDropDownValueOfSelectDropDown(driver, "ddlInspectionCallEquipmentEQUIP2", 1);
				
				     String textAfterRemove=  Helper.getStringAfterRemoveFrom(equpmentTextComplete, "[");
				     String Equipment_TextFinal=StartUpTempAndProcessMonitoringObject.getEquipmentText(textAfterRemove);
				     
				
				 String Equipment_Status=	Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionStatusEQUIP3']/option", "Calibrated");
				 
				 Helper.clearTextValueWithXpathAndEnterNewValue(driver,"//input[@id='eqpTempratureEQUIP6']","90");
				 				
				 String ActionRequired_text= Helper.selectDropDownByTextValue(driver, "//select[@id='ddlEqupmentActionEQUIP5']/option", "Sterilization");
				 
				StartUpTempAndProcessMonitoringObject.DoneButton_EquipmentCheckClick();
				Helper.pause(2);
				Helper.acceptAlert(driver);												
				Helper.pause(3);
				
				
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.equipmentDetailsClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver,0, 800);
				Helper.pause(2);
				
				String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblEquipmentList']/tbody/tr/td[contains(text(),'{0}')]//following::td[3]", Equipment_TextFinal);
				Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(212, 237, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
				
				String ActionRequired_ActualValue=foodSafetyManagementObject.getTextOfActionRequiredInEquipment(driver, Equipment_TextFinal);	
				Helper.compareTwoStringValues(ActionRequired_ActualValue, ActionRequired_text);	  
}	
		    	
		    	
		    	
		    	
		    	

				       // @Test(description="Verify SelfInspection EquipmentCheck  Negative Case")
					public void SelfInspection_EquipmentCheck_04_NegativeCase() {

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();					
					StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
					StartUpTempAndProcessMonitoringObject.LeftMenuClick();
					StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
					String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
							
					String equpmentTextComplete=Helper.allDropDownValueOfSelectDropDown(driver, "ddlInspectionCallEquipmentEQUIP2", 1);
				
				     String textAfterRemove= Helper.getStringAfterRemoveFrom(equpmentTextComplete, "[");
				     String Equipment_TextFinal=StartUpTempAndProcessMonitoringObject.getEquipmentText(textAfterRemove);
				     
				
				 String Equipment_Status=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionStatusEQUIP3']/option", "Not Working");
				 
				 Helper.clearTextValueWithXpathAndEnterNewValue(driver,"//input[@id='eqpTempratureEQUIP6']","10");
				 				
				 String ActionRequired_text= Helper.selectDropDownByTextValue(driver, "//select[@id='ddlEqupmentActionEQUIP5']/option", "Equipment for Maintenance");
				 
				StartUpTempAndProcessMonitoringObject.DoneButton_EquipmentCheckClick();
				Helper.pause(2);
				Helper.acceptAlert(driver);												
				Helper.pause(3);
				
				
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.equipmentDetailsClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver,0, 800);
				Helper.pause(2);
				
				String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblEquipmentList']/tbody/tr/td[contains(text(),'{0}')]//following::td[3]", Equipment_TextFinal);
				Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
				
				String ActionRequired_ActualValue=foodSafetyManagementObject.getTextOfActionRequiredInEquipment(driver, Equipment_TextFinal);	
				Helper.compareTwoStringValues(ActionRequired_ActualValue, ActionRequired_text);	  
}	
		    	
		    	
		    	
		    	
		    	
		    	
					  // @Test(description="Verify SelfInspection EquipmentCheck  Positive Case")
					public void SelfInspection_EquipmentCheck_05_PositiveCase() {

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();					
					StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
					StartUpTempAndProcessMonitoringObject.LeftMenuClick();
					StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
					String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
							
					String equpmentTextComplete=Helper.allDropDownValueOfSelectDropDown(driver, "ddlInspectionCallEquipmentEQUIP2", 1);
				
				     String textAfterRemove= Helper.getStringAfterRemoveFrom(equpmentTextComplete, "[");
				     String Equipment_TextFinal=StartUpTempAndProcessMonitoringObject.getEquipmentText(textAfterRemove);
				     
				
				 String Equipment_Status=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionStatusEQUIP3']/option", "Working Properly");
				 
				 Helper.clearTextValueWithXpathAndEnterNewValue(driver,"//input[@id='eqpTempratureEQUIP6']","50");
				 				
				 String ActionRequired_text= Helper.selectDropDownByTextValue(driver, "//select[@id='ddlEqupmentActionEQUIP5']/option", "No action taken");
				 
				StartUpTempAndProcessMonitoringObject.DoneButton_EquipmentCheckClick();
				Helper.pause(2);
				Helper.acceptAlert(driver);												
				Helper.pause(3);
				
				
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.equipmentDetailsClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver,0, 800);
				Helper.pause(2);
				
				String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblEquipmentList']/tbody/tr/td[contains(text(),'{0}')]//following::td[3]", Equipment_TextFinal);
				Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(212, 237, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
				
				String ActionRequired_ActualValue=foodSafetyManagementObject.getTextOfActionRequiredInEquipment(driver, Equipment_TextFinal);	
				Helper.compareTwoStringValues(ActionRequired_ActualValue, ActionRequired_text);	  
}	
		    	
		    	
		    	
		    	
		    	
		    	

					  // @Test(description="Verify SelfInspection EquipmentCheck  Positive Case")
					public void SelfInspection_EquipmentCheck_06_PositiveCase() {

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();					
					StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
					StartUpTempAndProcessMonitoringObject.LeftMenuClick();
					StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
					String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
							
					String equpmentTextComplete=Helper.allDropDownValueOfSelectDropDown(driver, "ddlInspectionCallEquipmentEQUIP2", 1);
				
				     String textAfterRemove= Helper.getStringAfterRemoveFrom(equpmentTextComplete, "[");
				     String Equipment_TextFinal=StartUpTempAndProcessMonitoringObject.getEquipmentText(textAfterRemove);
				     
				
				 String Equipment_Status=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionStatusEQUIP3']/option", "Clean & disinfected");
				 
				 Helper.clearTextValueWithXpathAndEnterNewValue(driver,"//input[@id='eqpTempratureEQUIP6']","50");
				 				
				 String ActionRequired_text= Helper.selectDropDownByTextValue(driver, "//select[@id='ddlEqupmentActionEQUIP5']/option", "Thermal Disinfection");
				 
				StartUpTempAndProcessMonitoringObject.DoneButton_EquipmentCheckClick();
				Helper.pause(2);
				Helper.acceptAlert(driver);												
				Helper.pause(3);
				
				
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.equipmentDetailsClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver,0, 800);
				Helper.pause(2);
				
				String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblEquipmentList']/tbody/tr/td[contains(text(),'{0}')]//following::td[3]", Equipment_TextFinal);
				Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(212, 237, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
				
				String ActionRequired_ActualValue=foodSafetyManagementObject.getTextOfActionRequiredInEquipment(driver, Equipment_TextFinal);	
				Helper.compareTwoStringValues(ActionRequired_ActualValue, ActionRequired_text);	  
}	    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	

					   //@Test(description="Verify SelfInspection EquipmentCheck  Positive Case")
					public void SelfInspection_EquipmentCheck_07_PositiveCase() {

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();					
					StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
					StartUpTempAndProcessMonitoringObject.LeftMenuClick();
					StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
					String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
							
					String equpmentTextComplete=Helper.allDropDownValueOfSelectDropDown(driver, "ddlInspectionCallEquipmentEQUIP2", 1);
				
				     String textAfterRemove= Helper.getStringAfterRemoveFrom(equpmentTextComplete, "[");
				     String Equipment_TextFinal=StartUpTempAndProcessMonitoringObject.getEquipmentText(textAfterRemove);
				     
				
				 String Equipment_Status=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionStatusEQUIP3']/option", "Right temperature");
				 
				 Helper.clearTextValueWithXpathAndEnterNewValue(driver,"//input[@id='eqpTempratureEQUIP6']","100");
				 				
				 String ActionRequired_text= Helper.selectDropDownByTextValue(driver, "//select[@id='ddlEqupmentActionEQUIP5']/option", "Chemical Disinfection");
				 
				StartUpTempAndProcessMonitoringObject.DoneButton_EquipmentCheckClick();
				Helper.pause(2);
				Helper.acceptAlert(driver);												
				Helper.pause(3);
				
				
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.equipmentDetailsClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver,0, 800);
				Helper.pause(2);
				
				String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblEquipmentList']/tbody/tr/td[contains(text(),'{0}')]//following::td[3]", Equipment_TextFinal);
				Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(212, 237, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
				
				String ActionRequired_ActualValue=foodSafetyManagementObject.getTextOfActionRequiredInEquipment(driver, Equipment_TextFinal);	
				Helper.compareTwoStringValues(ActionRequired_ActualValue, ActionRequired_text);	  
}	    	    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
					 //@Test(description="Verify SelfInspection EquipmentCheck  Negative Case")
					public void SelfInspection_EquipmentCheck_08_NegativeCase() {

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();					
					StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
					StartUpTempAndProcessMonitoringObject.LeftMenuClick();
					StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
					String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
							
					String equpmentTextComplete=Helper.allDropDownValueOfSelectDropDown(driver, "ddlInspectionCallEquipmentEQUIP2", 1);
				
				     String textAfterRemove= Helper.getStringAfterRemoveFrom(equpmentTextComplete, "[");
				     String Equipment_TextFinal=StartUpTempAndProcessMonitoringObject.getEquipmentText(textAfterRemove);
				     
				
				 String Equipment_Status=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionStatusEQUIP3']/option", "Wrong temperature");
				 
				 Helper.clearTextValueWithXpathAndEnterNewValue(driver,"//input[@id='eqpTempratureEQUIP6']","60");
				 				
				 String ActionRequired_text= Helper.selectDropDownByTextValue(driver, "//select[@id='ddlEqupmentActionEQUIP5']/option", "Equipment for Calibration");
				 
				StartUpTempAndProcessMonitoringObject.DoneButton_EquipmentCheckClick();
				Helper.pause(2);
				Helper.acceptAlert(driver);												
				Helper.pause(3);
				
				
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.equipmentDetailsClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver,0, 800);
				Helper.pause(2);
				
				String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblEquipmentList']/tbody/tr/td[contains(text(),'{0}')]//following::td[3]", Equipment_TextFinal);
				Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
				
				String ActionRequired_ActualValue=foodSafetyManagementObject.getTextOfActionRequiredInEquipment(driver, Equipment_TextFinal);	
				Helper.compareTwoStringValues(ActionRequired_ActualValue, ActionRequired_text);	  
}	    	    	
		    		
		    	
		    	
		    	
		    	
					 //@Test(description="Verify SelfInspection EquipmentCheck  Negative Case")
					public void SelfInspection_EquipmentCheck_09_NegativeCase() {

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();					
					StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
					StartUpTempAndProcessMonitoringObject.LeftMenuClick();
					StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
					String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
							
					String equpmentTextComplete=Helper.allDropDownValueOfSelectDropDown(driver, "ddlInspectionCallEquipmentEQUIP2", 1);
				
				     String textAfterRemove= Helper.getStringAfterRemoveFrom(equpmentTextComplete, "[");
				     String Equipment_TextFinal=StartUpTempAndProcessMonitoringObject.getEquipmentText(textAfterRemove);
				     
				
				 String Equipment_Status=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionStatusEQUIP3']/option", "Food Compromised");
				 
				 Helper.clearTextValueWithXpathAndEnterNewValue(driver,"//input[@id='eqpTempratureEQUIP6']","150");
				 				
				 String ActionRequired_text= Helper.selectDropDownByTextValue(driver, "//select[@id='ddlEqupmentActionEQUIP5']/option", "No action taken");
				 
				StartUpTempAndProcessMonitoringObject.DoneButton_EquipmentCheckClick();
				Helper.pause(2);
				Helper.acceptAlert(driver);												
				Helper.pause(3);
				
				
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.equipmentDetailsClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver,0, 800);
				Helper.pause(2);
				
				String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblEquipmentList']/tbody/tr/td[contains(text(),'{0}')]//following::td[3]", Equipment_TextFinal);
				Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
				
				String ActionRequired_ActualValue=foodSafetyManagementObject.getTextOfActionRequiredInEquipment(driver, Equipment_TextFinal);	
				Helper.compareTwoStringValues(ActionRequired_ActualValue, ActionRequired_text);	  
}	    	    	
					
					
					
					
					
					 //@Test(description="Verify SelfInspection EquipmentCheck  Negative Case")
					public void SelfInspection_EquipmentCheck_10_NegativeCase() {

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();					
					StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
					StartUpTempAndProcessMonitoringObject.LeftMenuClick();
					StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
					String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
							
					String equpmentTextComplete=Helper.allDropDownValueOfSelectDropDown(driver, "ddlInspectionCallEquipmentEQUIP2", 1);
				
				     String textAfterRemove= Helper.getStringAfterRemoveFrom(equpmentTextComplete, "[");
				     String Equipment_TextFinal=StartUpTempAndProcessMonitoringObject.getEquipmentText(textAfterRemove);
				     
				
				 String Equipment_Status=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionStatusEQUIP3']/option", "Poor Storage");
				 
				 Helper.clearTextValueWithXpathAndEnterNewValue(driver,"//input[@id='eqpTempratureEQUIP6']","200");
				 				
				 String ActionRequired_text= Helper.selectDropDownByTextValue(driver, "//select[@id='ddlEqupmentActionEQUIP5']/option", "Chemical Disinfection");
				 
				StartUpTempAndProcessMonitoringObject.DoneButton_EquipmentCheckClick();
				Helper.pause(2);
				Helper.acceptAlert(driver);												
				Helper.pause(3);
				
				
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.equipmentDetailsClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver,0, 800);
				Helper.pause(2);
				
				String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblEquipmentList']/tbody/tr/td[contains(text(),'{0}')]//following::td[3]", Equipment_TextFinal);
				Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
				
				String ActionRequired_ActualValue=foodSafetyManagementObject.getTextOfActionRequiredInEquipment(driver, Equipment_TextFinal);	
				Helper.compareTwoStringValues(ActionRequired_ActualValue, ActionRequired_text);	  
}	    	    			
					
					
					
					
					
					 @Test(description="Verify SelfInspection EquipmentCheck  Negative Case")
					public void SelfInspection_EquipmentCheck_11_NegativeCase() {

					loginScreen logpge = PageFactory.initElements(driver, loginScreen.class);
					logpge.Foodwatch_login(excel.readExcelDataString("login", 0, 0), excel.readExcelDataString("login", 0, 1));
					// driver.findElement(By.xpath("//button[@id='btnclosePopup']")).click();					
					StartUpTempAndProcessMonitoring StartUpTempAndProcessMonitoringObject = PageFactory.initElements(driver,StartUpTempAndProcessMonitoring.class);
					StartUpTempAndProcessMonitoringObject.LeftMenuClick();
					StartUpTempAndProcessMonitoringObject.mouseOverInspectionStartUpAndClick();
					String EntityName = StartUpTempAndProcessMonitoringObject.searchInspectionEntityinTableGrid("UNU");/// DYNAMIC
							
					String equpmentTextComplete=Helper.allDropDownValueOfSelectDropDown(driver, "ddlInspectionCallEquipmentEQUIP2", 1);
				
				     String textAfterRemove= Helper.getStringAfterRemoveFrom(equpmentTextComplete, "[");
				     String Equipment_TextFinal=StartUpTempAndProcessMonitoringObject.getEquipmentText(textAfterRemove);
				     	
				
				 String Equipment_Status=Helper.selectDropDownByTextValue(driver, "//select[@id='ddlInspectionStatusEQUIP3']/option", "Wrong placement");
				 
				 Helper.clearTextValueWithXpathAndEnterNewValue(driver,"//input[@id='eqpTempratureEQUIP6']","50");
				 				
				 String ActionRequired_text= Helper.selectDropDownByTextValue(driver, "//select[@id='ddlEqupmentActionEQUIP5']/option", "Equipment for Maintenance");
				 
				StartUpTempAndProcessMonitoringObject.DoneButton_EquipmentCheckClick();
				Helper.pause(2);
				Helper.acceptAlert(driver);												
				Helper.pause(3);	
				
				
				StartUpTempAndProcessMonitoringObject.LeftMenuClick();
				SearchOnEstablishNameAndLicenseNumber SearchOnEstablishNameAndLicenseNumberObject = PageFactory.initElements(driver, SearchOnEstablishNameAndLicenseNumber.class);
				SearchOnEstablishNameAndLicenseNumberObject.clickMyEntityLink();
				SearchOnEstablishNameAndLicenseNumberObject.enterValueInSearchField(EntityName); // need to check for dynamic
				SearchOnEstablishNameAndLicenseNumberObject.clickSearchButton();	
				Helper.ClickUsingLinkText(driver, EntityName); // need to check for dynamic
				entityTreeView entityTreeViewObject = PageFactory.initElements(driver, entityTreeView.class);
				entityTreeViewObject.ClickOnEntityTreeView();
				Helper.pause(3);
				GeneralInformation GeneralInformationObject = PageFactory.initElements(driver, GeneralInformation.class);
				GeneralInformationObject.ClickOnGeneralInformationTab();
				Helper.pause(1);
				foodSafetyManagement foodSafetyManagementObject = PageFactory.initElements(driver, foodSafetyManagement.class);
				foodSafetyManagementObject.ClickFoodSafetyManagement();
				Helper.pause(1);
				foodSafetyManagementObject.equipmentDetailsClick();
				Helper.pause(2);
				Helper.scrollDownPage(driver,0, 800);
				Helper.pause(2);
				
				String xpathOf_StatusField=Helper.dynamicXpath("//table[@id='tblEquipmentList']/tbody/tr/td[contains(text(),'{0}')]//following::td[3]", Equipment_TextFinal);
				Helper.CSSColorValueDynamicXpath(driver, xpathOf_StatusField, "rgba(248, 215, 218, 1)");   //+ve means green color=212, 237  //-ve mean red- 248,215
				
				String ActionRequired_ActualValue=foodSafetyManagementObject.getTextOfActionRequiredInEquipment(driver, Equipment_TextFinal);	
				Helper.compareTwoStringValues(ActionRequired_ActualValue, ActionRequired_text);	  
}	    	    				
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
	
	
	
}
