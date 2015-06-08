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
	public void simpleMove(Map map, Character pers, CellPosition target)
	{
		int deltaX = Math.abs(pers.getCellTraveled().getPosition().getPositionX() - target.getPositionX());
		int deltaY = Math.abs(pers.getCellTraveled().getPosition().getPositionY() - target.getPositionY());
		
		if (deltaX + deltaY == 1)
		{
			map.moveCharacter(pers, target);
			map.getTeamController().deduct(1);
		}
		else
		{
			//TODO bouger le perso de plusieurs cases puis soustraire les PA
		}
	}
}
