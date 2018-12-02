
public abstract class Animal 
{
	protected String name;
	  protected int population;
	  
	/**
	 * Null constructor for DessertItem class
	 */
	  public Animal() {
	    this("",0);
	  }

	/**
	 * Initializes Animal data
	 */   
	  public Animal(String name,int pop) 
	  {
	    if (name.length() <= Zoo.MAX_ITEM_NAME_SIZE)
	      this.name = name;
	    else 
	      this.name = name.substring(0,Zoo.MAX_ITEM_NAME_SIZE);
	    this.population = pop;
	  }

	public void setName(String name) 
	{
		this.name = name;
	}

	public void setPopulation(int population) 
	{
		this.population = population;
	}

	/**
	 * Returns name of Animal
	 * @return name of Animal
	 */  
	  public final String getName() 
	  {
	    return name;
	  }

	/**
	 * Returns population of Animal
	 * @return population of Animal
	 */  
	  public final int getPopulation() 
	  {
	    return population;
	  }

	/**
	 * Returns cost of Animal
	 * @return cost of Animal
	 */  
	  public abstract int getCost();



}
