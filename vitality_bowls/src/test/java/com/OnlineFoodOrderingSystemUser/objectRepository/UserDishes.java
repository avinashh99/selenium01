package com.OnlineFoodOrderingSystemUser.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDishes {
	/**
	 * Here we declare the selectDish element by using @FindBy annotation
	 */
	@FindBy(linkText="Yorkshire Lamb Patties") private WebElement selectedDishes;
	/**
	 * Here we declare the element addToCart by using @FindBy annotation
	 */
	@FindBy(xpath="//a[text()='Yorkshire Lamb Patties']/ancestor::div[@class='food-item']/descendant::input[@class='btn theme-btn']") private WebElement addToCart;
	/**
	 * Here we declare the element checkOut by using @FindBy annotation
	 */
	@FindBy(linkText="Checkout") private WebElement checkout;
	/**
	 * Here we initialize all the elements by using initElements() method of PageFactory class by creating constructor
	 * @param driver
	 */
	public UserDishes(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * By using this method we click on selectedDish element
	 */
	
	public void clickOnSelectedDishes()
	{
		selectedDishes.click();
	}
	/**
	 * By using this method we can click on AddToCart feature
	 */
	public void clickOnAddToCart()
	{
		addToCart.click();
	}
	/**
	 * By using this we can click on CheckOut feature
	 */
	public void clickOnCheckout()
	{
		checkout.click();
	}
	

}
