package fr.iut.tapawaru;

import fr.iut.tapawaru.action.Attack;
import fr.iut.tapawaru.action.Move;
import fr.iut.tapawaru.gui.MainFrame;
import fr.iut.tapawaru.map.CellPosition;
import fr.iut.tapawaru.map.Map;
import fr.iut.tapawaru.team.Character;

/**
 * Class containing main
 * 
 * @authors CEARD, MATHEY, MOUNIER, 
 * @authors PELLOUX-PRAYER, PRADELLE
 */
public class Main
{
	public static MainFrame mainFrame;
	public static void main(String[] args)
	{
		Map map = new Map();
		mainFrame = new MainFrame(map);
		System.out.println(map);
	}
	
	
}
