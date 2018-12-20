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

public class Amphibian extends Animal
{
	int costForOneDay;
	int costForAllAnimal;
	public Amphibian(String name, int pop, int cost)
	{
		super(name, pop);
		costForOneDay = cost;
		this.getCost();
		
	}
	@Override
	public int getCost() {
		return costForOneDay;
	}

}
