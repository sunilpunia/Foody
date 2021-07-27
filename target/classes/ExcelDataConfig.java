package resources;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
                                                               //This is running reference from Otwani 
public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public ExcelDataConfig(String excelPath) {
		
		try {
			File src=new File(excelPath);
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		}
		catch(Exception e){
			System.err.println(e.getMessage());	
		}
	}
	 
	public String readExcelDataIndex(int sheetIndex, int row, int column) {

		sheet1 = wb.getSheetAt(sheetIndex);
		String data=sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	
	public String readExcelDataString(String sheetName, int row, int column) {

		sheet1 = wb.getSheet(sheetName);
		String data=sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public double readExcelDataNumeric(String sheetName, int row, int column) {

		sheet1 = wb.getSheet(sheetName);
		double data=sheet1.getRow(row).getCell(column).getNumericCellValue();
		return data;

	}
	
	public int getRowCount(int sheetIndex) {
		
		int row= wb.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
		return row;
	
		
	}

}
