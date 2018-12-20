import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import org.w3c.dom.css.Rect;

public class Screen extends JPanel
{
	int WIDTH = 1200;
	int HEIGHT = 600;
	
	int offSet = WIDTH/4;
	
	int widthOfSquare = (WIDTH - offSet)/8;
	int heightOfSquare = HEIGHT/8;
	
	TimerTask task;
	Timer time;
	
	int counter = 0;
	
	float timeLeft = 100;
	
	int score = 10;
	
	int[][] gameBoard;
	Jewel[][] gameJewels;
	
	Random r;
	
	int FirstColSelcted = -1;
	int FirstRowSelcted = -1;
	int FirstColorSelected = -1;
	
	int SecondColSelcted = -1;
	int SecondRowSelcted = -1;
	int SecondColorSelected = -1;
	
	boolean someThingSlected = false;
	
	boolean switchHappening = false;
	
	int counterForSwitch = 0;
	
	Rectangle firstRecForSwitch;
	Rectangle secondRecForSwitch;
	
	int MovingValueForSwitchCol = 0;
	int MovingValueForSwitchRow = 0;
	
	public Screen()
	{
		addMouseListener(new MyMouseAdapter());
		firstRecForSwitch = new Rectangle(0,0,0,0);
		secondRecForSwitch = new Rectangle(0,0,0,0);
		r = new Random();
		gameBoard = new int[8][8];
		gameJewels = new Jewel[8][8];
		for(int row = 0;row < 8;row++)
		{
			for(int col = 0;col < 8;col++)
			{
				Color tempColor = Color.BLACK;
				int randomColorValue = r.nextInt(6);
				gameBoard[row][col] = randomColorValue;
				switch(randomColorValue)
				{
				case 0:
					tempColor = Color.RED;
					break;
				case 1:
					tempColor = Color.GREEN;
					break;
				case 2:
					tempColor = Color.CYAN;
					break;
				case 3:
					tempColor = Color.YELLOW;
					break;
				case 4:
					tempColor = Color.LIGHT_GRAY;
					break;
				case 5:
					tempColor = Color.MAGENTA;
					break;
				case 6:
					tempColor = Color.ORANGE;
					break;
				}
				Jewel tempJewel = new Jewel(offSet + (col * (WIDTH - offSet) / 8), row * (HEIGHT / 8), (WIDTH - offSet) /8, HEIGHT/8, tempColor, randomColorValue);
				gameJewels[row][col] = tempJewel;
			}
		}
		time = new Timer();
		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		task = new TimerTask() 
		{
			public void run()
			{
				if(counter % 100 == 0)
				{
					timeLeft-= 1;
				}
				if(timeLeft <= 0)
				{
					System.out.println("YOU LOST YOU LOSER");
				}
				if(switchHappening)
				{
					counterForSwitch++;
					if(counterForSwitch <= 0)
					{
						if(FirstColSelcted - SecondColSelcted)
						{
							MovingValueForSwitchCol = -1 * ((HEIGHT/8) / 4);
						}
						else
						{
							
						}
						switch(FirstRowSelcted - SecondRowSelcted)
						{
						case -1:
							
							break;
						case 0:
							
							break; 
						case 1:
							
							break;
						}
						firstRecForSwitch.setBounds(offSet + (FirstColSelcted * (WIDTH - offSet) / 8), FirstRowSelcted * (HEIGHT / 8), (WIDTH - offSet) /8, HEIGHT/8); 
						secondRecForSwitch.setBounds(offSet + (SecondColSelcted * (WIDTH - offSet) / 8), SecondRowSelcted * (HEIGHT / 8), (WIDTH - offSet) /8, HEIGHT/8);
						
					}else
					{
						gameBoard[FirstRowSelcted][FirstColSelcted] = SecondColorSelected;
						gameBoard[SecondRowSelcted][SecondColSelcted] = FirstColorSelected;
						switchHappening = false;
						counterForSwitch = 0;
						FirstColSelcted = -1;
						FirstRowSelcted = -1;
						SecondColSelcted = -1;
						SecondRowSelcted = -1;
					}
				}
				counter++;
				//System.out.println(counter);
				repaint();
			}
		};
		time.scheduleAtFixedRate(task, 1, 10);
		checkForThreeInARow();
	}
	public void paint(Graphics g)
	{
		//checkForThreeInARow();
		Color tempColor;
		g.clearRect(0, 0, WIDTH, HEIGHT);
		for(int row = 0;row < 8;row++)
		{
			for(int col = 0;col < 8;col++)
			{
				if(row == FirstRowSelcted && col == FirstColSelcted)
				{
					//g.setColor(Color.black);
				}
				
					switch(gameBoard[row][col])
					{
						case 0:
							g.setColor(Color.RED);
							break;
						case 1:
							g.setColor(Color.GREEN);
							break;
						case 2:
							g.setColor(Color.CYAN);
							break;
						case 3:
							g.setColor(Color.YELLOW);
							break;
						case 4:
							g.setColor(Color.LIGHT_GRAY);
							break;
						case 5:
							g.setColor(Color.MAGENTA);
							break;
						case 6:
							g.setColor(Color.ORANGE);
							break;
						case 7:
							g.setColor(Color.WHITE);
							break;
					
				}
				g.fillRect(offSet + (col * (WIDTH - offSet) / 8), row * (HEIGHT / 8), widthOfSquare, heightOfSquare);
			}
		}
		
		g.setFont(new Font("Serif", Font.BOLD, 50));
		
		FontMetrics metrics = g.getFontMetrics(new Font("Serif", Font.BOLD, 50));
		boolean toCheckFont = true;
		int toGetTextRight = 50;
		while(toCheckFont)
		{
			if(HEIGHT/10 <= metrics.getHeight())
			{
				//System.out.println("HELLO IS IT ME YOUR LOOKING FOR");
				toGetTextRight--;
				metrics = g.getFontMetrics(new Font("Serif", Font.BOLD, toGetTextRight));
			}
			else
			{
				g.setFont(new Font("Serif", Font.BOLD, toGetTextRight));
				//System.out.println(toGetTextRight + "TEST RIGHT");
				toCheckFont = false;
			}
		}
		g.drawString(String.valueOf(score), HEIGHT/20, (int) (HEIGHT/20 + (metrics.getHeight() / 1.3)));
		g.setColor(Color.black);
		g.drawRect(HEIGHT/20, HEIGHT/20, WIDTH/4 - ((HEIGHT/20) * 2), HEIGHT/10);
		//g.fillRect(WIDTH - 25, 0, WIDTH - 25, HEIGHT);
		//above is left side and right side line
		for(int x = 0;x <= 8;x++)
		{
			g.setColor(Color.BLACK);
			g.drawLine(offSet + (x * (WIDTH - offSet) / 8), 0, offSet + (x * (WIDTH - offSet) / 8), HEIGHT);
			//System.out.println(offSet + (x * 100));
		}
		for(int x = 0;x <= 8;x++)
		{
			g.drawLine(offSet, x * (HEIGHT / 8), WIDTH, x * (HEIGHT / 8));
		}
		//death line ----------------
		g.drawLine(offSet, 0, offSet, HEIGHT);
		g.setColor(Color.BLACK);
		int timeLeftToInt = (int)((timeLeft/100) * (HEIGHT/2));
		//System.out.println(timeLeftToInt - (HEIGHT/5));
		//System.out.println();
		g.fillRect(HEIGHT/5, ((HEIGHT/2) - timeLeftToInt) + (HEIGHT/5), offSet/4, timeLeftToInt);
		//g.fillRect(timeLeftToInt, offSet/4,HEIGHT/5, HEIGHT/5);
		//System.out.println(timeLeft/100);
	}
	
