package nerualNetworkGame;

public class nerualNetwork 
{
	double x1,x2,w1,w2;
	double finalValue;
	
	public double caculationForNetwork(double x1,double x2,double w1,double w2) 
	{
		double bias = 170;
		x2 = x2/10;
		x1 = (x1/10) - bias;
		
		//System.out.println("weight 1 = "+ w1);
		//System.out.println("weigth 2 = "+ w2);
		
		//System.out.println("value 1 = "+ x1);
		//System.out.println("value 2 = "+ x2);		
		
		double value1 = x1 * w2;
		double value2 = x2 * w2;
		//System.out.println("value 1 = "+value1);
		//System.out.println("value 2 = "+value2);
		
		double value3 = value1 + value2;
		
		double value4 = value3;
		
		//System.out.println(value4);
		
		finalValue = 1 / (1 + Math.exp(value4));
		
		System.err.println("final Value" + finalValue);
		
		return finalValue;
	}
}
