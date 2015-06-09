package fr.iut.tapawaru.gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import fr.iut.tapawaru.map.Map;
import fr.iut.tapawaru.team.Team;

/**
 * Create the Victory Frame.
 * @author jpelloux
 *
 */
public class VictoryFrame extends JFrame
{
	/**
	 * Constructor for victory of one team.
	 * If winner team is null is an equality.
	 * @param map Map of the game which is win.
	 * @param team The winner team. 
	 */
	public VictoryFrame(Map map, Team team)
	{
		//Main.mainFrame.dispose();
		this.setTitle("Tapawaru");
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
}
