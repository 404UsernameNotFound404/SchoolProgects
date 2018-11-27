/*
 * Name: Henry Morris

 * Date: 11/16/2018
 * 
 * Constructors: 
 * -BasicQueue(ArrayList<String> orders, ArrayList<String> names)the constructor populates the array list with 10 costumers
 * the constuctor also gives this class acess to the orders and names arraylist of strings which I need to make more costumers
 * Methods:
 * dequeue() This method adds one to start so as not to delete it without using a lot of processing power it also checks if the queue is now empty
 * enqueue() This method takes one away from start to add another person to line and not to have the same person you have dequeued it makes that
 * remove() This method takes one away from numberOfEntries and removes the person from line at the given index the person inputs
 * add() This method adds one to numberOfEntries and adds a new person to start of line 
 * isFull() this returns isFull boolean which is updated when ever a relevant function is run
 * isEmpty() this returns isEmpty boolean which is updated when ever a relevant function is run
 * size() this returns number of entries - start which equals the number of entries 
 * toString:
 * the to string outputs all the values in the array list()
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BasicQueue 
{
	ArrayList<Customer> arrLQueue;
	int start = 0;
	int numberOfEntries = 0;
	Random r;
	public ArrayList<String> orders;
	public ArrayList<String> names;
	
	boolean isFull;
	boolean isEmpty = false;
	
	
	public BasicQueue()
	{
		//Queue<Costumer> q = new LinkedList<Costumer>();
		File textFileWithNames = new File("names.txt");
		File textFileWithOrders = new File("orders.txt");
		ArrayList<String> cosNamesArr = new ArrayList<String>();
		ArrayList<String> cosOrdersArr = new ArrayList<String>();
				
		try 
		{
			BufferedReader brNames = new BufferedReader(new FileReader(textFileWithNames));
			BufferedReader brOrder = new BufferedReader(new FileReader(textFileWithOrders));
			while(brNames.ready())
			{
				cosNamesArr.add(brNames.readLine());
			}
			while(brOrder.ready())
			{
				cosOrdersArr.add(brOrder.readLine());
			}
			for(int x = 0;x < cosNamesArr.size();x++)
			{
						//queue.enqueue(cosNamesArr.get(r.nextInt(29)), cosOrdersArr.get(r.nextInt(9)));
			}
					
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
				orders = cosOrdersArr;
				names = cosNamesArr;
		r = new Random();
		arrLQueue = new ArrayList<Customer>();
		for(int x = 0;x < 10;x++)
		{
			arrLQueue.add(new Customer(names.get(r.nextInt(29)), orders.get(r.nextInt(9))));
			numberOfEntries++;
			isFull = true;
		}
		
	}
	public void dequeue()
	{
		//System.out.println("DEQUEU");
		start++;
		if(start == numberOfEntries)
		{
			isEmpty = true;
		}
		if(start != 0)
		{
			isFull = false;
		}
	}
	public void enqueue()
	{
		r = new Random();		
		arrLQueue.set(start, new Customer(names.get(r.nextInt(29)), orders.get(r.nextInt(9))));
		start--;
		isEmpty = false;
		//numberOfEntries++;
	}
	public boolean isFull()
	{
		return isFull;
	}
	public boolean isEmpty()
	{
		return isEmpty;
	}
	public void remove()
	{
		
		GetInput inputController = new GetInput();
		Iterator<Customer> iterForRemove = arrLQueue.iterator();
		int intInputForRemove = inputController.GetInputInt();
		while(iterForRemove.hasNext())
		{
			Customer next = iterForRemove.next();
			//System.out.println(next.Order + "==" + arrLQueue.get(intInputForRemove).Order);
			if(next.costumerName.compareTo(arrLQueue.get(intInputForRemove).costumerName) == 0 && next.Order.compareTo(arrLQueue.get(intInputForRemove).Order) == 0)
			{
				//System.out.println("--------------------------- " + next);
				iterForRemove.remove();
				//start++;
				numberOfEntries--;
				break;
			}
		}
	}
	public int size()
	{
		return numberOfEntries - start;
	}
	public void add()
	{
		arrLQueue.add(new Customer(names.get(r.nextInt(29)), orders.get(r.nextInt(9))));
		numberOfEntries++;
	}
	@Override
	public String toString() 
	{
		String placeHolderToString = "";
		
		for(int x = start;x < arrLQueue.size();x++)
		{
			//System.out.println(x);
			//placeHolderToString = placeHolderToString + arrLQueue.get(x) + " Number X: " + x + "\n";
			placeHolderToString = placeHolderToString + arrLQueue.get(x) + "\n";
		}	
		return placeHolderToString;
	}
}
