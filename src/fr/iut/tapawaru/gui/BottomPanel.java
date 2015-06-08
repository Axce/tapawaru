package fr.iut.tapawaru.gui;

import java.awt.Color;
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
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;

public class BottomPanel extends JPanel
{
	private Image background;
	private Image left;

	public BottomPanel()
	{
		//JLabel picLabel = new JLabel(new ImageIcon("img/botScreenBackground.png"));
		try
		{
			this.background = ImageIO.read(new File("img/botScreen/background.png"));
			this.left = ImageIO.read(new File("img/botScreen/left.png"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.add(picLabel );
		GridBagLayout myGrid = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(myGrid);
		
//		c.fill = GridBagConstraints.BOTH;
//		c.ipady = 0;
//		c.weightx = 100;
//		c.weighty = 50;
//		c.gridwidth = 1;
//		c.gridheight =5;
//		c.gridx = 0;
//		c.gridy = 0;
//		this.add(new JButton("A"),c);
//		
//		c.fill = GridBagConstraints.VERTICAL;
//		c.ipadx = 10;
//		c.weightx = 200;
//		c.gridwidth = 1;
//		c.gridheight =0 ;
//		c.gridx = 0;
//		c.gridy = 0;
//		JProgressBar progressBar;
//		progressBar = new JProgressBar(0, 100);
//		progressBar.setValue(50);
//		progressBar.setStringPainted(true);
//		progressBar.setString("50 HP");
//		progressBar.setBackground(Color.BLACK);
//		progressBar.setForeground(Color.RED);
//		this.add(progressBar);
		
		JPanel panel1 = new BottomCharacter();
		JPanel panel2= new BottomCharacter();
		JPanel panel3= new BottomCharacter();

		panel1.add(new JButton("aa"));
		panel2.add(new JButton("aa"));
		panel3.add(new JButton("aa"));
		
		c.fill = GridBagConstraints.CENTER;
		c.ipady = 0;
		c.weightx = 150;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridheight =1 ;
		c.gridx = 2;
		c.gridy = 0;
		this.add(panel1,c);
		
		c.fill = GridBagConstraints.CENTER;
		c.ipady = 0;
		c.weightx = 150;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridheight =1 ;
		c.gridx = 2;
		c.gridy = 1;
		this.add(panel2,c);
		
		
		
	}
	
	public void paintComponent(Graphics g) {
        g.drawImage(this.background, 0, 0, null);
 
    }
}
