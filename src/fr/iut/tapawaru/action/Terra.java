package fr.iut.tapawaru.action;

import fr.iut.tapawaru.map.CellPosition;
import fr.iut.tapawaru.map.GlyphPosition;

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

	public final static void rotate(CellPosition cellPosition,boolean direction)
	{
		GlyphPosition[] glyphPosition =cellPosition.generateAdjacentGlyphPosition();
		// TODO lunch rotate fx
		
	}
}
