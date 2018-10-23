import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LibraryFunct 
{
	ArrayList<Book> bookArrL = new ArrayList<Book>();
	FileReader fr;
	BufferedReader br;
	
	public void readFile(File file)
	{
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			while(br.ready())
			{
				System.out.println(br.readLine());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
