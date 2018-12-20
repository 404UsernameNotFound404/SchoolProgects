import java.awt.Color;
import java.awt.Font; //needed to use components setting methods (e.g., colors, fonts) 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException; 

public class TTTPanel extends JPanel implements ActionListener,MouseListener{
	// model
	//private TicTacToe aTictactoe;

	private JButton[][]   button;	 
	private JButton 	exitButton, resetButton;
	private JLabel    playerLabel, statusLabel; //private JLabel    playerLabel, statusLabel;
	private Font      playerFont, fancyFont;
	
	
	private static int bWidth = 100;
	private static int bHeight = 50;
	
	boolean playerOneIsTrue = true;
	
	int xCounterRow = 0;
	int yCounterRow = 0;
	
	int yCounterCol0 = 0;
	int yCounterCol1 = 0;
	int yCounterCol2 = 0;
	
	int xCounterCol0 = 0;
	int xCounterCol1 = 0;
	int xCounterCol2 = 0;
	
	int totalCounter = 0;
	
	String defualtText = " ";
	Color defaultColor = SystemColor.control;
	
	BufferedImage BlackLine;
	
	JLabel Turn;
	
	//constructor
	public TTTPanel() {
		//create instance of TicTacToe
		//aTicTacToe = new TicTacToe();
			
		// set the layout for the panel to not have a layout manager
		setLayout(null);
					
		// Create and add a player JLabel 
		//playerLabel = new JLabel("Player"); 
		//playerLabel.setBounds(140, 25, 240, 45);
		//add(playerLabel);
			
		// Create a 2nd JLabel with a different font 
		statusLabel = new JLabel(""); 
		statusLabel.setBounds(160, 180, 230, 200);
		add(statusLabel); // Add the label to this Frame
		
		Turn = new JLabel("Player One Turn");
		//.setBounds(r);
		Turn.setBounds(560, 25, 230, 200);
		add(Turn); // Add the label to this Frame
		
		//Instructions
		JLabel Instructions1 = new JLabel("Player One = X");
		JLabel Instructions2 = new JLabel("Player Two = Y");
		Instructions1.setBounds(400, 100, 230, 50);
		Instructions2.setBounds(400, 150, 230, 50);
		add(Instructions1);
		add(Instructions2);
		// Create a JButton 
			button = new JButton[3][3];
			for (int row=0; row<3; row++){
				for(int col = 0;col < 3; col++)
				{
					button[row][col] = new JButton(""); 
					button[row][col].setBackground(defaultColor); 
					button[row][col].setLocation((50+(bWidth * col)), (100+(row*bHeight))); 
					button[row][col].setSize(bWidth,bHeight); 
				    add(button[row][col]);
				      
				    //Set all buttons to work with the event handlers
				    button[row][col].addActionListener(this);
				    button[row][col].addMouseListener(this);
				    //button[row][col].setText("R " + row + " C " + col);
				    button[row][col].setText(defualtText);
				}
			}
			//Add exit button
			exitButton = new JButton("Exit"); 
			exitButton.setBackground(SystemColor.control); 
			exitButton.setLocation(250, 300); 
		    exitButton.setSize(100,40); 
		    add(exitButton);
		    //Add reset button to allow for a new game    
		    resetButton = new JButton("New Game"); 
			resetButton.setBackground(SystemColor.control); 
			resetButton.setLocation(50, 300); 
		    resetButton.setSize(125,40); 
		    add(resetButton);
		    // Add event listeners for the buttons
		    exitButton.addActionListener(this);
		    resetButton.addActionListener(this);
		    exitButton.addMouseListener(this);
		    resetButton.addMouseListener(this);
		    validate();
		}	
		//This is the event handler for the button 
		   public void actionPerformed(ActionEvent e) { 
		       //Ask the event which button it represents 
		       if (e.getActionCommand().equals("Exit")) 
		            System.exit(0);
		       
		       if (e.getActionCommand().equals("New Game")){
		    	   // Call the method to reset the game
		    	   try {
					resetGame();
				} catch (ExepctionController e1) {
					System.out.println("Catch for resetGame");
					e1.printStackTrace();
				}
		       }
		   }
		   public void mousePressed(MouseEvent event) 
		   { 
			   // get location of mouse press
			   int x = event.getXOnScreen() - super.getLocationOnScreen().x;
			   int y = event.getYOnScreen() - super.getLocationOnScreen().y;
		    		     
		       if((event.getButton()>0) && (y < 300)){
			       // determine the row and column;
			       int buttonRow = (y-100)/bHeight;
			       int buttonCol = (x-50)/bWidth;
			       //System.out.println("Button Row and Width" + buttonRow + " " + buttonCol);
			       if(playerOneIsTrue)
			       {
			    	   System.out.println("PLAYER");
			    	   button[buttonRow][buttonCol].setText("Y");
			    	   button[buttonRow][buttonCol].setBackground(Color.GREEN);
			    	   disableListner(buttonRow, buttonCol);
			    	   playerOneIsTrue = false;
			    	   checkGame();
			    	   System.out.println("player one");
			    	   Turn.setText("Player Two's Turn");
			       }else
			       {
			    	   button[buttonRow][buttonCol].setText("X");
			    	   button[buttonRow][buttonCol].setBackground(Color.RED);
			    	   disableListner(buttonRow, buttonCol);
			    	   playerOneIsTrue = true;
			    	   System.out.println("player two");
			    	   checkGame();
			    	   Turn.setText("Player One's Turn");
			       }
			       repaint();
		       }
		   }

		   public void mouseReleased(MouseEvent event) { 
			  // Good for dragging situations
		   }

