package POM_EntityTreeView;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import resources.Helper;

public class foodSafetyManagement {

	public WebDriver driver;

	public foodSafetyManagement(WebDriver sdriver) {
		this.driver = sdriver;
	}
	

	@FindBy(how=How.XPATH,using="//*[@id='accordion']/div[4]/div[1]/h4/span")
	WebElement foodSafetyManagementMain;
	
	
	
	//Food Details
	//=====================================================================
			
	@FindBy(how=How.XPATH,using="//div[@id='foodProduct_accordionId']/h4/a")
	WebElement foodDetails;
	
	//Quick Upload TAB
	@FindBy(how=How.XPATH,using="//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[1]")                    //Quick Upload button
	WebElement quickUploadButton; 
	@FindBy(how=How.XPATH,using="//input[@id='txtBrandProduct']")
	WebElement nameOfYourProduct;
	@FindBy(how=How.XPATH,using="//input[@id='searchbox']")
	WebElement supplierSearchTextBox;
	@FindBy(how=How.XPATH,using="//button[@id='SearchButton']")
	WebElement supplierSearchButton;
	//This xpath is not correct. It locate only all the search result.But selenium clicks only the 1st result.
	@FindBy(how=How.XPATH,using="//table[@id='tbllandingpageUrl']/tbody/tr")             
	WebElement popUpMsgFirstElementXpath;
	@FindBy(how=How.XPATH,using="//input[@id='chkbox']")
	WebElement checkBox;                                              //Tick Checkbox if this Product is Produce By Yourself
	@FindBy(how=How.XPATH,using="//input[@id='btnAdd']")
	WebElement addButton;
	@FindBy(how=How.XPATH,using="//a[@id='imgBtnMaterialAdd_136649']")
	WebElement actionSaveButton;
	@FindBy(how=How.XPATH,using="//input[@id='btnNextProduct']")
	WebElement nextProduct;
	@FindBy(how=How.XPATH,using="//input[@id='txtsearch']")
	WebElement searchProductName;
	@FindBy(how=How.XPATH,using="//*[@id='btnGo']")
	WebElement goButton;
	
	
	  //Add Client button screen
	@FindBy(how=How.XPATH,using="//div[@id='collapse6']/div/div[1]/div[2]/div/div[1]/a[2]")                   //Add Client button
	WebElement addClientButton;
	@FindBy(how=How.XPATH,using="//input[@id='txtsearch']")
	WebElement searchClientInFoodwatch;
	@FindBy(how=How.XPATH,using="//input[@id='btnAddToConnect']")
	WebElement addToConnect;
	@FindBy(how=How.XPATH,using="//input[@class='form-control input-sm']")
	WebElement search;
	
	
	//Food details table grid
	@FindBy(how=How.XPATH,using="//input[@class='form-control input-sm']")
	WebElement searchFoodDetails;
	@FindBy(how=How.XPATH,using="//*[@id=\"tblProductList\"]/tbody/tr[1]/td[10]/a[1]/div")
	WebElement actionsProductEdit;
	
	
	///Edit product screen in new TAB
	@FindBy(how=How.XPATH,using="//input[@id='ProductName']")
	WebElement yourFoodProductName;
	@FindBy(how=How.XPATH,using="//input[@id='FoodName']")
	WebElement searchByNamesOrBarcode;
	@FindBy(how=How.XPATH,using="//input[@id='chkYes']")
	WebElement yesRadioButtonAddaClaim;
	@FindBy(how=How.XPATH,using="//input[@id='chkNo']")
	WebElement noRadioButtonAddaClaim;
	@FindBy(how=How.XPATH,using="//select[@id='ProcessingType']")
	WebElement typeOfProcessingDP;
	@FindBy(how=How.XPATH,using="//select[@id='PreparationMethod']")
	WebElement preparationMethodDP;
	@FindBy(how=How.XPATH,using="//select[@id='PackagingInfo']")
	WebElement packagingInformationDP;
	@FindBy(how=How.XPATH,using="//input[@id='Remarks']")
	WebElement otherRemarks;
	@FindBy(how=How.XPATH,using="//select[@id='ServingSize']")
	WebElement servingSizeUnitDP;	
	@FindBy(how=How.XPATH,using="//input[@id='GramWght']")
	WebElement gramWeightPerServing;	
	@FindBy(how=How.XPATH,using="//input[@id='txtCaloriesPS']")
	WebElement caloriesPerServing;
	@FindBy(how=How.XPATH,using="//input[@id='btnAddingProduct']")
	WebElement finishEditingThisProduct;
	@FindBy(how=How.XPATH,using="//*[@id='tblProductList']/tbody/tr[1]/td[10]/a[3]/span")
	WebElement deleteButton;
	
	
	
	
	
