package fr.iut.tapawaru.action;

import fr.iut.tapawaru.map.CellPosition;
import fr.iut.tapawaru.map.Map;
import fr.iut.tapawaru.team.Character;

/**
 * Movements.
 * One movement is an action, just as a spell.
 * In fact, there's only one possible movement: towards an adjacent box.
 * This class only exists to add other possible movements if necessary.
 * 
 * @authors CEARD, MATHEY, MOUNIER, 
 * @authors PELLOUX-PRAYER, PRADELLE
 */
public class Move extends Action
{
	public static void simpleMove(Map map, Character pers, CellPosition target)
	{
		int deltaX = Math.abs(pers.getCellTraveled().getPosition().getPositionX() - target.getPositionX());
		int deltaY = Math.abs(pers.getCellTraveled().getPosition().getPositionY() - target.getPositionY());
		
		if (map.getTeamController().deduct(deltaX + deltaY))
				map.moveCharacter(pers, target);
	}
}
