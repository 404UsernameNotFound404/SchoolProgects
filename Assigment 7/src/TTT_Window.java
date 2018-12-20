import javax.swing.JFrame;  //needed to use swing components e.g. JFrame

import java.awt.Color;
import java.awt.Container;

public class TTT_Window extends JFrame{
	
	// Set up constants for width and height of frame 
		static final int WIDTH = 800; 
		static final int HEIGHT = 450;
		
		// constructor
		public TTT_Window(String title) { 
		   	// Set the title of the frame, must be before variable declarations 
		   	super(title);
				   
		   	TTTPanel basicPanel; 
		   	Container container;
		   	
		   	// Instantiate and add the SimplePanel to the frame
		   	basicPanel = new TTTPanel(); 
		   	basicPanel.setBackground(Color.getHSBColor(120, 200, 150)); 
		   	container = getContentPane();
		   	
		   	//container.setLayout(null);
		    setLocationByPlatform(true);
		   	container.add(basicPanel);
		   	container.validate();
		} 
		    
		public static void main(String args[]) 
		{ 
			// Instantiate a FirstApplication object so you can display it 
		    TTT_Window frame =  new TTT_Window("TicTacToe Game"); 
		    frame.setDefaultCloseOperation(EXIT_ON_CLOSE); 
			
		    // Set the size of the application window (frame) 
		    frame.setLocation(0,0);
			frame.setSize(WIDTH, HEIGHT);
				  
		    frame.setVisible(true); // Show the application (frame) 
		} 
	}

