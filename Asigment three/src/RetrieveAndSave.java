import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class RetrieveAndSave 
{	
	public static void main (String args[])
	{
		SavePtIO info = new SavePtIO();
		
		// define the File to open	
      	File currFile = new File("gamerStat.txt");
      	
      	/***********************************************************/ 	
		// open and read the original text file and instantiate
      	// the objects for the arrays in the SavePtIO class
      	/**********************************************************/
		
		info.fileReadMethod(currFile);
				
		// add another item into the game savepoint array saveData
		//info.setSaveData();
		
		//info.getSaveData().setPlayer("Curious George");
		//info.getSaveData().setLevel("Two");
		//info.getSaveData().setLives(3);
		//info.getSaveData().setSavePoint(5);
		//info.getSaveData().setMana(0.56);
				
		//info.setIncreaseCount();
		
		//print out all of the  entries using the toString()
		System.out.println(info);
		
		
		/*************************************************************/
		// write the object out as a text file with the new addition
		/*************************************************************/
		File backFile = new File("gamerStatBackUp.txt");
		
		//info.writeFileMethod(backFile);
		
		
		/*************************************************************/
		// export file as a class file.
		/*************************************************************/
		File newFile = new File("gamerStat.dat");
		
		//info.writeObjectMethod(newFile);
		
		
		/*************************************************************/
		// import the file as a class
		// to prove you have written the file,  load and then show
		/************************************************************/
		
		//remember the second array saveObjData was made for this part
		
		//info.objectInputMethod(newFile);  
		
		//Final check of your results.
		
		//System.out.println("There are "+ info.getCounter() +" games saved in the list.\n" + "The game information is: ");
		
		//for(int c=0; c<info.getCounter(); c++)
		//{
			//System.out.print(c+":\n");
			//System.out.print(info.getSaveObjData(c));
			//System.out.println();
		//}		
	}
}