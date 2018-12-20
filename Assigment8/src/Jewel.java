import java.awt.Color;
import java.awt.Graphics;

public class Jewel 
{
	public int WIDTH,HEIGHT;
	public int x,y;
	public Color c;
	public int colorValue;
	public Jewel(int x, int y, int WIDTH, int HEIGHT, Color c, int colorValue)
	{
		this.x = x;
		this.y = y;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.c = c;
		this.colorValue = colorValue;
	}
	public void draw(Graphics g)
	{
		//System.out.println("HELLOOOOOOOOOOOOOo");
		g.setColor(c);
		g.fillRect(x ,y , WIDTH, HEIGHT);
	}
}
