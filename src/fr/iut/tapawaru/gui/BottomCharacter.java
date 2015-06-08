package fr.iut.tapawaru.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BottomCharacter extends JPanel
{
	private Image left;

	public BottomCharacter()
	{
		try
		{
			this.left = ImageIO.read(new File("img/botScreen/left.png"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g) {
        g.drawImage(this.left, 0, 0, null);
 
    }
}
