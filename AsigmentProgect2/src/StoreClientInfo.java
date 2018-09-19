
public class StoreClientInfo 
{
	int ADMINFEE = 20;
	int CREDITLIMIT = 2000;
	float SHIPWEIGHT = 0.5f;
	int INTEREST = 15;
	String storeName;
	float balance = 0;
	float purchase = 0;
	float weight = 0;
	boolean delivery;
	
	public static final String ANSI_RED = "\u001B[31m";
	
	public StoreClientInfo(String storeName) 
	{
		this.storeName = storeName;
	}
	public StoreClientInfo(String storeName,int balance)
	{
		this.storeName = storeName;
		this.balance = balance;
	}
	public StoreClientInfo(String storeName,boolean delivery)
	{
		this.storeName = storeName;
		this.delivery = delivery;
	}
	public StoreClientInfo()
	{
		storeName = "Name Not Found";		
	}
	
	//////////////////////////////////////////////////////////////////////Constructors above 
	
	public void placeOrder(double cost,boolean delivery,float weight) //places an order with cost if its delivery and the weight
	{
		cost = cost + (SHIPWEIGHT * weight); 
		if(cost > CREDITLIMIT)
		{
			System.err.println("Error Cost exexceds credit limit by " + (cost - CREDITLIMIT));
		}else
		{
			balance = balance + (float) cost; 
		}
		System.out.println("Order Placed \nCost: " + cost);
	}
	
	public void payment(int amountPayed)
	{
		if(balance - amountPayed >= 0)
		{
			System.out.println("Amount Payed: " + amountPayed + "\n balance = " + balance + "\n");
			balance = balance - amountPayed;
		}else
		{
			float changeDue = (balance-amountPayed) * -1;
			System.err.println("ERROR Payment greater then balance \n Change Due: " + changeDue);
		}
		
	}
	///////////////////////////////////////////////////////////////////////seters and getter below
	public String getName() {
		return "StoreName: " + storeName;
	}
	public void setName(String storeName) {
		this.storeName = storeName;
	}
	public String getBalance() {
		return "Balance For " + storeName + ": " + balance;
	}
	@Override
	 public String toString() {
	    
		return "Store Name: " + storeName + "\n" + "Balance Of Store: " + balance + "\n";
		
	  }
}
