import java.io.Serializable;

public class gameSaveInfo implements Serializable
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
	
	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getSavePoints() {
		return savePoints;
	}

	public void setSavePoint(int savePoints) {
		this.savePoints = savePoints;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public float getMana() {
		return mana;
	}

	public void setMana(float mana) {
		this.mana = mana;
	}

	@Override
	public String toString() 
	{
		return player +": " + level + ","  + savePoints + ","  + lives +  "," + mana;
		 
	}
}
