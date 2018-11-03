/*
 * Name: Henry Morris
 * Date: 11/2/2018
 * 
 * Constructors: 
 * Methods:
 * Getters and Setters:
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UseFile extends JPanel
{
	int WIDTH = 350,HEIGHT = 150;
	public UseFile(LibraryFunct LibFunct)
	{
		System.out.println("UseFile");
		JFrame frame = new JFrame("FileInput");
		JLabel label = new JLabel();
		JTextField inputField = new JTextField();
		inputField.setBounds(50,50,200,30);
		label.setBounds(50,0,400,50);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.add(inputField);
		frame.add(label);
		inputField.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						String fileName = inputField.getText();
						File inputFile = new File(fileName);
						if(!inputFile.exists())
						{
							System.out.println("Error frame");
							ErrorFrame errFrame = new ErrorFrame();
							errFrame.show();
						}else
						{
							LibFunct.readFile(inputFile);
						}
			
						frame.setVisible(false);
						frame.dispose();
					}
				});
		label.setFont(new Font("TimesRoman",Font.BOLD,20));
		label.setText("Type Text File Name");
	}
	public void paint(Graphics g)
	{
		System.out.println("pain");
		g.setFont(new Font("TimeRoman",Font.BOLD,20));
		g.setColor(Color.BLACK);
		g.drawString("Enter File Name E.X:", 50, 0);
	}

}
