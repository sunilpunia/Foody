package resources;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Helper {
	
	
	
	public static WebDriver driver;
	public Properties prop;
	public ExcelDataConfig excel;
	public manageConfigProperties config;
	
	
	

	//public  Helper(WebDriver sdriver) {
	//	this.driver = sdriver;
	//}
	
	
	public static void radioandcheckbox(String radioxpath, String chexbxxpath) {

		List<WebElement> radio = driver.findElements(By.xpath(radioxpath));
		// xpath="//input[@type='radio']"

		for (int i = 0; i < radio.size(); i++) {

			WebElement local_radio = radio.get(i);
			String value = local_radio.getAttribute("value");
			// String radiobuttonname= local_radio.getTagName();
			System.err.println("values from radion buttons   " + value);

			if (value.equalsIgnoreCase("Option 3")) {
				local_radio.click();

			}
		}

		List<WebElement> checbx = driver.findElements(By.xpath(chexbxxpath));
		for (int i = 0; i < checbx.size(); i++) {

			WebElement ele = checbx.get(i);
			String chkvalue = ele.getAttribute("value");
			if (chkvalue.equalsIgnoreCase("checkbox2")) {
				ele.click();
				break;
			}
		}
	}

	public static void readfromproperty(String propfilename) throws IOException {

		Properties prop = new Properties();
		InputStream input = new FileInputStream(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\src\\main\\java\\resources\\data.properties");

		prop.load(input);
		String dataurl = prop.getProperty(propfilename);
		System.err.println(dataurl);
	}

	public static void writetoproperty(String propfilename) throws IOException {
		Properties prop = new Properties();
		OutputStream output = new FileOutputStream(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.setProperty("sunil", "blueaves");
		prop.store(output, "This is my data");

	}

	public static void scrollDownPage(WebDriver driver,int horizontal, int vertical) {
		((JavascriptExecutor) driver).executeScript("scroll(" + horizontal + "," + vertical + ")");

	}

	/*public static void selectDropdownbyVisibleText(String id, String drpdownvalue) {
		WebElement drop_down = driver.findElement(By.id(id));
		Select sel = new Select(drop_down);
		sel.selectByVisibleText(drpdownvalue);
		
	} */
	
		
	
	//New method created
	 public static String selectDropDownByTextValue(WebDriver driver,String DropDownAllValuesXpath,String ExpDropDownText) {
		   
		   
		    List<WebElement> allDropDownValues= driver.findElements(By.xpath(DropDownAllValuesXpath));
		  
		   for(int i=0;i<allDropDownValues.size();i++) {
			           String singleValue=allDropDownValues.get(i).getText();
			   if(singleValue.equalsIgnoreCase(ExpDropDownText)) {
				   allDropDownValues.get(i).click();
				   break;
			   }			   
		   }
		   return ExpDropDownText;
	   }
	
		

	//example xpath=//ul[@id='ui-id-1']/li
public static void intelligentSearch(WebDriver driver,String id,String SearchValue,String xpath) {
		driver.findElement(By.id(id)).sendKeys(SearchValue);
		Helper.pause(2);
	    List<WebElement> list=	driver.findElements(By.xpath(xpath));
    	Helper.pause(2);
	
	   for(int i=0;i<list.size();i++) {
	    	String textOfSearchResult=  list.get(i).getText();
		    System.err.println( "Total dropDownValues-"+ " "+list.size()+"DropDown values are-"+textOfSearchResult);
		    if(textOfSearchResult.equalsIgnoreCase(SearchValue)) {
		   	list.get(i).click();
			 break;
		}
	}	
	}	
	



//Example xpath=//div[@class='col-sm-6 col-md-5']/ul/li/a     ,Advance version
	public static void intelligentSearchAdvance(WebDriver driver,String id,String SearchValue, String compareWith,String xpath) {
		
			driver.findElement(By.id(id)).sendKeys(SearchValue);
			Helper.pause(2);
		    List<WebElement> list=	driver.findElements(By.xpath(xpath));
	    	Helper.pause(2);
		
		   for(int i=0;i<list.size();i++) {
		    	String textOfSearchResult=  list.get(i).getText();
			    System.err.println( "Total dropDownValues-"+ " "+list.size()+"DropDown values are-"+textOfSearchResult);
			    if(textOfSearchResult.equalsIgnoreCase(compareWith)) {
			   	list.get(i).click();
				 break;
			}
		}		
	}


		
//Please try to less use this method
	public static void selectDropdownbyValue(String id, String drpdownvalue) {
		WebElement drop_down = driver.findElement(By.id(id));
		Select sel = new Select(drop_down);
		sel.selectByValue(drpdownvalue);
	}

	//Need to remove this method as its not very good method.Not sure whether it will return text or not
	public static String selectDropdownbyIndex( WebDriver driver,String id,int drpdownIndex ) {	 
		 WebElement drop_down= driver.findElement(By.id(id));	  
		  Select sel=new Select(drop_down);		  
				sel.selectByIndex(drpdownIndex);
			return drop_down.getText();
	}
	
	public static String allDropDownValueOfSelectDropDown(WebDriver driver,String id,int indexno) {	 
		 WebElement drop_down= driver.findElement(By.id(id));	  
		  Select sel=new Select(drop_down);		  
			List<WebElement> allDropDownValues=sel.getOptions();
			allDropDownValues.get(indexno).click();
			return allDropDownValues.get(indexno).getText();
	}
		
	
	
	
//Need to write more for this method.Will write while writing test cases.
	public static void verfyDrpDownAsc(String drpDownWebElementID) {
	Select sel = new Select(driver.findElement(By.id(drpDownWebElementID)));
	List actual_list = new ArrayList();
	List<WebElement> my_tools = sel.getOptions();

	for (WebElement ele : my_tools) {
		String data = ele.getText();
		actual_list.add(data);
		//System.err.println(data);
	}
	List temp=new ArrayList();
	temp.addAll(actual_list);
	Collections.sort(temp);
	Assert.assertTrue(actual_list.equals(temp));

}
	
	
	
	public static void bootStrapDropDown(String dropdownxpath, String listxpath, String attributename,String clickAttbute) {

		driver.findElement(By.xpath(dropdownxpath)).click();
		List<WebElement> menu_list = driver.findElements(By.xpath(listxpath));

		for (WebElement element : menu_list) {
			String attbutnme = element.getAttribute(attributename);

			if (attbutnme.contentEquals(clickAttbute)) {
				element.click();
				break;
			}
			System.err.println("Values from downdow is --" + attbutnme);

		}
		driver.quit();
	}	
		
	public static void tcCompareTitle(String baseUrl,String ExpTitle) {
		driver = new ChromeDriver();
		driver.get(baseUrl);
		String actualTitle=driver.getTitle();
		if(actualTitle.equalsIgnoreCase(ExpTitle)) {
			System.err.println(actualTitle  + "-- Test case is Pass");
		}
		else {
			System.err.println(actualTitle  + "-- Test Case is Fail");
		}
	}
	
	
	public static void bssElementClickWithXpath(String xpath) {

		WebElement button = driver.findElement(By.xpath(xpath));
		button.click();
	}
	
	
	public static void verifyErrMsg(String URL,String xpathvalid,String xpathOfErrMsg,String expctdText) throws InterruptedException {
		
		driver=new ChromeDriver();
		driver.get(URL);
		
		driver.findElement(By.id(xpathvalid)).click();
		Thread.sleep(1000);
		String actual_errText=driver.findElement(By.xpath(xpathOfErrMsg)).getText();
		Assert.assertTrue(actual_errText.contains(expctdText));
		
	}
	
	
	public static String takeScreenShot(WebDriver driver, String screnshotnam) {

		try {
			TakesScreenshot screensht = (TakesScreenshot) driver;
			File source = screensht.getScreenshotAs(OutputType.FILE);
			String dest = "C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Screenshots\\" +getCurrentDateTime() + screnshotnam + ".jpg";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.err.println("Screenshot taken");
			return dest;
		} catch (Exception e) {
			System.err.println("Exception while taking screenshot" + e.getMessage());
			return e.getMessage();
		}

	}
	
	
	public static String getCurrentDateTime() {
		
		 DateFormat customFormat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
		
	}
	
	public static String getWindowTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public static void setDropDownValueWithXpath(String xpath, String value) {
		WebElement dropDownElement = driver.findElement(By.xpath(xpath));
		Select dropDownSelect = new Select(dropDownElement);
		dropDownSelect.selectByValue(value);
	}
	
	public void clearDropDownValueWithXpath(String xpath, String value) {
		WebElement dropDownElement = driver.findElement(By.xpath(xpath));
		Select dropDownSelect = new Select(dropDownElement);
		dropDownSelect.deselectByValue(value);
	}
	
	
	public static void setTextBoxValueWithXpath(String xpath,String value) {
		
		WebElement textbox=driver.findElement(By.xpath(xpath));
		textbox.sendKeys(value);
	}
	
	
	public static void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
}
	
	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	
	public static void ClickUsingLinkText( WebDriver driver,String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}
	
	
	public static String getAlertText() {
		return driver.switchTo().alert().getText();
	}
	
	public static void clickHyperLink(String linktext) {
		WebElement hyperLink = driver.findElement(By.linkText(linktext));
		hyperLink.click();
	}
	
	public static void clickWithXpath(String xpath) {
		WebElement button = driver.findElement(By.xpath(xpath));
		button.click();
	}

	public static void clickById(String id) {
		WebElement button = driver.findElement(By.id(id));
		button.click();
	} 
	
	public static void clearTextValueWithXpathAndEnterNewValue(WebDriver driver,String xpath, String newValue) {
		WebElement textBox = driver.findElement(By.xpath(xpath));
		textBox.clear();
		textBox.sendKeys(newValue);
	}
	
	public static String getAttributeValueWithXpath(String xpath) {
		WebElement textBox = driver.findElement(By.xpath(xpath));
		return textBox.getAttribute("value");
	}
	
	public static void refreshPage(){
		driver.navigate().refresh();
	}
	
	public static void windowClose() {
		driver.close();
		
	}
	
	public static void windowQuit(WebDriver driver) {
		driver.quit();
		
	}
	 
	
	public void switchToFrameGrid(String iframename) {
		driver.switchTo().frame(driver.findElement(By.name(iframename)));
	
	}
	
	public void switchtoFramebyNameOrID(String frameNameOrId) {
		driver.switchTo().frame(frameNameOrId);
	}
	
	public static void switchToiFramebyName(String workingIFrame) {
		List<WebElement> total_iframe = driver.findElements(By.tagName("iframe"));
		System.err.println("iFrame name---"+total_iframe);

		for (int i = 0; i <= total_iframe.size(); i++) {

			WebElement iFrame_name = total_iframe.get(i);
			String iFrame = iFrame_name.getAttribute("name");
			System.err.println("iFrame name--"+iFrame_name.getAttribute("name"));

			if (iFrame.equals(workingIFrame)) {
				driver.switchTo().frame(iFrame);
			}

		}
	}
	
	
	//Need to check this method
	public static void switchToiFramebyAttribute(String workingIFrame, String frameType) {
		List<WebElement> total_iframe = driver.findElements(By.tagName("iframe"));
		System.err.println("iFrame name---"+total_iframe);

		for (int i = 0; i <= total_iframe.size(); i++) {

			WebElement iFrame_name = total_iframe.get(i);
			String iFrame = null;
			if (frameType=="id") {
				iFrame=iFrame_name.getAttribute("id");
			}	
			else if (frameType=="name") {
				iFrame=iFrame_name.getAttribute("name");
			}	
			else if (frameType=="class") {
				iFrame=iFrame_name.getAttribute("class");
			}		
			else if (frameType=="title") {
				iFrame=iFrame_name.getAttribute("title");
			}
			///System.err.println("iFrame name--"+iFrame_name.getAttribute("name"));
			if (iFrame.equals(workingIFrame)) {
				driver.switchTo().frame(iFrame);
			}

		}
	}
	
	
	
	
	//Need to write this method which is using ElementConstant.
	/*public void getLogoFrame(String BSS_FRAME) {
		driver.switchTo().defaultContent();
		List<WebElement> firstLevelChildFrame = driver.findElements(By.tagName(ElementConstants.BSS_FRAME));
		driver.switchTo().frame(firstLevelChildFrame.get(0));

		   
	}*/
	
	public static void setTextBoxValueWithXpathUsingTabClear(String xpath, String value) {
		WebElement textBox = driver.findElement(By.xpath(xpath));
		textBox.clear();
		textBox.sendKeys(value);
	}
	
	public static void setTextBoxValueWithXpathAndUnfocus(String xpath, String value) {
		WebElement textBox = driver.findElement(By.xpath(xpath));
		textBox.clear();
		textBox.sendKeys(value);
		textBox.sendKeys(Keys.TAB);
	}
	
	
	//Not sure where this method will be used
	public static void setTextBoxValueWithXpathUsingEnter(String xpath, String value) {
		WebElement textBox = driver.findElement(By.xpath(xpath));
		textBox.sendKeys(value);
		textBox.sendKeys(Keys.ENTER);
	}
	
	
	
	public static void setDropDownValueWithId(String id, String value) {
		
		WebElement dropDownElement=driver.findElement(By.id(id));
		Select dropDownSelect=new Select(dropDownElement);
		dropDownSelect.selectByValue(value);
		
	}
	
	

	public static void switchToWindow(String winName) {
		
		Set<String>	windows=driver.getWindowHandles();
		
			 for(String win:windows) {
				 
				 if(win.equalsIgnoreCase(winName)) {
					 driver.switchTo().window(winName);
				 }
			 }
		}
		
	
	
	public static void switchToChildWinUsingIterator(String child_window) {
		String parent_window = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {

			child_window = i1.next();

			if (!parent_window.equalsIgnoreCase(child_window)) {
				driver.switchTo().window(child_window);
				System.err.println(driver.getTitle());
			}
		}
	}
	
	
	
	//Switch to new tab and work on it.
	public static String switchToNewTab(WebDriver driver,String clickXpath) {				
		 String parentWindow=driver.getWindowHandle();				
		 driver.findElement(By.xpath(clickXpath)).click();			
		 Set<String> allWindows= driver.getWindowHandles();
		 
		    for(String child:allWindows) {
			
			 if(!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				Helper.pause(2);
			
				
			}				
		}
		    return parentWindow;			
		}
	
	
	
	
	public static WebDriver switchToMainWindow(WebDriver driver,String parent) {
		driver.switchTo().window(parent);
		return driver;

	}


	public static void switchToDefaultContent() {

		driver.switchTo().defaultContent();
	}
	
	
	
	
	public static void pause(int sleepTime) {
		int sleepSec = 1000 * sleepTime;

		try {
			Thread.sleep(sleepSec);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void closeAllPopUps() {
		String parent_tab = driver.getWindowHandle();
		Set<String> all_PopUp = driver.getWindowHandles();

		for (String pops : all_PopUp) {

			if (!parent_tab.equalsIgnoreCase(pops)) {
				driver.switchTo().window(pops);
				driver.close();
			}
		}
		driver.switchTo().window(parent_tab);
	}
	
	
	public static void bootStrapPopupClose() {

		driver.switchTo().alert().dismiss();
	}

	public static void bootStrapPopupAccept() {

		driver.switchTo().alert().accept();
	}

	public static void captureAlertMsgText() {

		String alert_Text = driver.switchTo().alert().getText();
		System.err.println(alert_Text);
	}

	public static void writeDataInAlertBox(String Text) {

		driver.switchTo().alert().sendKeys(Text);
	}

	public static void popUpInFrameAccept(String framename) {

		driver.switchTo().frame(framename);
		driver.switchTo().alert().accept();
	}
	
	
	
	public static void pageLoadTimeOut() {

		driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);

	}
	
	
	//Need to write this method in a proper way
	public static void explicitWaitExpCondnXpath(String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	}

	public static void rightClick(String xpath, String clickElemtXpath) {

		Actions act = new Actions(driver);
		act.contextClick(driver.findElement(By.xpath(xpath))).perform();
		driver.findElement(By.xpath(clickElemtXpath)).click();
	}
	

	public static void doubleClick(String xpath) {

		Actions act = new Actions(driver);
		act.doubleClick(driver.findElement(By.xpath(xpath))).perform();

	}
		
	public static void dragDrop(String xpathSource, String xpathDestnation) {

		WebElement source = driver.findElement(By.xpath(xpathSource));
		WebElement destnation = driver.findElement(By.xpath(xpathDestnation));

		Actions act = new Actions(driver);

		act.dragAndDrop(source, destnation).build().perform();
	}

	public static void dragDropWithXYCordinates(String xpathSource, int xOffset, int yOffset) {

		WebElement source = driver.findElement(By.xpath(xpathSource));

		Actions act = new Actions(driver);

		act.dragAndDropBy(source, xOffset, yOffset).build().perform();
	}
	
	
	public static void fillFormUsingTAB(String xpathof1stfield, String sendkey, String Tab1, String Tab2, String Tab3,
			String Tab4, String Tab5, String Tab6, String Tab7, String Tab8, String Tab9) {

		Actions act = new Actions(driver);
		driver.findElement(By.xpath(xpathof1stfield)).sendKeys(sendkey);

		act.sendKeys(Keys.TAB).pause(Duration.ofSeconds(2)).sendKeys(Tab1).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(2)).sendKeys(Tab2).sendKeys(Keys.TAB).pause(Duration.ofSeconds(2))
				.sendKeys(Tab3).sendKeys(Keys.TAB).pause(Duration.ofSeconds(2)).sendKeys(Tab4).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(2)).sendKeys(Tab5).sendKeys(Keys.TAB).pause(Duration.ofSeconds(2))
				.sendKeys(Tab6).sendKeys(Keys.TAB).pause(Duration.ofSeconds(2)).sendKeys(Tab7).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(2)).sendKeys(Tab8).sendKeys(Keys.TAB).pause(Duration.ofSeconds(2))
				.sendKeys(Tab9).build().perform();
	}
	
	public static void mouseOver(String xpath, String drpDownListXpath, String attribute_name, String ReqDrpValue) {

		Actions act = new Actions(driver);
		WebElement web = driver.findElement(By.xpath(xpath));
		
		act.moveToElement(web).build().perform();
		List<WebElement> drop_down_List = driver.findElements(By.xpath(drpDownListXpath));
		for (int i = 0; i < drop_down_List.size(); i++) {
			WebElement drpValue = drop_down_List.get(i);
			String drp_down_text = drpValue.getAttribute(attribute_name);
			  Boolean link_Status=drpValue.isEnabled();
			  System.err.println("This is the link status--"+ link_Status);
			if (drp_down_text.equalsIgnoreCase(ReqDrpValue)) {
				drpValue.click();
				break;
			}
		}
	}
	
	public static void javaScriptExecutorSendKeys(String xpath,String sendkeysdata) {
   
		WebElement path = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1]", path,sendkeysdata);	
	}
	
	
	public static void javaScriptExecutorClick(String xpath) {
		JavascriptExecutor js=(JavascriptExecutor)driver;	
		WebElement ele=driver.findElement(By.xpath(xpath));
		
		js.executeScript("arguments[0].click()",ele);
		}
	
	
	
	public static void scrollTillElement(WebDriver driver,String xpath) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement element = driver.findElement(By.xpath(xpath));

		js.executeScript("arguments[0].scrollIntoView(true);",element );
		System.err.println(element.getText());
		element.click();

	}
	
	
	//How to Highlight all elements need to write a method pending
	
	public static void clickUnclickableElementUseActionID(WebDriver driver, String id) {

		Actions act = new Actions(driver);

		act.moveToElement(driver.findElement(By.id(id)));

	}

	public static void clickUnclickableElementUseActionXPATH(WebDriver driver, String xpath) {

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(xpath)));

	}


	//When element is not clickable then this method will be useful.
	public static void clickHiddenElement(String id_multplMatch) {

		List<WebElement> radio = driver.findElements(By.id(id_multplMatch));
		int total_element = radio.size();
		for (int i = 0; i < total_element; i++) {
			
			WebElement ele = radio.get(i);
			int x = ele.getLocation().getX();

			if (x != 0) {
				ele.click();
				break;
			}
		}
	
		}
	
	
	
	
	//this method is for dynamic xpath
	public static void CSSColorValueDynamicXpath( WebDriver driver,String textvalue,String expectedColorCode) {
		 String backGroundColor=driver.findElement(By.xpath(textvalue)).getCssValue("background-color");
		 Assert.assertEquals(backGroundColor, expectedColorCode,"Background Color is not as Expected");
		 System.err.println("Background color is matching, Test PASS");
          
		
	}
	
	
	
	
	public static void CSSColorValue( WebDriver driver,String xpath,String expectedColorCode) {
		 String backGroundColor=driver.findElement(By.xpath(xpath)).getCssValue("background-color");
		 Assert.assertEquals(backGroundColor, expectedColorCode,"Background Color is not as Expected");
		 System.err.println("Background color is matching, Test PASS");

		
	}
	
	
	
	//Filter the table record with one table row or column and return the Text value of other column or row.
	public static String  RowTextActiveYes(WebDriver driver,String xpathActivefieldFilterField,String compareToText, String xpathToGetText) {
		
		List<WebElement> Active_Status=driver.findElements(By.xpath(xpathActivefieldFilterField));
		 String FirstActivePerson ="";
		for(int i=0;i<Active_Status.size();i++) {
			   String print= Active_Status.get(i).getText();	
			if(print.equalsIgnoreCase(compareToText)) {	
				List<WebElement> allColumn=driver.findElements(By.xpath(xpathToGetText));
				String productName=allColumn.get(i).getText();
				FirstActivePerson=productName;
				break;
			}		
		}
		//System.err.println("Product Name is--"+FirstActivePerson);
		return FirstActivePerson;
	}
	
	
	//input[@id='{0}']
	//input[@id='{0}' and [@name='{1}']
	public static String dynamicXpath(String xPathExp, Object ...args) {
		 for(int i=0;i<args.length;i++) { 
			xPathExp= xPathExp.replace("{"+i+"}", (CharSequence) args[i]);
			 
		 }
		 return xPathExp;
	}
	
	//Example xpath=dynamicXpath(//input[@id='{0}'],"test");
	//Example xpath=dynamicXpath(//input[@id='{0}' and [@name='{1}',"test"]);
	
	
	public static String getStringFromStart(String str,String removeFrom) {
		   int indexNumber=  str.indexOf(removeFrom);
		     return str.substring(0, indexNumber);
			}
	
	public static String getStringAfterRemoveFrom(String str,String StartFrom) {
		   int indexNumber=  str.indexOf(StartFrom);  
		   String value=str.substring(indexNumber);		             
		         return   value; 
			}

	
	
	//Dynamic Xpath of Process Details.
	///Dynamic Xpath==//table[@id='tblProcessEdit']/tbody/tr/td[contains(text(),'Cooking')]//following::td[1]
	
	
	
	public static void  compareTwoStringValues(String actual, String expected) {		
		Assert.assertEquals(actual, expected);
		System.err.println("Actual and Expected values are same-Test Pass");
	}
	
	
	public static void verifyDeletedItemNOTpresentInTableGrid(WebDriver driver,String itemXpath) {
		
		try {
			driver.findElement(By.xpath(itemXpath));
			System.err.println("Item still present in table grid");
		}
		catch(Exception e){
			System.err.println("Item Removed/Deleted successfully");
		}
	}
		
		
		public static void logOut(WebDriver driver,String xpathLogout) {
			 driver.findElement(By.xpath(xpathLogout));
			}
			 
			 
			 public static String getLinkTextOfXpath(WebDriver driver,String xpath) {
				 
				return driver.findElement(By.xpath(xpath)).getText();	 
			 }
			 
		public static void highlightColorUsingXpath(WebDriver driver,WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",element);
			try {Thread.sleep(500);
			}
			catch(InterruptedException e){
			System.err.println(e.getMessage());
			}
			js.executeScript("argument[0].setAttribute('style','border: solid 2px white')",element);
		}
		
		public static void selectDateByJS(WebDriver driver,WebElement element,String dateValue) {
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].setAttribute('value','"+dateValue+"');", element);		
		}
		
	
	
	
	public static void uploadFileUsingAUTOIT(String batchFilePath) throws Exception {
		Runtime.getRuntime().exec(batchFilePath);
	}
	
	
	public static void clickOnChooseFileButton(WebDriver driver,String buttonXpath) {
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(buttonXpath))).click().build().perform();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
