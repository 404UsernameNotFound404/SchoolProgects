package sideScrollerJumper;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JFrame;

public class mainSideScroller extends JFrame {
	
	public mainSideScroller() 
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
		new mainSideScroller();
		
	}
}
