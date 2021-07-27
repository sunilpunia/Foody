package utility;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chromeOptions {

	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Driver\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("This is the path where extension file is located"));

		WebDriver driver = new ChromeDriver(options);

		driver.get("www.google.com");

	}

}
