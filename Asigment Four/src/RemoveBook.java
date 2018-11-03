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
	public RemoveBook(LibraryFunct LibFunct)
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
						if(!choseSearch)
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
											Iterator<Book> ILastName = LibFunct.bookArrL.iterator();
											while(ILastName.hasNext())
											{
												Book checkLastName = ILastName.next();
												if(nameInput.compareTo(checkLastName.authorLName) == 0)
												{
													LibFunct.bookArrL.remove(checkLastName);
													frame.setVisible(false);
													frame.dispose();
													foundLname = true;
													break;
												}
											}
											if(!foundLname)
											{
												ErrorFrame errorFrame = new ErrorFrame();
												errorFrame.show();
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
					if(!choseSearch)
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
											int remove = Integer.parseInt(JTF.getText());
											LibFunct.bookArrL.remove(remove);
											frame.setVisible(false);
											frame.dispose();
										}
										catch(Exception e1)
										{
											System.out.println("did not enter int");
											ErrorFrame errorFrame = new ErrorFrame();
											errorFrame.show();
											frame.setVisible(false);
											frame.dispose();
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
					if(!choseSearch)
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
										Iterator<Book> Ibook = LibFunct.bookArrL.iterator();
										while(Ibook.hasNext())
										{
											Book check = Ibook.next();
											if(inputTitle.compareTo(check.title) == 0)
											{
												LibFunct.bookArrL.remove(check);
												System.out.println("DOUND");
												frame.setVisible(false);
												frame.dispose();
												foundTitle = true;
											}
										}
										if(!foundTitle)
										{
											ErrorFrame errorFrame = new ErrorFrame();
											errorFrame.show();
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
	public void remove()
	{
		
		
	}
}