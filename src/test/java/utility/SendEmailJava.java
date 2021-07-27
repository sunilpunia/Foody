package utility;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class SendEmailJava {
     public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, EmailException {
		
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.cacert.org/");
		Thread.sleep(1000);
}
	public static void sendEmailUsingJava(String HostName,int smtpport,String mailFrom,String mailTo,String mailSubject,String mailMsg) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName(HostName);
		email.setSmtpPort(smtpport);
		email.setAuthenticator(new DefaultAuthenticator("username", "password"));
		email.setSSLOnConnect(true);
		email.setFrom(mailFrom);
		email.setSubject(mailSubject);
		email.setMsg(mailMsg);
		email.addTo(mailTo);
		email.send();
	}
	
	//Pending method--Sending email with attachments
	
	//Pending method--Sending HTML formatted email
	
	
	
	//This TestNG method
	@AfterMethod
	public static void sendMailForFailResult(ITestResult result) throws EmailException {
		
		if(result.getStatus()==ITestResult.FAILURE){
			sendEmailUsingJava("fljsd", 345, "skldfj", "sdfjk", "sldkfj", "lksjdf");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
