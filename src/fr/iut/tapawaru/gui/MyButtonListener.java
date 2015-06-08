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
	private JButton terraButton;
	
	
	
	public MyButtonListener(Map map)
	{
		this.map = map ;
		this.mapGui=null;
		
		this.terraButton = null;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == this.terraButton){
			Terra.GlyphCWspin(this.map, map.getSelectedCell().getPosition());
			this.mapGui.printGlyph(this.mapGui.getGraphics());
			this.mapGui.changeCellState(map.getSelectedCell().getPosition().getPositionX(), map.getSelectedCell().getPosition().getPositionY());
			

		} 
		

	}
	
	
	public void addBotPanel(BottomPanel botPanel)
	{
		this.botPanel= botPanel;
		
	}

	public void addMapGui(MapGUI mapGui)
	{
		this.mapGui= mapGui;
		
	}


	public void setTerraButton(JButton terraButton)
	{
		this.terraButton = terraButton;
		
	}
}
