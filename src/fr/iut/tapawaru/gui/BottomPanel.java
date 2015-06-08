package fr.iut.tapawaru.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomPanel extends JPanel
{
	private JButton glyphCWspin;
	private JButton glyphCCWspin;
	private JButton glyphRandom;

	public BottomPanel(MyButtonListener listener)
	{
		GridBagLayout myGrid = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(myGrid);
	
		this.glyphCWspin = new JButton("glyphCWspin");
//		glyphCWspin.setPreferredSize(new Dimension(220,250));
		c.fill = GridBagConstraints.BOTH;
		c.ipady = 0;
		c.weightx = 0;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		glyphCWspin.addActionListener(listener);
		glyphCWspin.setEnabled(false);
		listener.setGlyphCWspinButton(glyphCWspin);
		this.add(glyphCWspin,c);
		
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
		this.add(glyphCCWspin,c);
		
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
		this.add(glyphRandom,c);

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
}
