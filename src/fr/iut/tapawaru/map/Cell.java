package fr.iut.tapawaru.map;

/**
 * Practicable Cell forming the Map.
 * One character can walk on Cell.
 * One cell surrounded by 4 Glyphs.
 * 
 * @authors CEARD, MATHEY, MOUNIER, 
 * @authors PELLOUX-PRAYER, PRADELLE
 */
public class Cell extends MapElement
{
	/////// Attributes ////////////////////////////////////////
	/** Cell's X position on Map. */
	private int positionX;
	
	/** Cell's Y position on Map. */
	private int positionY;
	
	
	/////// Constructor ////////////////////////////////////////
	/**
	 * Constructor for the Cell.
	 * @param positionX: Cell's X position.
	 * @param positionY: Cell's Y position.
	 */
	public Cell(int positionX, int positionY)
	{
		this.positionX = positionX;
		this.positionY = positionY;
	}

	
	/////// Methods //////////////////////////////////////// 
	/**
	 * Get X position from current Cell.
	 * @return position x : current X position.
	 */
	public int getPositionX() 
	{
		return this.positionX;
	}
	
	/**
	 * Sets Cell's X position.
	 * @param int positionX: future Cell's X position.
	 */
	public void setPositionX(int positionX) 
	{
		this.positionX = positionX;
	}
	
	/**
	 * Get Y position from current Cell.
	 * @return positionY : current Y position.
	 */
	public int getPositionY() 
	{
		return positionY;
	}

	/**
	 * Sets Cell's Y position.
	 * @param int positionY : future Cell's Y position.
	 */
	public void setPositionY(int positionY) 
	{
		this.positionY = positionY;
	}

	@Override
	public String toString()
	{
		return " C ";
	}
	
	
	//TODO v�rifier le code
	
}
