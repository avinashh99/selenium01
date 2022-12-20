package com.vitality_bowls.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase {

	public static void main(String[] args) throws SQLException  {
		String MobileName1 = "iphone 14";
		String price1 = "10000";
		String BrandName1 = "Apple";
		Driver dbdriver= new Driver();
		DriverManager.registerDriver(dbdriver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44", "root","root");
		try
		{
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from mobile;");
		List<String> list = new ArrayList<String>();
		while(result.next())
		{
			list.add(result.getString("MobileName").toLowerCase()+" || "+result.getString("price").toLowerCase()+" || "+result.getString("BrandName").toLowerCase());
		}
		if(list.contains(MobileName1.toLowerCase()+" || "+price1.toLowerCase()+" || "+BrandName1.toLowerCase()))
		{
		   System.out.println("data already existed");
		}
		else
		{
			statement.executeUpdate("insert into mobile values('"+MobileName1+"','"+price1+"','"+BrandName1+"');");
			System.out.println("Data updated successfully");
		}
		}
		finally
		{
			connection.close();
			System.out.println("connection closed successfully");
		}	
	}
}
