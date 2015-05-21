package fr.iut.tapawaru.map;

/**
 * Map accueillant la partie.
 * Elle est modifiable par des sorts de Terra.
 * 
 * @author Axce
 */
public class Map
{
	/**
	 * taille (longueur) par defaut
	 */
	public static final int  DEFAULT_LENGHT = 20;
	
	/**
	 * taille (largeur) par defaut
	 */
	public static final int DEFAULT_WIDTH = 20;
	
	/**
	 * longueur de la map
	 */
	private final int length;
	
	/**
	 * largeur de la map
	 */
	private final int width;
		/**
	 * grille de Glyph
	 */
	private final Glyph[][] glyph;
	
	/**
	 * grille des cell
	 */
	private final Cell[][] map;
	
	/**
	 * creation de la map
	 */
	public Map()
	{
		this.map = new Cell[this.DEFAULT_LENGHT][this.DEFAULT_WIDTH];
		for(int lineNumber =0; lineNumber<this.length;lineNumber++)
		{
			for(int columnNumber = 0; columnNumber < this.width; columnNumber++)
			{
				this.map[lineNumber][columnNumber]= new Cell(lineNumber,columnNumber);
			}
		}
		this.length=DEFAULT_LENGHT;
		this.width=DEFAULT_WIDTH;	
		this.glyph = new Glyph[this.DEFAULT_LENGHT+1][this.DEFAULT_WIDTH+1];
		for(int lineNumber =0; lineNumber< this.DEFAULT_LENGHT+1; lineNumber++)
		{
			for(int columnNumber = 0; columnNumber < this.DEFAULT_WIDTH+1; columnNumber++)
			{
				this.glyph[lineNumber][columnNumber] = new Glyph(lineNumber,columnNumber);
			}
		}
	}

	
}

//TODO vérifier le code est voire les dimension de la map (modifiable ou nn ?)
