/*
 * Name: Henry Morris
 * Date: 11/2/2018
 * 
 * Constructors: 
 * Book(String allInfo, ArrayList<Book> bookArrL)
 * -creates a book with the info allInfo and parses into the proper fields if it passes try test
 * -also takes array list because it needs to check other books if this book equals them
 * Getters and Setters:
 * toString:
 * -The toString return all fields in books 
 */

import java.util.ArrayList;

public class Book 
{
	String authorLName, authorFName, title, format, publisher, language;
	int year;
	long numISBN;
	float cost;
	ArrayList<Book> bookArrL;
	public Book(String allInfo, ArrayList<Book> bookArrL)
	{
		try
		{
			String[] stringArr = allInfo.split(", ");
			authorLName = stringArr[0];
			authorFName	= stringArr[1];
			title = stringArr[2];
			format = stringArr[3];
			publisher = stringArr[4];
			year = Integer.parseInt(stringArr[5]);
			language = stringArr[6];
			numISBN = Long.parseLong(stringArr[7]);
			cost = Float.parseFloat(stringArr[8]);
			this.bookArrL = bookArrL;
		}
		catch(Exception e)
		{
			System.err.println("ERROR checker did not work");
		}
		
	}
	public boolean Equals()
	{
		int counterForDelete = 0;
		boolean delete = false;
		for(int x = 0;x < bookArrL.size();x++)
		{
			if(this.toString().compareTo(bookArrL.get(x).toString()) == 0)
			{
				System.out.println("Delete equals true");
				delete = true;
			}
		}
		return delete;
	}
	@Override
	public String toString() 
	{
		return authorLName + ", " + authorFName + ", " + title + ", " + format + ", " + publisher + ", " + year + ", " + language + ", " + numISBN + ", " + cost ; 
		//return authorLName + " " + authorFName + " " + title;
	}
}
