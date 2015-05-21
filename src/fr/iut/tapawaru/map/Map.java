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
	 * creation de la map
	 */
	public Map()
	{
		this.map = new Cell[this.length][this.width];
		for(int lineNumber =0; lineNumber<this.length;lineNumber++)
		{
			for(int columnNumber = 0; columnNumber < this.width; columnNumber++)
			{
				this.map[lineNumber][columnNumber]= new Cell(lineNumber,columnNumber);
			}
		}
	}
	
}

//TODO vérifier le code est voire les dimension de la map (modifiable ou nn ?)