	//Meal Times
    //=======================================================================================================
	
	@FindBy(how=How.XPATH,using="//*[@id='collapse6']/div/div[2]/div[1]/h4")
	WebElement mealTimes;
	
	@FindBy(how=How.XPATH,using="//div[@id='editMealtimes']/div/div[1]/a")
	WebElement addMealTime;
	
	//Add meal time sceen
	@FindBy(how=How.XPATH,using="//select[@id='OfferedMealPeriodId']")
	WebElement mealType;
	@FindBy(how=How.XPATH,using="//input[@id='NumberOfMeals']")
	WebElement numberOfMeals;
	@FindBy(how=How.XPATH,using="//input[@type='submit']") 
	WebElement addButtonMeal;
	@FindBy(how=How.XPATH,using="//table[@id='tblMeals']/tbody/tr[1]/td[5]/input")
	WebElement delete1stRecord; 
	@FindBy(how=How.XPATH,using="//input[@id='btnDoneclose']")
	WebElement doneButton;
		
	
	
	//Food Preparation Area
	//=======================================================================================================
	@FindBy(how=How.XPATH,using="//div[@id='foodarea_accordionId']/h4/a")
	WebElement foodPreparationAreaMain;
	
	@FindBy(how=How.XPATH,using="//div[@id='partial_FoodAreaSection']/div[1]/a[1]")
	WebElement addFoodPreparationAreaButton;
	@FindBy(how=How.XPATH,using="//div[@id='partial_FoodAreaSection']/div[1]/a[2]")
	WebElement viewFoodPreAreaInspectionHistory;
	
	@FindBy(how=How.XPATH,using="//table[@id='tblFoodPreparationAreaEdit']/tbody/tr[1]/td[4]")
	WebElement Status_1stRow;
	
	
    // Add food preparation area screen in new tab
	@FindBy(how=How.XPATH,using="//select[@id='PreparationAreaId']")
	WebElement foodPreparationAreaDP;
	@FindBy(how=How.XPATH,using="//input[@id='SubArea']")
	WebElement subArea;  
	@FindBy(how=How.XPATH,using="//input[@id='btnAddNewSubArea']")
	WebElement addMore;
	@FindBy(how=How.XPATH,using="//input[@id='txtSubArea_1']")
	WebElement newTextFieldComngAfterClickngAddMore;
	@FindBy(how=How.XPATH,using="//input[@id='AreaInSqFt']")
	WebElement areaInSqFt;
	@FindBy(how=How.XPATH,using="//textarea[@id='FreeDescription']")
	WebElement description;
	@FindBy(how=How.XPATH,using="//input[@id='Picture']")
	WebElement chooseFile;
	@FindBy(how=How.XPATH,using="//input[@id='btnSumbit']")
	WebElement add;
	@FindBy(how=How.XPATH,using="//input[@id='btnDoneclose']")
	WebElement done;
	
	
	//Process Details
	//===================================================================================
	
	@FindBy(how=How.XPATH,using="//div[@id='process_accordionId']/h4/a")
	WebElement ProcessDetails;
	@FindBy(how=How.XPATH,using="//div[@id='partial_ProcessSection']/div[1]/a")
	WebElement viewProcessInspectionHistory;
	@FindBy(how=How.XPATH,using="//table[@id='tblProcessEdit']/tbody/tr[1]/td[6]/a")
	WebElement clickToView1stLink;
	@FindBy(how=How.XPATH,using="//*[@id='tblProcessEdit']/tbody/tr[2]/td[6]/a")
	WebElement clickToView2stLink;
	
	
	
