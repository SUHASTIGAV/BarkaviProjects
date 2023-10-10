package org.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
public static String readDataFromExcel(String sheetName, int rowNo,int cellNo, String file) throws IOException
{
	File f = new File("C:\\Users\\Admin\\eclipse-workspace\\Mavenclass\\DataMaintain\\EmployeeDetails.xlsx");
	FileInputStream fin = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(fin);
	Sheet s = w.getSheet(sheetName);
	Row r =s.getRow(rowNo);
	Cell c = r.getCell(cellNo);
	
	int type=c.getCellType();
	String input="";
	if (type == 1)
	{
		 input = c.getStringCellValue();
		
	}
	else if (DateUtil.isCellDateFormatted(c))
	{
		Date da = c.getDateCellValue();
		SimpleDateFormat sim = new SimpleDateFormat("MMM dd,yyyy");
		 input = sim.format(da);
		
	}
	
	
	else	
	{
		double d = c.getNumericCellValue();
		long l = (long)d;
	 input =String.valueOf(l);
	
	}
	return input;
	
}

}