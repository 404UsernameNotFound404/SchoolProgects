
public class Bird extends Animal
{
	int costPerDay;
	public Bird(String name, int pop, int cost)
	{
		super(name, pop);
		getCost();
		costPerDay = cost;
		
	}
	@Override
	public int getCost() 
	{
		return costPerDay * population;
	}

}
