package POM_EntityTreeView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CurrentCertification {

	
	public WebDriver driver;

	public CurrentCertification(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	
	@FindBy(how=How.XPATH,using="//*[@id='accordion']/div[6]/div/h4")
	WebElement currentCertificationMain;
	
	

	@FindBy(how=How.XPATH,using="//*[@id='txtsearch']")
	WebElement searchCertificationBody;
	@FindBy(how=How.XPATH,using="//*[@id='btnGo']")
	WebElement goButton;
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[1]/td[10]/div")
	WebElement Edit_1stLink;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[6]/td[10]/div")
	WebElement Edit_2stLink;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[11]/td[10]/div")
	WebElement Edit_3stLink;
	
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[4]/td/div[1]/div/input")
	WebElement ValidFrom_1stRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[4]/td/div[2]/div/input")
	WebElement ValidUpTo_1stRow;
	
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[9]/td/div[1]/div/input")
	WebElement ValidFrom_2ndtRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[9]/td/div[2]/div/input")
	WebElement ValidUpTo_2ndRow;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[3]/td/div[1]/div/input")
	WebElement proposedDateOfAudit_1stRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[3]/td/div[2]/div/input")
	WebElement numberOfAuditHours_1stRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[3]/td/div[3]/div/select")
	WebElement NumberofNonconformities_1stRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[3]/td/div[4]/div/input")
	WebElement auditStartTime_1stRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[3]/td/div[5]/div/input")
	WebElement numberOfAuditor_1stRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[3]/td/div[6]/div/select")
	WebElement numberOfObservations_1stRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[3]/td/div[7]/div/input")
	WebElement auditEndTime_1stRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[3]/td/div[8]/div/input")
	WebElement numberOfExperts_1stRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[5]/td/div/div[2]/select")
	WebElement selectStatus_1stRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[5]/td/div/div[1]/input")
	WebElement saveButton_1stRow;
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[8]/td/div[1]/div/input")
	WebElement proposedDateOfAudit_2ndRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[8]/td/div[2]/div/input")
	WebElement numberOfAuditHours_2ndRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[8]/td/div[3]/div/select")
	WebElement NumberofNonconformities_2ndRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[8]/td/div[4]/div/input")
	WebElement auditStartTime_2ndRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[8]/td/div[5]/div/input")
	WebElement numberOfAuditor_2ndRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[8]/td/div[6]/div/select")
	WebElement numberOfObservations_2ndRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[8]/td/div[7]/div/input")
	WebElement auditEndTime_2ndRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[8]/td/div[8]/div/input")
	WebElement numberOfExperts_2ndRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[10]/td/div/div[2]/select")
	WebElement selectStatus_2ndRow;
	@FindBy(how=How.XPATH,using="//*[@id='DTCertification']/tbody/tr[10]/td/div/div[1]/input")
	WebElement saveButton_2ndRow;
	
	
	
	
	
	
	
	
	
	
	
	
	
}
