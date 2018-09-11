import java.util.Scanner; 

public class getInput 
{
	public static int getInput()
	{
		int playerInput = 0;
		boolean validInputIsTrue = true;
		while(validInputIsTrue)
		{
			validInputIsTrue = false;
			try
			{
				Scanner inputScanner = new Scanner(System.in);
				System.out.println("Please Input an Integer: ");
				playerInput = inputScanner.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("Error invalid Input please Input a Inreger: ");
				validInputIsTrue = true;
			}
		}
		return playerInput;
	}

}
