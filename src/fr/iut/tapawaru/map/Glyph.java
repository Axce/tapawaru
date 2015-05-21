package fr.iut.tapawaru.map;

/**
 * Glyphe constituant la Map.
 * Il existe [nombre indéterminé] types de glyphes différents.
 * Une Cell de la Map est entourée de 4 glyphes.
 * Le type d'un Spell d'Attack lancé dépend des glyphes adjacents au lanceur.
 * Choix du type du sort: le type d'un glyphe aléatoire parmi les 4 adjacents.
 * Choix de la puissance du sort : puissance multipliée par le nombre de glyphes du même type adjacents au lanceur.
 * 
 * @author Axce
 */
public class Glyph extends MapElement
{
	
	/**
	 * positionX d'un cell sur la map
	 */
	private int positionGlyphX;
	
	/**
	 * positionY d'un cell sur la map
	 */
	private int positionGlyphY;
	/**
	 * type de Glyph
	 */
	private TypeGlyph typeGlyph;

	public Glyph(int lineNumber, int columnNumber) 
	{
		this.positionGlyphX=lineNumber;
		this.positionGlyphY=columnNumber;
		this.typeGlyph=null;
	}
	//TODO Un enum des différents types de glyphes.

	public int getPositionGlyphY() {
		return this.positionGlyphY;
	}

	public void setPositionGlyphY(int positionGlyphY) {
		this.positionGlyphY = positionGlyphY;
	}

	public int getPositionGlyphX() {
		return this.positionGlyphX;
	}

	public void setPositionGlyphX(int positionGlyphX) {
		this.positionGlyphX = positionGlyphX;
	}

	public TypeGlyph getTypeGlyph() {
		return this.typeGlyph;
	}

	public void setTypeGlyph(TypeGlyph typeGlyph) {
		this.typeGlyph = typeGlyph;
	}
	
}
