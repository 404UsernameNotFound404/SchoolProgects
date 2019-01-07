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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.w3c.dom.css.Rect;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
 import javax.sound.sampled.Clip;

 
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
	
	int score = 0;
	
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
	
	
	
	public Screen()
	{
		//music
		playMusic();
		RowsToFall = new int[6];
		ColToFall = new int[6];
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
				int randomColorValue = r.nextInt(5);
				gameBoard[row][col] = randomColorValue;
			}
		}
		checkForThreeInARow(false, false);
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
					//System.out.println("YOU LOST YOU LOSER");
				}
				if(switchHappening)
				{
					repaint();
				}
				counter++;
				//System.out.println(counter);
				//repaint();
				checkForThreeInARow(true, false);
				GravityCheck();
			}
		};
		time.scheduleAtFixedRate(task, 1, 10);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Color tempColor;
		g.clearRect(0, 0, WIDTH, HEIGHT);
		try {
			imageBackground = ImageIO.read(new File("skyBackground.jpg"));
			g.drawImage(imageBackground, 0, 0, WIDTH, HEIGHT, null);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				image = colorPicker(FirstColorSelected);
				g.drawImage(image, offSet + (FirstColSelcted * (WIDTH - offSet) / 8) + MovingValueForSwitchRow, FirstRowSelcted * (HEIGHT / 8) + MovingValueForSwitchCol, (WIDTH - offSet) /8, HEIGHT/8, null);
				image = colorPicker(SecondColorSelected);
				g.drawImage(image, offSet + (SecondColSelcted * (WIDTH - offSet) / 8) + (-1 * MovingValueForSwitchRow), SecondRowSelcted * (HEIGHT / 8) + (-1 * MovingValueForSwitchCol), (WIDTH - offSet) /8, HEIGHT/8, null);
//				g.setColor(Color.GREEN);
//				g.fillRect(offSet + (FirstColSelcted * (WIDTH - offSet) / 8) + MovingValueForSwitchRow, FirstRowSelcted * (HEIGHT / 8) + MovingValueForSwitchCol, (WIDTH - offSet) /8, HEIGHT/8);
//				g.setColor(Color.BLACK);
//				g.fillRect(offSet + (SecondColSelcted * (WIDTH - offSet) / 8) + (-1 * MovingValueForSwitchRow), SecondRowSelcted * (HEIGHT / 8) + (-1 * MovingValueForSwitchCol), (WIDTH - offSet) /8, HEIGHT/8);
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
					
//					SecondColorSelected = gameBoard[FirstRowSelcted][FirstColSelcted];
//					FirstColorSelected = gameBoard[SecondRowSelcted][SecondColSelcted];
					//System.out.println("First Col " + FirstColSelcted + "First Row " + FirstRowSelcted);
					gameBoard[FirstColSelcted][FirstRowSelcted] = 7;
					gameBoard[SecondColSelcted][SecondRowSelcted] = 7;
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
			//draws squares
			for(int row = 0;row < 8;row++)
			{
				for(int col = 0;col < 8;col++)
				{
					if(switchHappening && (FirstRowSelcted == row && FirstColSelcted == col) || (SecondRowSelcted == row && SecondColSelcted == col) )
					{
						
					}
					else
					{
						image = colorPicker(gameBoard[col][row]);
						g.drawImage(image, offSet + (col * (WIDTH - offSet) / 8), row * (HEIGHT / 8), widthOfSquare, heightOfSquare, null);
					}
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
			//spliting lines
	//		for(int x = 0;x <= 8;x++)
	//		{
	//			g.setColor(Color.BLACK);
	//			g.drawLine(offSet + (x * (WIDTH - offSet) / 8), 0, offSet + (x * (WIDTH - offSet) / 8), HEIGHT);
	//			//System.out.println(offSet + (x * 100));
	//		}
	//		for(int x = 0;x <= 8;x++)
	//		{
	//			g.drawLine(offSet, x * (HEIGHT / 8), WIDTH, x * (HEIGHT / 8));
	//		}
			//death line ----------------
			g.drawLine(offSet, 0, offSet, HEIGHT);
			g.setColor(Color.BLACK);
			int timeLeftToInt = (int)((timeLeft/100) * (HEIGHT/2));
			g.fillRect(HEIGHT/5, ((HEIGHT/2) - timeLeftToInt) + (HEIGHT/5), offSet/4, timeLeftToInt);
			//death line -------------------
	}
	private class MyMouseAdapter extends MouseAdapter {

	    @Override
	    public void mousePressed(MouseEvent e) 
	    {
	    	if(!thingsFalling && !switchHappening)
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
				 //System.out.println(recRow + " ROW");
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
					 //System.out.println(row * widthOfSquare);
					 //System.out.println(( x > (row * widthOfSquare)) + "&&" + (x < (row * ((WIDTH - offSet) / 8)) + widthOfSquare));
					 //System.out.println(row * widthOfSquare + "&&" + ((row * ((WIDTH - offSet) / 8)) + widthOfSquare));
					 if(x >= ((col * widthOfSquare) + offSet) && x <= (col * ((WIDTH - offSet) / 8) + offSet) + widthOfSquare)
					 {
						//System.out.println(col + " COL");
						tempForCol = col;
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
		//System.out.println("Switch runs");
		if(((FirstColSelcted + 1 == SecondColSelcted || FirstColSelcted - 1 == SecondColSelcted) && FirstRowSelcted == SecondRowSelcted) || ((FirstRowSelcted + 1 == SecondRowSelcted || FirstRowSelcted - 1 == SecondRowSelcted) && FirstColSelcted == SecondColSelcted))
		{
			System.out.println("SCol: " + SecondColSelcted + " SRow: " + SecondRowSelcted + " Color For Second: " + gameBoard[FirstColSelcted][FirstRowSelcted]);
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
									repaint();
									try
									{
										Thread.sleep(100);
									}
									catch(Exception e)
									{
										
									}
									//RowsToFall[0] = col;
									//RowsToFall[1] = col - 1;
									//RowsToFall[2] = col - 2;
									score += 10;
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
					//check down
					if(gameBoard[col][row] == gameBoard[col + 1][row])
					{
						if(gameBoard[col][row] == gameBoard[col + 2][row])
						{
							if(justChecking)
							{
								checkForThreeInARowBool = true;
							}
							else
							{
								//System.out.println("HENRY");
								if(deleteIfTrue)
								{
									System.out.println("Found Three In A Row");
									gameBoard[col][row] = 7;
									gameBoard[col + 1][row] = 7;
									gameBoard[col + 2][row] = 7;
									score += 10;
									repaint();
									try
									{
										Thread.sleep(100);
									}
									catch(Exception e)
									{
										
									}
									//GravityCheck();
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
				}
				catch(Exception NullPointerException)
				{
					//System.out.println("Null Pinter Expection");
				}
				try
				{
					//check right
					if(gameBoard[col][row] == gameBoard[col][row + 1])
					{
						if(gameBoard[col][row] == gameBoard[col][row + 2])
						{
							if(justChecking)
							{
								checkForThreeInARowBool = true;
							}
							else
							{
								//System.out.println("HENRY");
								if(deleteIfTrue)
								{
									System.out.println("Found Three In A Row");
									gameBoard[col][row] = 7;
									gameBoard[col][row + 1] = 7;
									gameBoard[col][row + 2] = 7;
									score += 10;
									repaint();
									try
									{
										Thread.sleep(100);
									}
									catch(Exception e)
									{
										
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
				catch(Exception NullPointerException)
				{
					//System.out.println("Null Pinter Expection");
				}
				try
				{
					//check left 
					if(gameBoard[col][row] == gameBoard[col][row - 1])
					{
						if(gameBoard[col][row] == gameBoard[col][row - 2])
						{
							if(justChecking)
							{
								checkForThreeInARowBool = true;
							}
							else
							{
								//System.out.println("HENRY");
								if(deleteIfTrue)
								{
									System.out.println("Found Three In A Row");
									gameBoard[col][row] = 7;
									gameBoard[col][row - 1] = 7;
									gameBoard[col][row - 2] = 7;
									score += 10;
									repaint();
									try
									{
										Thread.sleep(100);
									}
									catch(Exception e)
									{
										
									}
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
			}
		}
		GravityCheck();
		return checkForThreeInARowBool;
	}
	public void GravityCheck()
	{
		if(!switchHappening)
		{
			//System.out.println("HELLO");
			boolean boolTemp = true;
			boolean foundFall = false;
			Random r = new Random();
			
			int counterForRowsToPick = 0;
			
			for(int y = 0;y < 8;y++)
			{
				//System.out.println("INFINTY");
				for(int x = 0;x<8;x++)
				{
					if(gameBoard[0][x] == 7)
					{
						gameBoard[0][x] = r.nextInt(5);
						//boolTemp = false;
					}
				}
				for(int row = 0;row < 8;row++)
				{
					for(int col = 0;col < 8;col++)
					{
						if(gameBoard[col][row] == 7)
						{
							System.out.println("COL: " + col + " ROW: " + row);
							gameBoard[col][row] = gameBoard[col - 1][row];
							gameBoard[col - 1][row] = 7;
							//RowsToFall[counterForRowsToPick] = row;
							//ColToFall[counterForRowsToPick] = col;
							//counterForRowsToPick++;
						}
					}
				}
			}
		}
	}
	public BufferedImage colorPicker(int color)
	{
		//Color returnValue = Color.WHITE;
		try {
			returnImage = ImageIO.read(new File("download.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		switch(color)
		{
		case 0:
			try {
				returnImage = ImageIO.read(new File("bejeweled_red_gem_by_ldinos_dc7zw40-pre.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1:
			try {
				returnImage = ImageIO.read(new File("bejeweled_green_gem_by_ldinos_dc2fr2h-pre.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				returnImage = ImageIO.read(new File("bejeweled_blue_gem_by_ldinos_dc2j9bc-pre.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				returnImage = ImageIO.read(new File("bejeweled_yellow_gem_by_ldinos_dc7nv99-pre.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			try {
				returnImage = ImageIO.read(new File("bejeweled_purple_gem_by_ldinos_dc9v7iu-pre.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			try {
				returnImage = ImageIO.read(new File("bejeweled_orange_gem_by_ldinos_dc2fouk-pre.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 7:
			try {
				returnImage = ImageIO.read(new File("0x0000007a-screenshot.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		return returnImage;
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
			File music = new File("BlackMirrorSong.wav");
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
}
