
public class gameSaveInfo 
{
	String player,level;
	int savePoints,lives;
	float mana;
	public gameSaveInfo(String player,String level,int savePoints,int lives,float mana)
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
		return player +": " + level + ","  + savePoints + ","  + lives +  "," + mana + ",";
		 
	}
}
