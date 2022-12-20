package com.OnlineFoodOrderingSystem.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinefooddelivery.genericUtility.WebDriverUtility;

public class AllRestaurantPage {
	/**
     * Here we are declaring restaurantName by using @FindBy annotation
     * @param driver
     */
	@FindBy(xpath = "//th[text()='Name']/ancestor::table/thead/following-sibling::tbody/tr[1]/td[2]") private  WebElement actualrestaurantname;
	/**
	 * here we initialize the elements by using initElements() methods of PageFactory class by creating constructor	
	 * @param driver
	 */
	public AllRestaurantPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * here we initialize elements by using initElements() method of PageFactory class which takes WebDriver  and current class object as an arguments
	 * @param webdriverutility
	 * @param restaurantname
	 */
	
	public void verifyRestaurantExisted(WebDriverUtility webdriverutility,String restaurantname)
	{
		String actrestaurantname = actualrestaurantname.getText();
		webdriverutility.verifyTheElementExisted(actrestaurantname, restaurantname);
	}
}
