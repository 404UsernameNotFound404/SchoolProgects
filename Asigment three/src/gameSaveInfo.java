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

	public String getSavePoints() {
		return savePoints;
	}

	public void setSavePoints(String savePoints) {
		this.savePoints = savePoints;
	}

	public String getLives() {
		return lives;
	}

	public void setLives(String lives) {
		this.lives = lives;
	}

	public String getMana() {
		return mana;
	}

	public void setMana(String mana) {
		this.mana = mana;
	}

	@Override
	public String toString() 
	{
		return player +": " + level + ","  + savePoints + ","  + lives +  "," + mana;
		 
	}
}
