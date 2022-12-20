package com.OnlineFoodOrderingSystemUser.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRestaurantPage {
	/**
	 * Here we declare the element selectedRestaurant by using @FindBy annotation
	 */
	@FindBy(linkText="North Street Tavern") private WebElement selectedRestaurant;
	/**
	 * Here we initialize all the elements by using initElements() method of PageFactory class by creating constructor
	 * @param driver
	 */
	
	public UserRestaurantPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * By using this method we can click on selectedRestaurant
	 */
	
	public void clickOnSelectedRestaurant()
	{
		selectedRestaurant.click();
	}

}
