package utility;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class HeadlessBrowser {

	public static void headlessVerifyTitle() {
		WebDriver driver = new HtmlUnitDriver();
		// After this code we will add driver.get(www.google.com") to make it headless
	}

	public static void headlessPhantomJS(WebDriver driver) {
		File src = new File("C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
		driver = new PhantomJSDriver();
		// driver.get("google.com");
	}
		
	
	
	
	
	
	
	
	

}
