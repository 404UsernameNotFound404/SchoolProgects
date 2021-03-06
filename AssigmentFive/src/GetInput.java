/*
 * Name: Henry Morris


 * Date: 11/27/2018
 * 
 * Methods:
 * GetInputInt() This method returns an integer when called and checks for invalid input
 * GetInputYes() This method checks if a player input is any form of yes E.X Yes,y,yes etc
 * 
 * 
 */
import java.util.Scanner; 

public class GetInput 
{
	public static int GetInputInt()
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
	public static int GetInputYes()
	{
		String userInput;
		int yesIsOne = 0;
		Scanner inputScanner = new Scanner(System.in);
		userInput = inputScanner.next();
		if(userInput.compareTo("Yes") == 0 || userInput.compareTo("Y") == 0 || userInput.compareTo("yes") == 0 || userInput.compareTo("y") == 0)
		{
			yesIsOne = 1;
		}
		return yesIsOne;
	}
}
