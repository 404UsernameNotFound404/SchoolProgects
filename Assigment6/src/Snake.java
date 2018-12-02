
public class Snake extends Reptile
{
	
	public Snake(String name, int pop, int cost) 
	{
		super(name, pop, cost);
		
	}
	@Override
	public int getCost() 
	{
		return (costPerDay * population) + (population * costForHabitat);
	}

}
