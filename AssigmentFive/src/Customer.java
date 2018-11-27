/*
 * Name: Henry Morris


 * Date: 11/27/2018
 * 
 * Constructors: 
 * Customer(String name, String order) the constructor takes a name and order then sets them to the local variables costumerName and order respectively
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Customer 
{
	String costumerName;
	String Order;
	public Customer(String name,String order)
	{
		//System.out.println(order);
		Order = order;
		costumerName = name;
	}
	@Override
	public String toString() 
	{
		return costumerName + ": " + Order;
		 
	}
	
}
