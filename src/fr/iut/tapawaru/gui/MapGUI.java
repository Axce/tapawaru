package fr.iut.tapawaru.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import fr.iut.tapawaru.map.Cell;
import fr.iut.tapawaru.map.CellPosition;
import fr.iut.tapawaru.map.GlyphPosition;
import fr.iut.tapawaru.map.Map;
import fr.iut.tapawaru.team.Buff;
import fr.iut.tapawaru.map.TypeGlyph;

public class MapGUI extends JPanel implements MouseListener
{
	/* ****************************************ATTRIBUTS******************************************** */
			/* *****************************Images size******************* */
	private static final int DEFAULT_OCTO_SIZE = 50;

			/* *****************************Images******************* */
	private Image octo;
	private Image octoSelected;

	private Image glyphFire;
	private Image glyphAir;
	private Image glyphEarth;
	private Image glyphIce;
	private Image glyphThunder;
	private Image glyphWater;
	private Image glyphHoly;
	private Image glyphDark;
	private Image glyphPattern;

			/* *****************************Utility******************* */
	private Map map;
	private Cell selectedCell;
	private BottomPanel botPanel;
	private CellPosition selectedCharacterPosition;

	/* ****************************************CONSTRUCTORS******************************************** */
	public MapGUI(Map map)
	{
		try
		{
			this.octo = ImageIO.read(new File("img/octo.png"));
			this.octoSelected = ImageIO.read(new File("img/octoSelected.png"));

			this.glyphFire = ImageIO.read(new File("img/glyphFire.png"));
			this.glyphAir = ImageIO.read(new File("img/glyphAir.png"));
			this.glyphEarth = ImageIO.read(new File("img/glyphEarth.png"));
			this.glyphIce = ImageIO.read(new File("img/glyphIce.png"));
			this.glyphThunder = ImageIO.read(new File("img/glyphThunder.png"));
			this.glyphWater = ImageIO.read(new File("img/glyphWater.png"));
			this.glyphHoly = ImageIO.read(new File("img/glyphHoly.png"));
			this.glyphDark = ImageIO.read(new File("img/glyphDark.png"));
			this.glyphPattern = ImageIO.read(new File("img/glyphPattern.png"));

			this.addMouseListener(this);

			this.map = map;
			this.botPanel = null;
			this.selectedCell = this.map.getSelectedCell();
			this.selectedCharacterPosition = null;
			this.map.setMapGui(this);
		} catch (IOException e)
		{
			e.printStackTrace();

		}

	}

	/* ****************************************GETTERS / SETTERS *************************************** */
	public void setSelectedCharacterPosition(CellPosition position)
	{
		if (!(this.selectedCharacterPosition == null))
			printCharacter(this.getGraphics(), this.selectedCharacterPosition.getPositionX(), this.selectedCharacterPosition.getPositionY());
		this.selectedCharacterPosition = position;
	}

	public BottomPanel getBottomPanel()
	{
		return this.botPanel;
	}
	
	public int[] guiMapSize()
	{
		int[] mapSize = new int[2];
		mapSize[0] = this.map.getXSize() * DEFAULT_OCTO_SIZE;
		mapSize[1] = this.map.getYSize() * DEFAULT_OCTO_SIZE;
		return mapSize;
	}
	
	public void addBotPanel(BottomPanel botPanel)
	{
		this.botPanel = botPanel;
		this.addKeyListener(this.botPanel);
	}

	/* ****************************************MAP DISPLAY TOOLS******************************************** */

				/* *****************************Cells******************* */
	public void paintGivenCell(CellPosition position, String picture)
	{
		this.getGraphics().drawImage(this.octo, position.getPositionX() * DEFAULT_OCTO_SIZE, position.getPositionY() * DEFAULT_OCTO_SIZE,
				this);

		printCharacter(this.getGraphics(), position.getPositionX(), position.getPositionY(), picture);

	}
	
	public void paintGivenCell(CellPosition position, Image img)
	{
		this.getGraphics().drawImage(img, position.getPositionX() * DEFAULT_OCTO_SIZE, position.getPositionY() * DEFAULT_OCTO_SIZE, this);

		printCharacter(this.getGraphics(), position.getPositionX(), position.getPositionY());

	}
	
