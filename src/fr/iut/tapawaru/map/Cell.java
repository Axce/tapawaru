package fr.iut.tapawaru.map;

/**
 * Case praticable constituant la Map.
 * Un character peut marcher sur une Cell.
 * Une Cell est entourÃ©e de 4 Glyphs.
 * 
 * @author Axce
 */
public class Cell extends MapElement
{
	/**
	 * positionX d'un cell sur la map
	 */
	private int positionX;
	
	/**
	 * positionY d'un cell sur la map
	 */
	private int positionY;
	
	public Cell(int positionX, int positionY)
	{
		this.positionX = positionX;
		this.positionY = positionY;
	}

	/**
	 * obtention de la positionX de la cell courante
	 * @return positionX courante
	 */
	public int getPositionX() 
	{
		return this.positionX;
	}
	
	/**
	 * modification de la positionX de la cell
	 * @param int positionX
	 */
	public void setPositionX(int positionX) 
	{
		this.positionX = positionX;
	}
	
	/**
	 * oBtention de la positionY de la cell courante
	 * @return positionY courante
	 */
	public int getPositionY() 
	{
		return positionY;
	}

	/**
	 * modification de la positionY de la cell 
	 * @param int positionY
	 */
	public void setPositionY(int positionY) 
	{
		this.positionY = positionY;
	}
	
	//TODO vérifier le code
	
}
