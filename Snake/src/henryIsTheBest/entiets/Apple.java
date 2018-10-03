package henryIsTheBest.entiets;

import java.awt.Color;
import java.awt.Graphics;

public class Apple 
{
	private int xCor, yCor, height, width;
	
	public Apple(int xCor,int yCor, int width)
	{
		xCor = this.xCor;
		yCor = this.yCor;
		width = this.width;		
	}
	public void tick()
	{
		
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(xCor * width, height + 800, width, height);
	}
	public int getxCor() {
		return xCor;
	}
	public void setxCor(int xCor) {
		this.xCor = xCor;
	}
	public int getyCor()
	{
		return yCor;
	}
	public void setyCor(int yCor)
	{
		yCor = this.yCor;
	}

}
