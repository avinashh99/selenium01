package com.OnlineFoodOrderingSystem.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	/**
	 * Here we are declaring the usernameTextField by using @FindBy annotation
	 */
	@FindBy(name="username") private WebElement userNameTextField;
	/**
	 * Here we are declaring the passwordTextField by using @FindBy annotation
	 */
	@FindBy(name="password") private WebElement passwordTextField;
	/**
	 * Here we are declaring the loginBtn by using @FindBy annotation
	 */
	@FindBy(name="submit") private WebElement loginBtn;
	/**
	 * Here we initialize the element by using initElements method of PageFactory class which takes WebDriver and Current class object as an arguments
	 * @param username
	 * @param password
	 */
	
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * By using this method we perform login action in the application
	 */
	
	public void loginToApplication(String username,String password)
	{
       userNameTextField.sendKeys(username);
       passwordTextField.sendKeys(password);
       loginBtn.click();
	}
}
