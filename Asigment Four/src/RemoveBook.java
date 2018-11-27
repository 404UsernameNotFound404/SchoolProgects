/*
 * Name: Henry Morris

 * Date: 11/2/2018
 * 
 * Constructors: 
 * RemoveBook(LibrrayFunct LibFunct)
 * -This method takes in the bookArrL array list from LibraryFunct Class
 * -It then creates JFrame with 3 JTextFields and those text fields input can delete things further comments for deleting in code
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemoveBook extends JPanel
{
	int WidthF = 400,HeightF = 600;
	int WidthB = 200, HeightB = 600;
	boolean choseSearch = false;
	public RemoveBook(ArrayList<Book> bookArrL)
	{
		JFrame frame = new JFrame("Serach");
		JButton serachByName = new JButton("Search By Authors Last Name");
		JButton serachByIndex = new JButton("Search By Index");
		JButton serachByTitle = new JButton("Search By Title");
		serachByName.setBounds(75,50,250,30);
		serachByIndex.setBounds(75,250,250,30);
		serachByTitle.setBounds(75,450,250,30);
		frame.setSize(WidthF, HeightF);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(serachByName);
		frame.add(serachByIndex);
		frame.add(serachByTitle);
		serachByName.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						if(!choseSearch) //does not allow two JTextInput fields to open at one time
						{
							JTextField JTF = new JTextField("Serach By Authors Last Name");
							JTF.setBounds(75,90,200,30);
							JTF.addActionListener(new ActionListener()
									{
										@Override
										public void actionPerformed(ActionEvent e) 
										{
											String nameInput = JTF.getText();
											boolean foundLname = false;
											Iterator<Book> ILastName = bookArrL.iterator(); //creates iterator for bookArrL
											while(ILastName.hasNext()) //while loop that goes through whole bookArrL array list
											{
												Book checkLastName = ILastName.next(); //gets a book from array
												if(nameInput.compareTo(checkLastName.authorLName) == 0) //checks if book has same author name as user input 
												{
													bookArrL.remove(checkLastName); //removes book with same last name as input
													frame.setVisible(false);
													frame.dispose();
													foundLname = true;
													break;
												}
											}
											if(!foundLname)
											{
												ErrorFrame errorFrame = new ErrorFrame(); //if program does not find a book with the same last name as input creates error screen
												frame.setVisible(false);
												frame.dispose();
											}
										}
									}
									);
							frame.add(JTF);
							System.out.println("Name");
							choseSearch = true;
						}
					}
				}
				);
		serachByIndex.addActionListener(new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
					if(!choseSearch) //does not allow two JTextInput fields to open at one time
					{
						JTextField JTF = new JTextField("Serach By Index");
						JTF.setBounds(75,290,200,30);
						JTF.addActionListener(new ActionListener()
								{
									@Override
									public void actionPerformed(ActionEvent e) 
									{
										try
										{
											int remove = Integer.parseInt(JTF.getText()); //parse's JTF text to int
											bookArrL.remove(remove); //removes a book from array at user input 
											frame.setVisible(false); //makes frame not visible
											frame.dispose(); //closes frame
										}
										catch(Exception e1)
										{
											ErrorFrame errorFrame = new ErrorFrame(); //if invalid input error frame shows up 
											frame.setVisible(false); //closes frame
											frame.dispose();// closes frame
										}
										
									}
								}
								);
						frame.add(JTF);
						System.out.println("Index");
						choseSearch = true;
					}
			}
				}
		);
		serachByTitle.addActionListener(new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
					if(!choseSearch) //does not allow two JTextInput fields to open at one time
					{
						JTextField JTF = new JTextField("Serach By Title");
						JTF.setBounds(75,490,200,30);
						JTF.addActionListener(new ActionListener()
								{
									@Override
									public void actionPerformed(ActionEvent e) 
									{
										String inputTitle = JTF.getText();
										boolean foundTitle = false;
										Iterator<Book> Ibook = bookArrL.iterator(); 
										while(Ibook.hasNext()) //while loop that goes through whole bookArrL
										{
											Book check = Ibook.next(); //gets book from array
											if(inputTitle.compareTo(check.title) == 0) //checks if input is same as title from each book
											{
												bookArrL.remove(check); //if title equals user input then delets book from array list
												frame.setVisible(false);
												frame.dispose();
												foundTitle = true;
											}
										}
										if(!foundTitle)
										{
											ErrorFrame errorFrame = new ErrorFrame(); //if input does not equal title of any book then displays error
											frame.setVisible(false);
											frame.dispose();
										}
									}
							
								});
						frame.add(JTF);
						System.out.println("Title");
						choseSearch = true;
					}
			}
				}
		);
		frame.setLayout(null);
		frame.setVisible(true);  
	}
	public void paint(Graphics g)
	{
		g.setFont(new Font("TimeRoman",Font.BOLD,25));
		g.setColor(Color.RED);
		g.drawString("Error", 10, 10);
	}
}
