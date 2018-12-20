import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExepctionController extends Exception
{
	public ExepctionController(String message)
	{
		System.out.println("KELLY CLARKSON");
		System.out.println(message);
		JFrame frame = new JFrame("ERROR");
		JButton button = new JButton("ERROR NO NEED TO RESET CLICK TO X OFF");
		frame.setSize(300, 200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		button.setBounds(50,50, 200,30);  
		frame.add(button);
		button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						frame.setVisible(false);
						frame.dispose();
					}
				});
	}
}
