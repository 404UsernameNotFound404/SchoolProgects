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
