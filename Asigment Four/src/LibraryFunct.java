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
			int disCounter = 0;
			while(br.ready())
			{
				//System.out.println(br.readLine());
				instanceBook = new Book(br.readLine());
				bookArrL.add(instanceBook);
			}
			for(int x = 0;x < bookArrL.size();x++)
			{
				for(int y = 0;y < bookArrL.get(x).authorLName.length();y++)
				{
					
				}
			}
			for(int x = 0;x < bookArrL.size();x++)
			{
				
				System.out.println(bookArrL.get(disCounter));
				disCounter++;
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

}
