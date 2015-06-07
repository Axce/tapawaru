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
		int[] mapSize = new int[2]; 
		mapSize[0] =this.map.getXSize()*DEFAULT_OCTO_SIZE;
		mapSize[1] =this.map.getYSize()*DEFAULT_OCTO_SIZE;
		return mapSize;
	}
	
	public void printCell(Graphics g)
	{
		for (int xSize = 0; xSize < this.map.getXSize(); xSize++) {
			for (int ySize = 0; ySize < this.map.getYSize(); ySize++) {

				g.drawImage(this.octo, xSize * DEFAULT_OCTO_SIZE, ySize
						* DEFAULT_OCTO_SIZE, this);
				
				if(!(this.map.getCharacter(xSize,ySize) ==null) )
				{
					Image imageBuffer = null;
					
					try
					{
						imageBuffer = ImageIO.read(new File(this.map.getCharacter(xSize, ySize).toString()));
					} catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					g.drawImage(imageBuffer, xSize * DEFAULT_OCTO_SIZE, ySize
							* DEFAULT_OCTO_SIZE, this);
					
				}

			}

		}
	}
	
	public void printGlyph(Graphics g)
	{
		for (int xSize = 0; xSize < this.map.getXSize()+1; xSize++) {
			for (int ySize = 0; ySize < this.map.getYSize()+1; ySize++) {

				if(this.map.getTypeOfGlyph(new GlyphPosition(xSize, ySize))==TypeGlyph.FIRE)
				{
					g.drawImage(glyphFire, xSize * DEFAULT_OCTO_SIZE-15, ySize
							* DEFAULT_OCTO_SIZE-15, this);
				}
				if(this.map.getTypeOfGlyph(new GlyphPosition(xSize, ySize))==TypeGlyph.AIR)
				{
					g.drawImage(glyphAir, xSize * DEFAULT_OCTO_SIZE-15, ySize
							* DEFAULT_OCTO_SIZE-15, this);
				}
				if(this.map.getTypeOfGlyph(new GlyphPosition(xSize, ySize))==TypeGlyph.EARTH)
				{
					g.drawImage(glyphEarth, xSize * DEFAULT_OCTO_SIZE-15, ySize
							* DEFAULT_OCTO_SIZE-15, this);
				}
				if(this.map.getTypeOfGlyph(new GlyphPosition(xSize, ySize))==TypeGlyph.ICE)
				{
					g.drawImage(glyphIce, xSize * DEFAULT_OCTO_SIZE-15, ySize
							* DEFAULT_OCTO_SIZE-15, this);
				}
				if(this.map.getTypeOfGlyph(new GlyphPosition(xSize, ySize))==TypeGlyph.THUNDER)
				{
					g.drawImage(glyphThunder, xSize * DEFAULT_OCTO_SIZE-15, ySize
							* DEFAULT_OCTO_SIZE-15, this);
				}
				if(this.map.getTypeOfGlyph(new GlyphPosition(xSize, ySize))==TypeGlyph.WATER)
				{
					g.drawImage(glyphWater, xSize * DEFAULT_OCTO_SIZE-15, ySize
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
