import java.util.ArrayList;

/*************************************************************************/
// class ZooStats  -has a Vector that holds the Animal items
// need the following methods:
//	public ZooStats()
//	public void enterItem(Animal item)
//	public int numberOfItems()
//	public int totalCost()
//	public void clear()
//	public String toString()
//Static method used to calculate the number of spaces needed to keep the right alignment
//	public static String space(String cost,String prefix)
/*************************************************************************/


public class ZooStats 
{
	ArrayList<Animal> listOfAnimals;
	int totalCostForAllAnimals = 0;
	public Zoo displayForCost;
	public ZooStats()
	{
		listOfAnimals = new ArrayList<Animal>();
	}
	public void enterItem(Animal item)
	{
		listOfAnimals.add(item);
	}
	public int numberOfItems()
	{
		
		return listOfAnimals.size();
	}
	public int totalCost()
	{
		for(int x = 0;x < listOfAnimals.size(); x++)
		{
			totalCostForAllAnimals += listOfAnimals.get(x).getCost();
		}
		return totalCostForAllAnimals;
	}
	public void clear()
	{
		
	}
	@Override
	public String toString()
	{
		String output = "Daily Accounts: \n";
		for(int x = 0;x < listOfAnimals.size();x++)
		{
			output += "The Daily " + listOfAnimals.get(x).getClass() + " Cost is " + displayForCost.cents2dollarsAndCents((listOfAnimals.get(x).getCost() / listOfAnimals.get(x).population)) + "/day \n";
			output += listOfAnimals.get(x).population + " " + listOfAnimals.get(x).name + " " + displayForCost.cents2dollarsAndCents(listOfAnimals.get(x).getCost());
			output += "\n";
		}
		return output;
	}

}
