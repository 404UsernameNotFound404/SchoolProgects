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
	
	boolean jumping = true;
	
	int counterForJump = 0;
	
	private Character Char;
	
	public Screen()
	{
		setFocusable(true);
		key = new Key();
		addKeyListener(key);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		bigBarAL = new ArrayList<bigBarrier>();
		bigBar = new bigBarrier();
		
		Char = new Character(floorValue,gravityForce);
		
		time = new Timer();
		
		timerTask = new TimerTask()
				{
					int spawner = 0;
					@Override
					public void run() 
					{
						spawner++;
						
						if(spawner == 50)
						{
							bigBar = new bigBarrier();
							bigBarAL.add(bigBar);
							//System.out.println("HELLO");
							spawner = 0;
							
						}
						if(counterForJump >= 0)
						{
							//System.out.print("JUMP" + counterForJump);
							Char.yCor = Char.yCor - (gravityForce * 4);
							counterForJump--;
						}
						Char.gravity();
						collisonCheck();
						upDateBarriers();
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
		//g.fillRect(100, counter, 10, 10);
		g.drawLine(0,floorValue + 3,WIDTH,floorValue + 3);
		Char.draw(g);
		for(int x = 0; x < bigBarAL.size();x++)
		{
			bigBarAL.get(x).draw(g);
		}
	}
	private void tick()
	{
		
	}
	private void upDateBarriers()
	{
		for(int x = 0;x<bigBarAL.size();x++)
		{
			bigBarAL.get(x).upDatePosition();
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
			
			if(key == KeyEvent.VK_SPACE && !Char.jumping)
			{
				Char.jumping = true;
				//counter = counter - (gravityForce * 15);
				counterForJump = 5;
				//System.out.println("SPACE");
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
