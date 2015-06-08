package fr.iut.tapawaru.action;

import java.util.ArrayList;

import fr.iut.tapawaru.map.CellPosition;
import fr.iut.tapawaru.map.Map;
import fr.iut.tapawaru.team.Character;

/**
 * Attack spells.
 * Library gathering static methods of the different attack spells.
 * Inherited class from Spell, likewise Terra spells.
 * 
 * @authors CEARD, MATHEY, MOUNIER, 
 * @authors PELLOUX-PRAYER, PRADELLE
 */
public class Attack extends Spell
{
	public static ArrayList<CellPosition> straightLine(Map map, Character caster, CellPosition target)
	{
		int deltaX = target.getPositionX() - caster.getCellTraveled().getPosition().getPositionX();
		int deltaY = target.getPositionY() - caster.getCellTraveled().getPosition().getPositionY();
		
		ArrayList<CellPosition> cellList = new ArrayList<CellPosition>();

		if (Math.abs(deltaX) > Math.abs(deltaY))
		{
			if (deltaX > 0) //right
			{
				for (int x = caster.getCellTraveled().getPosition().getPositionX()+1,
						 y = caster.getCellTraveled().getPosition().getPositionY();
					 x < map.getXSize();
					 x++)
				{
					cellList.add(new CellPosition(x, y));
				}
			}
			else	//left
			{
				for (int x = caster.getCellTraveled().getPosition().getPositionX()-1,
					 	 y = caster.getCellTraveled().getPosition().getPositionY();
					 x >= 0;
					 x--)
				{
					cellList.add(new CellPosition(x, y));
				}
			}

		}
		else
		{
			if (deltaY > 0)	//down
			{
				for (int x = caster.getCellTraveled().getPosition().getPositionX(),
					 	 y = caster.getCellTraveled().getPosition().getPositionY()+1;
					 y < map.getYSize();
					 y++)
				{
					cellList.add(new CellPosition(x, y));
				}
			}
			else	//up
			{
				for (int x = caster.getCellTraveled().getPosition().getPositionX(),
					 	 y = caster.getCellTraveled().getPosition().getPositionY()-1;
					 y >= 0;
					 y--)
				{
					cellList.add(new CellPosition(x, y));
				}
			}
		}
		
		return cellList;
	}
	
	public static ArrayList<CellPosition> aroundCaster(Map map, Character caster)
	{
		ArrayList<CellPosition> cellList = new ArrayList<CellPosition>();
		
		int xCaster = caster.getCellTraveled().getPosition().getPositionX();
		int yCaster = caster.getCellTraveled().getPosition().getPositionY();
		
		for (int y = yCaster - 1 ; y <= yCaster + 1 ; y++)
		{
			for (int x = xCaster - 1 ; x <= xCaster + 1 ; x++)
			{
				if ((x != xCaster || y != yCaster) &&
					x >= 0 && y >= 0 &&
					x < map.getXSize() && y < map.getYSize())
					cellList.add(new CellPosition(x, y));
			}
		}
		
		return cellList;
	}
}
