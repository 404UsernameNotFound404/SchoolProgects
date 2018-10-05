package henryIsTheBest.entiets;

import java.awt.Color;
import java.awt.Graphics;

public class Apple 
{
	private int xCor, yCor, height, width;
	public Apple(int xCor, int yCor, int size)
	{
		this.xCor = xCor;
		this.yCor = yCor;
		height = size;
		width = size;		
	}
	public void tick()
	{
		
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(xCor * width,yCor * height, width, height);
	}
	public int getxCor() {
		return xCor;
	}
	public void setxCor(int xCor) {
		this.xCor = xCor;
	}
	public int getyCor() {
		return yCor;
	}
	public void setyCor(int yCor) {
		this.yCor = yCor;
	}

}
