package fr.iut.tapawaru;

import fr.iut.tapawaru.gui.MainFrame;
import fr.iut.tapawaru.map.Map;

/**
 * Class containing main
 * 
 * @authors CEARD, MATHEY, MOUNIER, 
 * @authors PELLOUX-PRAYER, PRADELLE
 */
public class Main
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Map map = new Map();
		MainFrame mainFrame = new MainFrame(map);
		System.out.println(map);
		
	}
	
}
