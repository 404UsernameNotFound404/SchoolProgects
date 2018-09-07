
public class CheckNumbers 
{	
	public static void main(String[] args) 
	{
		checkingNumbers postiveCheck = new checkingNumbers();
		getInput inputClass = new getInput();
		
		int input = inputClass.getInput();
		
		boolean trueIsPostive = postiveCheck.checkIfPostive(input);
		postiveCheck.postiveIsTruePostive = postiveCheck.checkIfPostive(input);
		
		boolean trueIsPrime = postiveCheck.checkPrime(input);
		postiveCheck.postiveIsTruePrime = postiveCheck.checkPrime(input);
		
		
		int numberOfNumbers = postiveCheck.checkLength(input);
		postiveCheck.postiveIsTrueLenth = postiveCheck.checkLength(input); 
		
		boolean trueIsPalondrome = postiveCheck.checkPalandrome(input);
		postiveCheck.postiveIsTruePalandrome = postiveCheck.checkPalandrome(input);
		
		disPlayCharacters(postiveCheck);
	}
	public static void disPlayCharacters(checkingNumbers nums)
	{
		System.out.println("Postive number " + nums.postiveIsTruePostive);
		System.out.println("Prime Number " + nums.postiveIsTruePrime);
		System.out.println("Length Of Number: " + nums.postiveIsTrueLenth);
		System.out.println("Palandrome Number " + nums.postiveIsTruePalandrome); 
	}
}
