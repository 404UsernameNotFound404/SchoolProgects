
public class checkingNumbers 
{
	public static boolean checkIfPostive(int num)
	{
		if(num > 0)
		{
			return true;
		}else
		{
			return false;
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
			System.out.println(firstHalf);
			System.out.print(secondHalf);
			if(firstHalf == secondHalf)
			{
				//System.out.println(firstHalf + secondHalf);
				return true;
			}
			//System.out.println(firstHalf);
			//System.out.print(secondHalf);
		}
		return false;
	}
}

