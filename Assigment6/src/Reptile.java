
public class Reptile extends Animal
{
	int costPerDay;
	int costForLiving;
	public Reptile(String name, int pop, int cost)
	{
		super(name, pop);
		costPerDay = cost;
		costForLiving = this.getCost();
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
