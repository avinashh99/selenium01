package com.vitality_bowls.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestFData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		int lastRownum = sheet.getLastRowNum();
		short lastCellnum = sheet.getRow(0).getLastCellNum();
		String expectedTestcase = "CreateContactWithOrganizationTest";
		String expectedKey = "ExpectedOrders";
		String value = "";
		for(int i =0;i<=lastRownum;i++)
		{
			String ActualTestcase = sheet.getRow(i).getCell(0).getStringCellValue();
			if(ActualTestcase.equals(expectedTestcase))
			{
				for(int j=1;j<lastCellnum;j++)
				{
					String actualKey = sheet.getRow(i).getCell(j).getStringCellValue();
					if(actualKey.equals(expectedKey))
					{
						value = sheet.getRow(i+1).getCell(j).getStringCellValue();
						break;
					}
					
					
				}
				break;
			}
			
		}
		System.out.println(value);

	}

}
