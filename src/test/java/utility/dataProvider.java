package utility;

import org.testng.annotations.DataProvider;

import resources.ExcelDataConfig;


public class dataProvider {	
	@DataProvider(name = "FoodwatchLoginData")
	public Object[][] loginData() {

		ExcelDataConfig config = new ExcelDataConfig(
				"C:\\Users\\sunil.punia\\Desktop\\Selenium Project Software\\E2EProject\\Excel\\data.xlsx");

		int rows = config.getRowCount(0);
		Object[][] data = new Object[rows][2];

		for (int i = 0; i < rows; i++) {
			data[i][0] = config.readExcelDataIndex(0, i, 0);
			data[i][1] = config.readExcelDataIndex(0, i, 1);

		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
