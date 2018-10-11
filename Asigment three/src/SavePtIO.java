import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class SavePtIO 
{
	Scanner scan;
	Formatter formatter;
	public void fileReadMethod(File fileName)
	{
		try
		{
			scan = new Scanner(fileName);
		}
		catch(Exception e)
		{
			System.out.println("You done messed up son with fileName");
		}
		while(scan.hasNextLine())
		{
			System.out.println(scan.nextLine());
		}
	}
	public void fileWriteMethod(File fileName)
	{
		try
		{
			formatter = new Formatter(fileName.getName());
		}
		catch(Exception e)
		{
			System.out.println("you done messed up with forammatter sooon");
		}
		formatter.format("%s", "penis\n penis");
	}
	public void fileCloseMethod()
	{
		formatter.close();
		scan.close();
	}

}
