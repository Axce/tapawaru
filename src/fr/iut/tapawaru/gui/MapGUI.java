package fr.iut.tapawaru.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import fr.iut.tapawaru.map.GlyphPosition;
import fr.iut.tapawaru.map.Map;
import fr.iut.tapawaru.team.Character;
import fr.iut.tapawaru.map.TypeGlyph;


public class MapGUI extends JPanel {

	private static final int DEFAULT_OCTO_SIZE = 50;
	
	private Image octo;
	private Image glyphFire;
	private Image glyphAir;
	private Image glyphEarth;
	private Image glyphIce;
	private Image glyphThunder;
	private Image glyphWater;
	
	private Map map;

	public MapGUI(Map map) {
		try {
			this.octo = ImageIO.read(new File("img/octo.png"));
			this.glyphFire = ImageIO.read(new File("img/glyphFire.png"));
			this.glyphAir = ImageIO.read(new File("img/glyphAir.png"));
			this.glyphEarth = ImageIO.read(new File("img/glyphEarth.png"));
			this.glyphIce = ImageIO.read(new File("img/glyphIce.png"));
			this.glyphThunder = ImageIO.read(new File("img/glyphThunder.png"));
			this.glyphWater = ImageIO.read(new File("img/glyphWater.png"));
			
			this.map = map;
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public int[] guiMapSize()
	{
		int[] i = new int[2]; 
		i[0] =this.map.getLength()*DEFAULT_OCTO_SIZE;
		i[1] =this.map.getWidth()*DEFAULT_OCTO_SIZE;
		return i;
	}
	
	public void printCell(Graphics g)
	{
		for (int length = 0; length < this.map.getLength(); length++) {
			for (int width = 0; width < this.map.getWidth(); width++) {

				g.drawImage(this.octo, length * DEFAULT_OCTO_SIZE, width
						* DEFAULT_OCTO_SIZE, this);
				
				if(!(this.map.getCharacter(length,width) ==null) )
				{
					Image imageBuffer = null;
					
					try
					{
						imageBuffer = ImageIO.read(new File(this.map.getCharacter(length, width).toString()));
					} catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					g.drawImage(imageBuffer, length * DEFAULT_OCTO_SIZE, width
							* DEFAULT_OCTO_SIZE, this);
					
				}

			}

		}
	}
	
	public void printGlyph(Graphics g)
	{
		for (int length = 0; length < this.map.getLength()+1; length++) {
			for (int width = 0; width < this.map.getWidth()+1; width++) {

				if(this.map.getTypeOfGlyph(new GlyphPosition(length, width))==TypeGlyph.FIRE)
				{
					g.drawImage(glyphFire, length * DEFAULT_OCTO_SIZE-15, width
							* DEFAULT_OCTO_SIZE-15, this);
				}
				if(this.map.getTypeOfGlyph(new GlyphPosition(length, width))==TypeGlyph.AIR)
				{
					g.drawImage(glyphAir, length * DEFAULT_OCTO_SIZE-15, width
							* DEFAULT_OCTO_SIZE-15, this);
				}
				if(this.map.getTypeOfGlyph(new GlyphPosition(length, width))==TypeGlyph.EARTH)
				{
					g.drawImage(glyphEarth, length * DEFAULT_OCTO_SIZE-15, width
							* DEFAULT_OCTO_SIZE-15, this);
				}
				if(this.map.getTypeOfGlyph(new GlyphPosition(length, width))==TypeGlyph.ICE)
				{
					g.drawImage(glyphIce, length * DEFAULT_OCTO_SIZE-15, width
							* DEFAULT_OCTO_SIZE-15, this);
				}
				if(this.map.getTypeOfGlyph(new GlyphPosition(length, width))==TypeGlyph.THUNDER)
				{
					g.drawImage(glyphThunder, length * DEFAULT_OCTO_SIZE-15, width
							* DEFAULT_OCTO_SIZE-15, this);
				}
				if(this.map.getTypeOfGlyph(new GlyphPosition(length, width))==TypeGlyph.WATER)
				{
					g.drawImage(glyphWater, length * DEFAULT_OCTO_SIZE-15, width
							* DEFAULT_OCTO_SIZE-15, this);
				}

			}

		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		this.printCell(g);
		this.printGlyph(g);
	}
}