	public void changeCellState(int xSize, int ySize)
	{
		boolean goSelected = true;

		if (!(this.selectedCell == null))
		{

			this.getGraphics().drawImage(this.octo, this.selectedCell.getPosition().getPositionX() * DEFAULT_OCTO_SIZE,
					this.selectedCell.getPosition().getPositionY() * DEFAULT_OCTO_SIZE, this);
			this.map.getCell(new CellPosition(xSize, ySize)).setIsSelected(false);

			this.printCharacter(this.getGraphics(), selectedCell.getPosition().getPositionX(), selectedCell.getPosition().getPositionY());
			if ((this.selectedCell.getPosition().getPositionX() == xSize) && (this.selectedCell.getPosition().getPositionY() == ySize))
			{
				goSelected = false;
			}
			this.selectedCell = null;
			this.map.setSelectedCell(null);

			this.botPanel.paintTerraStateUnselected(botPanel.getGraphics());
		}

		if (goSelected)
		{
			this.getGraphics().drawImage(this.octoSelected, xSize * DEFAULT_OCTO_SIZE, ySize * DEFAULT_OCTO_SIZE, this);
			this.map.getCell(new CellPosition(xSize, ySize)).setIsSelected(true);
			this.selectedCell = this.map.getCell(new CellPosition(xSize, ySize));
			this.map.setSelectedCell(this.map.getCell(new CellPosition(xSize, ySize)));

			this.botPanel.paintTerraStateSelected(botPanel.getGraphics());
		}

		if (!(this.map.getCharacter(xSize, ySize) == null))
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

			this.getGraphics().drawImage(imageBuffer, xSize * DEFAULT_OCTO_SIZE, ySize * DEFAULT_OCTO_SIZE, this);
		}
	}

	public void printCell(Graphics g)
	{
		for (int xSize = 0; xSize < this.map.getXSize(); xSize++)
		{
			for (int ySize = 0; ySize < this.map.getYSize(); ySize++)
			{
				g.drawImage(this.octo, xSize * DEFAULT_OCTO_SIZE, ySize * DEFAULT_OCTO_SIZE, this);

				printCharacter(g, xSize, ySize);
			}

		}
	}

				/* *****************************Glyphs******************* */
	public void printGlyph(Graphics g)
	{
		for (int xSize = 0; xSize < this.map.getXSize() + 1; xSize++)
		{
			for (int ySize = 0; ySize < this.map.getYSize() + 1; ySize++)
			{

				if (this.map.getTypeOfGlyph(new GlyphPosition(xSize, ySize)) == TypeGlyph.FIRE)
				{
					g.drawImage(glyphFire, xSize * DEFAULT_OCTO_SIZE - 15, ySize * DEFAULT_OCTO_SIZE - 15, this);
				}
				if (this.map.getTypeOfGlyph(new GlyphPosition(xSize, ySize)) == TypeGlyph.AIR)
				{
					g.drawImage(glyphAir, xSize * DEFAULT_OCTO_SIZE - 15, ySize * DEFAULT_OCTO_SIZE - 15, this);
				}
				if (this.map.getTypeOfGlyph(new GlyphPosition(xSize, ySize)) == TypeGlyph.EARTH)
				{
					g.drawImage(glyphEarth, xSize * DEFAULT_OCTO_SIZE - 15, ySize * DEFAULT_OCTO_SIZE - 15, this);
				}
				if (this.map.getTypeOfGlyph(new GlyphPosition(xSize, ySize)) == TypeGlyph.ICE)
				{
					g.drawImage(glyphIce, xSize * DEFAULT_OCTO_SIZE - 15, ySize * DEFAULT_OCTO_SIZE - 15, this);
				}
				if (this.map.getTypeOfGlyph(new GlyphPosition(xSize, ySize)) == TypeGlyph.THUNDER)
				{
					g.drawImage(glyphThunder, xSize * DEFAULT_OCTO_SIZE - 15, ySize * DEFAULT_OCTO_SIZE - 15, this);
				}
				if (this.map.getTypeOfGlyph(new GlyphPosition(xSize, ySize)) == TypeGlyph.WATER)
				{
					g.drawImage(glyphWater, xSize * DEFAULT_OCTO_SIZE - 15, ySize * DEFAULT_OCTO_SIZE - 15, this);
				}
				if (this.map.getTypeOfGlyph(new GlyphPosition(xSize, ySize)) == TypeGlyph.HOLY)
				{
					g.drawImage(glyphHoly, xSize * DEFAULT_OCTO_SIZE - 15, ySize * DEFAULT_OCTO_SIZE - 15, this);
				}
				if (this.map.getTypeOfGlyph(new GlyphPosition(xSize, ySize)) == TypeGlyph.DARK)
				{
					g.drawImage(glyphDark, xSize * DEFAULT_OCTO_SIZE - 15, ySize * DEFAULT_OCTO_SIZE - 15, this);
				}

				g.drawImage(glyphPattern, xSize * DEFAULT_OCTO_SIZE - 15, ySize * DEFAULT_OCTO_SIZE - 15, this);

			}

		}
	}

				/* *****************************Characters******************* */
	public void printCharacter(Graphics g, int xSize, int ySize, String picture)
	{
		if (!(this.map.getCharacter(xSize, ySize) == null))
		{
			Image imageBuffer = null;

			try
			{
				imageBuffer = ImageIO
						.read(new File("img/perso/" + picture + this.map.getCharacter(xSize, ySize).getHealthPoint() + ".png"));
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			g.drawImage(imageBuffer, xSize * DEFAULT_OCTO_SIZE, ySize * DEFAULT_OCTO_SIZE, this);
			paintBuff(g, xSize, ySize);
		}
	}
	
	private void printCharacter(Graphics g, int xSize, int ySize)
	{
		if (!(this.map.getCharacter(xSize, ySize) == null))
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

			g.drawImage(imageBuffer, xSize * DEFAULT_OCTO_SIZE, ySize * DEFAULT_OCTO_SIZE, this);

			paintBuff(g, xSize, ySize);
		}
	}

	private void paintBuff(Graphics g, int xSize, int ySize)
	{
		Image imageBuffer = null;
		if (!(this.map.getCharacter(xSize, ySize).getBuff() == null))
		{
			switch (this.map.getCharacter(xSize, ySize).getBuff())
			{
			case BURNING:
				try
				{
					imageBuffer = ImageIO.read(new File("img/perso/buffBurning.png"));
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case FREEZING:
				try
				{
					imageBuffer = ImageIO.read(new File("img/perso/buffFreezing.png"));
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
				break;
			default:
			}
			g.drawImage(imageBuffer, xSize * DEFAULT_OCTO_SIZE, ySize * DEFAULT_OCTO_SIZE, this);
		}
	}

				/* *****************************Components******************* */	
	@Override
	public void paintComponent(Graphics g)
	{
		this.printCell(g);
		this.printGlyph(g);
	}

	public void paintComponent()
	{
		this.printCell(this.getGraphics());
		this.printGlyph(this.getGraphics());
	}
	
	/* ****************************************ANIMATION DISPLAY******************************************** */
	
	public void spellAnimation(ArrayList<CellPosition> posList, TypeGlyph typeGlyph)
	{
		Image tmp = null;
		for (int indexPict = 1; indexPict < 6; indexPict++)
		{
			try
			{
				tmp = ImageIO.read(new File("img/spells/" + typeGlyph.toString() + indexPict + ".png"));
			} catch (IOException k)
			{
				// TODO Auto-generated catch block
				k.printStackTrace();
			}
			for (CellPosition cellpos : posList)
			{

				this.paintGivenCell(cellpos, tmp);
			}

			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void buffAnimation(Cell cellTraveled, Buff buff)
	{
		Image tmp = null;
		for (int indexPict = 1; indexPict < 6; indexPict++)
		{
			try
			{
				tmp = ImageIO.read(new File("img/spells/" + buff.toString() + indexPict + ".png"));
			} catch (IOException k)
			{
				// TODO Auto-generated catch block
				k.printStackTrace();
			}

			this.paintGivenCell(cellTraveled.getPosition(), tmp);

			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.paintGivenCell(cellTraveled.getPosition(), this.octo);
	}

	/* ****************************************MOUSE LISTENER******************************************** */

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		this.changeCellState((int) e.getX() / 50, (int) e.getY() / 50);
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

}
