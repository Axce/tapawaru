package fr.iut.tapawaru.map;

/**
 * Position of the cell on the map.
 * 
 * @author jpelloux
 * @version 1.0.0
 */
public class CellPosition
{
	/** Cell's X position on Map. */
	private int positionX;
	
	/** Cell's Y position on Map. */
	private int positionY;

	/**
	 * Constructor of the Cell position
	 * @param positionX
	 * @param positionY
	 */
	public CellPosition(int positionX, int positionY)
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
	
	/**
	 * Generate the 4 position of adjacent glyphs. .
	 * GlyphePosition[] like [ TopLeft,TopRight,BotRight,BotLeft].
	 * @return GlyphPosition[3].
	 */
	public GlyphPosition[] generateAdjacentGlyphPosition()
	{
		GlyphPosition[] glyphPosition = new GlyphPosition[3];
		glyphPosition[0] = new GlyphPosition(this.positionX-1 , this.positionY -1);
		glyphPosition[1] = new GlyphPosition(this.positionX , this.positionY -1);
		glyphPosition[2] = new GlyphPosition(this.positionX , this.positionY );
		glyphPosition[3] = new GlyphPosition(this.positionX-1 , this.positionY);
		return glyphPosition;
	}
	
}
