package nerualNetworkGame;

import java.awt.Color;
import java.awt.Graphics;

public class wideBarrier 
{

	public int WIDTH,HEIGHT,xCor,yCor;
	public wideBarrier()
	{
		WIDTH = 70;
		HEIGHT = 30;		
		xCor = 1500;	
		yCor = (6 * 70) - (HEIGHT - 3);
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(xCor, yCor, WIDTH, HEIGHT);
	}
	public void upDatePosition()
	{
		xCor = xCor - 10;
		//System.out.println("UPDATE");
	}
}
