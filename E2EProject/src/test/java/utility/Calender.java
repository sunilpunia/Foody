package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.Helper;

public class Calender {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		selectCalenderDate(driver,"//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']",
				"//div[@id='rb-calendar_onward_cal']//tr", "31");
		// Here xpath of calender list is not proper need to do hard work to write xpath
		// for these cases.
	}

	public static void selectCalenderDate(WebDriver driver,String xpathCalender, String xpathCalenderList, String select_date) {
		driver.findElement(By.xpath(xpathCalender)).click();
		Helper.pause(2);
		List<WebElement> dates = driver.findElements(By.xpath(xpathCalenderList));

		int total = dates.size();
		System.err.println("total no of datesss" + total);
		for (int i = 0; i < total; i++) {
			String select = dates.get(i).getText();
			if (select.equalsIgnoreCase(select_date)) {
				dates.get(i).click();
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	public static String selectCalenderDateToday(WebDriver driver,String xpathCalender, String xpathCalenderToday) {
		driver.findElement(By.xpath(xpathCalender)).click();
		Helper.pause(2);
		String TodayDate= driver.findElement(By.xpath(xpathCalenderToday)).getText();
		driver.findElement(By.xpath(xpathCalenderToday)).click();
		return TodayDate;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}













