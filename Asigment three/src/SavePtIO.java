import java.util.*;
import java.io.*;

public class SavePtIO 
{
	Scanner scan;
	Formatter formatter;
	
	gameSaveInfo[] saveData;
	gameSaveInfo[] saveObjData;
	
	FileReader fr;
	BufferedReader br; 
	FileWriter fw;
	PrintWriter pw;
	
	FileInputStream FIS;
	
	FileOutputStream FOS;
	
	ObjectOutputStream OOS;
	
	ObjectInputStream OIS;
	
	gameSaveInfo saveInfo;
	public void SavePtIO()
	{
	}
	int counter;
				
	public void fileReadMethod(File fileName)
	{
		int counterForObjectSaver = 0;
		try 
		{
			String[] gameSaveInfoValue;
			String player, level, savePoints, lives, mana;
			saveData = new gameSaveInfo[10];
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			while(br.ready())
			{
				gameSaveInfoValue = br.readLine().split(",");
				
				player = gameSaveInfoValue[0];
				level =gameSaveInfoValue[1];
				savePoints = gameSaveInfoValue[2];
				lives = gameSaveInfoValue[3];
				mana = gameSaveInfoValue[4];
				
				gameSaveInfo GSI = new gameSaveInfo(player,level,savePoints,lives,mana);
				saveData[counterForObjectSaver] = GSI;
				counterForObjectSaver++;
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
		try 
		{
			saveObjData = new gameSaveInfo[10];
			OOS = new ObjectOutputStream(new FileOutputStream(fileName));
			int counterForObject = 0;
			OOS.writeObject(saveData);
			counterForObject++;			
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
	public void readObjectMethod(File fileName)
	{
		int content;
			try {
				OIS = new ObjectInputStream(new FileInputStream(fileName));
				//System.out.println(OIS.readObject());
				//saveObjData = (gameSaveInfo[]) OIS.readObject();
				saveObjData = (gameSaveInfo[]) OIS.readObject();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(FIS.available());
 catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	@Override
	public String toString() 
	{	    
		return "toString";
	}

}
