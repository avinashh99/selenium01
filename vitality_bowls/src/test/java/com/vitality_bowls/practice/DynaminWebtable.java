package com.vitality_bowls.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynaminWebtable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("SubmitButton")).click();
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
		String expectedOrgName = "tcs40";
		//driver.findElement(By.xpath("//a[text()='"+expectedOrgName+"']/a[text()='Organizations']")).click();
		List<WebElement> listOrg = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]"));
		for(int i=1;i<listOrg.size();i++)
		{
			String actualName = listOrg.get(i).getText();
			if(actualName.equals(expectedOrgName))
			{
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(i+2)+"]/td/input")).click();
				break;
			}
		
		}

	}
}


