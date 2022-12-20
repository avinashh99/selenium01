package com.vitalityBowl.restaurant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OnlineFoodOrderingSystem.objectRepository.AddRestaurantPage;
import com.OnlineFoodOrderingSystem.objectRepository.AdminLoginPage;
import com.OnlineFoodOrderingSystem.objectRepository.AllRestaurantPage;
import com.OnlineFoodOrderingSystem.objectRepository.CommonPage;
import com.onlinefooddelivery.genericUtility.ExcelFile;
import com.onlinefooddelivery.genericUtility.IconstantPath;
import com.onlinefooddelivery.genericUtility.JavaUtility;
import com.onlinefooddelivery.genericUtility.PropertyFile;
import com.onlinefooddelivery.genericUtility.PropertyFileKeys;
import com.onlinefooddelivery.genericUtility.SheetName;
import com.onlinefooddelivery.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddRestaurant {

	public static void main(String[] args) throws IOException {
		PropertyFile f = new PropertyFile();
		f.propertyFilePath(IconstantPath.PROPERTY_FILE_PATH);
		String browser = f.getPropertyData(PropertyFileKeys.BROWSER.convertToString());
	    String url = f.getPropertyData(PropertyFileKeys.URL.convertToString());
		String username = f.getPropertyData(PropertyFileKeys.USERNAME.convertToString());
		String password = f.getPropertyData(PropertyFileKeys.PASSWORD.convertToString());
		String timeout1 = f.getPropertyData(PropertyFileKeys.TIMEOUT.convertToString());
		JavaUtility javautility = new JavaUtility();
		Long timeout = (Long) javautility.stringToAnyDataType(timeout1, "long");
		String randomnumberlimit = f.getPropertyData(PropertyFileKeys.RANDOM_NUMBER_LIMIT.convertToString());
		int randomnumber = javautility.getRandomNumber((Integer) javautility.stringToAnyDataType(randomnumberlimit, "int"));
		ExcelFile ef = new ExcelFile();
		String restaurantname = ef.getExcelData(IconstantPath.Excel_PATH, SheetName.SHEET1.convertToString(), 2, 1)+randomnumber;
		String phone = ef.getExcelData(IconstantPath.Excel_PATH, SheetName.SHEET1.convertToString(), 2, 2);
		String businessemail = ef.getExcelData(IconstantPath.Excel_PATH, SheetName.SHEET1.convertToString(), 2, 3);
		String websiteurl = ef.getExcelData(IconstantPath.Excel_PATH, SheetName.SHEET1.convertToString(), 2, 4);
		String restaurantaddress = ef.getExcelData(IconstantPath.Excel_PATH, SheetName.SHEET1.convertToString(), 2, 5);
		String imageaddress = ef.getExcelData(IconstantPath.Excel_PATH, SheetName.SHEET1.convertToString(), 2, 6);
		WebDriverUtility webdriverutility = new WebDriverUtility();
		WebDriver driver = webdriverutility.launchApplication(browser, timeout, url);
		AdminLoginPage loginpage = new AdminLoginPage(driver);
		loginpage.loginToApplication(username, password);
		CommonPage commonpage = new CommonPage(driver);
		commonpage.clickOnRestaurant();
		commonpage.clickOnAddRestaurant();
		AddRestaurantPage addrestaurantpage = new AddRestaurantPage(driver);
		addrestaurantpage.restaurantTextfield(restaurantname);
		addrestaurantpage.businessemailTextfield(businessemail);
		addrestaurantpage.phoneTextfield(phone);
		addrestaurantpage.websiteurlTextfield(websiteurl);
		addrestaurantpage.openhourTextBoxTexBox(webdriverutility);
		addrestaurantpage.closehourTextBox(webdriverutility);
		addrestaurantpage.opendaysTextBox(webdriverutility);
		addrestaurantpage.imageTextbox(webdriverutility);
		addrestaurantpage.selectCategoryTextbox(webdriverutility);
		addrestaurantpage.restaurantAddressTxtBox(restaurantaddress);
		addrestaurantpage.saveBtn();
		commonpage.clickOnAllRestaurant();
		AllRestaurantPage allrestaurantpage = new AllRestaurantPage(driver);
		allrestaurantpage.verifyRestaurantExisted(webdriverutility, restaurantname);
	    webdriverutility.closeBrowser(driver);

	}

}
