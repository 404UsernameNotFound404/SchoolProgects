import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.w3c.dom.css.Rect;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
 import javax.sound.sampled.Clip;

public class Screen extends JPanel
{
	int WIDTH;
	int HEIGHT;
	
	int offSet = WIDTH/4;
	
	int widthOfSquare = (WIDTH - offSet)/8;
	int heightOfSquare = HEIGHT/8;
	
	TimerTask task;
	Timer time;
	
	int counter = 0;
	
	float timeLeft = 100;
	
	int score = 0;
	
	int[][] gameBoard;
	
	Random r;
	
	int FirstColSelcted = -1;
	int FirstRowSelcted = -1;
	int FirstColorSelected = -1;
	
	int SecondColSelcted = -1;
	int SecondRowSelcted = -1;
	int SecondColorSelected = -1;
	
	boolean someThingSlected = false;
	boolean switchHappening = false;
	
	int howManyFramesForSwitchDefault = 35;
	int counterForSwitch = howManyFramesForSwitchDefault;
	
	Rectangle firstRecForSwitch;
	Rectangle secondRecForSwitch;
	
	int MovingValueForSwitchCol = 0;
	int MovingValueForSwitchRow = 0;
	
	int[] RowsToFall;
	int[] ColToFall;
	
	boolean thingsFalling = false;
	
	boolean switchBack = false;
	
	Clip clip;
	
	BufferedImage image;
	BufferedImage imageBackground;
	
	BufferedImage returnImage;
	
