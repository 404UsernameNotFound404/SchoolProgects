import java.awt.GridLayout;

import javax.swing.JFrame;

public class WindowCreator extends JFrame
{
	public WindowCreator()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Library Of Jorris");
		setResizable(false);
		init();
	}
	public void init()
	{
		setLayout(new GridLayout(1,1,0,0));
		DisplayControler s = new DisplayControler();
		add(s);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