	private class MyMouseAdapter extends MouseAdapter {
	    @Override
	    public void mousePressed(MouseEvent e) 
	    {
	    	/*
//			int x = MouseInfo.getPointerInfo().getLocation().x;
//			int y = MouseInfo.getPointerInfo().getLocation().y;
	    	 */
	        //int x = e.getXOnScreen() - getLocationOnScreen().;
			//int y = e.getYOnScreen() - this.getLocationOnScreen().y;
	    	//int x = e.getXOnScreen();
	    	//int y = e.getYOnScreen();
	    	 //int x = e.getX();
	    	 //int y = e.getY();
	    	 
	    	 int x = e.getXOnScreen() - getLocationOnScreen().x;
			 int y = e.getYOnScreen() - getLocationOnScreen().y;
			 //System.out.println("x: " + x + " y: " + y);
			 boolean forBreak = false;
			 if(x > offSet && y < WIDTH)
			 {
				 int tempForCol = -1;
				 //int recRow = y / (HEIGHT / 8);
				 //int recCol = x / ((WIDTH - offSet) / 8);
				 int recRow = y / (HEIGHT / 8);
				 int recCol = (x - offSet) / (WIDTH / 8);
				 //System.out.println("Row " + recRow + "Col " + recCol);
				 System.out.println(recRow + "ROW");
				 if(!someThingSlected)
				 {
					 FirstRowSelcted = recRow;
				 }
				 else
				 {
					 SecondRowSelcted = recRow;
				 }
				 //FirstrowSelcted = recRow;
				 for(int col = 0;col < 8; col++)
				 {
					 //System.out.println(row * widthOfSquare);
					 //System.out.println(( x > (row * widthOfSquare)) + "&&" + (x < (row * ((WIDTH - offSet) / 8)) + widthOfSquare));
					 //System.out.println(row * widthOfSquare + "&&" + ((row * ((WIDTH - offSet) / 8)) + widthOfSquare));
					 if(x >= ((col * widthOfSquare) + offSet) && x <= (col * ((WIDTH - offSet) / 8) + offSet) + widthOfSquare)
					 {
						System.out.println(col + "Row");
						tempForCol = col;
						System.out.println();
						break;
					 }
				 }
				 if(!someThingSlected)
				 {
					 FirstColSelcted = tempForCol;
					 someThingSlected = true;
				 }
				 else
				 {
					 SecondColSelcted = tempForCol;
					 someThingSlected = false;
					 Switch();
				 }
				 System.out.println("First Col " + FirstColSelcted + "First Row" + FirstRowSelcted);
				 System.out.println("First Col " + SecondColSelcted + "First Row" + SecondRowSelcted);
			 }
	    }
	    @Override
	    public void mouseDragged(MouseEvent e) {
	       
	    }

