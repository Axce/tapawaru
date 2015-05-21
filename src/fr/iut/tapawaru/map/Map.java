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
	private static final int  DEFAULT_LENGHT = 20;
	
	/**
	 * taille (largeur) par defaut
	 */
	private static final int DEFAULT_WIDTH = 20;
	
	/**
	 * longueur de la map
	 */
	private final int length;
	
	/**
	 * largeur de la map
	 */
	private final int width;
	
	/**
	 * grille des cell
	 */
	private final Cell[][] map;
	
	/**
	 * creer une map par defaut
	 */
	public Map()
	{
		this.map = new Cell[DEFAULT_LENGHT][DEFAULT_WIDTH];
		for(int lineNumber =0; lineNumber<DEFAULT_LENGHT;lineNumber++)
		{
			for(int columnNumber = 0; columnNumber < DEFAULT_WIDTH; columnNumber++)
			{
				this.map[lineNumber][columnNumber]= new Cell(lineNumber,columnNumber);
			}
		}
		this.length = DEFAULT_LENGHT;
		this.width = DEFAULT_WIDTH;
	}
	
}

//TODO vérifier le code est voire les dimension de la map (modifiable ou nn ?)
