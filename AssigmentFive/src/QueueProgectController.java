/*
 * Name: Henry Morris

 * Date: 11/27/2018
 * 
 * Constructors: 
 * 
 * Main:
 * The main has to parts
 * 1st is reading the files orders.txt, and names.txt and putting there contents into two diffrent array lists 
 */

import java.io.BufferedReader;
import java.io.Console;
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
		queue = new BasicQueue();
		boolean menu = true;
		int UserInput;
		
		while(menu)
		{
			GetInput GI = new GetInput();
			System.out.println("Welcome To Coffe Shop Queue 9000");
			System.out.println("1 = Display People In Queue");
			System.out.println("2 = Dequeue Person From Line");
			System.out.println("3 = Eneque person to line");
			System.out.println("4 = How Many People In Line");
			System.out.println("5 = Remove Someone With Index");
			System.out.println("6 = Add Someone To Line");
			System.out.println("7 = Exit");
			
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
						//System.out.println("Person removed " + queue.start + " number of entires " + queue.numberOfEntries);
						//System.out.println(queue);
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
						//System.out.println("New array with new person added");
						//System.out.println(queue);
					}else
					{
						System.out.println("ERROR to many pepole in line");
					}
					break;
				case 4:
					System.out.println("Number of people in queue " + queue.size());
					break;
				case 5:
					System.out.println("Please type in the index of the person you would like to remove.");
					queue.remove();
					break;
				case 6:
					System.out.print("You have added a person.");
					queue.add();
					break;
				case 7:
					System.out.println("Goodbye");
					System.exit(0);
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
