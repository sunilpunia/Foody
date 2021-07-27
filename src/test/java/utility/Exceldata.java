package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public Exceldata(String excelPath, String sheetName) throws IOException {
		// projectpath = System.getProperty("user.dir");
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);

	}

	public static void getRowCount() throws IOException {

		int rowCount = sheet.getPhysicalNumberOfRows();
		System.err.println(rowCount);

	}

	public static void getCellDataString(int rowNo, int colmNo) throws IOException {

		String rowCount = sheet.getRow(rowNo).getCell(colmNo).getStringCellValue();
		System.err.println(rowCount);

	}

	public static void getCellDataNumber(int rowNo, int colmNo) throws IOException {

		double rowCount = sheet.getRow(rowNo).getCell(colmNo).getNumericCellValue();
		System.err.println(rowCount);

	}

	
	public static void readAllExcelData() {
		
		int total_row=sheet.getLastRowNum();
		System.err.println("Total no of rows are --"+ total_row);
		
		for(int i=0;i<total_row;i++) {
			String data=sheet.getRow(i).getCell(i).getStringCellValue();
			System.err.println("Data from row"+i+"is" +data);
			
		}
		
	}
	
	
//==================================================================================

	//Need to Write generic method for excel for writing the data.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
