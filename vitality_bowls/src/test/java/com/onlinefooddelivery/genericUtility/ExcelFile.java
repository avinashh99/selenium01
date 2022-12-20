package com.onlinefooddelivery.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {
	
	private FileInputStream fis=null;
	private Workbook workbook=null;
    /**
     * This method is used to fetch the data from property file
     * @param filePath
     * @param sheetname
     * @param row
     * @param cell
     * @return
     */
	public String getExcelData(String filePath,String sheetname,int row,int cell)
	{
		String data = null;
		try {
		fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetname);
			DataFormatter dataFormatter = new DataFormatter();
			data = dataFormatter.formatCellValue(sheet.getRow(row).getCell(cell));
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
			
	}
	public void closeExcelFile()
	{
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
