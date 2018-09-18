
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


}
