package fr.iut.tapawaru.map;

public class GlyphPosition
{
	/** Glyph's X position on Map. */
	private int positionX;
	
	/** Glyph's Y position on Map. */
	private int positionY;

	/**
	 * Constructor of the Glyph position
	 * @param positionX
	 * @param positionY
	 */
	public GlyphPosition(int positionX, int positionY)
	{
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public int getPositionX()
	{
		return positionX;
	}

	public void setPositionX(int positionX)
	{
		this.positionX = positionX;
	}

	public int getPositionY()
	{
		return positionY;
	}

	public void setPositionY(int positionY)
	{
		this.positionY = positionY;
	}
}