	public Screen(int width, int height)
	{
		WIDTH = width;
		HEIGHT = height;
		
		offSet = WIDTH/4;
		widthOfSquare = (WIDTH - offSet)/8;
		heightOfSquare = HEIGHT/8;
		
		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		//music
		playMusic();
		//music end
		addMouseListener(new MyMouseAdapter());
		r = new Random();
		//setting up board
		gameBoard = new int[8][8];
		for(int row = 0;row < 8;row++)
		{
			for(int col = 0;col < 8;col++)
			{
				Color tempColor = Color.BLACK;
				int randomColorValue = r.nextInt(5);
				gameBoard[row][col] = randomColorValue;
			}
		}
		checkForThreeInARow(false, false);
		//checkForThreeInARow(false, false);
		//setting up board end
		//Game Loop For Change
		time = new Timer();
		task = new TimerTask() 
		{
			public void run()
			{
				if(counter % 100 == 0)
				{
					timeLeft-= 1;
				}
				if(switchHappening)
				{
					//System.out.println(counterForSwitch);
					counterForSwitch--;
					//System.out.println(counterForSwitch);
					if(counterForSwitch >= 0)
					{
						if (FirstColSelcted - SecondColSelcted == 1)
						{
							//System.out.println("Col Moving -");
							MovingValueForSwitchRow += -1 * (((WIDTH - offSet) / 8) / howManyFramesForSwitchDefault);
						}
						if(FirstColSelcted - SecondColSelcted == -1)
						{
							//System.out.println("Col Moving +");
							MovingValueForSwitchRow += 1 * (((WIDTH - offSet) / 8) / howManyFramesForSwitchDefault);
						}
						if (FirstRowSelcted - SecondRowSelcted == -1)
						{
							//System.out.println("Row Moving -");
							MovingValueForSwitchCol += 1 * ((HEIGHT/8) / howManyFramesForSwitchDefault);
						}
						if(FirstRowSelcted - SecondRowSelcted == 1)
						{
							MovingValueForSwitchCol += -1 * ((HEIGHT/8) / howManyFramesForSwitchDefault);
							//System.out.println("Row Moving+");
						}
						
					}else
					{
						gameBoard[FirstColSelcted][FirstRowSelcted] = SecondColorSelected;
						gameBoard[SecondColSelcted][SecondRowSelcted] = FirstColorSelected;
						
						if(!checkForThreeInARow(true, true) && !switchBack)
						{
							//System.out.println("switch back");
							//if no three in a row
							int tempForColorSwitchBackCol = 0;
							tempForColorSwitchBackCol = FirstColSelcted;
							FirstColSelcted = SecondColSelcted;
							SecondColSelcted = tempForColorSwitchBackCol;
							
							int tempForColorSwitchBackRow = 0;
							tempForColorSwitchBackRow = FirstRowSelcted;
							FirstRowSelcted = SecondRowSelcted;
							SecondRowSelcted = tempForColorSwitchBackRow;
							
//							SecondColorSelected = gameBoard[FirstRowSelcted][FirstColSelcted];
//							FirstColorSelected = gameBoard[SecondRowSelcted][SecondColSelcted];
							//System.out.println("First Col " + FirstColSelcted + "First Row " + FirstRowSelcted);
//							gameBoard[FirstColSelcted][FirstRowSelcted] = 7;
//							gameBoard[SecondColSelcted][SecondRowSelcted] = 7;
							switchHappening = true; 
							MovingValueForSwitchRow = 0;
							MovingValueForSwitchCol = 0;
							counterForSwitch = howManyFramesForSwitchDefault;
							switchBack = true;
							//System.out.println("FUCK SAKE");
						}
						else
						{
							
							//System.out.println("FUCK SAKE ELSE");
							//System.out.println("SO sad");
							gameBoard[FirstColSelcted][FirstRowSelcted] = SecondColorSelected;
							gameBoard[SecondColSelcted][SecondRowSelcted] = FirstColorSelected;
							switchHappening = false;
							counterForSwitch = howManyFramesForSwitchDefault;
							FirstColSelcted = -1;
							FirstRowSelcted = -1;
							SecondColSelcted = -1;
							SecondRowSelcted = -1;
							MovingValueForSwitchRow = 0;
							MovingValueForSwitchCol = 0;
							
						}
					}
				}
				else
				{
					
					checkForThreeInARow(true, false);
					GravityCheck();					
				}
				counter++;
				repaint();
				canMove();
			}
		};
		time.scheduleAtFixedRate(task, 1, 10);
		//Game Loop For Change end
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Color tempColor;
		g.clearRect(0, 0, WIDTH, HEIGHT);
	    //background
//		try {
//			imageBackground = ImageIO.read(new File("skyBackground.jpg"));
//			g.drawImage(imageBackground, 0, 0, WIDTH, HEIGHT, null);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//background
		//For Animation Switch
		if(switchHappening)
		{
			//image = colorPicker(FirstColorSelected);
			g.setColor(colorPick(FirstColorSelected));
			g.fillRect(offSet + (FirstColSelcted * (WIDTH - offSet) / 8) + MovingValueForSwitchRow, FirstRowSelcted * (HEIGHT / 8) + MovingValueForSwitchCol, (WIDTH - offSet) /8, HEIGHT/8);
			//g.drawImage(image, offSet + (FirstColSelcted * (WIDTH - offSet) / 8) + MovingValueForSwitchRow, FirstRowSelcted * (HEIGHT / 8) + MovingValueForSwitchCol, (WIDTH - offSet) /8, HEIGHT/8, null);
			//image = colorPicker(SecondColorSelected);
			g.setColor(colorPick(SecondColorSelected));
			g.fillRect(offSet + (SecondColSelcted * (WIDTH - offSet) / 8) + (-1 * MovingValueForSwitchRow), SecondRowSelcted * (HEIGHT / 8) + (-1 * MovingValueForSwitchCol), (WIDTH - offSet) /8, HEIGHT/8);
			//g.drawImage(image, offSet + (SecondColSelcted * (WIDTH - offSet) / 8) + (-1 * MovingValueForSwitchRow), SecondRowSelcted * (HEIGHT / 8) + (-1 * MovingValueForSwitchCol), (WIDTH - offSet) /8, HEIGHT/8, null);
//			g.setColor(Color.GREEN);
//			g.fillRect(offSet + (FirstColSelcted * (WIDTH - offSet) / 8) + MovingValueForSwitchRow, FirstRowSelcted * (HEIGHT / 8) + MovingValueForSwitchCol, (WIDTH - offSet) /8, HEIGHT/8);
//			g.setColor(Color.BLACK);
//			g.fillRect(offSet + (SecondColSelcted * (WIDTH - offSet) / 8) + (-1 * MovingValueForSwitchRow), SecondRowSelcted * (HEIGHT / 8) + (-1 * MovingValueForSwitchCol), (WIDTH - offSet) /8, HEIGHT/8);
			for(int row = 0;row < 8;row++)
			{
				for(int col = 0;col < 8;col++)
				{
					if(switchHappening && (FirstRowSelcted == row && FirstColSelcted == col) || (SecondRowSelcted == row && SecondColSelcted == col) )
					{
						
					}
					else
					{
						//image = colorPicker(gameBoard[col][row]);
						g.setColor(colorPick(gameBoard[col][row]));
						g.fillRect(offSet + (col * (WIDTH - offSet) / 8), row * (HEIGHT / 8), widthOfSquare, heightOfSquare);
						//g.drawImage(image, offSet + (col * (WIDTH - offSet) / 8), row * (HEIGHT / 8), widthOfSquare, heightOfSquare, null);
					}
				}
			}
			//spliting lines
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
		}
		else
		{
			//draws squares
			for(int row = 0;row < 8;row++)
			{
				for(int col = 0;col < 8;col++)
				{
						//image = colorPicker(gameBoard[col][row]);
						g.setColor(colorPick(gameBoard[col][row]));
						g.fillRect(offSet + (col * (WIDTH - offSet) / 8), row * (HEIGHT / 8), widthOfSquare, heightOfSquare);
						//g.drawImage(image, offSet + (col * (WIDTH - offSet) / 8), row * (HEIGHT / 8), widthOfSquare, heightOfSquare, null);
				}
			}
			//Text Print
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
			//Text Print End
			
			//print offset line
			g.setColor(Color.black);
			g.drawRect(HEIGHT/20, HEIGHT/20, WIDTH/4 - ((HEIGHT/20) * 2), HEIGHT/10);
			//print offset line end
			
			//spliting lines
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
			//splititing line end
			
			//death line
			g.drawLine(offSet, 0, offSet, HEIGHT);
			g.setColor(Color.BLACK);
			int timeLeftToInt = (int)((timeLeft/100) * (HEIGHT/2));
			g.fillRect(offSet/3, ((HEIGHT/2) - timeLeftToInt) + (HEIGHT/5), offSet/4, timeLeftToInt);
			//death line end
			}
	}
	private class MyMouseAdapter extends MouseAdapter {
	    @Override
	    public void mousePressed(MouseEvent e) 
	    {
	    	if(!thingsFalling && !switchHappening)
	    	{
	    	 System.out.println("HELLO");
	    	 int x = e.getXOnScreen() - getLocationOnScreen().x;
			 int y = e.getYOnScreen() - getLocationOnScreen().y;
			 //System.out.println("x: " + x + " y: " + y);
			 boolean forBreak = false;
			 if(x > offSet && y < WIDTH)
			 {
				 int tempForCol = -1;
				 int recRow = y / (HEIGHT / 8);
				 int recCol = (x - offSet) / (WIDTH / 8);
				 //System.out.println("REC COL" + recCol);
				 if(!someThingSlected)
				 {
					 //System.out.println("FIRST");
					 FirstRowSelcted = recRow;
				 }
				 else
				 {
					 //System.out.println("SECOND");
					 SecondRowSelcted = recRow;
				 }
				 //FirstrowSelcted = recRow;
				 for(int col = 0;col < 8; col++)
				 {
					 if(x >= ((col * widthOfSquare) + offSet) && x <= (col * ((WIDTH - offSet) / 8) + offSet) + widthOfSquare)
					 {
						//System.out.println(col + " COL");
						tempForCol = col;
						System.out.println(recCol + "Col");
						//System.out.println();
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
				 //System.out.println("First Col " + FirstColSelcted + "First Row" + FirstRowSelcted);
				 //System.out.println("First Col " + SecondColSelcted + "First Row" + SecondRowSelcted);
			 }
	    	}
	    }
	}
	public void Switch()
	{
		//System.out.println("Switch runs");
			
			if(((FirstColSelcted + 1 == SecondColSelcted || FirstColSelcted - 1 == SecondColSelcted) && FirstRowSelcted == SecondRowSelcted) 
			|| ((FirstRowSelcted + 1 == SecondRowSelcted || FirstRowSelcted - 1 == SecondRowSelcted) && FirstColSelcted == SecondColSelcted))
			{
				System.out.println("Switch Running");
				//System.out.println("SCol: " + SecondColSelcted + " SRow: " + SecondRowSelcted + " Color For Second: " + gameBoard[FirstColSelcted][FirstRowSelcted]);
				//System.out.println("SWITCH " + gameBoard[FirstColSelcted][FirstRowSelcted] + " TO " + gameBoard[SecondRowSelcted][SecondColSelcted]);
				int tempForColorSwitch = 0;
				FirstColorSelected = gameBoard[FirstColSelcted][FirstRowSelcted];
				SecondColorSelected = gameBoard[SecondColSelcted][SecondRowSelcted];
				//tempForColorSwitch = gameBoard[FirstColSelcted][FirstRowSelcted];
				//gameBoard[FirstRowSelcted][FirstColSelcted] = gameBoard[SecondColSelcted][SecondRowSelcted];
				//gameBoard[SecondRowSelcted][SecondColSelcted] = tempForColorSwitch;
				System.out.println("First Col " + FirstColSelcted + "First Row " + FirstRowSelcted);
				gameBoard[FirstColSelcted][FirstRowSelcted] = 7;
				gameBoard[SecondColSelcted][SecondRowSelcted] = 7;
				switchHappening = true; 
				//System.out.println("Allowed Switch");
				//checkForThreeInARow();
				switchBack = false;
			}
	}
	public boolean checkForThreeInARow(boolean deleteIfTrue, boolean justChecking)
	{
		//System.out.println("Check for three");
		boolean checkForThreeInARowBool = false;
		for(int row = 0;row < 8;row++)
		{
			for(int col = 0;col < 8;col++)
			{
				try
				{
					//check up
					if(gameBoard[col][row] == gameBoard[col - 1][row])
					{
						if(gameBoard[col][row] == gameBoard[col - 2][row])
						{
							//System.out.println("HENRY");
							if(justChecking)
							{
								checkForThreeInARowBool = true;
							}
							else
							{
								if(deleteIfTrue)
								{
									System.out.println("Found Three In A Row");
									gameBoard[col][row] = 7;
									gameBoard[col - 1][row] = 7;
									gameBoard[col - 2][row] = 7;
									score += 10;
									if(gameBoard[col][row] == gameBoard[col - 3][row])
									{
											gameBoard[col - 3][row] = 7;
											score += 10;
									}
									if(gameBoard[col][row] == gameBoard[col - 4][row])
									{
										gameBoard[col - 4][row] = 7;
										score += 10;
									}
									//RowsToFall[0] = col;
									//RowsToFall[1] = col - 1;
									//RowsToFall[2] = col - 2;
									//GravityCheck();
								}
								else
								{
									System.out.println("DELETE");
									if(r.nextInt(1) == 0)
									{
										gameBoard[col - 1][row] = r.nextInt(6);
									}
									else
									{
										gameBoard[col][row] = r.nextInt(6);
									}
								}
							}
							
							}
						}
					}
				catch(Exception NullPointerException)
				{
					//System.out.println("Null Pinter Expection");
				}
				try
				{
					if(gameBoard[col][row] == gameBoard[col + 1][row])
					{
						if(gameBoard[col][row] == gameBoard[col + 2][row])
						{
							//System.out.println("HENRY");
							if(justChecking)
							{
								checkForThreeInARowBool = true;
							}
							else
							{
								if(deleteIfTrue)
								{
									System.out.println("Found Three In A Row");
									gameBoard[col][row] = 7;
									gameBoard[col + 1][row] = 7;
									gameBoard[col + 2][row] = 7;
									
									if(gameBoard[col][row] == gameBoard[col + 3][row])
									{
										gameBoard[col + 3][row] = 7;
									}
									if(gameBoard[col][row] == gameBoard[col + 4][row])
									{
										if(deleteIfTrue && !justChecking)
										{
											gameBoard[col + 4][row] = 7;
										}
									}
								}
								else
								{
									System.out.println("DELETE");
									if(r.nextInt(1) == 0)
									{
										gameBoard[col + 1][row] = r.nextInt(6);
									}
									else
									{
										gameBoard[col][row] = r.nextInt(6);
									}
								}
							}
						}
					}
					//System.out.println("HENRY");
					
				}
				catch(Exception NullPointerException)
				{
					//System.out.println("Null Pinter Expection");
				}
				try
				{
					if(gameBoard[col][row] == gameBoard[col][row + 1])
					{
						if(gameBoard[col][row] == gameBoard[col][row + 2])
						{
							//System.out.println("HENRY");
							if(justChecking)
							{
								checkForThreeInARowBool = true;
							}
							else
							{
								if(deleteIfTrue)
								{
									System.out.println("Found Three In A Row");
									gameBoard[col][row] = 7;
									gameBoard[col][row + 1] = 7;
									gameBoard[col][row + 2] = 7;
									score += 10;
									if(gameBoard[col][row] == gameBoard[col][row + 3])
									{
											gameBoard[col][row + 3] = 7;
											score += 10;
									}
									if(gameBoard[col][row] == gameBoard[col][row + 4])
									{
										gameBoard[col][row + 4] = 7;
										score += 10;
									}
								}
								else
								{
									System.out.println("DELETE");
									if(r.nextInt(1) == 0)
									{
										gameBoard[col][row + 1] = r.nextInt(6);
									}
									else
									{
										gameBoard[col][row] = r.nextInt(6);
									}
								}
							}
						}
					}
				}
				//System.out.println("HENRY");
				catch(Exception NullPointerException)
				{
					//System.out.println("Null Pinter Expection");
				}
				try
				{
					if(gameBoard[col][row] == gameBoard[col][row - 1])
					{
						if(gameBoard[col][row] == gameBoard[col][row - 2])
						{
							//System.out.println("HENRY");
							if(justChecking)
							{
								checkForThreeInARowBool = true;
							}
							else
							{
								if(deleteIfTrue)
								{
									System.out.println("Found Three In A Row");
									gameBoard[col][row] = 7;
									gameBoard[col][row - 1] = 7;
									gameBoard[col][row - 2] = 7;
									score += 10;
									if(gameBoard[col][row] == gameBoard[col][row - 3])
									{
										gameBoard[col][row - 3] = 7;
										if(gameBoard[col][row] == gameBoard[col][row - 4])
										{
											gameBoard[col][row - 4] = 7;
										}
									}
								}
								else
								{
									System.out.println("DELETE");
									if(r.nextInt(1) == 0)
									{
										gameBoard[col][row - 1] = r.nextInt(6);
									}
									else
									{
										gameBoard[col][row] = r.nextInt(6);
									}
								}
							}
						}
					}
					//System.out.println("HENRY");
				
				}
				catch(Exception NullPointerException)
				{
					//System.out.println("Null Pinter Expection");
				}
			}
		}
		return checkForThreeInARowBool;
	}
	
	public void GravityCheck()
	{
		if(!switchHappening)
		{
			//System.out.println("HELLO");
			Random r = new Random();
			for(int y = 0;y < 8;y++)
			{
				//System.out.println("INFINTY");
				for(int x = 0;x<8;x++)
				{
					if(gameBoard[x][0] == 7)
					{
						gameBoard[x][0] = r.nextInt(5);
						//boolTemp = false;
					}
				}
				for(int row = 0;row < 8;row++)
				{
					for(int col = 0;col < 8;col++)
					{
						if(gameBoard[col][row] == 7)
						{
							//System.out.println("COL: " + col + " ROW: " + row);
							gameBoard[col][row] = gameBoard[col][row - 1];
							gameBoard[col][row - 1] = 7;
							//RowsToFall[counterForRowsToPick] = row;
							//ColToFall[counterForRowsToPick] = col;
							//counterForRowsToPick++;
						}
					}
				}
			}
			//checkForThreeInARow(true, false);
		}
		else
		{
			//System.out.println("SWITCH RUNNING");
		}
	}
	
	public void colorPicker1(int color)
	{
//		//Color returnValue = Color.WHITE;
//		try {
//			returnImage = ImageIO.read(new File("download.jpg"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		switch(color)
//		{
//		case 0:
//			try {
//				returnImage = ImageIO.read(new File("bejeweled_red_gem_by_ldinos_dc7zw40-pre.png"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//		case 1:
//			try {
//				returnImage = ImageIO.read(new File("bejeweled_green_gem_by_ldinos_dc2fr2h-pre.png"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//		case 2:
//			try {
//				returnImage = ImageIO.read(new File("bejeweled_blue_gem_by_ldinos_dc2j9bc-pre.png"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//		case 3:
//			try {
//				returnImage = ImageIO.read(new File("bejeweled_yellow_gem_by_ldinos_dc7nv99-pre.png"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//		case 4:
//			try {
//				returnImage = ImageIO.read(new File("bejeweled_purple_gem_by_ldinos_dc9v7iu-pre.png"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//		case 5:
//			try {
//				returnImage = ImageIO.read(new File("bejeweled_orange_gem_by_ldinos_dc2fouk-pre.png"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//		case 7:
//			try {
//				returnImage = ImageIO.read(new File("0x0000007a-screenshot.jpg"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//		}
//		return returnImage;
	}
	
	public Color colorPick(int ColorInt)
	{
		Color returnValue = Color.WHITE;
		switch(ColorInt)
		{
		case 0:
			returnValue = Color.GREEN;
			break;
		case 1:
			returnValue = Color.RED;
			break;
		case 2:
			returnValue = Color.MAGENTA;
			break;
		case 3:
			returnValue = Color.CYAN;
			break;
		case 4:
			returnValue = Color.YELLOW;
			break;
		case 5:
			returnValue = Color.BLUE;
			break;
		}
		return returnValue;
	}
	
	public boolean checkIfGoodSwitch(int col1, int row1, int color)
	{
		boolean returnValue = false;
		try {
			//System.out.println("HI");
			if((gameBoard[col1 + 1][row1] == color && gameBoard[col1 + 2][row1] == color) || (gameBoard[col1 + 1][row1] == color && gameBoard[col1 - 1][row1] == color))
			{
				returnValue = true;
				System.out.println("Col + or Col +/-");
			}
		} catch(Exception NullPointerException)
		{
			//System.out.println("Null Pinter Expection");
		}
		try {
			System.out.println("HI");
			if(gameBoard[col1 - 1][row1] == color && gameBoard[col1 - 2][row1] == color)
			{
				returnValue = true;
				System.out.println("col-");
			}
		}catch(Exception NullPointerException)
		{
			//System.out.println("Null Pinter Expection");
		}
		try {
			System.out.println("HI");
			if((gameBoard[col1][row1 + 1] == color && gameBoard[col1][row1  + 2] == color) || (gameBoard[col1][row1 + 1] == color && gameBoard[col1][row1 - 1] == color))
			{
				returnValue = true;
				System.out.println("row+ or row +/-");
			}
		} catch(Exception NullPointerException)
		{
			//System.out.println("Null Pinter Expection");
		}
		try {
			System.out.println("HI");
			if(gameBoard[col1][row1 - 1] == color && gameBoard[col1][row1  - 2] == color)
			{
				returnValue = true;
				System.out.println("Row-");
			}
		} catch(Exception NullPointerException)
		{
			//System.out.println("Null Pinter Expection");
		}
		return returnValue;
	}
	public void playMusic()
	{
		try
		{
			File music = new File("RapForBej.wav");
			if(music.exists())
			{
				AudioInputStream audio = AudioSystem.getAudioInputStream(music);
				clip = AudioSystem.getClip();
				clip.open(audio);
				clip.start();
				clip.loop(clip.LOOP_CONTINUOUSLY);
				
				System.out.println("HELLO");
			}
			else
			{
				System.out.println("WHAT");
			}
		}
		catch(Exception e)
		{
			System.out.println("ERROR");
		}
	}

	public boolean canMove()
	{
		boolean noMovesCol = false;
		boolean noMovesRow = false;
		boolean returnValue = false;
		
		for(int col = 0;col < 8;col++)
		{
			for(int row = 0;row < 8;row++)
			{
				try
				{
					if(gameBoard[col][row + 1] != gameBoard[col][row - 1])
					{
						noMovesCol = true;
					}
				}
				catch(Exception NullPointerException)
				{
					//System.out.println("Null Pinter Expection");
				}
				try
				{
					if(gameBoard[col + 1][row] != gameBoard[col - 1][row])
					{
						noMovesRow = true;
					}
				}
				catch(Exception NullPointerException)
				{
					//System.out.println("Null Pinter Expection");
				}
			}
		}
		if(noMovesCol && noMovesRow)
		{
			returnValue = true;
		}
		return returnValue;
	}

}
