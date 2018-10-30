import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UseFile extends JPanel
{
	int WIDTH = 500,HEIGHT = 500;
	public UseFile(LibraryFunct LibFunct)
	{
		System.out.println("UseFile");
		JFrame frame = new JFrame("FileInput");
		JTextField inputField = new JTextField();
		inputField.setBounds(10,10,100,30);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.add(inputField);
		inputField.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						String fileName = inputField.getText();
						File inputFile = new File(fileName);
						LibFunct.readFile(inputFile);
						frame.setVisible(false);
						frame.dispose();
					}
			
				});
	}

}
