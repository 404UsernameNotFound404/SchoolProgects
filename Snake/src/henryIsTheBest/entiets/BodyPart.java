package henryIsTheBest.entiets;

import java.awt.Color;
import java.awt.Graphics;

public class BodyPart 
{
	private int xCor,yCor,wd,he;
	public BodyPart(int xCoor,int yCoor,int size)
	{
		this.xCor = xCoor;
		this.yCor = yCoor;
		wd = size;
		he = size;
		
	}
	public void graphics(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(xCor * wd, yCor * he, wd, he);
		g.setColor(Color.GREEN);
		g.fillRect(xCor * wd + 2,yCor * he + 2,wd - 4,he - 4);
		//System.out.println("Andy Samberg");
	}

}