	    @Override
	    public void mouseReleased(MouseEvent e) {
	        
	    }

	    public void updateLocation(MouseEvent e) {
	       
	    }
	}
	public void Switch()
	{
		System.out.println("Switch runs");
		if((FirstColSelcted + 1 == SecondColSelcted || FirstColSelcted - 1 == SecondColSelcted) || (FirstRowSelcted + 1 == SecondRowSelcted || FirstRowSelcted - 1 == SecondRowSelcted))
		{
			//System.out.println("SWITCH " + gameBoard[FirstColSelcted][FirstRowSelcted] + " TO " + gameBoard[SecondRowSelcted][SecondColSelcted]);
			int tempForColorSwitch = 0;
			FirstColorSelected = gameBoard[FirstRowSelcted][FirstColSelcted];
			SecondColorSelected = gameBoard[FirstRowSelcted][FirstColSelcted];
			tempForColorSwitch = gameBoard[FirstRowSelcted][FirstColSelcted];
			gameBoard[FirstRowSelcted][FirstColSelcted] = gameBoard[SecondRowSelcted][SecondColSelcted];
			gameBoard[SecondRowSelcted][SecondColSelcted] = tempForColorSwitch;
			gameBoard[FirstRowSelcted][FirstColSelcted] = 7;
			gameBoard[SecondRowSelcted][SecondColSelcted] = 7;
			switchHappening = true; 
			System.out.println("Allowed Switch");
			checkForThreeInARow();
		}
	}
	public void checkForThreeInARow()
	{
		for(int row = 0;row < 8;row++)
		{
			for(int col = 0;col < 8;col++)
			{
				try
				{
					//check up
					if(gameBoard[row][col] == gameBoard[row - 1][col])
					{
						if(gameBoard[row][col] == gameBoard[row - 2][col])
						{
							System.out.println("Found Three In A Row");
							gameBoard[row][col] = 7;
							gameBoard[row - 1][col] = 7;
							gameBoard[row - 2][col] = 7;
							GravityCheck();
						}
					}
				}
				catch(Exception NullPointerException)
				{
					//System.out.println("Null Pinter Expection");
				}
				try
				{
					//check down
					if(gameBoard[row][col] == gameBoard[row + 1][col])
					{
						if(gameBoard[row][col] == gameBoard[row + 2][col])
						{
							System.out.println("Found Three In A Row");
							gameBoard[row][col] = 7;
							gameBoard[row + 1][col] = 7;
							gameBoard[row + 2][col] = 7;
							GravityCheck();
						}
					}
				}
				catch(Exception NullPointerException)
				{
					//System.out.println("Null Pinter Expection");
				}
				try
				{
					//check right
					if(gameBoard[row][col] == gameBoard[row][col + 1])
					{
						if(gameBoard[row][col] == gameBoard[row][col + 2])
						{
							System.out.println("Found Three In A Row");
							gameBoard[row][col] = 7;
							gameBoard[row][col + 1] = 7;
							gameBoard[row][col + 2] = 7;
							GravityCheck();
						}
						
					}
				}
				catch(Exception NullPointerException)
				{
					//System.out.println("Null Pinter Expection");
				}
				try
				{
					//check left 
					if(gameBoard[row][col] == gameBoard[row][col - 1])
					{
						if(gameBoard[row][col] == gameBoard[row][col - 2])
						{
							System.out.println("Found Three In A Row");
							gameBoard[row][col] = 7;
							gameBoard[row][col - 1] = 7;
							gameBoard[row][col - 2] = 7;
							GravityCheck();
						}
					}
				}
				catch(Exception NullPointerException)
				{
					//System.out.println("Null Pinter Expection");
				}
			}
		}
	}
	public void GravityCheck()
	{
		System.out.println("HELLO");
		boolean boolTemp = true;
		boolean foundFall = false;
		Random r = new Random();
		for(int y = 0;y < 8;y++)
		{
			System.out.println("INFINTY");
			for(int x = 0;x<8;x++)
			{
				if(gameBoard[0][x] == 7)
				{
					gameBoard[0][x] = r.nextInt(6);
					//boolTemp = false;
				}
			}
			for(int row = 1;row < 8;row++)
			{
				for(int col = 0;col < 8;col++)
				{
					if(gameBoard[row][col] == 7)
					{
						gameBoard[row][col] = gameBoard[row - 1][col];
						gameBoard[row - 1][col] = 7;
//						try {
//							Thread.sleep(10);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					}
				}
			}
		}
	}
}
