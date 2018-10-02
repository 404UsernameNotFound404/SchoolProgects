package nerualNetworkGame;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class WindowCreator extends JFrame {

	public WindowCreator()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("runner");
		setResizable(false);
		init();
	}
	public void init()
	{
		setLayout(new GridLayout(1,1,0,0));
		Screen s = new Screen();
		add(s);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new WindowCreator();

	}

}
