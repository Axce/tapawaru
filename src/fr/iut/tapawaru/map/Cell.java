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
	
	/** Cell's position on Map. */
	private CellPosition position;
	
	private fr.iut.tapawaru.team.Character character;
	
	private boolean isSelected;
	/////// Constructor ////////////////////////////////////////
	/**
	 * Constructor for the Cell.
	 * @param positionX: Cell's X position.
	 * @param positionY: Cell's Y position.
	 */
	public Cell(int positionX, int positionY)
	{
		this.position = new CellPosition(positionX, positionY);
		this.character = null;
		this.isSelected = false;
	}

	
	/////// Methods //////////////////////////////////////// 
	/**
	 * Get position from current Cell.
	 * @return position  : current position.
	 */
	public CellPosition getPosition() 
	{
		return this.position;
	}
	
	/**
	 * Sets Cell's position.
	 * @param int position: future Cell's position.
	 */
	public void setPosition(CellPosition position) 
	{
		this.position = position;
	}
	
	/**
	 * Sets Cell's X position.
	 * @param int positionX: future Cell's X position.
	 */
	public void setPositionX(int positionX) 
	{
		this.position.setPositionX(positionX);
	}
	
	/**
	 * Sets Cell's Y position.
	 * @param int positionY : future Cell's Y position.
	 */
	public void setPositionY(int positionY) 
	{
		this.position.setPositionY(positionY);
	}

	@Override
	public String toString()
	{
		return " C ";
	}


	public void addCharacter(fr.iut.tapawaru.team.Character character2)
	{
		// TODO EXCEPTION IF ONE CHAR ALREADY ON CELL? Or return old char?
		this.character = character2;
		
	}

	public boolean isSelected()
	{
		return this.isSelected;
	}
	
	public void setIsSelected(boolean state)
	{
		this.isSelected = state;
	}

	public fr.iut.tapawaru.team.Character getCharacter()
	{
		return this.character;
	}
	
	
	//TODO vérifier le code
	
}
