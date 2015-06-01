package fr.iut.tapawaru.gui;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BottomPanel extends JPanel
{
	private Image background;
	public BottomPanel()
	{
		//JLabel picLabel = new JLabel(new ImageIcon("img/botScreenBackground.png"));
		try
		{
			this.background = ImageIO.read(new File("img/botScreenBackground.png"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.add(picLabel );
		GridBagLayout myGrid = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(myGrid);
		
		c.fill = GridBagConstraints.BOTH;
		c.ipady = 0;
		c.weightx = 100;
		c.weighty = 50;
		c.gridwidth = 1;
		c.gridheight =5;
		c.gridx = 0;
		c.gridy = 0;
		this.add(new JButton("A"),c);
		
		c.fill = GridBagConstraints.CENTER;
		c.ipady = 0;
		c.weightx = 200;
		c.gridwidth = 1;
		c.gridheight =1 ;
		c.gridx = 1;
		c.gridy = 0;
		this.add(new JButton("B"),c);
		
		c.fill = GridBagConstraints.CENTER;
		c.ipady = 0;
		c.weightx = 150;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridheight =1 ;
		c.gridx = 2;
		c.gridy = 0;
		this.add(new JButton("haha"),c);
		
		c.fill = GridBagConstraints.CENTER;
		c.ipady = 0;
		c.weightx = 150;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridheight =1 ;
		c.gridx = 2;
		c.gridy = 1;
		this.add(new JButton("C"),c);
		
		
		
	}
	
	public void paintComponent(Graphics g) {
        g.drawImage(this.background, 0, 0, null);
    }
}
