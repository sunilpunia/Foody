package POM_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import resources.base;


public class loginScreen {
	public WebDriver driver;
	
	public loginScreen(WebDriver sdriver) {
		this.driver = sdriver;
	}

	@FindBy(how = How.ID, using = "username")
	WebElement username;
	@FindBy(how = How.NAME, using = "Password")
	WebElement password; 
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement login;
	@FindBy(how = How.LINK_TEXT, using ="Please register here")
	WebElement PlzRegisterHere;
	@FindBy(how = How.LINK_TEXT, using ="Forgot username or password?")
	WebElement ForgtUsrPass;
	@FindBy(how = How.LINK_TEXT, using = "Layout Submission Form")
	WebElement layoutSubForm;
	@FindBy(how = How.LINK_TEXT, using = "Request Support Form")
	WebElement requestSupportForm;
	@FindBy(how = How.XPATH, using = "//*[@class='larger']/span[text()='Login']")
	WebElement loginLinkTopRightSide;
	
	

	                   
	public void Foodwatch_login(String username1,String password1) {
		username.sendKeys(username1);
		password.sendKeys(password1);
		login.click();
	}
	public void Click_pleaseRegisterHere() {
		PlzRegisterHere.click();
	}
	public void Click_ForgotUsernameOrPass() {
		ForgtUsrPass.click();
	}

	public void Click_LayoutSubmissionForm() {
		layoutSubForm.click();
	}

	public void Click_RequestSupportForm() {
		requestSupportForm.click();
	}
	
	
	
	public void loginLinkTopRight() {
		loginLinkTopRightSide.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
