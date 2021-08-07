package LeftMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import resources.Helper;

public class LeftMenu {
	WebDriver driver;
	
	public LeftMenu(WebDriver sdriver) {
		this.driver = sdriver;
	
	}
	
	
	@FindBy(how=How.XPATH,using="//i[@class='fa fa-bars topbarmenu']")
	WebElement leftMenu_Button;
	
	
	
	public void leftMenuClick() {	
		leftMenu_Button.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
