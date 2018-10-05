package nerualNetworkGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Character extends JPanel
{
	int WIDTH,HEIGHT,xCor,yCor,floorValue,gravityForce;
	public int counterForJump;
	public boolean jumping = true;
	
	public Character(int floorValue,int gravityForce)
	{		
		WIDTH = 15;
		HEIGHT = 50;
		xCor = 100;
		yCor = (6 * 60);
		this.floorValue = floorValue;
		this.gravityForce = gravityForce;
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(xCor, yCor , WIDTH, HEIGHT);
		//System.out.println(yCor);
	}
	public void gravity()
	{
		System.out.println(floorValue + "floor value");
		System.out.println(gravityForce + "gravity Force");
		if(yCor < (floorValue - gravityForce ) - HEIGHT)
		{
			yCor = yCor + gravityForce;
		}else
		{
			jumping = false;
		}
	}
}
	
