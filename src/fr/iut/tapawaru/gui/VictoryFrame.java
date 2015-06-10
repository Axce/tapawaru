package fr.iut.tapawaru.gui;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		this.setTitle("Victory");
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JLabel imageVictory;
		if(team == null)
		{
			imageVictory = new JLabel( new ImageIcon( "img/win/winNull.png"));
		}else{
			imageVictory = new JLabel( new ImageIcon( "img/win/"+ team.getColorTeam()+".png"));
		}
		
		panel.add(imageVictory);
		this.add(panel);
		this.pack();
	}
	
}
