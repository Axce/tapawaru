package fr.iut.tapawaru.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import fr.iut.tapawaru.action.Terra;
import fr.iut.tapawaru.team.Character;
import fr.iut.tapawaru.team.TeamColor;

public class BottomPlayer extends JPanel implements ActionListener
{

	private BufferedImage apLeft5;
	private BufferedImage apLeft4;
	private BufferedImage apLeft3;
	private BufferedImage apLeft2;
	private BufferedImage apLeft0;
	private BufferedImage apLeft1;

	private JButton selectChamp;
	private Character character;
	private TeamColor teamColor;

	public BottomPlayer(TeamColor color, fr.iut.tapawaru.team.Character character)
	{
//		try
//		{
//			this.apLeft4 = ImageIO.read(new File("img/players/apLeft4.png"));
//			this.apLeft3 = ImageIO.read(new File("img/players/apLeft3.png"));
//			this.apLeft2 = ImageIO.read(new File("img/players/apLeft2.png"));
//			this.apLeft1 = ImageIO.read(new File("img/players/apLeft1.png"));
//			this.apLeft0 = ImageIO.read(new File("img/players/apLeft0.png"));
//			this.apLeft5 = ImageIO.read(new File("img/players/apLeft5.png"));
//		} catch (IOException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Image tmp = null;
		try
		{
			tmp = ImageIO.read(new File("img/botScreen/right.png"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(tmp,750, 0, this);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if (source == this.selectChamp)
		{	
			this.character.getMap().getMapGui().paintGivenCell(this.character.getCellTraveled().getPosition(),this.teamColor + "Selected");
			this.character.getMap().getMapGui().setSelectedCharacterPosition(this.character.getCellTraveled().getPosition());
		}// TODO Auto-generated method stub
	
	}
}
