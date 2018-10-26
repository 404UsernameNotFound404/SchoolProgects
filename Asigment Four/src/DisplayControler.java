import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisplayControler extends JPanel
{
	int WIDTH = 800;
	int HEIGHT = 800;
	int buttonNum = 0;
	int yValue = 100;
	private Key key;
	LibraryFunct LibFunct = new LibraryFunct();
	File booksTextFile = new File("Lib.txt");
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
				g.drawString("Librayer Of Jorris", 50, 200);
				break;
			case 1:
				for(int x = 0;x<LibFunct.getArraySize();x++)
				{
					Font sf = new Font("TimesRoman", Font.BOLD, 25);
					g.setFont(sf);
					g.drawString(LibFunct.getBook(x).toString(),0,yValue);
					yValue+= 100;
				}
				break;
			case 2:
				/*
				 JFrame InputFrame = new JFrame("Input Frame");
				InputFrame.setVisible(true);
				InputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				InputFrame.setLayout(new GridLayout(1,1,0,0));
				InputFrame.setLocationRelativeTo(null);
				InputFrame.setSize(400, 200);
				JPanel JP = new JPanel();
				JTextField TF = new JTextField();
				TF.setBounds(50,100, 200,30);  
				JP.add(TF);
				InputFrame.add(JP);
				*/
				 JFrame frame = new JFrame("TextField Example");  
				 JTextField t1,t2;  
				 t1=new JTextField("Welcome to Javatpoint.");  
				 t1.setBounds(50,100, 200,30);  
				 frame.setSize(400,400);  
				 frame.add(t1);
				 frame.setLayout(null);  
				 frame.setVisible(true);  
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
			if(key == KeyEvent.VK_1)
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
