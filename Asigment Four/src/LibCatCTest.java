import java.io.File;

public class LibCatCTest 
{
	public static void main(String[] args) 
	{
		LibraryFunct LibFunct = new LibraryFunct();
		
		File booksTextFile = new File("");
		LibFunct.readFile(booksTextFile);
	}
}
