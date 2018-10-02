/*
 * Name: Henry Morris
 * Date: 9/7/2018
 * Constructors:
 * all constructors:
 * StoreClientInfo() takes no parameters and adds admin 
 * StoreClientInfo(String storeName)
 * StoreClientInfo(String storeName,int orderAmount)
 * StoreClientInfo(String storeName, boolean delivery)
 * Functions:
 * placeOrder(double cost,boolean deliveryNeeded,float weightForOrder)
 * payment(double amountPayed)
 * addInterest()
 * 
 * Getters and Setters
 * 
 *
 */

public class StoreClientInfo 
{
	int ADMINFEE = 20;
	int CREDITLIMIT = 2000;
	double SHIPWEIGHT = 0.5f;
	double INTEREST = 1.15f;
	String storeName;
	double balance = 0;
	double purchase = 0;
	float weight = 0;
	boolean delivery = false;
	
	public StoreClientInfo(String storeName) 
	{
		this.storeName = storeName;
		balance = ADMINFEE + balance;
	}
	public StoreClientInfo(String storeName,int orderAmount)
	{
		if(orderAmount + balance > CREDITLIMIT)
		{
			System.err.println(storeName + ": Error Cost of Order execeds Credit Limit by " + (orderAmount - CREDITLIMIT) + "$");
		}else
		{
			balance = orderAmount + balance;
			System.out.println(storeName + ": order placed the cost is " + orderAmount + " the balance is now " + balance);
		}
		this.storeName = storeName;
		balance = ADMINFEE + balance;
	}
	public StoreClientInfo(String storeName,boolean delivery)
	{
		this.storeName = storeName;
		this.delivery = delivery;
		balance = ADMINFEE + balance;
	}
	public StoreClientInfo()
	{
		storeName = "poop"; 
		balance = ADMINFEE + balance;
	}
	
	//////////////////////////////////////////////////////////////////////Constructors above 
	
	public void placeOrder(double cost,boolean deliveryNeeded,float weightForOrder) //places an order with cost if its delivery and the weight
	{
		delivery = deliveryNeeded;
		double deliveryCost = 0;
		if(delivery)
		{
			deliveryCost = (SHIPWEIGHT * weightForOrder);
		}
		if(deliveryCost + cost + balance > CREDITLIMIT) 
		{
			System.out.println("error you have to pick up your order becuase shiping execeds your credit Limit");
		}
		else
		{
			cost = cost + deliveryCost;
			System.err.println("ANDY SAMBERG");
		}
		if(cost + balance > CREDITLIMIT)
		{
			System.err.println(storeName + ": Error Cost exexceds credit limit by " + (cost - CREDITLIMIT));
		}else
		{
			balance = balance + cost; 
		}
		System.out.println(storeName + ": Order Placed the cost is " + cost);
	}
	public void payment(double amountPayed)
	{
		if(balance - amountPayed >= 0)
		{
			balance = balance - amountPayed;
			System.out.println(storeName + ": the amount payed is " + amountPayed + " now the balance is " + balance + "\n");
		}else
		{
			double changeDue = (balance-amountPayed) * -1;
			System.err.println(storeName + ": ERROR Payment greater then balance \n Change Due: " + changeDue);
			balance = 0;
		}
	}
	public void addInterest()
	{		
		double intrest = ((balance * INTEREST) - balance) / 12;
		balance = balance + intrest;
		System.out.println(storeName + ": Intrest added " + intrest + "balance is now " + balance);
	}
	///////////////////////////////////////////////////////////////////////seters and getter below
	public String getName() {
		return "StoreName: " + storeName;
	}
	public void setName(String storeName) {
		this.storeName = storeName;
	}
	public String getBalance() {
		return storeName + ": Balance For " + storeName + ": " + balance;
	}
	@Override
	 public String toString() {
	    
		return storeName + " Balance Of Store " + (float) balance + "\n";
		
	  }
}
