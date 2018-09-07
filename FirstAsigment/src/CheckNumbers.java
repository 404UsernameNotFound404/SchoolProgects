
public class CheckNumbers 
{	
	public static void main(String[] args) 
	{
		int input = 12344321;
		checkingNumbers postiveCheck = new checkingNumbers();
		
		boolean trueIsPostive = postiveCheck.checkIfPostive(input);
		
		boolean trueIsPrime = postiveCheck.checkPrime(input);
		
		int numberOfNumbers = postiveCheck.checkLength(input);
		
		boolean trueIsPalondrome = postiveCheck.checkPalandrome(input);
		System.out.println(trueIsPalondrome);
		
		
		
	}
}
