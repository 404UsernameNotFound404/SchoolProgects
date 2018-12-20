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
		listOfAnimals.clear();
		totalCostForAllAnimals = 0;
	}
	@Override
	public String toString()
	{
		String output = "Daily Accounts: \n";
		for(int x = 0;x < listOfAnimals.size();x++)
		{
			output += "The Daily " + listOfAnimals.get(x).getClass() + " Cost is ";
			if(listOfAnimals.get(x).getClass() == Snake.class)
			{
				Snake SnakeClass = (Snake) listOfAnimals.get(x);
				output += displayForCost.cents2dollarsAndCents((SnakeClass.getCost() - SnakeClass.getHabitatCost())/ SnakeClass.population);
				output += "/ea. & ." + SnakeClass.getHabitatCost()  + "\n";
			}else if(listOfAnimals.get(x).getClass() == Amphibian.class || listOfAnimals.get(x).getClass() == Invertebrate.class)
			{
				output += displayForCost.cents2dollarsAndCents(listOfAnimals.get(x).getCost()) + "\n";
			}else
			{
				output += displayForCost.cents2dollarsAndCents(listOfAnimals.get(x).getCost() / listOfAnimals.get(x).population) + "\n";
			}
			// displayForCost.cents2dollarsAndCents((listOfAnimals.get(x).getCost() / listOfAnimals.get(x).population)) + "/day \n";
			output += listOfAnimals.get(x).population + " " + listOfAnimals.get(x).name;
			
			for(int y = 0;y < 50 - (String.valueOf(listOfAnimals.get(x).population).length() + listOfAnimals.get(x).name.length());y++)
			{
				output += " ";
			}
			output += displayForCost.cents2dollarsAndCents(listOfAnimals.get(x).getCost());
			output += "\n";
		}
		output += "\n";
		for(int x = 0; x < 57 - 10;x++)
		{
			output += " ";
		}
		for(int x = 0; x < 15;x++)
		{
			output += "-";
		}
		output += "\n" + "Total Cost";
		for(int x = 0;x < 57 - (String.valueOf(totalCostForAllAnimals).length() + 10 );x++)
		{
			output += " ";
		}
		output += displayForCost.cents2dollarsAndCents(totalCostForAllAnimals);
		return output;
	}
}
