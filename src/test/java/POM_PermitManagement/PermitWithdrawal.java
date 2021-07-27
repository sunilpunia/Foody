package POM_PermitManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PermitWithdrawal {


	public WebDriver driver;

	public PermitWithdrawal(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	

	//Permit Withdrawn Process
	//...............................................................
	@FindBy(how=How.XPATH,using="//input[@id='editEntity']")
	WebElement NameOfEntity;
	@FindBy(how=How.XPATH,using="//select[@id='ddlPICName']/option")
	WebElement NameOfPIC;
	@FindBy(how=How.XPATH,using="//input[@id='txtOldGrade']")
	WebElement OldGrade;
	@FindBy(how=How.XPATH,using="//input[@id='txtNewGrade']")
	WebElement NewGrade;
	
	@FindBy(how=How.XPATH,using="//input[@id='remarks']")
	WebElement Remarks;
	@FindBy(how=How.XPATH,using="//input[@id='btnSubmitPermitWithDrawn']")
	WebElement Submit_Button;
	@FindBy(how=How.XPATH,using="//input[@type='search']")
	WebElement Search_TextField;
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='tblPermitWithDrawnData']/tbody/tr[1]/td[7]/a[1]")
	WebElement Edit_1stRow;
	@FindBy(how=How.XPATH,using="//*[@id='tblPermitWithDrawnData']/tbody/tr[1]/td[7]/a[3]")
	WebElement Cancel_1stRow;
	@FindBy(how=How.XPATH,using="//table[@id='tblPermitWithDrawnData']/tbody/tr[1]/td[4]/input")
	WebElement OldGrade_1stRow;
	@FindBy(how=How.XPATH,using="//table[@id='tblPermitWithDrawnData']/tbody/tr[1]/td[5]/input")
	WebElement NewGrade_1stRow;
	@FindBy(how=How.XPATH,using="//table[@id='tblPermitWithDrawnData']/tbody/tr[1]/td[6]/input")
	WebElement Remarks_1stRow;
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='tblPermitWithDrawnData']/tbody/tr[2]/td[7]/a[1]")
	WebElement Edit_2ndRow;
	@FindBy(how=How.XPATH,using="//*[@id='tblPermitWithDrawnData']/tbody/tr[2]/td[7]/a[3]")
	WebElement Cancel_2ndRow;
	@FindBy(how=How.XPATH,using="//table[@id='tblPermitWithDrawnData']/tbody/tr[2]/td[4]/input")
	WebElement OldGrade_2ndRow;
	@FindBy(how=How.XPATH,using="//table[@id='tblPermitWithDrawnData']/tbody/tr[2]/td[5]/input")
	WebElement NewGrade_2ndRow;
	@FindBy(how=How.XPATH,using="//table[@id='tblPermitWithDrawnData']/tbody/tr[2]/td[6]/input")
	WebElement Remarks_2ndRow;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='tblPermitWithDrawnData']/tbody/tr[3]/td[7]/a[1]")
	WebElement Edit_3rdRow;
	@FindBy(how=How.XPATH,using="//*[@id='tblPermitWithDrawnData']/tbody/tr[3]/td[7]/a[3]")
	WebElement Cancel_3rdRow;
	@FindBy(how=How.XPATH,using="//table[@id='tblPermitWithDrawnData']/tbody/tr[3]/td[4]/input")
	WebElement OldGrade_3rdRow;
	@FindBy(how=How.XPATH,using="//table[@id='tblPermitWithDrawnData']/tbody/tr[3]/td[5]/input")
	WebElement NewGrade_3rdRow;
	@FindBy(how=How.XPATH,using="//table[@id='tblPermitWithDrawnData']/tbody/tr[3]/td[6]/input")
	WebElement Remarks_3rdRow;
	
	
	
	
	

	
	
	
}
