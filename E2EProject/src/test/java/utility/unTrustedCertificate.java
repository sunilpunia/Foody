package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class unTrustedCertificate {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.cacert.org/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		unTrustedCertificate(driver);
	} 

	
	//This is incorrect method need to write correct method	
		public static void unTrustedCertificate(WebDriver driver) {
			
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver=new ChromeDriver(cap);
			
			
			
		}  
}