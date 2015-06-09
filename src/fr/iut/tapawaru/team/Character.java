package fr.iut.tapawaru.team;

import fr.iut.tapawaru.map.Cell;
import fr.iut.tapawaru.map.Map;

public class Character
{
	// ///// Attributes ////////////////////////////////////////
	
	public final static int DEFAULT_MAX_HP = 5;

	/** Character's team of appurtenance. */
	private Team	team;
	
	/** Character's life points. */
	private int		healthPoint;
	
	private Cell	cellTraveled;
	
	private String	picture;

	private int maxHealthPoint;
	
	private Map map;
	
	private Buff buff;
	
	// ///// Constructor ////////////////////////////////////////
	
	/**
	 * Constructor of the Character.
	 * 
	 * @param team
	 *            : Character's team.
	 * @param healthpoint
	 *            : Character's life points.
	 */
	public Character(Team team,Map map)
	{
		this.team = team;
		this.maxHealthPoint = DEFAULT_MAX_HP;
		this.healthPoint = this.maxHealthPoint;

		this.cellTraveled = null;
		
		this.picture = "img/perso/" + this.team.getColorTeam().toString();
		
		this.map = map;
		this.buff = Buff.NORMAL;
	}
	
	// ///// Methods ////////////////////////////////////////
	
	
	/**
	 * Method to check that character's still alive.
	 */
	public boolean isAlive()
	{
		if (this.healthPoint <= 0)
			return false;
		return true;
	}
	
	public String toString()
	{
		return this.picture+this.healthPoint+ ".png";
	}
	
	/**
	 * Method to delete the current Character object.
	 */
	public void kill()
	{
		this.map.putCharacter(null, this.cellTraveled.getPosition());
		this.cellTraveled = null;
		this.setBuff(Buff.DEAD);
		this.map.getMapGui().repaint();
		this.map.getTeamController().checkWin();
	}
	
	public Cell getCellTraveled()
	{
		return this.cellTraveled;
	}
	
	public void setCell(Cell cell)
	{
		this.cellTraveled = cell;
	}
	
	public int getDefaultHealthPoint()
	{
		return this.maxHealthPoint;
	}
	
	public int getHealthPoint()
	{
		return this.healthPoint;
	}
	
	public void setPicture(String s)
	{

		this.picture = "img/perso/" + s;
	}
	
	public Map getMap()
	{
		return this.map;
	}

	public void inflict(int damages)
	{
		this.healthPoint -= damages;
		if (!this.isAlive())
		{
			this.kill();
		}
	}
	
	public void heal(int hp)
	{
		this.healthPoint += hp;
		if (this.healthPoint > this.maxHealthPoint)
			this.healthPoint = this.maxHealthPoint;
	}
	
	public void setBuff(Buff buff)
	{
		this.buff = buff;
	}
	
	public Buff getBuff()
	{
		return this.buff;
	}

}
