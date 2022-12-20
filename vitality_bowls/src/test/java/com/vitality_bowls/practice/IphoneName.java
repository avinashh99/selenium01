package com.vitality_bowls.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IphoneName {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		System.out.println(100/0 );
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("iphone"+Keys.ENTER);
		List<WebElement> allph = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> allprice = driver.findElements(By.xpath("//div[@class='_4rR01T']/../..//div[@class='_30jeq3 _1_WHN1']"));
		for(int i =0;i<allph.size();i++)
		{
			String text = allph.get(i).getText();
			String text1 = allprice.get(i).getText();
			System.out.println(text +"="+text1);
		}
		driver.quit();

	}

}
