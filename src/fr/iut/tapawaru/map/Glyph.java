package fr.iut.tapawaru.map;

/**
 * Glyph constituting the Map.
 * Exists [unknown number] different types of Glyphs.
 * One Map's Cell is surrounded by 4 (random) Glyphs.
 * The type of the thrown Attack' Spell depends on adjacent Glyphs to the thrower.
 * Choice of a spell's type: the type from a random Glyph amongst the 4, adjacent to the thrower.
 * Choice of a spell's power: power multiplied by the number of Glyphs of the same type, adjacent to the thrower.
 * 
 * @authors CEARD, MATHEY, MOUNIER, 
 * @authors PELLOUX-PRAYER, PRADELLE
 */
public class Glyph extends MapElement
{
	/////// Attributes ////////////////////////////////////////
	/** Glyph's X position on Map. */
	private int positionGlyphX;
	
	/** Glyph's Y position on Map. */
	private int positionGlyphY;
	
	/** Glyph's type. */
	private TypeGlyph typeGlyph;

	
	/////// Constructor ////////////////////////////////////////
	/**
	 * Constructor for the Glyph.
	 * @param lineNumber
	 * @param columnNumber
	 */
	public Glyph(int lineNumber, int columnNumber) 
	{
		this.positionGlyphX=lineNumber;
		this.positionGlyphY=columnNumber;
		this.typeGlyph=null;
	}
	
	
	/////// Methods //////////////////////////////////////// 

	/**
	 * Gets X position from current Glyph.
	 * @return position x : current X position.
	 */
	public int getPositionGlyphX() {
		return this.positionGlyphX;
	}

	/**
	 * Sets Glyph's X position.
	 * @param int positionGlyphX: future Glyph's X position.
	 */
	public void setPositionGlyphX(int positionGlyphX) {
		this.positionGlyphX = positionGlyphX;
	}
	
	
	/**
	 * Gets Y position from current Glyph.
	 * @return position x : current X position.
	 */
	public int getPositionGlyphY() {
		return this.positionGlyphY;
	}

	/**
	 * Sets Glyph's Y position.
	 * @param int positionGlyphY: future Glyph's Y position.
	 */
	public void setPositionGlyphY(int positionGlyphY) {
		this.positionGlyphY = positionGlyphY;
	}

	
	/**
	 * Gets type from current Glyph.
	 * @return typeGlyph : current type.
	 */
	public TypeGlyph getTypeGlyph() {
		return this.typeGlyph;
	}

	/**
	 * Sets Glyph's type position.
	 * @param TypeGlyph typeGlyph: future Glyph's type.
	 */
	public void setTypeGlyph(TypeGlyph typeGlyph) {
		this.typeGlyph = typeGlyph;
	}
	
}
