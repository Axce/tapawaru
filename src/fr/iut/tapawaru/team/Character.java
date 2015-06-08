package fr.iut.tapawaru.team;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fr.iut.tapawaru.gui.BottomPlayer;
import fr.iut.tapawaru.map.Cell;
import fr.iut.tapawaru.map.CellPosition;




import fr.iut.tapawaru.map.Map;

import java.awt.Component;
/**
 * Character of a team. Contained in the listCharacter attribute.
 * 
 * @authors CEARD, MATHEY, MOUNIER,
 * @authors PELLOUX-PRAYER, PRADELLE
 */
import java.awt.Image;

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

	private BottomPlayer bottomPlayer;

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
	public Character(Team team, int healthpoint,Map map)
	{
		this.team = team;
		this.maxHealthPoint = healthpoint;
		this.healthPoint = healthpoint;

		this.cellTraveled = null;
		
		this.picture = "img/perso/" + this.team.getColorTeam().toString()
				+ ".png";
		
		this.bottomPlayer = new BottomPlayer(team.getColorTeam(),this);
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
		return this.picture;
	}
	
	/**
	 * Method to delete the current Character object.
	 */
	public void kill()
	{
		// TODO complete
	}
	
	public Cell getCellTraveled()
	{
		return cellTraveled;
	}
	
	public void setCell(Cell cell)
	{
		this.cellTraveled = cell;
	}

	public BottomPlayer getBottomPlayer()
	{
		// TODO Auto-generated method stub
		return this.bottomPlayer;
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

		this.picture = "img/perso/" + s+ ".png";
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
