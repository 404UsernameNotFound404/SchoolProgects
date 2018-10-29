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
			for(int x = 0;x < bookArrL.size();x++)
			{
				System.out.println(bookArrL.get(x).toString());
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
	public void AddBook(String input)
	{
		instanceBook = new Book(input);
		sortArrL(instanceBook);
	}
	public void sortArrL(Book toBeSorted)
	{
		boolean foundSmall = true;
		for(int x = 0;x < bookArrL.size();x++)
		{
			foundSmall = true;
			if(bookArrL.get(x).authorLName.compareToIgnoreCase(toBeSorted.authorLName) > 0)
			{
				bookArrL.add(x, toBeSorted);
				foundSmall = false;
				break;
			}
		}
		if(foundSmall)
		{
			foundSmall = false;
			bookArrL.add(toBeSorted);
		}
	}//sortArrL()
	public void selectionSortCost()
	{
		ArrayList<Book> tempBookArray = new ArrayList<Book>();
		for(int x = bookArrL.size() - 1;x > 0;x--)
		{
			Book largestTitleBook = bookArrL.get(x);
			for(int y = 0;y < x;y++)
			{
				if(largestTitleBook.cost < bookArrL.get(y).cost)
				{
					largestTitleBook = bookArrL.get(y);
					bookArrL.remove(y);
				}
			}
			tempBookArray.add(largestTitleBook);
		}
		bookArrL = tempBookArray;
	}
	public void bubbleSortTitle()
	{
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
