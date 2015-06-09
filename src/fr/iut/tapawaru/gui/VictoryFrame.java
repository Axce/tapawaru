package fr.iut.tapawaru.gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import fr.iut.tapawaru.map.Map;
import fr.iut.tapawaru.team.Team;

public class VictoryFrame extends JFrame
{
	public VictoryFrame(Map map, Team team)
	{
		//Main.mainFrame.dispose();
		this.setTitle("Tapawaru");
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	
}
