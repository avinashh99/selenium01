package com.vitality_bowls.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis =  new FileInputStream("./src/test/resources/TestFData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		try
		{
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(2);
		row.getCell(1);
		
		DataFormatter dataFormatter = new DataFormatter();
		String data = dataFormatter.formatCellValue(sheet.getRow(2).getCell(1));
		System.out.println(data);
		}
		finally
		{
			workbook.close();
		}

	}

}
