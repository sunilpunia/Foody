package POM_MyEntities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchOnEstablishNameAndLicenseNumber {

public WebDriver driver;

	public SearchOnEstablishNameAndLicenseNumber(WebDriver sdriver) {
		this.driver = sdriver;
	}
	
	
	@FindBy(how=How.XPATH,using="//*[@id='txtsearch']")
	WebElement searchTextField;
	@FindBy(how=How.XPATH,using="//*[@id='bttnClick']")
	WebElement searchbutton;
	@FindBy(how=How.XPATH,using="//*[@id=\"tbllandingpageUrl\"]/tbody/tr[1]/td[3]/a")
	WebElement entitySearchTable;
	
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'My Entities')]")
	WebElement myEntity_Click;
	
	
	
	
	public void clickMyEntityLink() {
		myEntity_Click.click();
	}
	
	
	
	
	/*public void enterValueInSearchField(String enterTxt) {
		searchTextField.sendKeys(enterTxt);
	} */

	
	public String enterValueInSearchField(String enterTxt) {
		searchTextField.sendKeys(enterTxt);
		return enterTxt;
	}
	
	
	
	
	
	
	
	
	
	
	public void clickSearchButton() {
		searchbutton.click();
	}

	public void clickEntitySearchResult() {
		entitySearchTable.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
