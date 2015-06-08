package fr.iut.tapawaru.gui;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomPlayer extends JPanel
{

	private BufferedImage apLeft5;
	private BufferedImage apLeft4;
	private BufferedImage apLeft3;
	private BufferedImage apLeft2;
	private BufferedImage apLeft0;
	private BufferedImage apLeft1;

	public BottomPlayer()
	{
		try
		{
			this.apLeft4 = ImageIO.read(new File("img/players/apLeft4.png"));
			this.apLeft3 = ImageIO.read(new File("img/players/apLeft3.png"));
			this.apLeft2 = ImageIO.read(new File("img/players/apLeft2.png"));
			this.apLeft1 = ImageIO.read(new File("img/players/apLeft1.png"));
			this.apLeft0 = ImageIO.read(new File("img/players/apLeft0.png"));
			this.apLeft5 = ImageIO.read(new File("img/players/apLeft5.png"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
