package com.OnlineFoodOrderingSystemUser.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinefooddelivery.genericUtility.WebDriverUtility;

public class MyOrderpage {
	/**
	 * Here we declare the actualOrders by using @FindBy annotation
	 */
	@FindBy(xpath="//td[text()=' Yorkshire Lamb Patties']") private WebElement actualOrders;
	/**
	 * Here we declare the orderedItem by using @FindBy annotation
	 */
	@FindBy(xpath="//td[text()=' Yorkshire Lamb Patties']") private WebElement orderedItem;
	/**
	 * Here we declare the deleteIconOfOrderedElement by using @FindBy annotation
	 */
	@FindBy(xpath="//td[text()=' Yorkshire Lamb Patties']/following-sibling::td[5]/a/i[@class='fa fa-trash-o']") private WebElement deleteIconofOrderedItem;
	/**
	 * Here we declare the allOrderedItem by using @FindBy annotation
	 */
	@FindBy(xpath="//td[@data-column='Item']") private List<WebElement> allOrderedItem;
	/**
	 * Here we declare dispatchOrder by using @FindBy annotation
	 */
	@FindBy(xpath="//tr//td[4]/button") private WebElement dispatchOrder;
	/**
	 * Here we initialize allelements by using initElements() method of PageFactory class by creating constructor
	 * @param driver
	 */
	public MyOrderpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * By using this method we get the text of the element
	 * @return
	 */
	public String getTextActualOrders()
	{
		String actualorder = actualOrders.getText();
		return actualorder;
	}
	/**
	 * By using this method we verify the element is present or not
	 * @param webdriverutility
	 * @param expectedOrder
	 */
	
	public void verifyTheElement(WebDriverUtility webdriverutility,String expectedOrder)
	{
		webdriverutility.verifyTheElementExisted(getTextActualOrders(), expectedOrder);
	}
	/**
	 * By using this method we can click on deleteIcon of Ordered Item
	 */
	public void clickondeleteIconofOrderedItem()
	{
		deleteIconofOrderedItem.click();
	}
	public void handlePopup(WebDriver driver,WebDriverUtility webdriverutility)
	{
		webdriverutility.switchToAlertWindowAndAccept(driver);
	}
	/**
	 * By using this method we can verify whether the element is deleted or not
	 */
	public void verifyElementDeleted()
	{
		for(WebElement order:allOrderedItem)
		{
			String actualOrder = getTextActualOrders();
			if(order.equals(actualOrder))
			{
				System.out.println("Order not deleted");
				break;
			}
			else
			{
				System.out.println("Order not deleted");
				break;
			}
		}
	}
	/**
	 * By using we can get the text of dispatched element
	 * @return
	 */
	public String getTextDispatchOrder()
	{
		String dispatchText = dispatchOrder.getText();
		return dispatchText;
	}
	/**
	 * By using this method we can verify the order is dispatched or not
	 */
	
	public void verifyOrderedDispatch()
	{
		Object actualDispatch = getTextDispatchOrder();
		String expecteddispatch = "Dispatch";
		if(actualDispatch.equals(expecteddispatch))
		{
			System.out.println("order dispatched");
		}
		else
		{
			System.out.println("order not dispatched");
		}
	}
	

}
