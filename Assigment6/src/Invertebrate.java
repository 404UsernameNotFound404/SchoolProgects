
public class Invertebrate extends Animal
{
	int costToTakeCareOfThem;
	public Invertebrate(String name, int pop, int cost)
	{
		super(name,pop);
		costToTakeCareOfThem = cost;
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return costToTakeCareOfThem;
	}
	
}
