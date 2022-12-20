package com.onlinefooddelivery.genericUtility;

import java.util.Random;

/**
 * This class contains java resuable methods
 * @author qqqqqqqqqqqqqqqqqqqq
 *
 */
public class JavaUtility {
	/**
	 * This method is used to convert string to Long and int datatype
	 * @param s
	 * @param strategy
	 * @return
	 */
	public Object stringToAnyDataType(String s,String strategy)
	{
		Object convertedData = null;
		if(strategy.equals("int"))
		{
			convertedData = Integer.parseInt(s);
		}
		else if(strategy.equals("long"))
		{
			convertedData = Long.parseLong(s);
		}
		return convertedData;
	}
	/**
	 * this method is used to get the random number
	 * @param limit
	 * @return
	 */
	
	public int getRandomNumber(int limit)
	{
		int randomnumber = new Random().nextInt(limit);
		return randomnumber;
	}

}
