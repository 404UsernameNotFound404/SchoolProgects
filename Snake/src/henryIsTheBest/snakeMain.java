package henryIsTheBest;

import java.awt.GridLayout;
import javax.swing.JFrame;

import henryIsTheBest.graphics.Screen;

public class snakeMain extends JFrame 
{
	public snakeMain() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Snake");
		setResizable(false);
		InIt();
			
	}	
	public void InIt() 
	{
		setLayout(new GridLayout(1,1,0,0));
		Screen s = new Screen();
		add(s);
		pack();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new snakeMain();
		
	}
}
