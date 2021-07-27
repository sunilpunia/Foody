package utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyLinks {

	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.0.76:82/Account/Login");

		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("reach_ghaffar@dm.gov.ae");
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("200sresu@1966");
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		driver.manage().window().maximize();
		Thread.sleep(1000);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.err.println("Total links in the application are--- " + links.size());

		for (int i = 0; i < links.size(); i++) {
			WebElement ele = links.get(i);
			String linkUrl = ele.getAttribute("href");

			verifyLinkActive(linkUrl);
		}
	}

	public static void verifyLinkActive(String linkUrl) throws IOException {

		URL all = new URL(linkUrl);
		HttpURLConnection httpUrlConnect = (HttpURLConnection) all.openConnection();
		httpUrlConnect.setConnectTimeout(3000);
		httpUrlConnect.connect();
		if (httpUrlConnect.getResponseCode() == 200) {
			System.err.println(linkUrl + "--" + httpUrlConnect.getResponseMessage());
		}

		if (httpUrlConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
			System.err.println(
					linkUrl + "--" + httpUrlConnect.getResponseMessage() + "--" + HttpURLConnection.HTTP_NOT_FOUND);
		}

	}

}