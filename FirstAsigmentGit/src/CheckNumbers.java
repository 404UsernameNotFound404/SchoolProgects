/* Name: Henry Morris
 * Date: 9/7/2018
 * Purpose: The control center of the program that creates instances of the classes needed.
 * checkingNumbers: is the class that checks all the things that need checking like if the number is positive
 * getInput: this class contains a scanner that gets a integer to use as input
 * Functions:
 * displayCharacters: this displays all the data I collected that the project requested 
 */

public class CheckNumbers 
{	
	public static void main(String[] args) 
	{
		getInput inputClass = new getInput(); //creating an instance of the class getInput()
		int input = inputClass.getInput(); //getting the input 
		checkNumberTest postiveCheck = new checkNumberTest(input); //creating an instance of checkingNumbers class
		
		//boolean trueIsPostive = postiveCheck.checkIfPostive(input);
		postiveCheck.postiveIsTruePostive = postiveCheck.checkIfPostive(input);
		
		//boolean trueIsPrime = postiveCheck.checkPrime(input);
		postiveCheck.postiveIsTruePrime = postiveCheck.checkPrime(input);
		
		
		//int numberOfNumbers = postiveCheck.checkLength(input);
		postiveCheck.postiveIsTrueLenth = postiveCheck.checkLength(input); 
		
		//boolean trueIsPalondrome = postiveCheck.checkPalandrome(input);
		postiveCheck.postiveIsTruePalandrome = postiveCheck.checkPalandrome(input);
		
		disPlayCharacters(postiveCheck);
	}
	public static void disPlayCharacters(checkNumberTest nums)
	{
		System.out.println("Your Number: " + nums.input);
		System.out.println("Postive number: " + nums.postiveIsTruePostive);
		System.out.println("Prime Number: " + nums.postiveIsTruePrime);
		System.out.println("Length Of Number: " + nums.postiveIsTrueLenth);
		System.out.println("Palandrome Number: " + nums.postiveIsTruePalandrome); 
	}
}
