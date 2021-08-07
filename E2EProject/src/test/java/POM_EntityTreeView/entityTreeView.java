package POM_EntityTreeView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class entityTreeView {

	
	
	public WebDriver driver;

	public entityTreeView(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	
	//EntityTreeView
	@FindBy(how=How.XPATH,using="//*[@class='bullet']/li/span")
	WebElement EntityTreeView_Link;
	
	
	//Barcode scan
	@FindBy(how=How.XPATH,using="//*[@id='divQRCode']/a")
	WebElement Scanning_Barcode;
	
	
	//Foodwatch Connect App after clicking on Barcode

	@FindBy(how=How.XPATH,using="//*[@id='menusectionhome']/div/div[1]/div[1]/div[2]/a")
	WebElement Menu;
	@FindBy(how=How.XPATH,using="//*[@id='menusectionhome']/div/div[1]/div[2]/div/a")
	WebElement Promotions;
	@FindBy(how=How.XPATH,using="//*[@id='menusectionhome']/div/div[1]/div[3]/div/a")
	WebElement Safety_Rating;
	@FindBy(how=How.XPATH,using="//*[@id='fType']")
	WebElement Share_Feedback;
	@FindBy(how=How.XPATH,using="//*[@id='menusectionhome']/div/div[2]/div[2]/div/a")
	WebElement Alerts;
	@FindBy(how=How.XPATH,using="//*[@id='menusectionhome']/div/div[2]/div[3]/div/a")
	WebElement Covid_19;
	
	
	
	@FindBy(how=How.XPATH,using="//*[@class='hmIcon']")
	WebElement TopUpper_icon;
	@FindBy(how=How.XPATH,using="//*[@class='mobile-nav']/ul/li[1]/a")
	WebElement Emergency_Number;
	@FindBy(how=How.XPATH,using="//*[@class='mobile-nav']/ul/li[2]/a")
	WebElement DM_Webpage;
	@FindBy(how=How.XPATH,using="//*[@class='homebtnsect']/a")
	WebElement ReturnTo_HomeButton;
	
	
	
	
	public void ClickOnEntityTreeView() {
		EntityTreeView_Link.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
