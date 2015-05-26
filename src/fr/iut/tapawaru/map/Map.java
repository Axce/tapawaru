package fr.iut.tapawaru.map;

/**
 * Map hosting the game.
 * It's editable with the Terra' Spells.
 * 
 * @authors CEARD, MATHEY, MOUNIER, 
 * @authors PELLOUX-PRAYER, PRADELLE
 */
public class Map
{
	/////// Attributes ////////////////////////////////////////

	/** Map's default length. */
	public static final int  DEFAULT_LENGTH = 20;
	
	/** Map's default width. */
	public static final int DEFAULT_WIDTH = 20;
	
	/** Map's length. */
	private final int length;
	
	/** Map's width. */
	private final int width;
	
	/** Glyphs'grid. */
	private final Glyph[][] glyph;
	
	/** Cells'grid. */
	private final Cell[][] map;
	
	
	/////// Constructor ////////////////////////////////////////

	/**
	 * Constructor for the Map.
	 */
	public Map()
	{
		this.map = new Cell[this.DEFAULT_LENGTH][this.DEFAULT_WIDTH];
		for(int lineNumber =0; lineNumber<this.length;lineNumber++)
		{
			for(int columnNumber = 0; columnNumber < this.width; columnNumber++)
			{
				this.map[lineNumber][columnNumber]= new Cell(lineNumber,columnNumber);
			}
		}
		this.length=DEFAULT_LENGTH;
		this.width=DEFAULT_WIDTH;	
		this.glyph = new Glyph[this.DEFAULT_LENGTH+1][this.DEFAULT_WIDTH+1];
		for(int lineNumber =0; lineNumber< this.DEFAULT_LENGTH+1; lineNumber++)
		{
			for(int columnNumber = 0; columnNumber < this.DEFAULT_WIDTH+1; columnNumber++)
			{
				this.glyph[lineNumber][columnNumber] = new Glyph(lineNumber,columnNumber);
			}
		}
	}

	
}

//TODO vérifier le code et voir les dimensions de la map (modifiables ou non ?)