	//Food From Other Premises
    //===================================================================================
	@FindBy(how=How.XPATH,using="//*[@id='collapse6']/div/div[5]/div/h4/a")
	WebElement foodFromOtherPremisesMain;
	@FindBy(how=How.XPATH,using="//*[@id='tblNewfoodfromotherpremisesAdded']/tbody/tr/td[10]/div/img")
	WebElement filePath;
	@FindBy(how=How.XPATH,using="//*[@id=\"tblNewfoodfromotherpremisesAdded\"]/tbody/tr/td[11]/a[2]/span")
	WebElement actionCancel;
	@FindBy(how=How.XPATH,using="//*[@id=\"tblNewfoodfromotherpremisesAdded\"]/tbody/tr/td[11]/a[1]/span")
	WebElement actionEdit;
	
	//Action Edit screen
	//--------------------------------------------------------------------------
	@FindBy(how=How.XPATH,using="//*[@id='EntityNameSearch']")
	WebElement searchEntityNameORLicenseNo;
	@FindBy(how=How.XPATH,using="//*[@id='FoodItem']")
	WebElement foodItemEdit;
	@FindBy(how=How.XPATH,using="//*[@id='AmountPortions']")
	WebElement foodPortionsEdit;
	@FindBy(how=How.XPATH,using="//*[@id='Quantity']")
	WebElement quantityEdit;
	@FindBy(how=How.XPATH,using="//*[@id='Temperature']")
	WebElement temperatureEdit;
	@FindBy(how=How.XPATH,using="//*[@id='Vehicle']")
	WebElement vehicleEdit;
	@FindBy(how=How.XPATH,using="//*[@id='Timing']")
	WebElement timingOfDeliveryFoodFromOtherPremises;
	@FindBy(how=How.XPATH,using="//*[@id='filepathFoodHandlerNew']")
	WebElement chooseFileEdit;
	@FindBy(how=How.XPATH,using="//*[@id='SubmitMealPerday']")
	WebElement saveButton;
	@FindBy(how=How.XPATH,using="//*[@class='btn btn-default btn-primary']")
	WebElement cancelButton;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"editFoodpremises\"]/div/div[1]/a")
	WebElement addFoodFromOtherPremisesButton;
	
	//Add food from other premises new tab screen
	//------------------------------------------------
	@FindBy(how=How.XPATH,using="//*[@id='EntityNameSearch']")
	WebElement searchEntityNameorLicenseNo;
	@FindBy(how=How.XPATH,using="//*[@id='FoodItem']")
	WebElement foodItem;
	@FindBy(how=How.XPATH,using="//*[@id='AmountPortions']")
	WebElement foodPortions;
	@FindBy(how=How.XPATH,using="//*[@id='Quantity']")
	WebElement quantity;
	@FindBy(how=How.XPATH,using="//*[@id='Temperature']")
	WebElement temperature;
	@FindBy(how=How.XPATH,using="//*[@id='Vehicle']")
	WebElement vehicle;
	@FindBy(how=How.XPATH,using="//*[@id='Timing']")
	WebElement timingOfDelivery;
	@FindBy(how=How.XPATH,using="//*[@id='filepathFoodHandlerNew']")
	WebElement chooseFileAddFoodFromOtherPremises;
	@FindBy(how=How.XPATH,using="//*[@value='Add']")
	WebElement addButtonFoodFromOtherPremises;
	@FindBy(how=How.XPATH,using="//*[@id='tblFoodPremises']/tbody/tr[1]/td[10]/input")
	WebElement deleteButton1st;
	@FindBy(how=How.XPATH,using="//*[@id='tblFoodPremises']/tbody/tr[2]/td[10]/input")
	WebElement deleteButton2st;
	@FindBy(how=How.XPATH,using="//*[@id='btnDoneclose']")
	WebElement doneButtonAddFoodFromOtherPremises;
	
	
	
	
	// Food Transportation Vehicles
	//================================================================================
	
	@FindBy(how=How.XPATH,using="//*[@id='collapse6']/div/div[6]/div[1]/h4/a")
	WebElement foodTransportationVehiclesMain;	
	@FindBy(how=How.XPATH,using="//*[@id='editVehicles']/div/div[1]/a[2]")
	WebElement viewInspectionHistory;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='editVehicles']/div/div[1]/a[1]")
	WebElement addVehicle;
	//Add Vehicle screen in new tab
	//----------------------------------------
	@FindBy(how=How.XPATH,using="//*[@id='TypeOfOwnershipId']")
	WebElement typeOfOwnership;
	@FindBy(how=How.XPATH,using="//*[@id='VehicleManufacturarId']")
	WebElement vehicleManufecturer;
	@FindBy(how=How.XPATH,using="//*[@id='VehicleId']")
	WebElement plateNumber;
	@FindBy(how=How.XPATH,using="//*[@id='ChasisNumber']")
	WebElement chasisNumber;
	@FindBy(how=How.XPATH,using="//*[@id='YearOfManufacture']")
	WebElement yearOfManufecturer;

	@FindBy(how=How.XPATH,using="//*/div[1]/div[9]/input[1]")
	WebElement chillerRadioButton;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfVehicleId'][2]")
	WebElement combiRadioButton;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfVehicleId'][3]")
	WebElement dryFoodRadioButton;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfVehicleId'][4]")
	WebElement freezerRadioButton;
	@FindBy(how=How.XPATH,using="//*[@id='NatureOfVehicleId'][5]")
	WebElement hotFoodRadioButton;
	
	@FindBy(how=How.XPATH,using="//*[@id='EntityVehicalFoodTransportType']/option[1]")
	WebElement ChilledandFrozenFoodInDifferentCabinets;
	@FindBy(how=How.XPATH,using="//*[@id='EntityVehicalFoodTransportType']/option[2]")
	WebElement ChilledandRoomTemperatureinSeparateCabinets;
	@FindBy(how=How.XPATH,using="//*[@id='EntityVehicalFoodTransportType']/option[3]")
	WebElement chilledFood_0Deg_3C;
	@FindBy(how=How.XPATH,using="//*[@id='EntityVehicalFoodTransportType']/option[4]")
	WebElement chilledFood_5Deg_C;
	@FindBy(how=How.XPATH,using="//*[@id='EntityVehicalFoodTransportType']/option[5]")
	WebElement freezer_minus12DegORBelow;
	@FindBy(how=How.XPATH,using="//*[@id='EntityVehicalFoodTransportType']/option[6]")
	WebElement freezer_minus18DegORBelow;
	@FindBy(how=How.XPATH,using="//*[@id='EntityVehicalFoodTransportType']/option[7]")
	WebElement hotFood;
	@FindBy(how=How.XPATH,using="//*[@id='EntityVehicalFoodTransportType']/option[8]")
	WebElement noTemperatureControl;
	@FindBy(how=How.XPATH,using="//*[@id='EntityVehicalFoodTransportType']/option[9]")
	WebElement roomTemperature_30DegORBelow;
	@FindBy(how=How.XPATH,using="//*[@id='EntityVehicalFoodTransportType']/option[10]")
	WebElement roomTemperature_forInsulatedBoxes;
	
	@FindBy(how=How.XPATH,using="//*[@id='ImageUrl']")
	WebElement chooseFileAddVehicle;
	@FindBy(how=How.XPATH,using="//*[@id='Remark']")
	WebElement remarkAddVehicle;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddVehicleToGrid']")
	WebElement addButton_AddVehicle;
	@FindBy(how=How.XPATH,using="//*[@id='btnDoneclose']")
	WebElement doneButton_AddVehicle;
	@FindBy(how=How.XPATH,using="//*[@id='tblEntityVehicle']/tbody/tr[1]/td[10]/input")
	WebElement delete_addVehicle1stRecord;
	@FindBy(how=How.XPATH,using="//*[@id='tblEntityVehicle']/tbody/tr[2]/td[10]/input")
	WebElement delete_addVehicle2stRecord;
	
	// Did not write xpath for Action Edit button screen
	
	
	
	// Equipment Details
	//=================================================================================================
	@FindBy(how=How.XPATH,using="//*[@id='collapse6']/div/div[7]/div[1]/h4/a")
	WebElement equipmentDetailsMain;
	
	@FindBy(how=How.XPATH,using="//*[@id='partial_EquipmentSection']/div[1]/a[1]")
	WebElement addEquipmentButton;
	@FindBy(how=How.XPATH,using="//*[@id='partial_EquipmentSection']/div[1]/a[2]")
	WebElement viewEquipmentInspectionHistoryButton;
	@FindBy(how=How.XPATH,using="//*[@id='tblEquipmentList']/tbody/tr[1]/td[8]/a[1]")
	WebElement cancelButtonUnderAction;
	@FindBy(how=How.XPATH,using="//*[@id='tblEquipmentList']/tbody/tr[1]/td[8]/a[2]")
	WebElement editButtonUnderAction;
	
	
	//Add Equipment screen coming in new Tab
	//-----------------------------------------------
	@FindBy(how=How.XPATH,using="//*[@id='Equipment']")
	WebElement Equipment;
	
	@FindBy(how=How.XPATH,using="//*[@id='btnSupplierList']")
	WebElement equipmentAuthorizedSuppliersList;
	
	@FindBy(how=How.XPATH,using="//*[@name='EquipmentLabel']")
	WebElement equipmentLabel;
	@FindBy(how=How.XPATH,using="//*[@name='ddlPreparationArea']")
	WebElement preparationAreaDropDown;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddEquipment']")
	WebElement addButtonAddEquipment;
	@FindBy(how=How.XPATH,using="//*[@id='btnDoneclose']")
	WebElement closeButton;
	
	
	
	
	//========================================================================================================
	
	
	
	
	public void ClickFoodSafetyManagement() {
		foodSafetyManagementMain.click();	
	}
	
	public void ClickFoodPreparationArea() {
		foodPreparationAreaMain.click();
	}
	
	public void ClickfoodDetails() {
		foodDetails.click();
	}
	
	public void ClickquickUploadButton() {
		quickUploadButton.click();
	}
	
	public void ClickaddClientButton() {
		addClientButton.click();
	}
	

	public void ClickProcessDetails() {
		ProcessDetails.click();
	}
	
	
	public String getTextOflastActionField(WebDriver driver,String TakeAction_textvalue) {
		
		String xpathOfLastAction=Helper.dynamicXpath("//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'{0}')]", TakeAction_textvalue);
		return driver.findElement(By.xpath(xpathOfLastAction)).getText();
		
		
	}
	
	
	
	//Equipment Detail
	//===========================================================
	
    public void equipmentDetailsClick() {
    	equipmentDetailsMain.click();
    	
    }
	
public String getTextOfActionRequiredInEquipment(WebDriver driver,String Equipment_TextFinal) {
		
		String xpathOfLastAction=Helper.dynamicXpath("//table[@id='tblEquipmentList']/tbody/tr/td[contains(text(),'{0}')]//following::td[4]", Equipment_TextFinal);
		return driver.findElement(By.xpath(xpathOfLastAction)).getText();
		
		
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
public void VerifyProcessDetailsColor() {
		
		Helper.CSSColorValue(driver,"//table[@id='tblFoodPreparationAreaEdit']/tbody/tr[1]/td[4]","rgba(248, 215, 218, 1)");
	}	
	
	
	
	
public void VerifyFoodAreaColor() {
		
		Helper.CSSColorValue(driver,"//table[@id='tblFoodPreparationAreaEdit']/tbody/tr[1]/td[4]","rgba(248, 215, 218, 1)");
	}
	
	
public void VerifyFoodAreaColor2ndDropDown() {
	
	Helper.CSSColorValue(driver,"//table[@id='tblFoodPreparationAreaEdit']/tbody/tr[2]/td[4]","rgba(248, 215, 218, 1)");
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
