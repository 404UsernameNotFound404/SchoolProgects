import java.util.Objects;

/* Name: Henry Morris
 * Date: 9/7/2018
 * Purpose: to receive player input and complete certain actions and operation then return a result
 * Functions:
 * checkIfPostive: checks if number is positive or negative(above or below zero) if positive return true
 * 
 * checkPrime: checks if number is prime. Does this by using input number % then a value that goes from zero
 * to input number and if any of them return zero it means its not prime, but if none of them do it return 
 * false meaning its not prime.
 * 
 * checkLength: converts player input to string then uses function string.length() to find length
 * 
 * checkPalndrome: explanation in function 
 * 
 */

public class checkNumberTest
{
	boolean postiveIsTruePostive;
	boolean postiveIsTruePrime;
	int postiveIsTrueLenth; 
	int input;
	boolean postiveIsTruePalandrome;
	
	public checkNumberTest(int playerInput)
	{
		input = playerInput;
	}
	
	public static boolean checkIfPostive(int num)
	{
		boolean postiveIsTrue = false;
		if(num > 0)
		{
			postiveIsTrue = true;
			return postiveIsTrue;
		}else
		{
			postiveIsTrue = false;
			return postiveIsTrue;
		}
	}
	public static boolean checkPrime(int num1)
	{
		boolean trueIsPostive = true;
		for(int x = 2;x < num1; x++)
		{
			//System.out.println("Andy");
			//System.out.print(x + "|");
			//System.out.println(num1);
			//System.out.println((num1 % x));
			if(num1 % x == 0)
			{
				trueIsPostive = false;
				//System.out.println((num1 % x));
				x = num1 + 10;
			}
		}
		return trueIsPostive; 
	}
	public static int checkLength(int num2)
	{
		int numString = String.valueOf(num2).length();
		return numString;
	}
	public static boolean checkPalandrome(int num3)
	{
		boolean returnPalndromeIsTrue = false;
		int numString1 = String.valueOf(num3).length();
		String fullString1 = String.valueOf(num3);
		String firstHalf = "";
		String secondHalf = "";
		if(numString1 % 2 == 0) //checks if length of input is even or odd 
		{
			for(int x = 0;x < (numString1/2);x++)//loop runs half the length of the string 
			{
				firstHalf = firstHalf + fullString1.charAt(x);//starts at begging of input string and adds half its value to empty string
				secondHalf = secondHalf + fullString1.charAt((numString1 -1) - x);//starts at end of input going back adding its value to emtpy string 
			}
			//System.out.println(firstHalf);
			//System.out.print(secondHalf);
		}else
		{
			for(int x = 0; x < ((numString1-1)/2);x++) //runs half the string minus one becuase the share the middle one 
			{
				firstHalf = firstHalf + fullString1.charAt(x); //starts at begging of input string and adds half its value to empty string
				secondHalf = secondHalf + fullString1.charAt((numString1-1)-x); //starts at end of input going back adding its value to emtpy string 
			}
		}
		if(Objects.equals(secondHalf,firstHalf)) //checks if they equal each other if they do return true meaning it is a palndrome 
		{
			returnPalndromeIsTrue = true; 
			return returnPalndromeIsTrue;
		}
		return returnPalndromeIsTrue;
	}
}

