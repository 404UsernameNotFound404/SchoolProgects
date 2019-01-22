/*
 * Name: Henry Morris
 * 
 * Date: 11/27/2018
 * 
 * Constructors: 
 * 
 * Methods:
 * getHabitatCost()
 * 		Because the program required per day cost I needed the habitat cost to subtract from daily cost. 
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
