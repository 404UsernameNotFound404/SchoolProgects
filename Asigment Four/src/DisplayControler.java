/*
 * Name: Henry Morris

 * Date: 11/2/2018
 * 
 * Constructors: 
 * DisplayControler()
 * 
 * Methods:
 * void paint(Graphics g)
 * -built in method for JPanel
 * -more explanation
 * Other Classes:
 * Key implements KeyListener
 * -This is apart of KeyListner library and allows for video game like input from java
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisplayControler extends JPanel
{
	int WIDTH = 1400;
	int HEIGHT = 700;
	int buttonNum = 0;
	int yValue;
	private Key key;
	LibraryFunct LibFunct = new LibraryFunct();
	
	JFrame frame = new JFrame();
	String addBookInput;
	
	JButton bubbleSort;
	public DisplayControler()
	{
		JFrame frame = new JFrame("Library Of Jorris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Library Of Jorris");
		frame.setResizable(false);
		frame.setSize(WIDTH, HEIGHT);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		key = new Key();
		addKeyListener(key);
		this.frame = frame;
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.clearRect(0, 0, WIDTH, HEIGHT);
		//ImageIcon img = new ImageIcon("blackImage.jpg");
		//img.paintIcon(this, g, 0, 0);
		switch(buttonNum)
		{
			case 0:				
				Font f = new Font("TimesRoman", Font.BOLD, 90);
				g.setFont(f);
				g.setColor(Color.BLACK);
				g.drawString("Library Of Jorris", 50, 100);
				g.setFont(new Font("TimesRoman", Font.BOLD,45));
				g.drawString("0 = Back To Menu", 50, 200);
				g.drawString("1 = Display Books In Library ", 50, 300);
				g.drawString("2 = Enter A New Book", 50, 400);
				g.drawString("3 = Remove A Book", 50, 500);
				g.drawString("4 = Enter new File", 50, 600);
				break;
			case 1:
				yValue = 50;
				Font sf = new Font("TimesRoman", Font.BOLD, 20);
				g.setFont(sf);
				g.setColor(Color.BLACK);
				for(int x = 0;x<LibFunct.getArraySize();x++)
				{
					System.out.println(LibFunct.getBook(x).toString());
					g.drawString(LibFunct.getBook(x).toString(),10,yValue);
					yValue+= 50;
				}
				g.drawLine(0, HEIGHT - 115, WIDTH, HEIGHT - 115);
				g.drawString("A = Sort By Title", 20, HEIGHT - 75);
				g.drawString("B = Sort By Cost", 20, HEIGHT - 50);
				g.drawString("C = Sort By Last Name", 20, HEIGHT - 25);
				break;
			case 2:
				UserInputBook UIB = new UserInputBook(LibFunct);
				buttonNum = 0;
				repaint();
				break;
			case 3:
				RemoveBook Se = new RemoveBook(LibFunct.bookArrL);
				buttonNum = 0;
				repaint();
				break;
			case 4:
				UseFile fileInput = new UseFile(LibFunct);
				buttonNum = 0;
				repaint();
				break;
		}
	}
	private class Key implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent e) 
		{
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_0)
			{
				System.out.println("0");
				buttonNum = 0;
				repaint();
			}
			if(key == KeyEvent.VK_1 & buttonNum != 1)
			{
				System.out.println("1");
				buttonNum = 1;
				repaint();
			}
			if(key == KeyEvent.VK_2)
			{
				System.out.println("2");
				buttonNum = 2;
				repaint();
			}
			if(key == KeyEvent.VK_3)
			{
				System.out.println("2");
				buttonNum = 3;
				repaint();
			}
			if(key == KeyEvent.VK_4)
			{
				System.out.println("hiting 4");
				buttonNum = 4;
				repaint();
			}
			if(key == KeyEvent.VK_A & buttonNum == 1) 
			{
				LibFunct.bubbleSortTitle();
				repaint();
			}
			if(key == KeyEvent.VK_B & buttonNum == 1) 
			{
				LibFunct.selectionSortCost();
				repaint();
			}
			if(key == KeyEvent.VK_C & buttonNum == 1) 
			{
				LibFunct.reSortByLastName();
				repaint();
			}
			
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}
