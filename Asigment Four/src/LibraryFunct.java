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
<<<<<<< HEAD
			//if() to check if same then compare fName
=======
			foundSmall = true;
>>>>>>> d7c4ef0d46f89609d6c4cfe778a535e989c7d630
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
	public Book getBook(int c)
	{
		return bookArrL.get(c);
	}
	public int getArraySize()
	{
		return bookArrL.size();
	}
}
