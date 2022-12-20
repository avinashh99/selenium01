package com.onlinefooddelivery.genericUtility;

public enum SheetName {
	
	SHEET1("Sheet1"),SHEETNAME2("System Test Case");
	
	private String keys;
	//setter
	private SheetName(String keys)
	{
		this.keys=keys;
	}
	//getter
	
	public String convertToString()
	{
		return keys.toString();
	}

}
