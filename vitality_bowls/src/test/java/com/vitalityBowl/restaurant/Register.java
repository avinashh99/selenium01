package com.vitalityBowl.restaurant;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register {
	public static void main(String[] args) throws IOException, InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	FileInputStream fis= new FileInputStream("./src/test/resources/commondata.properties");
	Properties pr=new Properties();
	pr.load(fis);
	String url = pr.getProperty("url");
	driver.get(url);


	driver.findElement(By.xpath("//a[text()='Register']")).click();
	driver.findElement(By.id("example-text-input")).sendKeys("avsh");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("firstname")).sendKeys("fooe");
	driver.findElement(By.name("lastname")).sendKeys("fifoo");
	driver.findElement(By.id("exampleInputPassword1")).sendKeys("food1");
	driver.findElement(By.id("exampleInputPassword2")).sendKeys("food1");
	driver.findElement(By.id("exampleTextarea")).sendKeys("send food to this address");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(3000);
	driver.close();
	System.out.println("successfully registered");
	}


	}


