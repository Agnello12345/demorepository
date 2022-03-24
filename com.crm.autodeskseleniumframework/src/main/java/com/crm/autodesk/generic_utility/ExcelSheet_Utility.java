package com.crm.autodesk.generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet_Utility 
{
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable
	{
        FileInputStream fisa = new FileInputStream("./src/test/resources/EXCELSHEET.xlsx");
	 	Workbook book = WorkbookFactory.create(fisa);
//	 	Sheet sh = book.getSheet(sheetName);
//	 	Row r = sh.getRow(rowNum);
//	 	String data=r.getCell(cellNum).getStringCellValue();
     	DataFormatter format=new DataFormatter();
		return format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
}
}