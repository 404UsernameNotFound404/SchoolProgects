import java.util.Scanner; 

public class getInput 
{
	public static int getInput()
	{
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Please Input an Integer: ");
		int playerInput = inputScanner.nextInt();
		
		return playerInput;
	}

}
