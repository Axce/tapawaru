package fr.iut.tapawaru.map;

import java.util.Arrays;

import fr.iut.tapawaru.team.Team;
import fr.iut.tapawaru.team.TeamController;

/**
 * Map hosting the game.
 * It's editable with the Terra' Spells.
 * X-axis is xSize
 * Y-axis is ySize
 * [xSize][ySize] 
 * @authors CEARD, MATHEY, MOUNIER, 
 * @authors PELLOUX-PRAYER, PRADELLE
 */
public class Map
{
	/////// Attributes ////////////////////////////////////////

	/** Map's default xSize. */
	public static final int  DEFAULT_X_SIZE = 30;
	
	/** Map's default ySize. */
	public static final int DEFAULT_Y_SIZE = 15;
	
	/** Map's xSize. */
	private final int xSize;
	
	/** Map's ySize. */
	private final int ySize;
	
	/** Glyphs'grid. */
	private final Glyph[][] glyph;
	
	/** Cells'grid. */
	private final Cell[][] map;
	
	private TeamController teamController;

	private Cell selectedCell;

	private Team playingTeam;
	
	
	/////// Constructor ////////////////////////////////////////

	/**
	 * Constructor for the Map.
	 */
	public Map()
	{ 
		this.selectedCell=null;
		this.xSize=DEFAULT_X_SIZE;
		this.ySize=DEFAULT_Y_SIZE;
		this.map = new Cell[this.xSize][this.ySize];
		
		for(int lineNumber =0; lineNumber<this.xSize;lineNumber++)
		{
			for(int columnNumber = 0; columnNumber < this.ySize; columnNumber++)
			{
				this.map[lineNumber][columnNumber]= new Cell(lineNumber,columnNumber);
			}
		}	
		this.glyph = new Glyph[this.xSize+1][this.ySize+1];
		for(int lineNumber =0; lineNumber< this.xSize+1; lineNumber++)
		{
			for(int columnNumber = 0; columnNumber < this.ySize+1; columnNumber++)
			{
				this.glyph[lineNumber][columnNumber] = new Glyph(lineNumber,columnNumber);
			}
		}
		this.teamController = new TeamController(this);
		
		this.selectedCell=null;
		this.playingTeam = null;
		
	}

	
	public void moveCharacter(fr.iut.tapawaru.team.Character character,CellPosition position)
	{
		// TODO EXCEPTIONS

		this.map[position.getPositionX()][position.getPositionY()].setCharacter(character);
		character.setCell(this.getCell(position));
		
		
	}
	
	public fr.iut.tapawaru.team.Character getCharacter(int posX, int posY)
	{
		return this.map[posX][posY].getCharacter();
	}
	
	public int getXSize()
	{
		return xSize;
	}



	public int getYSize()
	{
		return ySize;
	}
	
	public TeamController getTeamController()
	{
		return this.teamController;
	}


	/**
	 * ToString override
	 * Print the map with cells and glyphs
	 */
	@Override
	public String toString()
	{
		StringBuilder strMap = new StringBuilder();
		
		for (int ySize = 0; ySize < this.ySize+1; ySize++)
		{
			strMap.append(this.glyph[0][ySize]+"   " );
		}
		strMap.append("\n");
		for (int xSize = 0; xSize < this.xSize; xSize++)
		{
			for (int ySize = 0; ySize < this.ySize; ySize++)
			{
				strMap.append(" " + this.map[xSize][ySize]);
			}
			strMap.append( "\n");
			for (int ySize = 0; ySize < this.ySize+1; ySize++)
			{
				strMap.append(this.glyph[xSize+1][ySize]+"   " );
			}
			strMap.append( "\n");

		}
		return strMap.toString();
	}
	
	public TypeGlyph getTypeOfGlyph(GlyphPosition pos)
	{
		return this.glyph[pos.getPositionX()][pos.getPositionY()].getTypeGlyph();
		
	}


	public Cell getCell(CellPosition pos)
	{
		// TODO Auto-generated method stub
		return this.map[pos.getPositionX()][pos.getPositionY()];
	}


	public Glyph getGlyph(GlyphPosition pos)
	{
		return this.glyph[pos.getPositionX()][pos.getPositionY()];
	}


	public void setCell(CellPosition pos, Cell cell)
	{
		this.map[pos.getPositionX()][pos.getPositionY()] = cell;		
	}

	public void setGlyph(GlyphPosition pos, Glyph glyph)
	{
		this.glyph[pos.getPositionX()][pos.getPositionY()] = glyph;		
	}


	public Cell getSelectedCell()
	{
		// TODO Auto-generated method stub
		return this.selectedCell;
	}
	
	public void setSelectedCell(Cell cell)
	{
		this.selectedCell = cell;
	}
	
	public void setPlayingTeam(Team team)
	{
		this.playingTeam = team;
	}
	
	public Team getPlayingTeam()
	{
		return this.playingTeam ;
	}
	
}


//TODO v�rifier le code et voir les dimensions de la map (modifiables ou non ?)
