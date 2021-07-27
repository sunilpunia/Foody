package POM_EntityTreeView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GeneralInformation {

	WebDriver driver;

	public GeneralInformation(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	
	@FindBy(how=How.XPATH,using="//*[@id='clpsAccordion1']/a")
	WebElement generalInformation;
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='NameOfEstablishment']")
	WebElement nameOfEstablishment;
	@FindBy(how=How.XPATH,using="//*[@id='Streetname']")
	WebElement streetName;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='Streetnumber']")
	WebElement streeNumber;
	@FindBy(how=How.XPATH,using="//*[@id='POBOX']")
	WebElement PO_BOX;
	@FindBy(how=How.XPATH,using="//*[@id='CountryID']")
	WebElement country_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='UAECityId']")
	WebElement city_dropDown;
	@FindBy(how=How.XPATH,using="//*[@id='UAECityRegionId']")
	WebElement UAEcityRegion;
	@FindBy(how=How.XPATH,using="//*[@id='CountryCode1']")
	WebElement country_code;
	@FindBy(how=How.XPATH,using="//*[@id='OfficeLine1']")
	WebElement officeLine1;
	@FindBy(how=How.XPATH,using="//*[@id='OfficeEmail1']")
	WebElement office_email;
	@FindBy(how=How.XPATH,using="//*[@id='WebsiteURL']")
	WebElement website_URL;
	@FindBy(how=How.XPATH,using="//*[@id='GroupId']")
	WebElement groupDropDown;
	@FindBy(how=How.XPATH,using="//*[@id='SubGroupId']")
	WebElement subGroup;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='Picture']")
	WebElement picture_chooseFile;
	@FindBy(how=How.XPATH,using="//*[@id='btnClear']")
	WebElement removeButton;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='Lackstatus']")
	WebElement lockStatus_checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='IssueStatus']")
	WebElement issueStatus_checkbox;
	@FindBy(how=How.XPATH,using="//*[@id='Comments']")
	WebElement addComment;
	@FindBy(how=How.XPATH,using="//*[@id='LicenseNumber']")
	WebElement licenseNumber;
	@FindBy(how=How.XPATH,using="//*[@id='LicenseIssueDate']")
	WebElement licenseIssueDate;
	@FindBy(how=How.XPATH,using="//*[@id='LicenseExpirationDate']")
	WebElement licenseExpirationDate;
	
	
	
	
	//Makani Details
	@FindBy(how=How.XPATH,using="//*[@id='MakaniNr']")
	WebElement makaniNumber;
	@FindBy(how=How.XPATH,using="//*[@id='LatitueLongitude']")
	WebElement latitudeAndLongitude;
	@FindBy(how=How.XPATH,using="//*[@id='EjariContractNr']")
	WebElement EjariContractNumber;
	
	//disability access
	@FindBy(how=How.XPATH,using="//*[@id='DisablityAccess1']")
	WebElement yesButton;
	@FindBy(how=How.XPATH,using="//*[@id='DisablityAccess2']")
	WebElement noButton;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddLatLong']")
	WebElement addLocationButton_Makani;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddLatLong2']")
	WebElement currentLocation_Makani;
	
	
	
	
	//Nearest Parking Area Type
	@FindBy(how=How.XPATH,using="//*[@id='NearestParkingAreaTypeId']/option[1]")
	WebElement free_parking;
	@FindBy(how=How.XPATH,using="//*[@id='NearestParkingAreaTypeId']/option[2]")
	WebElement not_applicable;
	@FindBy(how=How.XPATH,using="//*[@id='NearestParkingAreaTypeId']/option[3]")
	WebElement paid_parking;
	@FindBy(how=How.XPATH,using="//*[@id='NearestParkingAreaTypeId']/option[4]")
	WebElement valet_parking;
	@FindBy(how=How.XPATH,using="//*[@id='NearestParkingAreaLatitudeLongitude']")
	WebElement nearestParkingAreaLatitudeAndLongitude;
	@FindBy(how=How.XPATH,using="//*[@id='NearestParkingAreaDescription']")
	WebElement parkingArea_Description;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddLatLongParking']")
	WebElement addLocationButton_NearestParking;
	@FindBy(how=How.XPATH,using="//*[@id='btnAddLatLongParking2']")
	WebElement currentLocationButton_NearestParking;
	
	
	
	
	//public transport access
	@FindBy(how=How.XPATH,using="//*[@id='PublicTransportAccess1']")
	WebElement publicTransport_yesButton;
	@FindBy(how=How.XPATH,using="//*[@id='PublicTransportAccess2']")
	WebElement publicTransport_NoButton;
	
	@FindBy(how=How.XPATH,using="//*[@id='PublicTransportAccessDescription']")
	WebElement publicTransportAccess_Description;
	@FindBy(how=How.XPATH,using="//*[@id='btnUpdateGenInformation']")
	WebElement update_Button;
	
	
	
	
	
	
	public void ClickOnGeneralInformationTab() {
		
		generalInformation.click();
	}
	
	
	

	
	
	
	
	
	
}
