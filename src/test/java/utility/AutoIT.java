package utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoIT {

	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tinyupload.com/");
		
		Thread.sleep(1000);
		uploadSingleFileAutoIT(driver);
	}
	
	
	
	//This method is not working need to make it work.
		public static void uploadSingleFileAutoIT(WebDriver driver) throws IOException, InterruptedException {

		driver.findElement(By.xpath("//input[@name='uploaded_file']")).click();

		Runtime.getRuntime().exec("C:\\Users\\sunil.punia\\Documents\\fileuploadscript.exe");

		Thread.sleep(3000);

	}
		
		//Need to write code for uploading multiple files(Otwani video no-52)
		
		
		
		
	// Note use this method before driver.get(URL) line if authentication window is
	// opening before opening the url.( login authentication)
	public static void windowAuthUsingAutoIT() throws IOException {
		Runtime.getRuntime().exec("C:\\Users\\sunil.punia\\Desktop\\AutoIT Scripts\\windowAuthentication.exe");

	}
		
	
	
	//can also write code for getting file size and total no of downloaded files otwani video no-54 time-11:00
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
