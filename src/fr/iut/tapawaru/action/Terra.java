package fr.iut.tapawaru.action;

import fr.iut.tapawaru.map.CellPosition;
import fr.iut.tapawaru.map.Glyph;
import fr.iut.tapawaru.map.GlyphPosition;
import fr.iut.tapawaru.map.Map;

/**
 * Terraforming spells.
 * Library gathering static methods of the different Terra spells.
 * Inherited class from Spell, likewise Attack spells.
 * 
 * @authors CEARD, MATHEY, MOUNIER, 
 * @authors PELLOUX-PRAYER, PRADELLE
 */
public class Terra extends Spell
{
	public static void GlyphCWspin(Map map, CellPosition cellPosition)
	{
		GlyphPosition[] glyphPosList= cellPosition.generateAdjacentGlyphPosition();
		
		Glyph glyphBuffer = map.getGlyph(glyphPosList[3]);

		map.getGlyph(glyphPosList[2]).setGlyphPosition(glyphPosList[3]);;
		map.setGlyph(glyphPosList[3], map.getGlyph(glyphPosList[2]));
		map.getGlyph(glyphPosList[1]).setGlyphPosition(glyphPosList[2]);;
		map.setGlyph(glyphPosList[2], map.getGlyph(glyphPosList[1]));
		map.getGlyph(glyphPosList[0]).setGlyphPosition(glyphPosList[1]);;
		map.setGlyph(glyphPosList[1], map.getGlyph(glyphPosList[0]));
		glyphBuffer.setGlyphPosition(glyphPosList[0]);
		map.setGlyph(glyphPosList[0], glyphBuffer);
	}
	
	public static void GlyphCCWspin(Map map, CellPosition cellPosition)
	{
		GlyphPosition[] glyphPosList= cellPosition.generateAdjacentGlyphPosition();
		
		Glyph glyphBuffer = map.getGlyph(glyphPosList[0]);

		map.getGlyph(glyphPosList[1]).setGlyphPosition(glyphPosList[0]);;
		map.setGlyph(glyphPosList[0], map.getGlyph(glyphPosList[1]));
		map.getGlyph(glyphPosList[2]).setGlyphPosition(glyphPosList[1]);;
		map.setGlyph(glyphPosList[1], map.getGlyph(glyphPosList[2]));
		map.getGlyph(glyphPosList[3]).setGlyphPosition(glyphPosList[2]);;
		map.setGlyph(glyphPosList[2], map.getGlyph(glyphPosList[3]));
		glyphBuffer.setGlyphPosition(glyphPosList[3]);
		map.setGlyph(glyphPosList[3], glyphBuffer);
	}
}
