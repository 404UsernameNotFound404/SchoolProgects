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

public class Fish extends Animal
{
	int costForOneDay;
	int costForAllAnimal;
	public Fish(String name, int pop, int cost)
	{
		super(name, pop);
		costForOneDay = cost;
		this.getCost();
		
	}
	@Override
	public int getCost() {
		
		return costForOneDay * population;
	}

}
