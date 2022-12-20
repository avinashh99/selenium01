package com.vitality_bowls.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTesting {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/s?k=apple+iphone&crid=1AJVIYS33KIZ2&sprefix=apple+iphone%2Caps%2C371&ref=nb_sb_noss_1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/**
		 * Apple iPhone 12 (64GB) - Purple
		 * Apple iPhone 14 128GB Blue
		 * 
		 */
		
		List<String> al = new ArrayList<String>();
		al.add("Apple iPhone 12 (64GB) - Purple");
		al.add("Apple iPhone 14 128GB Blue");
		for(String a:al)
		{
			String phname= driver.findElement(By.xpath("//span[text()='"+a+"']/ancestor::h2/preceding-sibling::div/parent::div/following-sibling::div[@class='sg-row']//span[@class='a-price-whole']")).getText();
		System.out.println(phname);
		}

	}

}
