import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Search extends JPanel
{
	int WidthF = 400,HeightF = 600;
	int WidthB = 200, HeightB = 600;
	boolean choseSearch = false;
	public Search(LibraryFunct LibFunct)
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
											for(int x = 0;x < LibFunct.getArraySize();x++)
											{
												if(nameInput.compareTo(LibFunct.bookArrL.get(x).authorLName) == 0)
												{
													LibFunct.bookArrL.remove(x);
													frame.setVisible(false);
													frame.dispose();
													break;
												}
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
										int remove = Integer.parseInt(JTF.getText());
										LibFunct.bookArrL.remove(remove);
										frame.setVisible(false);
										frame.dispose();
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
										for(int x = 0;x < LibFunct.getArraySize();x++)
										{
											if(inputTitle.compareTo(LibFunct.bookArrL.get(x).title) == 0)
											{
												LibFunct.bookArrL.remove(x);
												frame.setVisible(false);
												frame.dispose();
											}
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
		
	}
	public void remove()
	{
		
		
	}
}
