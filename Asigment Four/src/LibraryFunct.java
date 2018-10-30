import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean ifEquals()
	{
		for(int x = 0;x < bookArrL.size() - 1;x++)
		{
			
		}
		return false;
		
	}
	public void AddBook(String input)
	{
		instanceBook = new Book(input);
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
		currentSort = 1;
		ArrayList<Book> tempArrL = new ArrayList<Book>();
		//tempArrL = bookArrL;
		int sizeOfArray = bookArrL.size();
		while(!bookArrL.isEmpty())
		{
			Book smallestBook = bookArrL.get(bookArrL.size() - 1);
			int toDelete = bookArrL.size() - 1;
			for(int y = 0;y < bookArrL.size() - 1;y++)
			{
				if(bookArrL.get(y).cost < smallestBook.cost)
				{
					smallestBook = bookArrL.get(y);
					toDelete = y;
					//System.out.println("andy samberg ----------------------------------------------");
				}
			}
			tempArrL.add(smallestBook);
			bookArrL.remove(toDelete);
			//System.out.println(smallestBook);
		}
		for(int h = 0;h < tempArrL.size();h++)
		{
			System.out.println(tempArrL.get(h));
		}
		bookArrL = tempArrL;
	}
	public void bubbleSortTitle()
	{
		currentSort = 0;
		for(int x = bookArrL.size() - 1; x > 0;x--)
		{
			for(int y = 0;y < x;y++)
			{
				if(bookArrL.get(y).title.compareTo(bookArrL.get(y+1).title) > 0)
				{
					System.out.println(bookArrL.get(y + 1) + "before");
					Book tempBook = new Book();
					tempBook = bookArrL.get(y);
					bookArrL.set(y, bookArrL.get(y + 1));
					bookArrL.set(y + 1, tempBook);
					System.out.println(bookArrL.get(y + 1) + "after");
				}
			}
		}
	}
	public Book getBook(int c)
	{
		return bookArrL.get(c);
	}
	public int getArraySize()
	{
		return bookArrL.size();
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
}