		   public void mouseEntered(MouseEvent event) { 
		    	//Brings focus to the button 
		   }

		   public void mouseExited(MouseEvent event) { 
		    	//Removes focus from the button
		   }
		   
		   public void mouseClicked(MouseEvent event) { 
		        
		        }

		   void disableListeners(){
			   for(int row=0; row<3; row++){
				   for(int col = 0;col < 3;col++)
				   {
					   button[row][col].removeActionListener(this);
					   button[row][col].removeMouseListener(this); 
				   }
			   }
		   }
		   void disableListner(int oneToDisableRow,int oneToDisableCol)
		   {
			   
			   button[oneToDisableRow][oneToDisableCol].removeActionListener(this);
			   button[oneToDisableRow][oneToDisableCol].removeMouseListener(this); 
		   }
		   void checkGame()
		   {
			   for(int r = 0;r < 3;r++)
			   {
				   for(int c = 0;c < 3;c++)
				   {
					   if(button[r][c].getText().compareTo("X") == 0)
					   {
						   switch(c)
						   {
							   case 0:
								   xCounterCol0++;
								   break;
							   case 1:
								   xCounterCol1++;
								   break;
							   case 2:
								   xCounterCol2++;
								   break;
						   }
						   //System.out.println("Found x");
						   xCounterRow++;
						   totalCounter++;
					   }
					   if(button[r][c].getText().compareTo("Y") == 0)
					   {
						   switch(c)
						   {
							   case 0:
								   yCounterCol0++;
								   break;
							   case 1:
								   yCounterCol1++;
								   break;
							   case 2:
								   yCounterCol2++;
								   break;
						   }
						   //System.out.println("Found x");
						   yCounterRow++;
						   totalCounter++;
					   }
				   }
				   if(button[0][0].getText().compareTo("X") == 0 & button[1][1].getText().compareTo("X") == 0 & button[2][2].getText().compareTo("X") == 0)
				   {
					   System.out.println("X WINS");
					   win(playerOneIsTrue);
					   disableListeners();
				   }
				   if(button[0][0].getText().compareTo("Y") == 0 & button[1][1].getText().compareTo("Y") == 0 & button[2][2].getText().compareTo("Y") == 0)
				   {
					   System.out.println("Y WINS");
					   win(playerOneIsTrue);
					   disableListeners();
				   }
				   if(xCounterRow == 3)
				   {
					   System.out.println("x Wins");
					   
				   }
				   if(yCounterRow == 3)
				   {
					   System.out.println("y Wins");
				   }
				   xCounterRow = 0;
				   yCounterRow = 0;
			   }
			   //System.out.println("xCounterCol0: " + xCounterCol0);
			   //System.out.println("xCounterCol1: " + xCounterCol1);
			   //System.out.println("xCounterCol2: " + xCounterCol2);
			   
			   System.out.print("\n");

			   //System.out.println("yCounterCol0: " + yCounterCol0);
			   //System.out.println("yCounterCol1: " + yCounterCol1);
			   //System.out.println("yCounterCol2: " + yCounterCol2);
			   if(xCounterCol0 == 3 || xCounterCol1 == 3 || xCounterCol2 == 3) 
			   {
				   System.out.println("X WINS");
				   win(playerOneIsTrue);
				   disableListeners();
			   }
			   if(yCounterCol0 == 3 || yCounterCol1 == 3 || xCounterCol2 == 3) 
			   {
				   System.out.println("Y WINS");
				   win(playerOneIsTrue);
				   disableListeners();
			   }
			   System.out.println(totalCounter);
			   if(totalCounter >= 9)
			   {
				   //tie code
				   statusLabel.setText("TIE");
				   System.out.println("PETER");
			   }
			   totalCounter = 0;
			   xCounterCol0 = 0;
			   xCounterCol1 = 0;
			   xCounterCol2 = 0;
			   
			   yCounterCol0 = 0;
			   yCounterCol1 = 0;
			   yCounterCol2 = 0;
		   }
		   void resetGame() throws ExepctionController
		   {	
			   Turn.setText("Player One's Turn");
			   boolean found = false;
			   for(int x = 0;x < 3;x++)
			   {
				   for(int y = 0;y < 3;y++)
				   {
					   //System.out.println(button[x][y].getText().compareTo(""));
					   if(button[x][y].getText().compareTo(" ") != 0)
					   {
						   //System.out.println("HATE");
						   found = true;
						   break;
					   }
				   }
				   if(found)
				   {
					   break;
				   }
			   }
			   if(!found)
			   {
				   System.out.println("it did not find anything");
				   throw new ExepctionController("NO CHARACTERS ENTRED");
			   }
			   else
			   {
				   for(int x = 0;x < 3;x++)
				   {
					   for(int y = 0;y < 3;y++)
					   {
						   button[x][y].setText(defualtText);
						   button[x][y].setBackground(defaultColor);
						   button[x][y].addActionListener(this);
						   button[x][y].addMouseListener(this);
					   }
				   }
				   statusLabel.setText("");
				   playerOneIsTrue = true;
			   }
		   }
		   void win(boolean whoWon)
		   {
			   if(whoWon != true)
			   {
				   System.out.println("y player wins");
				   statusLabel.setText("Player one wins");
				   //put out who won then a continue button continue button connects to resets 
			   }else
			   {
				   statusLabel.setText("Player two wins");
				   System.out.println("x player wins");
			   }
		   }
		   void checkWhichCollom(String xOrY)
		   {
			   
		   }
		   @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        //draw rectangle of black
		    }

}