import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

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
	File booksTextFile = new File("Lib.txt");
	
	String addBookInput;
	public DisplayControler()
	{
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		LibFunct.readFile(booksTextFile);
		setFocusable(true);
		key = new Key();
		addKeyListener(key);
	}
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, WIDTH, HEIGHT);
		switch(buttonNum)
		{
			case 0:
				Font f = new Font("TimesRoman", Font.BOLD, 90);
				g.setFont(f);
				g.drawString("Library Of Jorris", 50, 100);
				g.setFont(new Font("TimesRoman", Font.BOLD,45));
				g.drawString("0 = Back To Menue", 50, 200);
				g.drawString("1 = Display Books In Librayer ", 50, 300);
				g.drawString("2 = Enter A New Book", 50, 400);
				g.drawString("3 = Remove A Book", 50, 500);
				break;
			case 1:
				yValue = 50;
				for(int x = 0;x<LibFunct.getArraySize();x++)
				{
					Font sf = new Font("TimesRoman", Font.BOLD, 25);
					g.setFont(sf);
					g.drawString(LibFunct.getBook(x).toString(),10,yValue);
					yValue+= 75;
				}
				break;
			case 2:
				UserInputBook UIB = new UserInputBook(LibFunct);
				buttonNum = 0;
				repaint();
				break;
			case 3:
				Search Se = new Search(LibFunct);
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
