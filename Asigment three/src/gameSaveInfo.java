import java.io.Serializable;

public class gameSaveInfo implements Serializable
{
	String player,level;
	String savePoints,lives;
	String mana;
	public gameSaveInfo(String player,String level,String savePoints,String lives,String mana)
	{
		this.level = level;
		this.player = player;
		this.savePoints = savePoints;
		this.lives = lives;
		this.mana = mana;
	}
	@Override
	public String toString() 
	{
		return player +": " + level + ","  + savePoints + ","  + lives +  "," + mana;
		 
	}
}
