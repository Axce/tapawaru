package fr.iut.tapawaru.action;

import fr.iut.tapawaru.exception.AdjacentCellsException;
import fr.iut.tapawaru.map.Cell;
import fr.iut.tapawaru.map.CellPosition;
import fr.iut.tapawaru.map.Glyph;
import fr.iut.tapawaru.map.GlyphPosition;
import fr.iut.tapawaru.map.Map;
import fr.iut.tapawaru.map.TypeGlyph;

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
	
	/**
	 * Clockwise glyph spin
	 * 01	->	30
	 * 32       21
	 */
	public static void glyphCWspin(Map map, CellPosition cellPosition)
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
	
	/**
	 * Counter-clockwise glyph spin
	 * 01	->	12
	 * 32       03
	 */
	public static void glyphCCWspin(Map map, CellPosition cellPosition)
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
	
	/**
	 * 4 new random glyphs
	 * 01	->	??
	 * 32       ??
	 */
	public static void glyphRandom(Map map, CellPosition cellPosition)
	{
		GlyphPosition[] glyphPosList= cellPosition.generateAdjacentGlyphPosition();

		map.getGlyph(glyphPosList[0]).setTypeGlyph(TypeGlyph.getRandomType());
		map.getGlyph(glyphPosList[1]).setTypeGlyph(TypeGlyph.getRandomType());
		map.getGlyph(glyphPosList[2]).setTypeGlyph(TypeGlyph.getRandomType());
		map.getGlyph(glyphPosList[3]).setTypeGlyph(TypeGlyph.getRandomType());
	}
	
	/**
	 * Interchange 2 cell's surrounding glyphs
	 * 01  45	->	45  01
	 * 32  76      	76  32
	 * @deprecated
	 */
	public static void glyphShift(Map map, CellPosition cellPos1, CellPosition cellPos2) throws AdjacentCellsException
	{
		int deltaX = Math.abs(cellPos1.getPositionX() - cellPos2.getPositionX());
		int deltaY = Math.abs(cellPos1.getPositionY() - cellPos2.getPositionY());
		if (deltaX == 1 && deltaY ==0 ||
			deltaX == 0 && deltaY ==1 ||
			deltaX == 0 && deltaY ==0 ||
			deltaX == 1 && deltaY ==1)
			throw new AdjacentCellsException();
		
		GlyphPosition[] glyphPosList1= cellPos1.generateAdjacentGlyphPosition();
		GlyphPosition[] glyphPosList2= cellPos2.generateAdjacentGlyphPosition();
		TypeGlyph[] glyphTypebuffer= new TypeGlyph[glyphPosList1.length];
		
		for (int glyphIndex = 0 ; glyphIndex < glyphPosList1.length ; glyphIndex++)
		{
			glyphTypebuffer[glyphIndex] = map.getGlyph(glyphPosList1[glyphIndex]).getTypeGlyph();
		}

		map.getGlyph(glyphPosList1[0]).setTypeGlyph(map.getGlyph(glyphPosList2[0]).getTypeGlyph());
		map.getGlyph(glyphPosList1[1]).setTypeGlyph(map.getGlyph(glyphPosList2[1]).getTypeGlyph());
		map.getGlyph(glyphPosList1[2]).setTypeGlyph(map.getGlyph(glyphPosList2[2]).getTypeGlyph());
		map.getGlyph(glyphPosList1[3]).setTypeGlyph(map.getGlyph(glyphPosList2[3]).getTypeGlyph());
		map.getGlyph(glyphPosList2[0]).setTypeGlyph(glyphTypebuffer[0]);
		map.getGlyph(glyphPosList2[1]).setTypeGlyph(glyphTypebuffer[1]);
		map.getGlyph(glyphPosList2[2]).setTypeGlyph(glyphTypebuffer[2]);
		map.getGlyph(glyphPosList2[3]).setTypeGlyph(glyphTypebuffer[3]);
	}
	
	/**
	 * Interchange 2 cells
	 * @deprecated
	 */
	public static void cellShift(Map map, CellPosition cellPos1, CellPosition cellPos2)
	{
		Cell cellBuffer = map.getCell(cellPos1);
		map.getCell(cellPos2).setPosition(cellPos1);
		map.setCell(cellPos1, map.getCell(cellPos2));
		cellBuffer.setPosition(cellPos2);
		map.setCell(cellPos2, cellBuffer);
		
	}
	
	
}
