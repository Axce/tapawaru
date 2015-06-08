package fr.iut.tapawaru.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomPanel extends JPanel
{
	private JButton terraButton;
	private JButton terraButton2;

	public BottomPanel(MyButtonListener listener)
	{
		GridBagLayout myGrid = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(myGrid);
	
		this.terraButton = new JButton("terraButton");
//		BottomPanel botPanel = new BottomPanel();
		terraButton.setPreferredSize(new Dimension(220,250));
		c.fill = GridBagConstraints.BOTH;
		c.ipady = 0;
		c.weightx = 0;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		terraButton.addActionListener(listener);
		terraButton.setEnabled(false);
		listener.setTerraButton(terraButton);
		this.add(terraButton,c);
		
		 this.terraButton2 = new JButton("terraButton2");
		c.fill = GridBagConstraints.VERTICAL;
		c.ipady = 0;
		c.weightx = 0;
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 1;
		terraButton2.addActionListener(listener);
		this.add(terraButton2,c);

	}

	public JButton getTerraButton()
	{
		return this.terraButton;
	}
 
}
