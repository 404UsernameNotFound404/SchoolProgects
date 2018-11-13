import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BasicQueue 
{
	ArrayList<Customer> arrLQueue;
	int start = 0, end = 4;
	int numberOfEntries = 0;
	Random r;
	public ArrayList<String> orders;
	public ArrayList<String> names;
	
	boolean isFull;
	boolean isEmpty = false;
	
	
	public BasicQueue(ArrayList<String> orders, ArrayList<String> names)
	{
		r = new Random();
		arrLQueue = new ArrayList<Customer>();
		for(int x = 0;x < 10;x++)
		{
			arrLQueue.add(new Customer(names.get(r.nextInt(29)), orders.get(r.nextInt(9))));
			numberOfEntries++;
			isFull = true;
		}
		this.orders = orders;
		this.names = names;
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
		
	}
	public int size()
	{
		return numberOfEntries - start;
	}
	@Override
	public String toString() 
	{
		String placeHolderToString = "";
		
		for(int x = start;x < numberOfEntries;x++)
		{
			//System.out.println(x);
			//placeHolderToString = placeHolderToString + arrLQueue.get(x) + " Number X: " + x + "\n";
			placeHolderToString = placeHolderToString + arrLQueue.get(x) + "\n";
		}	
		return placeHolderToString;
	}
}
