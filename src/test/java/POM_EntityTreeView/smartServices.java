package POM_EntityTreeView;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class smartServices {
WebDriver driver;

	public smartServices(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	//smart services
		@FindBy(how=How.XPATH,using="//*[@id='divSmartPermits']/div[1]/h4/a")
		WebElement smartServicesMain;
		
		
		
		//Smart Permits
		@FindBy(how=How.XPATH,using="//*[@id='smartPermit_accordionId']/h4/a")
		WebElement smartPermit;
		
		
		@FindBy(how=How.XPATH,using="//input[@id='btnTemporaryPermit']")         //Approvals and Permits button
		WebElement approvalsAndPermits;
		
		
		//APPROVALS and PERMITS:--
		
		//Approval of Internal Training center/Consultancy
	
		@FindBy(how=How.XPATH,using="//input[@id='btnCancelTempPermitRequest']")            //CANCEL REQUEST button
		WebElement cancelRequestButton_internalTraining;
		@FindBy(how=How.XPATH,using="//input[@id='btnSaveTempPermitRequest']")              //SEND REQUEST button
		WebElement sendRequestButton_internalTraining;
		
		
		//Approval of External Training center/Consultancy
		@FindBy(how=How.XPATH,using="//select[@id='EntityBusinessActivityId']")
		WebElement typeOfPermitDropdownAE;
		@FindBy(how=How.XPATH,using="//select[@id='TechUserId']")
		WebElement technicalExpertDrpDownAE;
		@FindBy(how=How.XPATH,using="//input[@id='btnCancelTempPermitRequest']")            //CANCEL REQUEST button
		WebElement cancelRequestButtonAE;
		@FindBy(how=How.XPATH,using="//input[@id='btnSaveTempPermitRequest']")              //SEND REQUEST button
		WebElement sendRequestButtonAE;
		
		
		
		
		//approval of food safety Trainer-Internal
		@FindBy(how=How.XPATH,using="//select[@id='EntityBusinessActivityId']")
		WebElement typeOfPermitDropdownTI;
		@FindBy(how=How.XPATH,using="//select[@id='TechUserId']")
		WebElement technicalExpertDrpDownTI;
		@FindBy(how=How.XPATH,using="//select[@id='ddlTypeOfApproval']")                     //type of approval drop down
		WebElement typeOfApprovalDrpDownTI;
		@FindBy(how=How.XPATH,using="//select[@id='ddlTypeOfApproval']")                      //Select legal Permits     
		WebElement selectLegalPermitTI;
		@FindBy(how=How.XPATH,using="//button[@id='btnAddLegalPermits']")                      // add button    
		WebElement addButtonTI;
		@FindBy(how=How.XPATH,using="//input[@id='btnCancelTempPermitRequest']")            //CANCEL REQUEST button
		WebElement cancelRequestButtonTI;
		@FindBy(how=How.XPATH,using="//input[@id='btnSaveTempPermitRequest']")              //SEND REQUEST button
		WebElement sendRequestButtonTI;
		
		//approval of food safety Trainer-External
		@FindBy(how=How.XPATH,using="//select[@id='EntityBusinessActivityId']")
		WebElement typeOfPermitDropdownTE;
		@FindBy(how=How.XPATH,using="//select[@id='TechUserId']")
		WebElement technicalExpertDrpDownTE;
		@FindBy(how=How.XPATH,using="//select[@id='ddlTypeOfApproval']")                     //type of approval drop down
		WebElement typeOfApprovalDrpDownTE;
		@FindBy(how=How.XPATH,using="//select[@id='ddlTypeOfApproval']")                      //Select legal Permits     
		WebElement selectLegalPermitTE;
		@FindBy(how=How.XPATH,using="//button[@id='btnAddLegalPermits']")                      // add button    
		WebElement addButtonTE;
		@FindBy(how=How.XPATH,using="//input[@id='btnCancelTempPermitRequest']")            //CANCEL REQUEST button
		WebElement cancelRequestButtonTE;
		@FindBy(how=How.XPATH,using="//input[@id='btnSaveTempPermitRequest']")              //SEND REQUEST button
		WebElement sendRequestButtonTE;
		
		
		
		
		
		//Food Activity at Events
		@FindBy(how=How.XPATH,using="//select[@id='EntityBusinessActivityId']")
		WebElement typeOfPermitDropdownEvents;
		@FindBy(how=How.XPATH,using="//input[@id='StartDate']")                            //start date
		WebElement startDate;
		@FindBy(how=How.XPATH,using="//input[@id='EndDate']")                           //end date
		WebElement endDate;
		@FindBy(how=How.XPATH,using="//input[@id='EventName']")                          //event name
		WebElement eventName;
		@FindBy(how=How.XPATH,using="//input[@id='LocationFE']")                          //event location
		WebElement eventLocation;
		@FindBy(how=How.XPATH,using="//input[@id='radio1']")                          // Radio button- Yes(Do you have an event permit from DTCM?)
		WebElement yesButtonRadio;
		@FindBy(how=How.XPATH,using="//input[@id='radio2']")                          //Radio button- No(Do you have an event permit from DTCM?)
		WebElement noButtonRadio;
		
		//upload documents
		@FindBy(how=How.XPATH,using="//input[@type='file']")                         
		WebElement chooseFile1;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile2']")                         
		WebElement chooseFile2;                                                   //Upload File are same for all Permits
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile3']")                         
		WebElement chooseFile3;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile4']")                         
		WebElement chooseFile4;
		@FindBy(how=How.XPATH,using="//select[@id='TypeOfFoodBusiness']")                 //type of food business drop down         
		WebElement typeOfFoodBusiness;
		@FindBy(how=How.XPATH,using="//input[@id='radio5']")                         //yes radio button (Is there an accessible handwashing facility within 20 Meters?)
		WebElement yesRadioButton_isHandwashingFacilitywithin20Meter;
		@FindBy(how=How.XPATH,using="//input[@id='radio6']")                         //no radio button (Is there an accessible handwashing facility within 20 Meters?)
		WebElement noRadioButton_isHandwashingFacilitywithin20Meter;
		@FindBy(how=How.XPATH,using="//input[@id='Uploadfloorplan']")                 //upload file--upload floor plan        
		WebElement uploadFloorPlan;
		@FindBy(how=How.XPATH,using="//input[@id='Notes']")                            //notes text field
		WebElement notes;
		@FindBy(how=How.XPATH,using="//input[@id='btnCancelTempPermitRequest']")            //CANCEL REQUEST button
		WebElement cancelRequestButtoneEvents;
		@FindBy(how=How.XPATH,using="//input[@id='btnSaveTempPermitRequest']")              //SEND REQUEST button
		WebElement sendRequestButtonEvents;
		
		@FindBy(how=How.XPATH,using="//input[@id='TotalFloorAreaSqFt']")             
		WebElement TotalFloorAreaInSqFt;
		@FindBy(how=How.XPATH,using="//button[@id='btnAddApplicableProcesses']")             
		WebElement addButton;
		@FindBy(how=How.XPATH,using="//input[@id='radio3']")             
		WebElement IsReadToEatFoodBroughtFromEstablishmentYES;
		@FindBy(how=How.XPATH,using="//input[@id='NoOfStaffInFoodPrepArea']")             
		WebElement NumberOfStaffInFoodPreparationArea;
		
		
		
		//Non-Halal Food Activity
		@FindBy(how=How.XPATH,using="//select[@id='EntityBusinessActivityId']")
		WebElement typeOfPermitDropdownEventsNH;
		@FindBy(how=How.XPATH,using="//input[@id='StartDate']")                            //start date
		WebElement startDateNH;
		@FindBy(how=How.XPATH,using="//input[@id='EndDate']")                           //end date
		WebElement endDateNH;
		@FindBy(how=How.XPATH,using="//select[@id='NonHalalBusinessType']")                 //Type of Food Business        
		WebElement typeOfFoodBusinessNonHalal;
		@FindBy(how=How.XPATH,using="//input[@id='TotalfoodareainSqFt']")                                                     
		WebElement totalFoodAreaInSqFt;
		@FindBy(how=How.XPATH,using="//input[@id='TotalareaforNonHalalfoodinsqFt']")                         
		WebElement totalAreaNonHalalFoodInSqFt;
		@FindBy(how=How.XPATH,using="//select[@id='ddlTypeOfOperation']")                         
		WebElement typeOfOperation;
		
		@FindBy(how=How.XPATH,using="//button[@id='btnAddTypeOfOperation']")                  //Add button of Non Halal Food activity
		WebElement addButtonNonHalal;
		@FindBy(how=How.XPATH,using="//select[@id='ddlTypeOfApproval']")
		WebElement typeOfApproval;
		//upload documents
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile1']")                         
		WebElement chooseFile1NH;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile2']")                         
		WebElement chooseFile2NH;                                                   //Upload File are same for all Permits
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile3']")                         
		WebElement chooseFile3NH;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile4']")                         
		WebElement chooseFile4NH;
		@FindBy(how=How.XPATH,using="//input[@id='btnCancelTempPermitRequest']")            //CANCEL REQUEST button
		WebElement cancelRequestButtoneNH;
		@FindBy(how=How.XPATH,using="//input[@id='btnSaveTempPermitRequest']")              //SEND REQUEST button
		WebElement sendRequestButtonNH;
		
		
		
		
		
		//School Supply Permit
		@FindBy(how=How.XPATH,using="//select[@id='EntityBusinessActivityId']")
		WebElement typeOfPermitDropdownEventsSchool;
		@FindBy(how=How.XPATH,using="//input[@id='StartDate']")                            //start date
		WebElement startDateSchool;
		@FindBy(how=How.XPATH,using="//input[@id='EndDate']")                           //end date
		WebElement endDateSchool;
		@FindBy(how=How.XPATH,using="//input[@id='LocationSN']")
		WebElement schoolName;  
		//upload documents
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile1']")                         
		WebElement chooseFile1School;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile2']")                         
		WebElement chooseFile2School;                                                   //Upload File are same for all Permits
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile3']")                         
		WebElement chooseFile3School;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile4']")                         
		WebElement chooseFile4School;
		@FindBy(how=How.XPATH,using="//input[@id='Remarks']")  
		WebElement remarks;
		@FindBy(how=How.XPATH,using="//input[@id='btnCancelTempPermitRequest']")            //CANCEL REQUEST button
		WebElement cancelRequestButtoneSchool;
		@FindBy(how=How.XPATH,using="//input[@id='btnSaveTempPermitRequest']")              //SEND REQUEST button
		WebElement sendRequestButtonSchool;
		
		
		//Vending Machine
		@FindBy(how=How.XPATH,using="//select[@id='EntityBusinessActivityId']")
		WebElement typeOfPermitDropdownEventsVending;
		@FindBy(how=How.XPATH,using="//input[@id='StartDate']")                            //start date
		WebElement startDateVending;
		@FindBy(how=How.XPATH,using="//input[@id='EndDate']")                           //end date
		WebElement endDateVending;
		@FindBy(how=How.XPATH,using="//input[@id='entityLocation']")
		WebElement machineLocationRadioButton;
		@FindBy(how=How.XPATH,using="//input[@id='mapLocation']")
		WebElement chooseLocationFromMapRadioButton;
		@FindBy(how=How.XPATH,using="//input[@id='LocationVM']")
		WebElement machineLocation;
		//upload files
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile1']")                         
		WebElement chooseFile1Vending;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile2']")                         
		WebElement chooseFile2Vending;                                                   //Upload File are same for all Permits
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile3']")                         
		WebElement chooseFile3Vending;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile4']")                         
		WebElement chooseFile4Vending;
		@FindBy(how=How.XPATH,using="//input[@id='Remarks']")  
		WebElement remarksVending;
		@FindBy(how=How.XPATH,using="//input[@id='btnCancelTempPermitRequest']")            //CANCEL REQUEST button
		WebElement cancelRequestButtoneVending;
		@FindBy(how=How.XPATH,using="//input[@id='btnSaveTempPermitRequest']")              //SEND REQUEST button
		WebElement sendRequestButtonVending;
		
		
		//Food Promotion Permit
		@FindBy(how=How.XPATH,using="//select[@id='EntityBusinessActivityId']")
		WebElement typeOfPermitDropdownEventsPromotion;
		@FindBy(how=How.XPATH,using="//input[@id='StartDate']")                            //start date
		WebElement startDatePromotion;
		@FindBy(how=How.XPATH,using="//input[@id='EndDate']")                           //end date
		WebElement endDatePromotion;
		@FindBy(how=How.XPATH,using="//input[@id='FoodName']")
		WebElement foodItems;
		@FindBy(how=How.XPATH,using="//input[@id='btnAddFood']")
		WebElement addButonFoodItem;
		@FindBy(how=How.XPATH,using="//input[@id='LocationFPP']")
		WebElement addLocations;
		@FindBy(how=How.XPATH,using="//input[@id='btnAddLocation']")
		WebElement addButtonAddLocations ;
		@FindBy(how=How.XPATH,using="//input[@id='btnCancelTempPermitRequest']")            //CANCEL REQUEST button
		WebElement cancelRequestButtonePromotion;
		@FindBy(how=How.XPATH,using="//input[@id='btnSaveTempPermitRequest']")              //SEND REQUEST button
		WebElement sendRequestButtonPromotion;
		
		
		
		//Temporary permit for changes related to food label/packages
		@FindBy(how=How.XPATH,using="//select[@id='EntityBusinessActivityId']")
		WebElement typeOfPermitDropdownEventsTemporary;
		@FindBy(how=How.XPATH,using="//input[@id='FoodName']")
		WebElement foodItemsTempPermit;
		@FindBy(how=How.XPATH,using="//input[@id='btnAddFood']")
		WebElement addButtonTempPermit; 
		//upload files
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile1']")                         
		WebElement chooseFile1Temporary;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile2']")                         
		WebElement chooseFile2Temporary;                                                   //Upload File are same for all Permits
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile3']")                         
		WebElement chooseFile3Temporary;
		@FindBy(how=How.XPATH,using="//input[@id='PermittedChanges']")
		WebElement reqChanges;
		@FindBy(how=How.XPATH,using="//input[@id='Remarks']")  
		WebElement remarksTemporary;
		@FindBy(how=How.XPATH,using="//input[@id='btnCancelTempPermitRequest']")            //CANCEL REQUEST button
		WebElement cancelRequestButtoneTemporary;
		@FindBy(how=How.XPATH,using="//input[@id='btnSaveTempPermitRequest']")              //SEND REQUEST button
		WebElement sendRequestButtonTemporary;
		
		
		
		//Smart Permit>>LayOut Assessment
		//===========================================================================================================================================
		@FindBy(how=How.XPATH,using="//input[@id='PermanentPermitId']")
		WebElement layOutAssessment;
		@FindBy(how=How.XPATH,using="//input[@id='btnExisting']")
		WebElement existingbutton;
		@FindBy(how=How.XPATH,using="//input[@id='btnNew']")
		WebElement newButton;
		//New location
		@FindBy(how=How.XPATH,using="//input[@id='txtnewEntity']")                      //Popup message when clicking on New button
		WebElement enterLocation;
		@FindBy(how=How.XPATH,using="//input[@id='btnnewExisting']")                   //Popup message button when clicking on New button.
		WebElement submitLocation;
		//existing location
		@FindBy(how=How.XPATH,using="//input[@id='txtEntityName']")                   //Popup message when clicking on Existing button.
		WebElement searchAndSelectEntity;
		@FindBy(how=How.XPATH,using="//input[@id='btnSubmitExisting']")
		WebElement submitLocationExisting;
		@FindBy(how=How.XPATH,using="//input[@id='txtAreaInSqFt']")
		WebElement totalAreaInSqFt;
		@FindBy(how=How.XPATH,using="//input[@id='txtPreparea']")
		WebElement addPreparationArea;
		@FindBy(how=How.XPATH,using="//input[@id='txtExuipment']")
		WebElement addEquipment;
		@FindBy(how=How.XPATH,using="//input[@id='input-file-preview']")
		WebElement uploadLayout;
		@FindBy(how=How.XPATH,using="//input[@id='btnCancelPermPermitRequest']")
		WebElement cancelRequest;
		@FindBy(how=How.XPATH,using="//input[@id='btnSendRequest']")
		WebElement sendRequest;
		
		//customer satisfaction survey
		@FindBy(how=How.XPATH,using="//input[@id='Customersatisfaction']")
		WebElement customerSatisfactionSurvey;
		@FindBy(how=How.XPATH,using="//button[@id='submitNursing_btn']")
		WebElement save;
		@FindBy(how=How.XPATH,using="//button[@class='btn btn-danger btn-danger']")
		WebElement cancel;
		@FindBy(how=How.XPATH,using="//div[@id='PopupmsgforEditUser']/div/div/div/button")
		WebElement crossbutton;
		
		
	//---------------------------------------------------------------------------------------------------------------------------------------
	//========================================================================================================================================
		//Food Studies Requests
		@FindBy(how=How.XPATH,using="//*[@id='shelfLife_accordionId']")
		WebElement foodStudiesRequests;
		@FindBy(how=How.XPATH,using="//select[@id='mShelfFoodType']")
		WebElement selectFoodType;
		
		
		
		//Ready to Eat Packaged Food
		@FindBy(how=How.XPATH,using="//input[@id='FoodName']")
		WebElement foodItemsExtnOfShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='chkboxProductName']")
		WebElement ClickCheckBoxIfFoodNameNotAvailable;
		@FindBy(how=How.XPATH,using="//input[@id='FIRSRequestNumber']")
		WebElement AddFIRSRequestNumber;
		@FindBy(how=How.XPATH,using="//input[@id='CurrentShelfLifeYears']")
		WebElement NoOfYearsCurrentShelfLife;	
		@FindBy(how=How.XPATH,using="//input[@id='CurrentShelfLifeMonths']")
		WebElement NoOfMonthsCurrentShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='CurrentShelfLifeDays']")
		WebElement NoOfDaysCurrentShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='CurrentShelfLifeHours']")
		WebElement NoOfHoursCurrentShelfLife;		
		@FindBy(how=How.XPATH,using="//input[@id='AnticipatedNewShelfLifeYears']")
		WebElement NoOfYearsAnticipatedNewShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='AnticipatedNewShelfLifeMonths']")
		WebElement NoOfMonthsAnticipatedNewShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='AnticipatedNewShelfLifeDays']")
		WebElement NoOfDaysAnticipatedNewShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='AnticipatedNewShelfLifeHours']")
		WebElement NoOfHoursAnticipatedNewShelfLife;
		@FindBy(how=How.XPATH,using="//select[@id='ReasonOfExtId']")
		WebElement reasonForExtension;
		@FindBy(how=How.XPATH,using="//input[@id='ProdMicrobiologicalCount']")
		WebElement atTheTimeOfProduction;
		@FindBy(how=How.XPATH,using="//input[@id='EndOfShelfLifeMicrobiologicalCount']")
		WebElement atEndOfAnticipatedShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_1']")
		WebElement chooseFile1Packaged;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_2']")
		WebElement chooseFile2Packaged;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_3']")
		WebElement chooseFile3Packaged;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_4']")
		WebElement chooseFile4Packaged;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_5']")
		WebElement chooseFile5Packaged;
		@FindBy(how=How.XPATH,using="//input[@id='Remarks']")
		WebElement remarksPackaged;
		@FindBy(how=How.XPATH,using="//input[@id='btnSaveTempRequest']")
		WebElement sendRequestPackaged;
		
		
		//Product under Voluntary Shelf Life
		@FindBy(how=How.XPATH,using="//input[@id='FoodName']")
		WebElement foodItemsVoluntaryShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='chkboxProductName']")
		WebElement ClickCheckBoxVoluntaryShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='FIRSRequestNumber']")                           // VoluntaryShelfLife
		WebElement AddFIRSRequestNumberVoluntaryShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='CurrentShelfLifeYears']")
		WebElement NoOfYearsCurrentShelfLifeVS;	
		@FindBy(how=How.XPATH,using="//input[@id='CurrentShelfLifeMonths']")
		WebElement NoOfMonthsCurrentShelfLifeVS;
		@FindBy(how=How.XPATH,using="//input[@id='CurrentShelfLifeDays']")
		WebElement NoOfDaysCurrentShelfLifeVS;
		@FindBy(how=How.XPATH,using="//input[@id='CurrentShelfLifeHours']")
		WebElement NoOfHoursCurrentShelfLifeVS;		
		@FindBy(how=How.XPATH,using="//input[@id='AnticipatedNewShelfLifeYears']")
		WebElement NoOfYearsAnticipatedNewShelfLifeVS;
		@FindBy(how=How.XPATH,using="//input[@id='AnticipatedNewShelfLifeMonths']")
		WebElement NoOfMonthsAnticipatedNewShelfLifeVS;
		@FindBy(how=How.XPATH,using="//input[@id='AnticipatedNewShelfLifeDays']")
		WebElement NoOfDaysAnticipatedNewShelfLifeVS;
		@FindBy(how=How.XPATH,using="//input[@id='AnticipatedNewShelfLifeHours']")
		WebElement NoOfHoursAnticipatedNewShelfLifeVS;
		@FindBy(how=How.XPATH,using="//select[@id='ReasonOfExtId']")
		WebElement reasonForExtensionVS;
		@FindBy(how=How.XPATH,using="//input[@id='ProdMicrobiologicalCount']")
		WebElement atTheTimeOfProductionVS;
		@FindBy(how=How.XPATH,using="//input[@id='EndOfShelfLifeMicrobiologicalCount']")
		WebElement atEndOfAnticipatedShelfLifeVS;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_6']")
		WebElement chooseFile1VoluntaryShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_7']")
		WebElement chooseFile2VoluntaryShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_8']")
		WebElement chooseFile3VoluntaryShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_9']")
		WebElement chooseFile4VoluntaryShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_10']")
		WebElement chooseFile5VoluntaryShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='Remarks']")
		WebElement remarksVoluntaryShelfLife;
		@FindBy(how=How.XPATH,using="//input[@id='btnSaveTempRequest']")
		WebElement sendRequestPackagedVS;	
		
		
		//Product Defrosted for Sale
		@FindBy(how=How.XPATH,using="//input[@id='FoodName']")
		WebElement foodItemsProductDefrostedForSale;
		@FindBy(how=How.XPATH,using="//input[@id='chkboxProductName']")
		WebElement ClickCheckBoxProductDefrostedForSale;
		@FindBy(how=How.XPATH,using="//input[@id='FIRSRequestNumber']")                           //ProductDefrostedForSale
		WebElement AddFIRSRequestNumberProductDefrostedForSale;
		@FindBy(how=How.XPATH,using="//input[@id='CurrentShelfLifeYears']")                       //Defrosted
		WebElement NoOfYearsCurrentShelfLifeDefrosted;	
		@FindBy(how=How.XPATH,using="//input[@id='CurrentShelfLifeMonths']")
		WebElement NoOfMonthsCurrentShelfLifeDefrosted;
		@FindBy(how=How.XPATH,using="//input[@id='CurrentShelfLifeDays']")
		WebElement NoOfDaysCurrentShelfLifeDefrosted;
		@FindBy(how=How.XPATH,using="//input[@id='CurrentShelfLifeHours']")
		WebElement NoOfHoursCurrentShelfLifeDefrosted;		
		@FindBy(how=How.XPATH,using="//input[@id='AnticipatedNewShelfLifeYears']")
		WebElement NoOfYearsAnticipatedNewShelfLifeDefrosted;
		@FindBy(how=How.XPATH,using="//input[@id='AnticipatedNewShelfLifeMonths']")
		WebElement NoOfMonthsAnticipatedNewShelfLifeDefrosted;
		@FindBy(how=How.XPATH,using="//input[@id='AnticipatedNewShelfLifeDays']")
		WebElement NoOfDaysAnticipatedNewShelfLifeDefrosted;
		@FindBy(how=How.XPATH,using="//input[@id='AnticipatedNewShelfLifeHours']")
		WebElement NoOfHoursAnticipatedNewShelfLifeDefrosted;
		@FindBy(how=How.XPATH,using="//select[@id='ReasonOfExtId']")
		WebElement reasonForExtensionDefrosted;
		@FindBy(how=How.XPATH,using="//input[@id='ProdMicrobiologicalCount']")
		WebElement atTheTimeOfProductionDefrosted;
		@FindBy(how=How.XPATH,using="//input[@id='EndOfShelfLifeMicrobiologicalCount']")
		WebElement atEndOfAnticipatedShelfLifeDefrosted;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_11']")
		WebElement chooseFile1ProductDefrostedForSale;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_12']")
		WebElement chooseFile2ProductDefrostedForSale;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_13']")
		WebElement chooseFile3ProductDefrostedForSale;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_14']")
		WebElement chooseFile4ProductDefrostedForSale;
		@FindBy(how=How.XPATH,using="//input[@id='UploadFile_15']")
		WebElement chooseFile5ProductDefrostedForSale;
		@FindBy(how=How.XPATH,using="//input[@id='Remarks']")
		WebElement remarksProductDefrostedForSale;
		@FindBy(how=How.XPATH,using="//input[@id='btnSaveTempRequest']")
		WebElement sendRequestPackagedDefrosted;	
		
		
		
		
		
 //Methods Approvals and Permits
