import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueProgectController {
	
	static BasicQueue queue;
	public int totalRolls;
	public int[] total;

	public static void main(String[] args) 
	{			
		//Queue<Costumer> q = new LinkedList<Costumer>();
		File textFileWithNames = new File("names.txt");
		File textFileWithOrders = new File("orders.txt");
		ArrayList<String> cosNamesArr = new ArrayList<String>();
		ArrayList<String> cosOrdersArr = new ArrayList<String>();
		Random r; 
		
		boolean menu = true;
		
		int UserInput;
		r = new Random();
		
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
			queue = new BasicQueue(cosOrdersArr, cosNamesArr);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println(queue);
		while(menu)
		{
			GetInput GI = new GetInput();
			System.out.println("Welcome To Coffe Shop Queue 9000");
			System.out.println("1 = Display People In Queue");
			System.out.println("2 = Dequeue Person From Line");
			System.out.println("3 = add new person to line");
			System.out.println("4 = How Many People In Line");
			System.out.println("5 = Remove Someone With Index");
			
			UserInput = GI.GetInputInt();
			switch(UserInput) //this switch statement takes user input and gives them the option they wanted
			{
				case 1:
					System.out.println(queue.toString());
					break;
				case 2:
					if(queue.start < queue.numberOfEntries)
					{
						queue.dequeue();
						System.out.println("New array with first person removed " + queue.start + "number of entires " + queue.numberOfEntries);
						System.out.println(queue);
					}
					else
					{
						System.out.println("Error no cosutmers in line so no one to remove dumb dumb");
					}
					break;
				case 3:
					if(queue.start > 0 && queue.start != 0)
					{
						queue.enqueue();
						System.out.println("New array with new person added");
						System.out.println(queue);
					}else
					{
						System.out.println("ERROR to many pepole in line");
					}
					break;
				case 4:
					System.out.println("Number of people in queue " + queue.size());
					break;
			}
			//System.out.println("Would you like to do something else?");
			//if(GI.GetInputYes() == 0)
			//{
			//	menu = false;
			//2}
		}
	}
}
