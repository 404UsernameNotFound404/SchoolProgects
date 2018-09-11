package henryIsTheBest.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import henryIsTheBest.snakeMain;
import henryIsTheBest.entiets.Apple;
import henryIsTheBest.entiets.BodyPart;

public class Screen extends JPanel implements Runnable  
{
	private KeyEvent event; 
	
	private static long serizableID = 1l;
	public static final int WIDTH = 500, HEIGHT = 500;
	private Thread thread;
	private boolean running;
	private Graphics g; 
	private BodyPart b;
	private ArrayList <BodyPart> partsOfSnake;
	
	private int xCor = 10,yCor = 10;
	private int size = 10;
	
	private int ticks = 0;
	
	private boolean right = false, left = false, down = true, up = false;
	
	private Key key;
	
	private Apple apple;
	private ArrayList<Apple> apples;
	
	private Random r;
	
	private snakeMain main;
	
	private int tickRate = 90000;
	
	private int appleCount = 0;
	
	private boolean hitApple = false;
	
	public Screen()
	{
		setFocusable(true);
		
		key = new Key();
		
		addKeyListener(key);
		
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		partsOfSnake = new ArrayList<BodyPart>();
		apples = new ArrayList<Apple>();
		
		r = new Random();
		
		start();
	}
	public void tick()
	{
		ticks++;
		
		if(partsOfSnake.size() == 0)
		{
			b = new BodyPart(xCor,yCor,size);
			partsOfSnake.add(b);
		}
		if(apples.size() == 0)
		{
			int xCor = r.nextInt(49);
			int yCor = r.nextInt(49);
			apple = new Apple(xCor,yCor,10);
			apples.add(apple);
		}
		for(int i = 0; i < apples.size();i++)
		{
			if(xCor == apples.get(i).getxCor() && yCor == apples.get(i).getyCor())
			{
				size++;
				apples.remove(i);
				i--;
				hitApple = true;
			}
		}
		if(hitApple)
		{
			appleCount++;
			if(appleCount == 2)
			{
				tickRate = tickRate - 5000;
				System.out.print(tickRate);
				appleCount = 0;
			}
			hitApple = false;
		}
		if(ticks > tickRate)
		{
			if(right) xCor++;
			if(left) xCor--;
			if(down) yCor++;
			if(up) yCor--;
			for(int i = 0; i < partsOfSnake.size();i++)
			{
				for(int x = 1; x < partsOfSnake.size();x++)
				{
					if(i != x)
					{
						if(partsOfSnake.get(i).getxCor() == partsOfSnake.get(x).getxCor() && partsOfSnake.get(i).getyCor() == partsOfSnake.get(x).getyCor())
						{
							main.close();
							System.out.println("HIT");
						}
					}
				}
			}
			for(int y = 0; y < partsOfSnake.size();y++)
			{
				
			}
			if(partsOfSnake.size() > size)
			{
				partsOfSnake.remove(0);
			}
			b = new BodyPart(xCor,yCor,10);
			partsOfSnake.add(b);
			
			ticks = 0;
		}
		
		//System.out.println("Running...");
	}
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, WIDTH, HEIGHT);
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
		for(int x = 0; x<apples.size();x++)
		{
			apples.get(x).draw(g);
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
	private class Key implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_D && !left)
			{
				right = true;
				up = false;
				down = false;
			}
			if(key == KeyEvent.VK_A && !right)
			{
				left = true;
				up = false;
				down = false;
			}
			if(key == KeyEvent.VK_S && !up)
			{
				left = false;
				down = true;
				right = false;
			}
			if(key == KeyEvent.VK_W && !down)
			{
				left = false;
				up = true;
				right = false;
			}
		}
	
		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}
	
		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}	
	}
}
