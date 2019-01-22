import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectionClass extends JPanel implements ActionListener
{
	Character ch;
	public SelectionClass ()
	{
		JFrame frame = new JFrame("");
		JButton button = new JButton("Enter Resolution");
		frame.setSize(400, 400);
		String[] res = new String[] {
				"1000 x 500", "500 x 500", "400 x 200"
		};
		JComboBox<String> cb = new JComboBox<>(res);
		cb.setBounds(100,200,200,30);
        String petName = (String)cb.getSelectedItem();
		button.setBounds(100,250, 200,30);  
		frame.add(button);
		button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						frame.setVisible(false);
						frame.dispose();
						int returnRes1 = 10;
						int returnRes2 = 10;
						
						switch(cb.getSelectedIndex())
						{
						case 0:
							System.out.println("Choice one");
							returnRes1 = 1000;
							returnRes2 = 500;
							
							break;
						case 1:
							System.out.println("choice two");
							returnRes1 = 500;
							returnRes2 = 500;
							break;
						case 2:
							System.out.println("choise three");
							returnRes1 = 400;
							returnRes2 = 200;
							break;
						}
						
						new JFrameController(returnRes1, returnRes2);
						frame.setVisible(false);
						frame.dispose();
					}
				});
		JTextField JTF = new JTextField("");
		JTF.setBounds((400/2) - 100,(500/3),200,30);
		JTF.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						System.out.println("Beggining");
						String text = JTF.getText();
						String forCollectingNumber = "";
						String forCollectingNumber2 = "";
						boolean spaceHappened = false;
						for (int x = 0;x < text.length();x++)
					    {
					        if (Character.isDigit(text.charAt(x))) 
					        {
					        	if(!spaceHappened)
					        	{
					        		forCollectingNumber += text.charAt(x);
					        	}
					        	else
					        	{
					        		forCollectingNumber2 += text.charAt(x);
					        	}
					        }
					        ch = new Character(text.charAt(x));
					        if(ch.equals(' '))
					        {
					        	spaceHappened = true;
					        }
					    }
						new JFrameController(Integer.parseInt(forCollectingNumber), Integer.parseInt(forCollectingNumber2));
						frame.setVisible(false);
						frame.dispose();
					}
				}
				);
        
        frame.add(cb);
		frame.add(JTF);
		frame.add(this);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		repaint();
	}
	public void paint(Graphics g)
	{
		Font font =  new Font("TimesRoman", Font.BOLD, 40);
		g.setFont(font);
		g.setColor(Color.red);
		g.drawString("Enter Resolution",60, 120);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
