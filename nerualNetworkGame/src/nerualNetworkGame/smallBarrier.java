package nerualNetworkGame;

import java.awt.Color;
import java.awt.Graphics;

public class smallBarrier 
{
	public int WIDTH,HEIGHT,xCor,yCor;
	public smallBarrier()
	{
		WIDTH = 20;
		HEIGHT = 20;		
		xCor = 1500;	
		yCor = (6 * 70) - (HEIGHT - 3);
	}
	public void tick()
	{
		
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.GREEN);
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
