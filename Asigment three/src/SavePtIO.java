import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class SavePtIO 
{
	Scanner scan;
	Formatter formatter;
	
	String[] stringLines;
	String[] line;
	FileReader fr;
	BufferedReader br; 
	public void fileOpenMethod(File fileName)
	{
		try 
		{
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			line = new String[3];		
			int counter = 0;
			
			for(int x = 0;x<line.length;x++)
			{
				line[counter] = br.readLine();
				System.out.print(line[counter] + "\n");
				counter++;
			}		
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("file not found");
		} 
		catch (IOException e) 
		{
			System.out.println("IOExpection");
		}
	}
	public void fileReadMethod(File fileName)
	{
		int counter = 0;
		stringLines = new String[2];
		while(scan.hasNextLine())
		{
			stringLines[counter] = scan.nextLine();
		}
		System.out.println(stringLines[0]);
		System.out.println(stringLines[1]);
	}
	public void fileWriteMethod(File fileName)
	{
		String[] s;
		
		s = new String[2];
		s[0] = "H\n";
		s[1] = "HELLO\n";
		
		int counter = 0;
		
		int[] weights;
		weights = new int[3];
		weights[0] = 2;
		weights[1] = 5;
		weights[2] = 3;
		
		FileWriter FW;
		try {
			FW = new FileWriter(fileName);
			for(int x = 0;x<line.length;x++)
			{
				FW.write(line[x] + weights[x] + "\n");
			}
			FW.close();
		} catch (IOException e) {
			System.out.println("IOExpection");
		}	
		
	}
	public void fileCloseMethod()
	{
		formatter.close();
		scan.close();
	}

}
