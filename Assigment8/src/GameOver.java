import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameOver extends JPanel
{
	public GameOver()
	{
		JFrame frame = new JFrame("ERROR");
		JButton button = new JButton("Restart");
		frame.setSize(300, 200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		button.setBounds(50,50, 200,30);  
		frame.add(button);
		frame.add(this);
		button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						frame.setVisible(false);
						frame.dispose();
						
					}
				});
		repaint();
	}
	public void paint(Graphics g)
	{
		Font font =  new Font("TimesRoman", Font.BOLD, 25);
		g.setFont(font);
		g.setColor(Color.red);
		g.drawString("Game Over",100, 40);
	}
}
