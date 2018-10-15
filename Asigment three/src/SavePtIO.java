import java.util.*;
import java.io.*;

public class SavePtIO 
{
	Scanner scan;
	Formatter formatter;
	
	String[] saveData;
	gameSaveInfo[] saveObjData;
	
	FileReader fr;
	BufferedReader br; 
	FileWriter fw;
	PrintWriter pw;
	
	FileInputStream FIS;
	
	FileOutputStream FOS;
	
	gameSaveInfo saveInfo;
	public void SavePtIO()
	{
	}
	int counter;
				
	public void fileReadMethod(File fileName)
	{
		try 
		{
			saveData = new String[10];
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			for(int x = 0;x < saveData.length;x++)
			{
				saveData[x] = br.readLine();
				//System.out.println(saveData[x]);
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("file not found");
		} 
		catch (IOException e) 
		{
			System.out.println("IO execption");
		}
		
	}
	public void writeFileMethod(File fileName)
	{
		try 
		{
			fw = new FileWriter(fileName);
			pw = new PrintWriter(fw);
			for(int x = 0;x < saveData.length;x++)
			{
				System.out.println(saveData[x]);
				pw.print(saveData[x] + "\n");
			}
			fw.close();
			pw.close();
		} 
		catch (IOException e) 
		{
			System.out.println("IO expection");
		}
	}
	public void writeObjectMethod(File fileName)
	{
		int counterForSub = 0;
		int counterForSpaces = 0;
		String player = "";
		String level = "";
		int savePoints;
		try 
		{
			saveObjData = new gameSaveInfo[10];
			FOS = new FileOutputStream(fileName);
			
			for(int x = 0;x<saveObjData.length;x++)
			{
				while(counterForSpaces != 2)
				{
					if(saveData[x].charAt(counterForSub) == ' ')
					{
						counterForSpaces++;
					}
					player = player + (saveData[x].charAt(counterForSub));
					counterForSub++;
				}
				System.out.println(player);
				//saveObjData[x] = new gameSaveInfo(saveData[x].);
				//System.out.println(saveData[x]. + x + "\n");
			}
			
			saveInfo = new gameSaveInfo("Henry","one hundred",1,4,99);
			FOS.write(saveInfo.toString().getBytes());
			
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			//e.printStackTrace();
		}
	}
	public void readObjectMethod(File fileName)
	{
		int content;
		try 
		{
			FIS = new FileInputStream(fileName);
			//System.out.println(FIS.available());
			while ((content = FIS.read()) != -1) 
			{
				//System.out.print((char) content);
			}
			System.out.println();
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
	@Override
	public String toString() 
	{	    
		return "toString";
	}

}
