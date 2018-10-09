package nerualNetworkGame;

public class nerualNetwork 
{
	double x1,x2,w1,w2;
	
	public double caculationForNetwork(double x1,double x2,double w1,double w2) 
	{
		double bias = 0;
		double value1 = x1 * w2;
		double value2 = x2 * w2;
		
		double value3 = value1 + value2;
		
		double value4 = value3 + bias;
		
		double finalValue = 1 / 1 + Math.exp(value4);
		
		//System.out.println(finalValue);
		
		return finalValue;
	}
}
