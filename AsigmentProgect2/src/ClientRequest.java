import java.util.Scanner;

public class ClientRequest {

	public static void main(String[] args) {
		 StoreClientInfo client1 = new StoreClientInfo();
		 StoreClientInfo client2 = new StoreClientInfo("John's Grocer");
		 StoreClientInfo client3 = new StoreClientInfo("Mac's", 1250); 
		 StoreClientInfo client4 = new StoreClientInfo("Jefferson Corner Store", true );

		  System.out.println(client1);
		  System.out.println(client2);
		  System.out.println(client3);
		  System.out.println(client4);

		  client1.setName("John's Deli");
		  client1.placeOrder(400, false, 0);

		  System.out.println("\n" + client1.getName());
		  System.out.println("\n" + client1.getBalance());

		  client2.placeOrder(920, false, 0);
		  client3.placeOrder(1200, true, 34);
		  client4.placeOrder(1640, true, 46); 

		  System.out.println(client1);
		  System.out.println(client2);
		  System.out.println(client3);
		  System.out.println(client4);
		  
		  System.out.println("\n" + client2.getBalance());
		  client2.addInterest();
		  System.out.println(client2);
		  System.out.println();
		  
		  client1.payment(600);
		  client2.payment(400);
		  client3.payment(800);
		  client4.payment(200);
		  System.out.println();

		  
		  client1.placeOrder(1500, true, 23);
		  client2.placeOrder(350, false, 0);
		  client3.placeOrder(123.70, false, 0);
		  client4.placeOrder(500, true, 52);
		  System.out.println();

		  System.out.println(client1);
		  System.out.println(client2);
		  System.out.println(client3);
		  System.out.println(client4);
	}
}
