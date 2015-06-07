package fr.iut.tapawaru.map;

import java.util.Arrays;

import fr.iut.tapawaru.team.Team;
import fr.iut.tapawaru.team.TeamController;

/**
 * Map hosting the game.
 * It's editable with the Terra' Spells.
 * X-axis is length
 * Y-axis is width
 * [length][width] 
 * @authors CEARD, MATHEY, MOUNIER, 
 * @authors PELLOUX-PRAYER, PRADELLE
 */
public class Map
{
	/////// Attributes ////////////////////////////////////////

	/** Map's default length. */
	public static final int  DEFAULT_LENGTH = 30;
	
	/** Map's default width. */
	public static final int DEFAULT_WIDTH = 15;
	
	/** Map's length. */
	private final int length;
	
	/** Map's width. */
	private final int width;
	
	/** Glyphs'grid. */
	private final Glyph[][] glyph;
	
	/** Cells'grid. */
	private final Cell[][] map;
	
	private TeamController teamController;
	
	
	/////// Constructor ////////////////////////////////////////

	/**
	 * Constructor for the Map.
	 */
	public Map()
	{ 
		this.length=DEFAULT_LENGTH;
		this.width=DEFAULT_WIDTH;
		this.map = new Cell[this.length][this.width];
		
		for(int lineNumber =0; lineNumber<this.length;lineNumber++)
		{
			for(int columnNumber = 0; columnNumber < this.width; columnNumber++)
			{
				this.map[lineNumber][columnNumber]= new Cell(lineNumber,columnNumber);
			}
		}	
		this.glyph = new Glyph[this.length+1][this.width+1];
		for(int lineNumber =0; lineNumber< this.length+1; lineNumber++)
		{
			for(int columnNumber = 0; columnNumber < this.width+1; columnNumber++)
			{
				this.glyph[lineNumber][columnNumber] = new Glyph(lineNumber,columnNumber);
			}
		}
		this.teamController = new TeamController(this);
		
	}

	
	public void putCharacter(fr.iut.tapawaru.team.Character character,CellPosition position)
	{
		// TODO EXCEPTIONS

		this.map[position.getPositionX()][position.getPositionY()].addCharacter(character);
		
	}
	
	public fr.iut.tapawaru.team.Character getCharacter(int posX, int posY)
	{
		return this.map[posX][posY].getCharacter();
	}
	
	public int getLength()
	{
		return length;
	}



	public int getWidth()
	{
		return width;
	}



	/**
	 * ToString override
	 * Print the map with cells and glyphs
	 */
	@Override
	public String toString()
	{
		StringBuilder strMap = new StringBuilder();
		
		for (int cellWidth = 0; cellWidth < this.width+1; cellWidth++)
		{
			strMap.append(this.glyph[0][cellWidth]+"   " );
		}
		strMap.append("\n");
		for (int cellLength = 0; cellLength < this.length; cellLength++)
		{
			for (int cellWidth = 0; cellWidth < this.width; cellWidth++)
			{
				strMap.append(" " + this.map[cellLength][cellWidth]);
			}
			strMap.append( "\n");
			for (int cellWidth = 0; cellWidth < this.width+1; cellWidth++)
			{
				strMap.append(this.glyph[cellLength+1][cellWidth]+"   " );
			}
			strMap.append( "\n");

		}
		return strMap.toString();
	}
	
	public TypeGlyph getTypeOfGlyph(GlyphPosition pos)
	{
		return this.glyph[pos.getPositionX()][pos.getPositionY()].getTypeGlyph();
		
	}
	
}


//TODO v�rifier le code et voir les dimensions de la map (modifiables ou non ?)
