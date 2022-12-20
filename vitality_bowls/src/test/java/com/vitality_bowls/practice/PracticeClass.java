package com.vitality_bowls.practice;

import com.onlinefooddelivery.genericUtility.ExcelFile;
import com.onlinefooddelivery.genericUtility.IconstantPath;
import com.onlinefooddelivery.genericUtility.JavaUtility;
import com.onlinefooddelivery.genericUtility.PropertyFile;
import com.onlinefooddelivery.genericUtility.PropertyFileKeys;

public class PracticeClass {
	public static void main(String[] args)
	{
		PropertyFile p = new PropertyFile();
		//String data = p.getPropertyData("./src/test/resources/commondata.properties", "url");
		//System.out.println(data);
		ExcelFile e = new ExcelFile();
		String data1 = e.getExcelData("./src/test/resources/TestFData.xlsx", "Sheet1", 2, 1);
		System.out.println(data1);
		//PropertyFile f = new PropertyFile();
		//String url = f.getPropertyData(IconstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.URL.convertToString());
		//System.out.println(url);
		JavaUtility javautility = new JavaUtility();
		Long l = (Long) javautility.stringToAnyDataType("124", "long");
		System.out.println(l);
		
	}
	

}
