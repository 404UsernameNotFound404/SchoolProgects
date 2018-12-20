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

public class Snake extends Reptile
{
	int foodCost;
	int habitatCost;
	public Snake(String name, int pop, int cost, int costForHabitat) 
	{
		super(name, pop, cost);
		habitatCost = costForHabitat;
	}
	public int getHabitatCost()
	{
		return habitatCost;
	}
	@Override
	public int getCost() 
	{
		return (costPerDay * population) + habitatCost;
	}

}
