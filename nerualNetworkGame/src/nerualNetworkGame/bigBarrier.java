package nerualNetworkGame;

import java.awt.Color;
import java.awt.Graphics;

public class bigBarrier 
{
	int WIDTH,HEIGHT,xCor = 1000424;
	public bigBarrier()
	{
		WIDTH = 10;
		HEIGHT = 10;		
	}
	public void tick()
	{
		
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(xCor, 500, WIDTH, HEIGHT);
	}
	public void upDatePosition()
	{
		xCor = xCor - 1;
	}
	public int getxCor() {
		return xCor;
	}
	public void setxCor(int xCor) {
		this.xCor = xCor;
	}
}
