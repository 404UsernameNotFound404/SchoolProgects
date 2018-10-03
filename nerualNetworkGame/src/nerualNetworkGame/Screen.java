package nerualNetworkGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable
{
private static long serizableID = 1l;
	
	private Thread thread;
	private boolean running = false;
	
	private static int WIDTH = 1500, HEIGHT = 800;
	
	private Key key;
	
	int tickCounter = 0;
	
	TimerTask timerTask;
	
	Timer time;
	
	int delay = 50;
	
	int gravityForce = 6;
	
	int floorValue = gravityForce * 70;
	int counter = gravityForce * 50;
	
	private bigBarrier bigBar;
	private ArrayList<bigBarrier> bigBarAL;
	
	public Screen()
	{
		setFocusable(true);
		key = new Key();
		addKeyListener(key);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		time = new Timer();
		
		timerTask = new TimerTask()
				{
					int spawner = 0;
					@Override
					public void run() 
					{
						spawner++;
						if(spawner == 100)
						{
							bigBar = new bigBarrier();
							bigBarAL.add(bigBar);
							spawner = 0;
							
						}
						gravity();
						collisonCheck();
					}
				};
				
		time.scheduleAtFixedRate(timerTask, delay, delay);
		start();
	}
	public void start()
	{
		running = true;
		thread = new Thread(this, "GameLoop");
		thread.start();
	}
	public void run()
	{
		while(running)
		{
			tick();
			repaint();
		}
	}
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.fillRect(100, counter, 10, 10);
		g.drawLine(0,floorValue + 3,WIDTH,floorValue + 3);
		
		for(int x = 0; x < bigBarAL.size();x++)
		{
			bigBarAL.get(x).draw(g);
		}
	}
	private void tick()
	{
		
	}
	private void gravity()
	{
		if(counter < (floorValue - gravityForce))
		{
			counter = counter + gravityForce;
		}
	}
	private void collisonCheck()
	{
		
	}
	private class Key implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent e) 
		{
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_SPACE)
			{
				counter = counter - (gravityForce * 10);
				System.out.println("SPACE");
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
