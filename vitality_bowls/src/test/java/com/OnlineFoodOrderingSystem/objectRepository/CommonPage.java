package com.OnlineFoodOrderingSystem.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
	/**
	 * Here restaurantModule is declared by using @FindBy annotation
	 */
	@FindBy(xpath = "//span[text()='Restaurant']") private WebElement restaurantModule;
	/**
	 * Here addrestaurantFeature is declared by using @FindBy annotation
	 */
	@FindBy(linkText="Add Restaurant") private WebElement addrestaurantFeature;
	/**
	 * Here allRestaurant is declared by using @FindBy annotation
	 */
	@FindBy(linkText="All Restaurants") private WebElement allRestaurant;
	/**
	 * here all the elements are initialized by using @FindBy annotation by creating constructor
	 */
	public CommonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is used to click on restaurant module
	 */
	
	public void clickOnRestaurant()
	{
		restaurantModule.click();
	}
	/**
	 * This method is used to click on AddRestaurant feature
	 */
	public void clickOnAddRestaurant()
	{
		addrestaurantFeature.click();
	}
	/**
	 * This method is used to click on AllRestaurant feature
	 */
	public void clickOnAllRestaurant()
	{
		allRestaurant.click();
	}
	

}