//==========================================================================================
		
		public void smartServiceClick() {
			smartServicesMain.click();
		}
		
		public void smartPermitClick() {
			smartPermit.click();
		}
		
		public void approvalAndPermitsButtonClick() {
			approvalsAndPermits.click();
		}
		
		public void sendRequestButtonInternalTrainingClick() {
			sendRequestButton_internalTraining.click();
		}
			
		public String cancelButtonPermitTableGridClick(String xpathPrint,String followingXpathOfItem) {	
			 String cancelButtonXpath= xpathPrint +followingXpathOfItem;
	              driver.findElement(By.xpath(cancelButtonXpath)).click();	
	              return cancelButtonXpath;
		}
			
		//approval of food safety trainer -Internal
		//--------------------------------------------------
		public void clickAddButtonFoodSafetyTrainerInternal() {
			addButtonTI.click();
			
		}
		
		
		//Food activity at Events
		public void enterEventName(String enterValue) {
			eventName.sendKeys(enterValue);
		}
		public void selectDoYouHaveEventPermitFromDTCMradioButtonYES() {
			yesButtonRadio.click();
		}
		
		public void enterValueInNumberOfStaffInFoodPreparationArea(String enterValue) {
			NumberOfStaffInFoodPreparationArea.sendKeys(enterValue);
		}
		
		public void enterTotalFloorArea(String enterValue) {
			TotalFloorAreaInSqFt.sendKeys(enterValue);
		}
		
		public void clickOnAddButton() {
			addButton.click();
		}
		
		public void clickreadyToEatFoodBroughtFromOtherEstablishmentYES() {
			IsReadToEatFoodBroughtFromEstablishmentYES.click();
		}
		
		public void selectRadioButtonHandwashingFacilityIn20MetersYES() {
			yesRadioButton_isHandwashingFacilitywithin20Meter.click();
		}
		
		public void notesEnterValue(String notesComments) {
			notes.sendKeys(notesComments);
		}
		
		public void uploadDocumentOneClick() {
			chooseFile1.click();
			
		}
		
		
		public void clickOnSendRequestButton() {
			sendRequestButtonEvents.click();
		}
		
		
		
		//Non-Halal Permit
		public void enterTotalFoodAreaInSqFt(String enterArea) {
			totalFoodAreaInSqFt.sendKeys(enterArea);
		}
		
		
		public void enterNonHalalFoodAreaInSqFt(String nonHalalArea) {
			totalAreaNonHalalFoodInSqFt.sendKeys(nonHalalArea);
		}
		
		public void clickAddButtonNonHalalPermit() {
			addButtonNonHalal.click();
		}
		
		
		//School Supply Permit
		public void enterRemarksSchoolSupplyPermit(String enterRemarks) {
			remarks.sendKeys(enterRemarks);	
		}
		
		
		
		//Machine location
		public void chooseLocationRadioButtonVendingMachine() {
			machineLocationRadioButton.click();
		}
		
		
		//Food Promotion Permit	
	public void clickFoodItemsADDbutton() {
		addButonFoodItem.click();
	}
		
	public void clickAddLocationsADDbutton() {
		addButtonAddLocations.click();
	}
		
		
	//Temporary Permit for changes related to food label / packages	
		public void requestedChangesEnterComment(String enterComments) {
			reqChanges.sendKeys(enterComments);
		}
		
		
        public void remarksTemporaryPermit(String remakrsEnter) {
        	remarksTemporary.sendKeys(remakrsEnter);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
