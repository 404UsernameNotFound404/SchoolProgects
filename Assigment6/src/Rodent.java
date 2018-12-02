
public class Rodent extends Mammal
{
	int costForHabitat;
	public Rodent(String name, int pop, int costForFood, int costForHabitat) 
	{
		super(name, pop, costForFood);
		this.costForHabitat = costForHabitat;
	}
	@Override
	public int getCost() 
	{
		return (costPerDay * population) + (population * costForHabitat);
	}
	

}
