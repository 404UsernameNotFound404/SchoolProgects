import java.util.Scanner;

public class ClientRequest {

	public static void main(String[] args) {
		int menueSelction;
		getInput input = new getInput();
		menueSelction = input.getInput();
		switch(menueSelction)
		{
			case 1:
				 StoreClientInfo client1 = new StoreClientInfo();
				 System.out.println(client1);
				 client1.setName("John's Deli");
				 client1.placeOrder(400, false, 0);
				 System.out.println("\n" + client1.getName());
				 System.out.println("\n" + client1.getBalance());
				 System.out.println(client1);
				 client1.payment(600);
				 System.out.println(client1);
				 client1.placeOrder(150, true, 23);
				 System.out.println(client1);
				break;
			case 2:
				StoreClientInfo client2 = new StoreClientInfo("John's Grocer");
				System.out.println(client2);
				client2.placeOrder(920, false, 0);
				System.out.println(client2);
				client2.payment(1400);
				System.out.println(client2);
				client2.placeOrder(350, false, 0);
				System.out.println(client2);
				break;
			case 3:
				StoreClientInfo client3 = new StoreClientInfo("Mac's", 125);
				System.out.println(client3);
				client3.placeOrder(1200, true, 34);
				 System.out.println(client3);
				 client3.payment(800);
				 System.out.println(client3);
				 client3.placeOrder(123.70, false, 0);
				 System.out.println(client3);
				break;
			case 4:
				StoreClientInfo client4 = new StoreClientInfo("Jefferson Corner Store", true );
				System.out.println(client4);
				client4.placeOrder(1640, true, 46); 
				System.out.println(client4);
				client4.payment(200);
				System.out.println(client4);
				client4.placeOrder(550, true, 52);
				System.out.println(client4);
				client4.placeOrder(550, true, 52);
				System.out.println(client4);
				break;
		}
	     /*
		 StoreClientInfo client1 = new StoreClientInfo();
		 StoreClientInfo client2 = new StoreClientInfo("John's Grocer");
		 StoreClientInfo client3 = new StoreClientInfo("Mac's", 125);
		 StoreClientInfo client4 = new StoreClientInfo("Jefferson Corner Store", true );

		  //System.out.println(client1);
		  //System.out.println(client2);
		  //System.out.println(client3);
		  //System.out.println(client4);

		  client1.setName("John's Deli");
		  client1.placeOrder(400, false, 0);

		  System.out.println("\n" + client1.getName());
		  System.out.println("\n" + client1.getBalance());

		  //client2.placeOrder(920, false, 0);
		  //client3.placeOrder(1200, true, 34);
		  //client4.placeOrder(1640, true, 46); 

		  System.out.println(client1);
		  //System.out.println(client2);
		  //System.out.println(client3);
		  //System.out.println(client4);

		  client1.payment(600);
		  //client2.payment(1400);
		  //client3.payment(800);
		  //client4.payment(200);

		  System.out.println(client1);
		  //System.out.println(client2);
		  //System.out.println(client3);
		  //System.out.println(client4);
		  
		  client1.placeOrder(150, true, 23);
		  //client2.placeOrder(350, false, 0);
		  //client3.placeOrder(123.70, false, 0);
		  //client4.placeOrder(550, true, 52);

		  System.out.println(client1);
		 // System.out.println(client2);
		  //System.out.println(client3);
		  //System.out.println(client4);
		   */

	}

}
