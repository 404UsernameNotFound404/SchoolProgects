import java.awt.Color;
import java.awt.Graphics;

public class BodyPart 
{
	private int xCor,yCor,wd,he;
	public BodyPart(int xCoor,int yCoor,int size)
	{
		int xCor = xCoor;
		int yCor = yCoor;
		int wd = size;
		int he = size;
		
	}
	public void graphics(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(xCor, yCor, wd, he);
	}

}
