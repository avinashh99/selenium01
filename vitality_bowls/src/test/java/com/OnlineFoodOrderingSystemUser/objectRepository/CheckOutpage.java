package com.OnlineFoodOrderingSystemUser.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinefooddelivery.genericUtility.WebDriverUtility;

public class CheckOutpage{
	/**
	 * Here we declare the ordernowbutton by using @FindBy annotation
	 * @param driver
	 */
	@FindBy(name="submit") private WebElement ordernowbutton;
	/**
	 * Here we initialize the elements by using initElements() of PageFactory class by creating constructor
	 * @param driver
	 */
	
	public CheckOutpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 * By using this method we click on orderNow button feature
	 */
	
	
	public void clickOnOrdernowbutton()
	{
		ordernowbutton.click();
	}
	/**
	 * This method is used to handle the Alert Popup
	 * @param webdriverutility
	 * @param driver
	 */
	
	public void popupHandling(WebDriverUtility webdriverutility,WebDriver driver)
	{
		webdriverutility.switchToAlertWindowAndAccept(driver);
	}

}
