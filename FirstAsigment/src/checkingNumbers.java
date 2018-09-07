import java.util.Objects;

/*Name: Henry Morris
 * Date: 9/7/2018
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class checkingNumbers 
{
	boolean postiveIsTruePostive;
	boolean postiveIsTruePrime;
	int postiveIsTrueLenth; 
	boolean postiveIsTruePalandrome;
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
		if(numString1 % 2 == 0)
		{
			for(int x = 0;x < (numString1/2);x++)
			{
				firstHalf = firstHalf + fullString1.charAt(x); 
				secondHalf = secondHalf + fullString1.charAt((numString1 -1) - x);
			}
			//System.out.println(firstHalf);
			//System.out.print(secondHalf);
		}else
		{
			for(int x = 0; x < ((numString1-1)/2);x++)
			{
				firstHalf = firstHalf + fullString1.charAt(x);
				secondHalf = secondHalf + fullString1.charAt((numString1-1)-x);
			}
		}
		if(Objects.equals(secondHalf,firstHalf))
		{
			returnPalndromeIsTrue = true; 
			return returnPalndromeIsTrue;
		}
		return returnPalndromeIsTrue;
	}
}

