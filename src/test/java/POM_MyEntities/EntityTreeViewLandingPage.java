package POM_MyEntities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EntityTreeViewLandingPage {

	public WebDriver driver;

	public EntityTreeViewLandingPage(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	
	@FindBy(how=How.XPATH,using="//*[@id='container']/div/ul/li/span")
	WebElement xpathEntityTreeView;
	@FindBy(how=How.XPATH,using="//*[@class='label-anchortag Entity-Link']")
	WebElement xpathQRcodeFoodConnectApp;
	
	
	
	
	
	
	
	
}
