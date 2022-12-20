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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.OnlineFoodOrderingSystemUser.objectRepository.CheckOutpage;
import com.OnlineFoodOrderingSystemUser.objectRepository.MyOrderpage;
import com.OnlineFoodOrderingSystemUser.objectRepository.UserCommonPage;
import com.OnlineFoodOrderingSystemUser.objectRepository.UserDishes;
import com.OnlineFoodOrderingSystemUser.objectRepository.UserLoginpage;
import com.OnlineFoodOrderingSystemUser.objectRepository.UserRestaurantPage;
import com.onlinefooddelivery.genericUtility.ExcelFile;
import com.onlinefooddelivery.genericUtility.IconstantPath;
import com.onlinefooddelivery.genericUtility.JavaUtility;
import com.onlinefooddelivery.genericUtility.PropertyFile;
import com.onlinefooddelivery.genericUtility.PropertyFileKeys;
import com.onlinefooddelivery.genericUtility.SheetName;
import com.onlinefooddelivery.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderPlaced
{

	public static void main(String[] args) {
		PropertyFile p = new PropertyFile();
		JavaUtility javautility = new JavaUtility();
		WebDriverUtility webdriverutility = new WebDriverUtility();
		p.propertyFilePath(IconstantPath.PROPERTY_FILE_PATH2);
		String browser = p.getPropertyData( PropertyFileKeys.BROWSER.convertToString());
		String url = p.getPropertyData( PropertyFileKeys.URL.convertToString());
		String username = p.getPropertyData( PropertyFileKeys.USERNAME.convertToString());
		String password = p.getPropertyData( PropertyFileKeys.PASSWORD.convertToString());
		String timeout1 = p.getPropertyData( PropertyFileKeys.TIMEOUT.convertToString());
		Long timeout = (Long) javautility.stringToAnyDataType(timeout1, "long");
		ExcelFile excelfile = new ExcelFile();
	    String expectedOrder = excelfile.getExcelData(IconstantPath.TESTFDATA_EXCELPATH,SheetName.SHEET1.convertToString(), 2, 3);
		WebDriver driver = webdriverutility.launchApplication(browser, timeout, url);
		CheckOutpage checkoutpage = new CheckOutpage(driver);
		UserLoginpage userloginpage=new UserLoginpage(driver);
		userloginpage.loginAction(username, password);
		UserCommonPage usercommonpage = new UserCommonPage(driver);
		usercommonpage.clickOnRestaurant();
		UserRestaurantPage userrestaurantpage = new UserRestaurantPage(driver);
		userrestaurantpage.clickOnSelectedRestaurant();
		UserDishes userdishes = new UserDishes(driver);
		userdishes.clickOnSelectedDishes();
		userdishes.clickOnAddToCart();
		userdishes.clickOnCheckout();
		checkoutpage.clickOnOrdernowbutton();
		checkoutpage.popupHandling(webdriverutility,driver);
		checkoutpage.popupHandling(webdriverutility,driver);
		MyOrderpage myorderpage = new MyOrderpage(driver);
		myorderpage.verifyTheElement(webdriverutility, expectedOrder);
		webdriverutility.closeBrowser(driver);

	}

}
