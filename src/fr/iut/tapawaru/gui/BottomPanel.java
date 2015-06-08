package fr.iut.tapawaru.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

import fr.iut.tapawaru.map.Map;

public class BottomPanel extends JPanel
{
	private JButton glyphCWspin;
	private JButton glyphCCWspin;
	private JButton glyphRandom;

	private Image apLeft5;
	private Image apLeft4;
	private Image apLeft3;
	private Image apLeft2;
	private Image apLeft0;
	private Image apLeft1;

	private Map map;

	public BottomPanel(MyButtonListener listener, Map map)
	{
		GridBagLayout myGrid = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(myGrid);

		this.glyphCWspin = new JButton("glyphCWspin");
		// glyphCWspin.setPreferredSize(new Dimension(220,250));
		c.fill = GridBagConstraints.BOTH;
		c.ipady = 0;
		c.weightx = 0;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		glyphCWspin.addActionListener(listener);
		glyphCWspin.setEnabled(false);
		listener.setGlyphCWspinButton(glyphCWspin);
		this.add(glyphCWspin, c);

		this.glyphCCWspin = new JButton("glyphCCWspin");
		c.fill = GridBagConstraints.VERTICAL;
		c.fill = GridBagConstraints.BOTH;
		c.ipady = 0;
		c.weightx = 0;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 0;
		glyphCCWspin.addActionListener(listener);
		glyphCCWspin.setEnabled(false);
		listener.setGlyphCCWspinButton(glyphCCWspin);
		this.add(glyphCCWspin, c);

		this.glyphRandom = new JButton("glyphRandom");
		c.fill = GridBagConstraints.VERTICAL;
		c.fill = GridBagConstraints.BOTH;
		c.ipady = 0;
		c.weightx = 0;
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 0;
		glyphRandom.addActionListener(listener);
		glyphRandom.setEnabled(false);
		listener.setGlyphRandomButton(glyphRandom);
		this.add(glyphRandom, c);

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

		this.map = map;
	}

	public JButton getGlyphCWspin()
	{
		return this.glyphCWspin;
	}

	public JButton getGlyphCCWspin()
	{
		return this.glyphCCWspin;
	}

	public JButton getGlyphRandom()
	{
		return this.glyphRandom;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		Image tmp = null;
		switch (this.map.getTeamController().getPlayingTeam().getActionPointsLeft())
		{
		case 0:
			tmp = apLeft0;
			break;
		case 1:
			tmp = apLeft1;
			break;
		case 2:
			tmp = apLeft2;
			break;
		case 3:
			tmp = apLeft3;
			break;
		case 4:
			tmp = apLeft4;
			break;
		case 5:
			tmp = apLeft5;
			break;
		}

		g.drawImage(tmp, 0, 0, this);
		try
		{
			tmp = ImageIO.read(new File("img/players/"+this.map.getTeamController().getPlayingTeam().getColorTeam()+".png"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(tmp, 0, 100, this);
	}
}
