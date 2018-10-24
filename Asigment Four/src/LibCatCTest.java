import java.io.File;

public class LibCatCTest 
{
	public static void main(String[] args) 
	{
		LibraryFunct LibFunct = new LibraryFunct();
		
		File booksTextFile = new File("Lib.txt");
		LibFunct.readFile(booksTextFile);
	}
}
