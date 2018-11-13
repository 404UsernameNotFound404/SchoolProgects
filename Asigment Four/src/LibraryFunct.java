/*
 * Name: Henry Morris

 * Date: 11/2/2018
 * 
 * Constructors: 
 * Methods:
 * public void readFile(File file)
 * -this method reads a line from the file and passes into addBook method
 * public void AddBook(String input)
 * -AddBook method takes argument of a string and creates a new book instance with the string as a argument
 * public void reSortByLastName()
 * -this method creates a new array list and puts all the books from bookArrL into the array after using sortArrL(Book toBeSorted,ArrayList<Book> arrayListToUse)
 * public void sortArrL(Book toBeSorted,ArrayList<Book> arrayListToUse)
 * -this takes a book that needs sorting and an array to sort it into. It sorts it by last name of author. More details in actually method.
 * public void selectionSortCost()
 * -Comments in actually method
 * public void bubbleSortTitle()
 * -Comments in actually method
 * public boolean checkInfo(String allInfo)
 * -This method takes a string which is input from user and checks if it is proper input using a try and catch statement.
 * Getters and Setters:
 * Book getBook(int c)
 * -this returns the book at the index of the argument c
 * int getArraySize()
 * -this returns size of array as int
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class LibraryFunct 
{
	ArrayList<Book> bookArrL = new ArrayList<Book>();
	Book instanceBook;
	FileReader fr;
	BufferedReader br;
	
	int currentSort = 2;
	
	public void readFile(File file)
	{
		try 
		{
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while(br.ready())
			{
				AddBook(br.readLine());
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
		
	}
	public void AddBook(String input)
	{
		instanceBook = new Book(input, bookArrL);
		if(!instanceBook.Equals())
		{
			switch(currentSort)
			{
				case 2:
					sortArrL(instanceBook,bookArrL);
					break;
				case 1:
					bookArrL.add(instanceBook);
					selectionSortCost();
					break;
				case 0:
					bookArrL.add(instanceBook);
					bubbleSortTitle();
					break;
			}
		}
		else 
		{
			System.out.println("Equals");
			ErrorFrame error = new ErrorFrame();
			error.show();
		}
	}
	public void reSortByLastName()
	{
		currentSort = 2;
		ArrayList<Book> tempArrayList = new ArrayList<Book>();
		for(int x  = 0;x < bookArrL.size();x++)
		{
			sortArrL(bookArrL.get(x),tempArrayList);
		}
		bookArrL = tempArrayList;
	}
	public void sortArrL(Book toBeSorted,ArrayList<Book> arrayListToUse)
	{
		boolean foundSmall = true;
		for(int x = 0;x < arrayListToUse.size();x++)
		{
			foundSmall = true;
			if(arrayListToUse.get(x).authorLName.compareToIgnoreCase(toBeSorted.authorLName) > 0)
			{
				arrayListToUse.add(x, toBeSorted);
				foundSmall = false;
				break;
			}
		}
		if(foundSmall)
		{
			foundSmall = false;
			arrayListToUse.add(toBeSorted);
		}
	}//sortArrL()
	public void selectionSortCost()
	{
		ArrayList<Book> tempArrL = new ArrayList<Book>(); //creates new array to save all the smallest values from the bookArrL array
		while(!bookArrL.isEmpty()) //loop that goes through until bookArrL is empty
		{
			Book smallestBook = bookArrL.get(bookArrL.size() - 1); //this takes the last entry in the bookArrL and assumes its smallest
			int toDelete = bookArrL.size() - 1; //this saves the last index of the array
			for(int y = 0;y < bookArrL.size() - 1;y++) //this is a for loop that iterates through array
			{
				if(bookArrL.get(y).cost < smallestBook.cost) //this checks if the current check of the bookArrL has a lower cost then the current smallestBook
				{
					smallestBook = bookArrL.get(y); //saves the current check as the lowest cost book
					toDelete = y; //this tells me which book to delete from array
				}
			}
			tempArrL.add(smallestBook);
			bookArrL.remove(toDelete);
			//System.out.println(smallestBook);
		}
		bookArrL = tempArrL;
	}
	public void bubbleSortTitle()
	{
		currentSort = 0;
		for(int x = bookArrL.size() - 1; x > 0;x--) //goes through whole array list
		{
			for(int y = 0;y < x;y++) //goes through unsorted part of array list
			{
				if(bookArrL.get(y).title.compareTo(bookArrL.get(y+1).title) > 0) //checks if book title value is greater then the next one in the list 
				{
					//System.out.println(bookArrL.get(y + 1) + "before");
					Book tempBook = bookArrL.get(y); //creates temp book to save book program is replacing
					bookArrL.set(y, bookArrL.get(y + 1));
					bookArrL.set(y + 1, tempBook); //takes temp book and puts it in place of book we switched into its place
					//System.out.println(bookArrL.get(y + 1) + "after");
				}
			}
		}
	}
	public boolean checkInfo(String allInfo)
	{
		try
		{
			String[] stringArr = allInfo.split(", ");
			String authorLName = stringArr[0];
			String authorFName	= stringArr[1];
			String title = stringArr[2];
			String format = stringArr[3];
			String publisher = stringArr[4];
			int year = Integer.parseInt(stringArr[5]);
			String language = stringArr[6];
			long numISBN = Long.parseLong(stringArr[7]);
			float cost = Float.parseFloat(stringArr[8]);
		}
		catch(Exception e)
		{
			System.err.println("ERROR please use correct formatting when entering book");
			return false;
		}
		return true;
	}
	public Book getBook(int c)
	{
		return bookArrL.get(c);
	}
	public int getArraySize()
	{
		return bookArrL.size();
	}
}
