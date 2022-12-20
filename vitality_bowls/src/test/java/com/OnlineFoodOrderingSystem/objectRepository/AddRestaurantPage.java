package com.OnlineFoodOrderingSystem.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.onlinefooddelivery.genericUtility.IconstantPath;
import com.onlinefooddelivery.genericUtility.WebDriverUtility;
/**
 * @FindBy annotaion is used to declare the weblement
 * @author qqqqqqqqqqqqqqqqqqqq
 *
 */
public class AddRestaurantPage {
	@FindBy(name="res_name") private WebElement restaurantNameTextField;
	/**
	 * This annotation is used to declare the element 
	 */
	@FindBy(name="email") private WebElement businessemailTextField;
	/**
	 * This annotation is used to declare the element
	 */
	@FindBy(name="phone") private WebElement phoneTextField;
	/**
	 * This annotation is used to declare the element
	 */
	@FindBy(name="url") private WebElement websiteUrlTextField;
	/**
	 * This annotation is used to declare the element
	 */
	@FindBy(name="o_hr") private WebElement openhourTextBox;
	/**
	 * This annotation is used to declare the element
	 */
	@FindBy(name="c_hr") private WebElement closehourTextBox;
	/**
	 * This annotation is used to declare the element
	 */
	@FindBy(name="o_days") private WebElement opendaysTextBox;
	/**
	 * This annotation is used to declare the element
	 */
	@FindBy(name="file") private WebElement imageTextbox;
	/**
	 * This annotation is used to declare the element
	 */
	@FindBy(name="c_name") private WebElement selectCategoryTextbox;
	/**
	 * This annotation is used to declare the element
	 */
    @FindBy(name="address") private WebElement restaurantAddressTxtBox;
    /**
	 * This annotation is used to declare the element
	 */
    @FindBy(name="submit") private WebElement saveBtn;
    /**
     * this method is used to inialize the element
     * @param driver
     */
    public AddRestaurantPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    /**
     * this method is used to send restaurant name to the restauranttextfield
     * @param restaurantname
     */
    public void restaurantTextfield(String restaurantname)
    {
    	restaurantNameTextField.sendKeys(restaurantname);
    }
    /**
     * this is method is used to send the businessemail
     * @param businessemail
     */
    public void businessemailTextfield(String businessemail)
    {
    	businessemailTextField.sendKeys(businessemail);
    }
    /**
     * this method is used to send the phonenumber in phoneTextField
     * @param phone
     */
    public void phoneTextfield(String phone)
    {
    	phoneTextField.sendKeys(phone);
    }
    /**
     * this method is used to send website url in websiteUrlTextField
     * @param websiteurl
     */
    public void websiteurlTextfield(String websiteurl)
    {
    	websiteUrlTextField.sendKeys(websiteurl);
    }
    /**
     * this method is used to select value from openHour dropdown webelement
     * @param webdriverutility
     */
    public void openhourTextBoxTexBox(WebDriverUtility webdriverutility)
    {
    	
    	webdriverutility.selectByValue(openhourTextBox, "10am");
    	
    }
    /**
     * this method is used to select from closehour dropdown element 
     * @param webdriverutility
     */
    public void closehourTextBox(WebDriverUtility webdriverutility)
    {
    	
    	webdriverutility.selectByValue(closehourTextBox, "10pm");
    	
    }
    /**
     * this method is used to select value from opendays dropdown element
     * @param webdriverutility
     */ 
    public void opendaysTextBox(WebDriverUtility webdriverutility)
    {
    	
    	webdriverutility.selectByValue(opendaysTextBox, "Mon-Sat");
    }
     /**
      * this method is used to upload image in restaurantimage webelement
      * @param webdriverutility
      */
    public void imageTextbox(WebDriverUtility webdriverutility)
    {
    	
    	String imgpath = webdriverutility.getAbsolutePath(IconstantPath.IMAGEPATH);
    	imageTextbox.sendKeys(imgpath);
    }
    /**
     * this method is used to select from selectCategory dropdown element
     * @param webdriverutility
     */
    public void selectCategoryTextbox(WebDriverUtility webdriverutility)
    {
    	
    	webdriverutility.select(selectCategoryTextbox, "Italian");
    	
    }
    /**
     * this method is used to send the address in the restaurant address element
     * @param restaurantAdress
     */
    public void restaurantAddressTxtBox(String restaurantAdress)
    {
    	restaurantAddressTxtBox.sendKeys(restaurantAdress);
    }
    /**
     * this method is used to click on save button
     */
    public void saveBtn()
    {
    	saveBtn.click();
    }
    
    	
    
    
    
    
}
