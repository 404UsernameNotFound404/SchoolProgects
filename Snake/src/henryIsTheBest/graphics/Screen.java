package henryIsTheBest.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable  
{
	private static long serizableID = 1l;
	public static final int WIDTH = 800, HEIGHT = 800;
	private Thread thread;
	private boolean running;
	private Graphics g; 
	
	public Screen()
	{
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		start();
	}
	public void tick()
	{
		//System.out.println("Running...");
	}
	public void paint(Graphics g)
	{
		for(int x = 0;x< WIDTH/10;x++)
		{
			g.drawLine(x * 10, 0, x * 10, HEIGHT);
		}
		for(int y = 0;y<HEIGHT/10;y++)
		{
			g.drawLine(0, y * 10, HEIGHT, y * 10);
		}
		
	}
	public void start()
	{
		running = true; 
		thread = new Thread(this, "GameLoop");
		thread.start();
	}
	public void stop()
	{
		
	}
	public void run()
	{
		while(running)
		{
			tick();
			repaint();
		}
	}
}
