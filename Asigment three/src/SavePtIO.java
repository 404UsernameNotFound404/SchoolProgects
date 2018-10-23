/*
 * Name: Henry Morris
 * Date: 9/7/2018
 * 
 * Constructors: 
 * SavePtIO()
 * -this initializes the counter and two arrays(saveData and saveObjData) 
 * Methods:
 * fileReadMethod(File fileName)
 * -Reads file and saves data into array. Further comments on how this is done in code.
 * writeFileMethod(File fileName)
 * -This method writes the text into the backup text doc.
 * writeObjectMethod(File fileName)
 * -This method takes the saveData array and writes it into the 
 * objectInputMethod(File fileName)
 * 
 * Getters and Setters:
 * getCounter()
 * getSaveObjData(int c)
 * setIncreaseCount()
 * getSaveData()
 * setSaveData()
 * -Creates an empty instance of GameSaveInfo
 * 
 * ToString()
 * -uses an empty string to display all the ToString's from saveData array
 */
import java.util.*;
import java.io.*;

public class SavePtIO 
{
	Scanner scan;
	Formatter formatter;
	
	GameSaveInfo[] saveData;
	GameSaveInfo[] saveObjData;
	
	FileReader fr;
	BufferedReader br; 
	FileWriter fw;
	PrintWriter pw;
	
	FileInputStream FIS;
	
	FileOutputStream FOS;
	
	ObjectOutputStream OOS;
	
	ObjectInputStream OIS;
	
	GameSaveInfo saveInfo;
	
	private int counter;
	
	public SavePtIO()
	{
		counter = 0;
		saveData = new GameSaveInfo[10];
		saveObjData = new GameSaveInfo[10];
	}
	
	public void fileReadMethod(File fileName)
	{
		int counterForObjectSaver = 0;
		try 
		{
			String[] gameSaveInfoValue;
			String player, level, savePoints, lives, mana;
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			while(br.ready())
			{
				counter++;
				//System.out.println("counter: " + counter);
				gameSaveInfoValue = br.readLine().split(","); //splits one line of text doc into all needed data
				
				player = gameSaveInfoValue[0]; //we know in the text doc the first thing before the first , is the player name
				level =gameSaveInfoValue[1]; //same as above, but the second piece of info
				savePoints = gameSaveInfoValue[2]; 
				lives = gameSaveInfoValue[3];
				mana = gameSaveInfoValue[4];
				
				int savePointsInt = Integer.parseInt(savePoints); //converts savePoints from string to int
				int livesInt = Integer.parseInt(lives); //converts lives from string to int
				float manaFloat = Float.parseFloat(mana); //converts mana from string to float
				
				GameSaveInfo GSI = new GameSaveInfo(player,level,savePointsInt,livesInt,manaFloat); //Creates a instance of gameSaveInfo
				saveData[counterForObjectSaver] = GSI; //adds the gameSaveInfo from above to array saveData
				counterForObjectSaver++; //increase the counter that keeps track of how many objects are currently in saveData
			}
			fr.close();
			br.close();
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
				//System.out.println(saveData[x]);
				pw.print(saveData[x] + "\n"); //prints data from saveData[] to file provided
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
		try 
		{
			saveObjData = new GameSaveInfo[10];
			OOS = new ObjectOutputStream(new FileOutputStream(fileName));
			OOS.writeObject(saveData); //writes saveData's whole array to DAT file provided 
			OOS.close();
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
	public void objectInputMethod(File fileName)
	{
			try 
			{
				OIS = new ObjectInputStream(new FileInputStream(fileName));
				//System.out.println(OIS.readObject());
				//saveObjData = (gameSaveInfo[]) OIS.readObject();
				saveObjData = (GameSaveInfo[]) OIS.readObject(); //This reads DAT file provided 
				
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
			catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public int getCounter()
	{
		return counter;
	}
	public GameSaveInfo getSaveObjData(int c)
	{
		return saveObjData[c]; //this allows other script to access setters/getters in gameSaveInfo instances that are in saveObjData[]
	}
	public void setIncreaseCount()
	{
		counter++;
	}
	public GameSaveInfo getSaveData()
	{
		//System.out.println(counter + " counter");
		return saveData[counter];
	}
	public void setSaveData()
	{
		saveData[counter] = new GameSaveInfo();
	}
	@Override
	public String toString() 
	{	    
		String display = "";
		
		for(int x = 0;x<counter;x++)
		{
			display = display + (saveData[x] + "\n");
		}
		return display; 
	}

}
