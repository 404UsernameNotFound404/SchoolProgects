
public class StoreClientInfo 
{
	int ADMINFEE = 20;
	int CREDITLIMIT = 2000;
	float SHIPWEIGHT = 0.5f;
	float INTEREST = 1.15f;
	String storeName;
	float balance = 0;
	float purchase = 0;
	float weight = 0;
	boolean delivery;
	
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
	
	public void placeOrder(double cost,boolean delivery,float weight) //places an order with cost if its delivery and the weight
	{
		delivery = this.delivery;
		if(delivery)
		{
		cost = cost + (SHIPWEIGHT * weight);
		}
		if(cost + balance > CREDITLIMIT)
		{
			System.err.println(storeName + ": Error Cost exexceds credit limit by " + (cost - CREDITLIMIT));
			balance = 0;
		}else
		{
			balance = balance + (float) cost; 
		}
		System.out.println(storeName + ": Order Placed the cost is " + cost);
	}
	public void payment(int amountPayed)
	{
		if(balance - amountPayed >= 0)
		{
			balance = balance - amountPayed;
			System.out.println(storeName + ": the amount payed is " + amountPayed + " now the balance is " + balance + "\n");
		}else
		{
			float changeDue = (balance-amountPayed) * -1;
			System.err.println(storeName + ": ERROR Payment greater then balance \n Change Due: " + changeDue);
		}
	}
	public void addInterest()
	{		
		float intrest = ((balance * INTEREST) - balance) / 12;
		balance = balance - intrest;
		System.out.println(storeName + ": Intrest added " + intrest + "balance is now " + balance);
		intrest = 0;
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
	    
		return storeName + " Balance Of Store " + balance + "\n";
		
	  }
}
