package nerualNetworkGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
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
	
	private smallBarrier smalBar;
	private ArrayList<smallBarrier> smalBarAL;
	
	boolean jumping = true;
	
	int counterForJump = 0;
	
	private Character Char;
	
	Random r;
	
	boolean gameOver = false;
	
	int points = 0;
	
	String pointsString;

	public Screen()
	{
		setFocusable(true);
		key = new Key();
		addKeyListener(key);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		bigBarAL = new ArrayList<bigBarrier>();
		bigBar = new bigBarrier();
		
		smalBarAL = new ArrayList<smallBarrier>();
		smalBar = new smallBarrier();
		
		Char = new Character(floorValue,gravityForce);
		
		time = new Timer();
		
		r = new Random();
		
		timerTask = new TimerTask()
				{
					int spawner = 0;
					int spawnerDelay = 25;
					int spawnerDelaySteady = 25;
					int numberOfSpawns = 0;
					@Override
					public void run() 
					{
						spawner++;
						
						points++;
						
						if(numberOfSpawns == 10)
						{
							numberOfSpawns = 0;
							spawnerDelaySteady-= 10;
							//System.out.println("done ten");
						}
						if(spawner >= spawnerDelay)
						{
							if(r.nextInt(2) == 1)
							{
								spawnerDelay = spawnerDelaySteady + r.nextInt(20) + 5;
								numberOfSpawns++;
								bigBar = new bigBarrier();
								bigBarAL.add(bigBar);
								//System.out.println("HELLO");
								spawner = 0;
							}else
							{
								spawnerDelay = spawnerDelaySteady + r.nextInt(20);
								smalBar = new smallBarrier();
								smalBarAL.add(smalBar);
								spawner = 0;
							}
							
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
						checkBarrierDelete();
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
			repaint();
		}
	}
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, WIDTH, HEIGHT);
		if(points > 100)
		{
			g.setColor(Color.cyan);
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}
		if(!gameOver)
		{
			pointsString = Integer.toString(points);
			Font myFont = new Font("Serif", Font.BOLD, 75);
			g.setFont(myFont);
			//System.out.println(pointsString);
			g.setColor(Color.BLACK);
			g.drawString("Points: " + pointsString, 550, 100);
		}
		//g.fillRect(100, counter, 10, 10);
		g.setColor(Color.BLACK);
		g.drawLine(0,floorValue + 3,WIDTH,floorValue + 3);
		Char.draw(g);
		for(int x = 0; x < bigBarAL.size();x++)
		{
			bigBarAL.get(x).draw(g);
		}
		for(int x = 0; x < smalBarAL.size();x++)
		{
			smalBarAL.get(x).draw(g);
		}
		if(gameOver)
		{
			Font myFont = new Font("Serif", Font.BOLD, 75);
			g.setFont(myFont);
			g.setColor(Color.RED);
			g.drawString("GAME OVER", 500, 100);
			time.cancel();
		}
	}
	private void upDateBarriers()
	{
		for(int x = 0;x<bigBarAL.size();x++)
		{
			bigBarAL.get(x).upDatePosition();
		}
		for(int x = 0;x<smalBarAL.size();x++)
		{
			smalBarAL.get(x).upDatePosition();
		}
	}
	private void collisonCheck()
	{	
		for(int x = 0;x<bigBarAL.size();x++)
		{
			if((bigBarAL.get(x).xCor <= Char.xCor + Char.WIDTH && Char.xCor <= bigBarAL.get(x).xCor + bigBarAL.get(x).WIDTH)
					&& Char.yCor + Char.HEIGHT >= bigBarAL.get(x).yCor)
			{
				gameOver = true;
				//System.out.println("FUCKING COLLIDED");
			}
			else
			{
				//System.out.println("Char.yCor = " + (Char.yCor + Char.HEIGHT));
				//System.out.println("bigBarAL.get(x).HEIGHT = " +  bigBarAL.get(x).yCor);
			}
		}
		for(int y = 0;y<smalBarAL.size();y++)
		{
			if((smalBarAL.get(y).xCor <= Char.xCor + Char.WIDTH && Char.xCor <= smalBarAL.get(y).xCor + smalBarAL.get(y).WIDTH)
					&& Char.yCor + Char.HEIGHT >= smalBarAL.get(y).yCor)
			{
				gameOver = true;
				System.out.println("fucking collided");
			}
		}
		
	}
	private void checkBarrierDelete()
	{
		for(int x = 0;x<bigBarAL.size();x++)
		{
			if(bigBarAL.get(x).xCor < 0)
			{
				//System.out.println("remomved big " + x);
				bigBarAL.remove(x);
			}
		}
		for(int x = 0;x<smalBarAL.size();x++)
		{
			if(smalBarAL.get(x).xCor < 0)
			{
				//System.out.println("remomved small " + x);
				smalBarAL.remove(x);
			}
		}
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
			if(key == KeyEvent.VK_SHIFT && !Char.jumping)
			{
				Char.jumping = true;
				counterForJump = 3;
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
