/*
 * Name: Henry Morris
 * 
 * Date: 11/27/2018
 * 
 * Constructors: 
 * 
 * Methods:
 * 
 * toString:
 * 
 */

public class Invertebrate extends Animal
{
	int costToTakeCareOfThem;
	public Invertebrate(String name, int pop, int cost)
	{
		super(name,pop);
		costToTakeCareOfThem = cost;
	}
	@Override
	public int getCost() {
		return costToTakeCareOfThem;
	}
	
}
