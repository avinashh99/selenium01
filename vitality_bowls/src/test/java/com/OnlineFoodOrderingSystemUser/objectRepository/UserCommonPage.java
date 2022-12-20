package com.OnlineFoodOrderingSystemUser.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCommonPage {
	@FindBy(xpath = "//a[text()='Restaurants ']") private WebElement restaurantModule;
	@FindBy(linkText="My Orders") private WebElement myordersModule;
	@FindBy(xpath="//a[text()='Logout']") private WebElement logoutBtn;
	
	public UserCommonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnRestaurant()
	{
		restaurantModule.click();
	}
	public void clickOnMyOrdersModule()
	{
		myordersModule.click();
	}
	public void clickOnlogoutBtn()
	{
		logoutBtn.click();
	}

}
