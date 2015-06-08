package fr.iut.tapawaru.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.iut.tapawaru.action.Terra;
import fr.iut.tapawaru.map.Map;

public class MyButtonListener implements ActionListener
{
	private Map map;
	private BottomPanel botPanel;
	private MapGUI mapGui;
	
	private JButton glyphCWspin;
	private JButton glyphCCWspin;
	private JButton glyphRandom;
	private JButton glyphShift;

	public MyButtonListener(Map map)
	{
		this.map = map;
		this.mapGui = null;

		this.glyphCWspin = null;
		this.glyphCCWspin = null;
		this.glyphRandom = null;
		this.glyphShift = null;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if (source == this.glyphCWspin)
		{
			Terra.glyphCWspin(this.map, map.getSelectedCell().getPosition());
			this.mapGui.printGlyph(this.mapGui.getGraphics());
			this.mapGui.changeCellState(map.getSelectedCell().getPosition().getPositionX(), map.getSelectedCell().getPosition()
					.getPositionY());
		}
		if (source == this.glyphCCWspin)
		{
			Terra.glyphCCWspin(this.map, map.getSelectedCell().getPosition());
			this.mapGui.printGlyph(this.mapGui.getGraphics());
			this.mapGui.changeCellState(map.getSelectedCell().getPosition().getPositionX(), map.getSelectedCell().getPosition()
					.getPositionY());
		}
		if (source == this.glyphRandom)
		{
			Terra.glyphRandom(this.map, map.getSelectedCell().getPosition());
			this.mapGui.printGlyph(this.mapGui.getGraphics());
			this.mapGui.changeCellState(map.getSelectedCell().getPosition().getPositionX(), map.getSelectedCell().getPosition()
					.getPositionY());
		}

	}

	public void addBotPanel(BottomPanel botPanel)
	{
		this.botPanel = botPanel;

	}

	public void addMapGui(MapGUI mapGui)
	{
		this.mapGui = mapGui;

	}

	public void setGlyphCWspinButton(JButton terraButton)
	{
		this.glyphCWspin = terraButton;
	}

	public void setGlyphCCWspinButton(JButton terraButton)
	{
		this.glyphCCWspin = terraButton;
	}

	public void setGlyphRandomButton(JButton terraButton)
	{
		this.glyphRandom = terraButton;
	}
	

}
