package com.vitalityBowl.restaurant;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.OnlineFoodOrderingSystemUser.objectRepository.MyOrderpage;
import com.OnlineFoodOrderingSystemUser.objectRepository.UserCommonPage;
import com.OnlineFoodOrderingSystemUser.objectRepository.UserLoginpage;
import com.onlinefooddelivery.genericUtility.ExcelFile;
import com.onlinefooddelivery.genericUtility.IconstantPath;
import com.onlinefooddelivery.genericUtility.JavaUtility;
import com.onlinefooddelivery.genericUtility.PropertyFile;
import com.onlinefooddelivery.genericUtility.PropertyFileKeys;
import com.onlinefooddelivery.genericUtility.SheetName;
import com.onlinefooddelivery.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderDispatch {
	public static void main(String[] args) throws IOException {

		PropertyFile f = new PropertyFile();
		WebDriverUtility webdriverutility = new WebDriverUtility();
		f.propertyFilePath(IconstantPath.PROPERTY_FILE_PATH2);
		String browser = f.getPropertyData(PropertyFileKeys.BROWSER.convertToString());
	    String url = f.getPropertyData(PropertyFileKeys.URL.convertToString());
		String username = f.getPropertyData(PropertyFileKeys.USERNAME.convertToString());
		String password = f.getPropertyData(PropertyFileKeys.PASSWORD.convertToString());
		String timeout1 = f.getPropertyData(PropertyFileKeys.TIMEOUT.convertToString());
		JavaUtility javautility = new JavaUtility();
		Long timeout = (Long) javautility.stringToAnyDataType(timeout1, "long");
		ExcelFile ef = new ExcelFile();
		String data = ef.getExcelData(IconstantPath.TESTDATA_EXCELPATH,SheetName.SHEETNAME2.convertToString(), 1, 1);
		WebDriver driver = webdriverutility.launchApplication(browser, timeout, url);
		UserLoginpage userloginpage = new UserLoginpage(driver);
		userloginpage.loginAction(username, password);
		MyOrderpage myorderpage = new MyOrderpage(driver);
		UserCommonPage usercommonpage = new UserCommonPage(driver);
		usercommonpage.clickOnMyOrdersModule();
		myorderpage.verifyOrderedDispatch();
		usercommonpage.clickOnlogoutBtn();
		webdriverutility.closeBrowser(driver);
		   }

		}


