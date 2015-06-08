package fr.iut.tapawaru.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

import fr.iut.tapawaru.action.Terra;
import fr.iut.tapawaru.map.Map;
/**
 * 
 * @author Akroz
 * @deprecated 
 */
public class MyKeyListener implements KeyListener
{
	private Map map;
	private BottomPanel botPanel;
	private MapGUI mapGui;
	
	private JButton glyphCWspin;
	private JButton glyphCCWspin;
	private JButton glyphRandom;
	private JButton glyphShift;

	public MyKeyListener(Map map)
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
			this.botPanel.paint(this.botPanel.getGraphics());

		}
		if (source == this.glyphCCWspin)
		{
			Terra.glyphCCWspin(this.map, map.getSelectedCell().getPosition());
			this.mapGui.printGlyph(this.mapGui.getGraphics());
			this.mapGui.changeCellState(map.getSelectedCell().getPosition().getPositionX(), map.getSelectedCell().getPosition()
					.getPositionY());
			this.botPanel.paint(this.botPanel.getGraphics());

		}
		if (source == this.glyphRandom)
		{
			Terra.glyphRandom(this.map, map.getSelectedCell().getPosition());
			this.mapGui.printGlyph(this.mapGui.getGraphics());
			this.mapGui.changeCellState(map.getSelectedCell().getPosition().getPositionX(), map.getSelectedCell().getPosition()
					.getPositionY());
			this.botPanel.paint(this.botPanel.getGraphics());
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

	
	@Override
	public void keyPressed(KeyEvent arg0)
	{
		if		
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	

}
