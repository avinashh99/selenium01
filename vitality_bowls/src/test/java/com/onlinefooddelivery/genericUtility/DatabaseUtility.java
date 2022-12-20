package com.onlinefooddelivery.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;


/**
 * This class contains all reusable actions of Database
 * @author qqqqqqqqqqqqqqqqqqqq
 *
 */
public class DatabaseUtility {
	private Connection connection;
	/**
	 * this method is used to fetch data from database
	 * @param query
	 * @param columnName
	 * @return
	 */
	public List<String> getDataFromDatabase(String query,String columnName)
	{
		ResultSet result=null;
		try {
			Statement statement = connection.createStatement();
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> list = new ArrayList<String>();
			try {
				while(result.next())
				{
					try {
						list.add(result.getString(columnName));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		
	}
	/**
	 * this method is used to connect jdbc with javacode
	 * @param dbURL
	 * @param dbUserName
	 * @param dbPassword
	 */
	public void openDBConnection(String dbURL,String dbUserName, String dbPassword)
	{
		Driver dbDriver=null;
		try {
			dbDriver = new Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbDriver);
			connection = DriverManager.getConnection(dbURL,dbUserName,dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * this method is used to close the connection
	 */
	
	public void closeDB()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to modify the database
	 * @param query
	 */
	public void modifyDataInDatabase(String query)
	{
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to verify the data is present in database or not 
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 */
	public boolean verifyDataInDatabase(String query,String columnName,String expectedData)
	{
		List<String> list = getDataFromDatabase(query,columnName);
		boolean flag = false;
		/*for(String actualData:list)
		{
			if(actualData.equals(expectedData))
			{
				flag=true;
				break;
			}
		}*/
		if(list.contains(expectedData))
			flag=true;
		return flag;
	}
	
	

}
