import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class JFrameController extends JFrame
{
	public JFrameController()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Snake");
		setResizable(true);
		InIt();
	}
	public void InIt()
	{
		setLayout(new GridLayout(1,1,0,0));
		Screen s = new Screen();
		add(s);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		//ShapeMover stuff = new ShapeMover();
	}

	public static void main(String[] args) 
	{
		new JFrameController();
	}

}
