package nerualNetworkGame;

import java.awt.Color;
import java.awt.Graphics;

public class bigBarrier 
{
	int WIDTH,HEIGHT,xCor,yCor;
	public bigBarrier()
	{
		WIDTH = 20;
		HEIGHT = 50;		
		xCor = 1500;	
		yCor = (6 * 70) - (HEIGHT - 3);
	}
	public void tick()
	{
		
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(xCor, yCor, WIDTH, HEIGHT);
	}
	public void upDatePosition()
	{
		xCor = xCor - 10;
		//System.out.println("UPDATE");
	}
	public int getxCor() {
		return xCor;
	}
	public void setxCor(int xCor) {
		this.xCor = xCor;
	}
}
