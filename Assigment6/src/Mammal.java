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

public class Mammal extends Animal
{
	public int costForLiving;
	public int costPerDay;
	public Mammal(String name, int pop, int cost)
	{
		super(name, pop);
		costPerDay = cost;
		costForLiving = this.getCost();
	}
	@Override
	public int getCost() 
	{
		return population * costPerDay;
	}

}
