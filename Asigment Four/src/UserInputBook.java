/*
 * Name: Henry Morris
 * Date: 11/2/2018
 * 
 * Constructors: 
 * UserInputBook(LibraryFunct LibFunct)
 * -This Constructor creates the frame and adds all of the JTextFields it also sets up the action listeners for the JTextField
 * Methods:
 * Getters and Setters:
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserInputBook extends JPanel
{
	String addBookInput;
	public UserInputBook(LibraryFunct LibFunct)
	{
		 JFrame frame = new JFrame("INPUT");  
		 JButton button = new JButton("Enter");
		 JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9; 
		 t1=new JTextField("Last Name Of Author"); 
		 t2=new JTextField("First Name Of Author"); 
		 t3=new JTextField("Title");
		 t4=new JTextField("Format");
		 t5=new JTextField("Publisher"); 
		 t6=new JTextField("Year(int)"); 
		 t7=new JTextField("Language"); 
		 t8=new JTextField("ISBN #(long)"); 
		 t9=new JTextField("Cost(float)"); 
		 t1.setBounds(10,10, 570,30);  
		 t2.setBounds(10,50, 570,30);  
		 t3.setBounds(10,90, 570,30);  
		 t4.setBounds(10,130, 570,30);  
		 t5.setBounds(10,170, 570,30);  
		 t6.setBounds(10,210, 570,30);  
		 t7.setBounds(10,250, 570,30);  
		 t8.setBounds(10,290, 570,30);  
		 t9.setBounds(10,330, 570,30);
		 button.setBounds(10,380,100,30);
		 frame.setSize(600,600);  
		 frame.add(t1);
		 frame.add(t2);
		 frame.add(t3);
		 frame.add(t4);
		 frame.add(t5);
		 frame.add(t6);
		 frame.add(t7);
		 frame.add(t8);
		 frame.add(t9);
		 frame.add(button);
		 button.addActionListener(new ActionListener()
				 {
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						addBookInput = t1.getText();
						addBookInput = addBookInput +", " + t2.getText();
						addBookInput = addBookInput +", " + t3.getText();
						addBookInput = addBookInput +", " + t4.getText();
						addBookInput = addBookInput +", " + t5.getText();
						addBookInput = addBookInput +", " + t6.getText();
						addBookInput = addBookInput +", " + t7.getText();
						addBookInput = addBookInput +", " + t8.getText();
						addBookInput = addBookInput +", " + t9.getText();
						if(LibFunct.checkInfo(addBookInput))
						{
							LibFunct.AddBook(addBookInput);
							
						}else
						{
							ErrorFrame errorFrame = new ErrorFrame();
						}
						
						frame.setVisible(false);
						frame.dispose();
						System.out.println(addBookInput);
					}
				 }
				 );
		 frame.setLayout(null);
		 frame.setVisible(true);  
	}

}
