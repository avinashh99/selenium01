package com.OnlineFoodOrderingSystemUser.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginpage {
	/**
	 * Here we declare the element usernameTextBox by using @FindBy annotation
	 */
	@FindBy(name="username") private WebElement usernameTextBox;
	/**
	 * Here we declare the element passwordTextBox by using @FindBy annotation
	 */
	@FindBy(name="password") private WebElement passwordTextBox;
	/**
	 * Here we declare the element loginTextBox by using @FindBy annotation
	 */
	@FindBy(name="submit") private WebElement loginTextBox;
	/**
	 * Here we initialize all the elements by using initElements() method of PageFactory class by creating constructor
	 * @param driver
	 */
	public UserLoginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * By using this method we can perform login action by using  passing username and password as an arguments
	 * @param username
	 * @param password
	 */
	public void loginAction(String username,String password)
	{
		usernameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginTextBox.click();
	}

}
