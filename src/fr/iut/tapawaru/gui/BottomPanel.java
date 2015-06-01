package fr.iut.tapawaru.gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BottomPanel extends JPanel
{
	public BottomPanel()
	{
		JLabel picLabel = new JLabel(new ImageIcon("img/botScreenBackground.png"));
		this.add(picLabel );

		//this.add(new JButton("haha"));
	}
	
}
