package com.vitality_bowls.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class FetchDataFromProperty {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties property = new Properties();
		property.load(fis);
		String browser = property.getProperty("browser").trim();
		String url = property.getProperty("url").trim();
		String username = property.getProperty("username").trim();
		String password = property.getProperty("password").trim();
		String timeout = property.getProperty("timeout").trim();
		int randomnumber = new Random().nextInt(1000);

	}

}
