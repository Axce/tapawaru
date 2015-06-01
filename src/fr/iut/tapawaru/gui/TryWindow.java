package fr.iut.tapawaru.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.omg.CORBA.portable.RemarshalException;

public class TryWindow {

	public static void main(String[] args) {
		JFrame frameTry = new JFrame();
		frameTry.setTitle("hahah");
		
		JPanel myPane = new JPanel();
		GridBagLayout myGrid = new GridBagLayout();
		
		GridBagConstraints c = new GridBagConstraints();
		frameTry.setLayout(myGrid);
//		for(int i =0 ; i <3;i++)
//		{
//			JLabel image = new JLabel(new ImageIcon( "random"+i+".jpg") );
//			myPane.add(image);
//		}
		
		MapGUI map = new MapGUI();
		map.setPreferredSize(new Dimension(400, 400));
		c.fill = GridBagConstraints.BOTH;
		c.ipady =0 ;
		c.weightx = 0;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		frameTry.add(map,c);
		
		JButton exit = new JButton("Exit");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 200;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		frameTry.add(exit, c);

		JButton loadMap = new JButton("LoadMap");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 200;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		frameTry.add(loadMap, c);
		
	//	frameTry.add(myPane);
		frameTry.pack();
		//frameTry.setResizable(false);
		frameTry.setVisible(true);

	}

}
