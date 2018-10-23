package nerualNetworkGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

public class Character extends JPanel
{
	int WIDTH,HEIGHT,xCor,yCor,floorValue,gravityForce;
	public int counterForJump;
	public boolean jumping = true;
	double w1,w2;
	
	public Character(int floorValue,int gravityForce)
	{		
		Random r = new Random();
		WIDTH = 15;
		HEIGHT = 50;
		xCor = 100;
		yCor = (6 * 60);
		w1 = r.nextDouble();
		w2 = r.nextDouble();
		this.floorValue = floorValue;
		this.gravityForce = gravityForce;
		counterForJump = 0;
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(xCor, yCor, WIDTH, HEIGHT);
		//System.out.println(yCor);
	}
	public void gravity()
	{
		//System.out.println(floorValue + "floor value");
		//System.out.println(gravityForce + "gravity Force");
		if(yCor < (floorValue - gravityForce ) - HEIGHT)
		{
			yCor = yCor + gravityForce;
		}else
		{
			yCor = (floorValue - HEIGHT) + 3;
			jumping = false;
		}
	}
}
	
