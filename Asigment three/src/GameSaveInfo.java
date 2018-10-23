/* Name: Henry Morris
 * Date: 9/7/2018
 * 
 * Constructors: 
 * gameSaveInfo(String player,String level,int savePoints,int lives,float mana)
 * gameSaveInfo()
 * -made so you can create a new one one value at a time
 * This constructor takes the values from one of the game stat and saves it to variables within the class.
 * Getters and Setters:
 * setPlayer()
 * setLevel()
 * setsavePoints()
 * setLives()
 * setMana()
 */

import java.io.Serializable;

public class GameSaveInfo implements Serializable
{
	String player,level;
	int savePoints,lives;
	float mana;
	
	public GameSaveInfo(String player,String level,int savePoints,int lives,float mana)
	{
		this.level = level;
		this.player = player;
		this.savePoints = savePoints;
		this.lives = lives;
		this.mana = mana;
	}
	public GameSaveInfo()
	{
		//to initialize an empty GameSaveInfo to allow another to be added to array
	}
	public void setPlayer(String playr) 
	{
		this.player = playr;
	}
	public void setLevel(String level) 
	{
		this.level = level;
	}
	public void setSavePoint(int savePoints) 
	{
		this.savePoints = savePoints;
	}
	public void setLives(int lives) 
	{
		this.lives = lives;
	}
	
	public void setMana(double mana) 
	{
		this.mana = (float) mana;
	}
	@Override
	public String toString() 
	{
		return player +": " + level + ","  + savePoints + ","  + lives +  "," + mana;
		 
	}
}
