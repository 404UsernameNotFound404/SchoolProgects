import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class JFrameController extends JFrame
{
	int w,h;
	public JFrameController(int W, int H)
	{
		w = W;
		h = H;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Snake");
		setResizable(true);
		InIt();
	}
	public void InIt()
	{
		setLayout(new GridLayout(1,1,0,0));
		Screen s = new Screen(w, h);
		add(s);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		//ShapeMover stuff = new ShapeMover();
	}

	public static void main(String[] args) 
	{
		new SelectionClass();
		//new JFrameController(1000, 500);
		//new GameOver();
	}

}
