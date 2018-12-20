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

public class Reptile extends Animal
{
	int costPerDay;
	int costForLiving;
	public Reptile(String name, int pop, int cost){
		super(name, pop);
		costPerDay = cost;
		costForLiving = this.getCost();
	}
	@Override
	public int getCost() {
		return costPerDay * population;
	}
}
