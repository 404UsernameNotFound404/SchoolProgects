package henryIsTheBest.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import henryIsTheBest.entiets.BodyPart;

public class Screen extends JPanel implements Runnable  
{
	private KeyEvent event; 
	
	private static long serizableID = 1l;
	public static final int WIDTH = 800, HEIGHT = 800;
	private Thread thread;
	private boolean running;
	private Graphics g; 
	private BodyPart b;
	private ArrayList <BodyPart> partsOfSnake;
	
	private int xCor = 10,yCor = 10;
	private int size = 10;
	
	private int ticks = 0;
	
	private boolean right = true, left = false, down = false, up = false;
	
	public Screen()
	{
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		partsOfSnake = new ArrayList<BodyPart>();
		
		start();
	}
	public void tick()
	{
		if(partsOfSnake.size() == 0)
		{
			b = new BodyPart(xCor,yCor,size);
			partsOfSnake.add(b);
		}
		
		ticks++;
		
		if(ticks > 2500000)
		{
			if(right)
			{
				xCor++;
			}
			b = new BodyPart(xCor,yCor,10);
			if(partsOfSnake.size() > 5)
			{
				partsOfSnake.remove(partsOfSnake.size() - 1);
			}else
			{
				partsOfSnake.add(b);
			}
			
			ticks = 0;
			
		}
		
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
		for(int x = 0;x<partsOfSnake.size();x++)
		{
			partsOfSnake.get(x).graphics(g);
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
