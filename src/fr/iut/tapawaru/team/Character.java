package fr.iut.tapawaru.team;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fr.iut.tapawaru.map.Cell;
import fr.iut.tapawaru.map.CellPosition;


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
	
	/** Character's team of appurtenance. */
	private Team	team;
	
	/** Character's life points. */
	private int		healthPoint;
	
	private Cell	cellTraveled;
	
	private String	picture;
	
	// ///// Constructor ////////////////////////////////////////
	
	/**
	 * Constructor of the Character.
	 * 
	 * @param team
	 *            : Character's team.
	 * @param healthpoint
	 *            : Character's life points.
	 */
	public Character(Team team, int healthpoint)
	{
		this.team = team;
		this.healthPoint = healthpoint;
		this.cellTraveled = null;
		
		this.picture = "img/perso/" + this.team.getColorTeam().toString()
				+ ".png";
		
	}
	
	// ///// Methods ////////////////////////////////////////
	
	/**
	 * Method to cast a spell.
	 */
	public void castSpell()
	{
		// TODO faire la m�thode
	}
	
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
		if (!this.isAlive())
		{
			// TODO faire la m�thode;
		}
		
	}
	
	public Cell getCellTraveled()
	{
		return cellTraveled;
	}
	
	public void setCell(Cell cell)
	{
		this.cellTraveled = cell;
	}
	
}
