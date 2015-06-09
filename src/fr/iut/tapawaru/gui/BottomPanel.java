package fr.iut.tapawaru.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import fr.iut.tapawaru.team.Character;







import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

import fr.iut.tapawaru.action.Attack;
import fr.iut.tapawaru.action.Move;
import fr.iut.tapawaru.action.Terra;
import fr.iut.tapawaru.map.CellPosition;
import fr.iut.tapawaru.map.Map;

public class BottomPanel extends JPanel implements KeyListener
{

	private Image apLeft5;
	private Image apLeft4;
	private Image apLeft3;
	private Image apLeft2;
	private Image apLeft0;
	private Image apLeft1;

	private Map map;
	private BottomPlayer[] team1Bottom;
	private BottomPlayer[] team2Bottom;

	private boolean caseSelected;
	private MapGUI mapGui;
	private Character characterSelected;
	private Image right;
	private Image hpBar;
	
	public BottomPanel(Map map)
	{
	try
		{
			this.apLeft4 = ImageIO.read(new File("img/players/apLeft4.png"));
			this.apLeft3 = ImageIO.read(new File("img/players/apLeft3.png"));
			this.apLeft2 = ImageIO.read(new File("img/players/apLeft2.png"));
			this.apLeft1 = ImageIO.read(new File("img/players/apLeft1.png"));
			this.apLeft0 = ImageIO.read(new File("img/players/apLeft0.png"));
			this.apLeft5 = ImageIO.read(new File("img/players/apLeft5.png"));
			
			this.right = ImageIO.read(new File("img/botScreen/right.png"));
			
			this.hpBar = ImageIO.read(new File("img/botScreen/hpBar.png"));

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//this.addKeyListener(this);
		this.map = map;
		this.caseSelected=false;
		this.mapGui = this.map.getMapGui();
//		this.team1Bottom = new BottomPlayer[this.map.getTeamController().getTeam1().getNbCharacter()];
//		for(int indexPlayer=0;indexPlayer < this.map.getTeamController().getTeam1().getNbCharacter(); indexPlayer++)
//		{
//			this.team1Bottom[indexPlayer] =this.map.getTeamController().getTeam1().getCharacter()[indexPlayer].getBottomPlayer();
//		}
//		
//		this.team2Bottom = new BottomPlayer[this.map.getTeamController().getTeam2().getNbCharacter()];
//		for(int indexPlayer=0;indexPlayer < this.map.getTeamController().getTeam2().getNbCharacter(); indexPlayer++)
//		{
//			this.team2Bottom[indexPlayer] =this.map.getTeamController().getTeam2().getCharacter()[indexPlayer].getBottomPlayer();	
//		}
//		
//		for(int indexPlayer=0;indexPlayer < this.map.getTeamController().getTeam1().getNbCharacter(); indexPlayer++)
//		{
//			this.add(this.team1Bottom[indexPlayer]);
//		}
//		for(int indexPlayer=0;indexPlayer < this.map.getTeamController().getTeam2().getNbCharacter(); indexPlayer++)
//		{
//			this.add(this.team2Bottom[indexPlayer]);
//		}
//		
//		this.chooseDisplayTeam();
//	}
//
//	public JButton getGlyphCWspin()
//	{
//		return this.glyphCWspin;
//	}
//
//	public JButton getGlyphCCWspin()
//	{
//		return this.glyphCCWspin;
//	}
//
//	public JButton getGlyphRandom()
//	{
//		return this.glyphRandom;
//	}
//
//	public void chooseDisplayTeam()
//	{
//		if(this.map.getTeamController().getPlayingTeam() == this.map.getTeamController().getTeam1())
//		{
//			for(int indexPlayer=0;indexPlayer < this.map.getTeamController().getTeam1().getNbCharacter(); indexPlayer++)
//			{
//				this.team1Bottom[indexPlayer].setVisible(true);
//			}
//			for(int indexPlayer=0;indexPlayer < this.map.getTeamController().getTeam2().getNbCharacter(); indexPlayer++)
//			{
//				this.team2Bottom[indexPlayer].setVisible(false);
//			}
//			System.out.println("team1");
//		}else{
//			for(int indexPlayer=0;indexPlayer < this.map.getTeamController().getTeam1().getNbCharacter(); indexPlayer++)
//			{
//				this.team1Bottom[indexPlayer].setVisible(false);
//			}
//			for(int indexPlayer=0;indexPlayer < this.map.getTeamController().getTeam2().getNbCharacter(); indexPlayer++)
//			{
//				this.team2Bottom[indexPlayer].setVisible(true);
//			}
//			System.out.println("team2");
//		}
//		System.out.println("yolo");
	}
	
	public void paintTerraStateSelected(Graphics g)
	{
		Image tmp = null;
		try
		{
			tmp = ImageIO.read(new File("img/botScreen/left2"+this.map.getTeamController().getPlayingTeam().getColorTeam()+"Selected.png"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(tmp, 0, 0, this);
		paintPA(g, tmp);
		this.caseSelected =true;

	}
	
	public void paintTerraStateUnselected(Graphics g)
	{
		Image tmp = null;
		try
		{
			tmp = ImageIO.read(new File("img/botScreen/left2"+this.map.getTeamController().getPlayingTeam().getColorTeam()+".png"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(tmp, 0, 0, this);
		paintPA(g, tmp);
		this.caseSelected =false;

	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		this.paintTerraStateUnselected(g);
		
		g.drawImage(right,375, 0, this);

		paintPA(g, right);
		
		this.printHp(g);

	}
	
	private void paintPA(Graphics g, Image tmp)
	{
		switch (this.map.getTeamController().getPlayingTeam().getActionPointsLeft())
		{
		case 0:
			tmp = apLeft0;
			break;
		case 1:
			tmp = apLeft1;
			break;
		case 2:
			tmp = apLeft2;
			break;
		case 3:
			tmp = apLeft3;
			break;
		case 4:
			tmp = apLeft4;
			break;
		case 5:
			tmp = apLeft5;
			break;
		}

		g.drawImage(tmp, 113, 130, this);
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(this.caseSelected)
		{
			
			switch (e.getKeyChar())
			{
			case 'w':
				Terra.glyphCWspin(this.map, map.getSelectedCell().getPosition());
				this.mapGui.printGlyph(this.mapGui.getGraphics());
				this.mapGui.changeCellState(map.getSelectedCell().getPosition().getPositionX(), map.getSelectedCell().getPosition()
						.getPositionY());
				this.paint(this.getGraphics());

				break;
			case 'x':
				Terra.glyphCCWspin(this.map, map.getSelectedCell().getPosition());
				this.mapGui.printGlyph(this.mapGui.getGraphics());
				this.mapGui.changeCellState(map.getSelectedCell().getPosition().getPositionX(), map.getSelectedCell().getPosition()
						.getPositionY());
				this.paint(this.getGraphics());
				break;
			case 'c':
				Terra.glyphRandom(this.map, map.getSelectedCell().getPosition());
				this.mapGui.printGlyph(this.mapGui.getGraphics());
				this.mapGui.changeCellState(map.getSelectedCell().getPosition().getPositionX(), map.getSelectedCell().getPosition()
						.getPositionY());
				this.paint(this.getGraphics());
				break;
			default:
			}	
		}
		switch (e.getKeyChar())
		{
		case 'a':
			if(!this.map.getTeamController().getPlayingTeam().getCharacter()[0].isAlive())
				break;
			if(this.characterSelected==null)
			{
				
				this.mapGui.paintGivenCell(this.map.getTeamController().getPlayingTeam().getCharacter()[0].getCellTraveled().getPosition(),this.map.getTeamController().getPlayingTeam().getColorTeam() + "Selected");
				this.characterSelected = this.map.getTeamController().getPlayingTeam().getCharacter()[0];
				this.mapGui.setSelectedCharacterPosition(this.map.getTeamController().getPlayingTeam().getCharacter()[0].getCellTraveled().getPosition());
				try
				{
					this.right = ImageIO.read(new File("img/botScreen/right0selected.png"));
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(this.characterSelected==this.map.getTeamController().getPlayingTeam().getCharacter()[0])
			{
				this.mapGui.paintGivenCell(this.map.getTeamController().getPlayingTeam().getCharacter()[0].getCellTraveled().getPosition(),this.map.getTeamController().getPlayingTeam().getColorTeam().toString());
				this.characterSelected = null;
				this.mapGui.setSelectedCharacterPosition(null);
				try
				{
					this.right = ImageIO.read(new File("img/botScreen/right.png"));
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}else
			{
				this.mapGui.paintGivenCell(this.characterSelected.getCellTraveled().getPosition(),this.map.getTeamController().getPlayingTeam().getColorTeam().toString());
				this.mapGui.paintGivenCell(this.map.getTeamController().getPlayingTeam().getCharacter()[0].getCellTraveled().getPosition(),this.map.getTeamController().getPlayingTeam().getColorTeam() + "Selected");
				this.characterSelected = this.map.getTeamController().getPlayingTeam().getCharacter()[0];
				this.mapGui.setSelectedCharacterPosition(this.map.getTeamController().getPlayingTeam().getCharacter()[0].getCellTraveled().getPosition());
				try
				{
					this.right = ImageIO.read(new File("img/botScreen/right0selected.png"));
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			this.repaint();
			//this.mapGui.setSelectedCharacterPosition(this.map.getTeamController().getPlayingTeam().getCharacter()[0].getCellTraveled().getPosition());
			break;
		case 'z':
			if(!this.map.getTeamController().getPlayingTeam().getCharacter()[1].isAlive())
				break;
			if(this.characterSelected==null)
			{
				this.mapGui.paintGivenCell(this.map.getTeamController().getPlayingTeam().getCharacter()[1].getCellTraveled().getPosition(),this.map.getTeamController().getPlayingTeam().getColorTeam() + "Selected");
				this.characterSelected = this.map.getTeamController().getPlayingTeam().getCharacter()[1];
				this.mapGui.setSelectedCharacterPosition(this.map.getTeamController().getPlayingTeam().getCharacter()[1].getCellTraveled().getPosition());
				try
				{
					this.right = ImageIO.read(new File("img/botScreen/right1selected.png"));
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(this.characterSelected==this.map.getTeamController().getPlayingTeam().getCharacter()[1])
			{
				this.mapGui.paintGivenCell(this.map.getTeamController().getPlayingTeam().getCharacter()[1].getCellTraveled().getPosition(),this.map.getTeamController().getPlayingTeam().getColorTeam().toString());
				this.characterSelected = null;
				this.mapGui.setSelectedCharacterPosition(null);
				try
				{
					this.right = ImageIO.read(new File("img/botScreen/right.png"));
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}else
			{
				this.mapGui.paintGivenCell(this.characterSelected.getCellTraveled().getPosition(),this.map.getTeamController().getPlayingTeam().getColorTeam().toString());
				this.mapGui.paintGivenCell(this.map.getTeamController().getPlayingTeam().getCharacter()[1].getCellTraveled().getPosition(),this.map.getTeamController().getPlayingTeam().getColorTeam() + "Selected");
				this.characterSelected = this.map.getTeamController().getPlayingTeam().getCharacter()[1];
				this.mapGui.setSelectedCharacterPosition(this.map.getTeamController().getPlayingTeam().getCharacter()[1].getCellTraveled().getPosition());
				try
				{
					this.right = ImageIO.read(new File("img/botScreen/right1selected.png"));
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			this.repaint();
			break;
		case 'e':
			if(!this.map.getTeamController().getPlayingTeam().getCharacter()[2].isAlive())
				break;
			if(this.characterSelected==null)
			{
				this.mapGui.paintGivenCell(this.map.getTeamController().getPlayingTeam().getCharacter()[2].getCellTraveled().getPosition(),this.map.getTeamController().getPlayingTeam().getColorTeam() + "Selected");
				this.characterSelected = this.map.getTeamController().getPlayingTeam().getCharacter()[2];
				this.mapGui.setSelectedCharacterPosition(this.map.getTeamController().getPlayingTeam().getCharacter()[2].getCellTraveled().getPosition());
				try
				{
					this.right = ImageIO.read(new File("img/botScreen/right2selected.png"));
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(this.characterSelected==this.map.getTeamController().getPlayingTeam().getCharacter()[2])
			{
				this.mapGui.paintGivenCell(this.map.getTeamController().getPlayingTeam().getCharacter()[2].getCellTraveled().getPosition(),this.map.getTeamController().getPlayingTeam().getColorTeam().toString());
				this.characterSelected = null;
				this.mapGui.setSelectedCharacterPosition(null);
				try
				{
					this.right = ImageIO.read(new File("img/botScreen/right.png"));
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}else
			{
				this.mapGui.paintGivenCell(this.characterSelected.getCellTraveled().getPosition(),this.map.getTeamController().getPlayingTeam().getColorTeam().toString());
				this.mapGui.paintGivenCell(this.map.getTeamController().getPlayingTeam().getCharacter()[2].getCellTraveled().getPosition(),this.map.getTeamController().getPlayingTeam().getColorTeam() + "Selected");
				this.characterSelected = this.map.getTeamController().getPlayingTeam().getCharacter()[2];
				this.mapGui.setSelectedCharacterPosition(this.map.getTeamController().getPlayingTeam().getCharacter()[2].getCellTraveled().getPosition());
				try
				{
					this.right = ImageIO.read(new File("img/botScreen/right2selected.png"));
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			this.repaint();
			break;
		default:
		}	
		if(!(this.characterSelected == null))
		{
			
			switch (e.getKeyChar())
			{
			case 'q':
				if(this.map.getSelectedCell()==null)
				{
//					Image tmp = null;
//					try
//					{
//						tmp = ImageIO.read(new File("img/octoSelectable.png"));
//					} catch (IOException k)
//					{
//						// TODO Auto-generated catch block
//						k.printStackTrace();
//					}
//					for(CellPosition cellpos: Move.getAccessiblePos(this.map, this.characterSelected))
//					{
//						
//						this.mapGui.paintGivenCell(cellpos, tmp);
//					}
							
				}else{
				Attack.laserBeam(this.map, this.characterSelected, this.map.getSelectedCell().getPosition());
				this.repaint();
				this.mapGui.printCell(this.mapGui.getGraphics());
				this.characterSelected=null;
				this.mapGui.setSelectedCharacterPosition(null);
				this.map.setSelectedCell(null);
				this.caseSelected = false;
				try
				{
					this.right = ImageIO.read(new File("img/botScreen/right.png"));
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				}
				break;
			case 's':
				if(this.map.getSelectedCell()==null)
				{
//					Image tmp = null;
//					try
//					{
//						tmp = ImageIO.read(new File("img/octoSelectable.png"));
//					} catch (IOException k)
//					{
//						// TODO Auto-generated catch block
//						k.printStackTrace();
//					}
//					for(CellPosition cellpos: Move.getAccessiblePos(this.map, this.characterSelected))
//					{
//						
//						this.mapGui.paintGivenCell(cellpos, tmp);
//					}
							
				}else{
				Attack.aroundCaster(this.map, this.characterSelected);
				this.repaint();
				this.mapGui.printCell(this.mapGui.getGraphics());
				this.characterSelected=null;
				this.mapGui.setSelectedCharacterPosition(null);
				this.map.setSelectedCell(null);
				this.caseSelected = false;
				try
				{
					this.right = ImageIO.read(new File("img/botScreen/right.png"));
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				}
				break;
			case 'd':
				if(this.map.getSelectedCell()==null)
				{
//					Image tmp = null;
//					try
//					{
//						tmp = ImageIO.read(new File("img/octoSelectable.png"));
//					} catch (IOException k)
//					{
//						// TODO Auto-generated catch block
//						k.printStackTrace();
//					}
//					for(CellPosition cellpos: Move.getAccessiblePos(this.map, this.characterSelected))
//					{
//						
//						this.mapGui.paintGivenCell(cellpos, tmp);
//					}
//							
				}else{
				Attack.flowerBomb(this.map, this.characterSelected, this.map.getSelectedCell().getPosition());
				this.repaint();
				this.mapGui.printCell(this.mapGui.getGraphics());
				this.characterSelected=null;
				this.mapGui.setSelectedCharacterPosition(null);
				this.map.setSelectedCell(null);
				this.caseSelected = false;
				try
				{
					this.right = ImageIO.read(new File("img/botScreen/right.png"));
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				}
				break;
			case ' ':
				if(this.map.getSelectedCell()==null)
				{
					Image tmp = null;
					try
					{
						tmp = ImageIO.read(new File("img/octoSelectable.png"));
					} catch (IOException k)
					{
						// TODO Auto-generated catch block
						k.printStackTrace();
					}
					for(CellPosition cellpos: Move.getAccessiblePos(this.map, this.characterSelected))
					{
						
						this.mapGui.paintGivenCell(cellpos, tmp);
					}
							
				}else{
				Move.simpleMove(this.map, this.characterSelected, this.map.getSelectedCell().getPosition());
				this.repaint();
				this.mapGui.printCell(this.mapGui.getGraphics());
				this.characterSelected=null;
				try
				{
					this.right = ImageIO.read(new File("img/botScreen/right.png"));
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				this.mapGui.setSelectedCharacterPosition(null);
				this.map.setSelectedCell(null);
				this.caseSelected = false;
				}
				break;
			default:
			}	
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e)
	{
		
		
	}
	
	public void printHp(Graphics g)
	{
		for(int index = 0; index <this.map.getTeamController().getPlayingTeam().getCharacter()[0].getHealthPoint();index++)
		{
			g.drawImage(hpBar, 400, 15 + 10*index, this);
		}
		for(int index = 0; index <this.map.getTeamController().getPlayingTeam().getCharacter()[1].getHealthPoint();index++)
		{
			g.drawImage(hpBar, 512, 15 + 10*index, this);
		}
		for(int index = 0; index <this.map.getTeamController().getPlayingTeam().getCharacter()[2].getHealthPoint();index++)
		{
			g.drawImage(hpBar, 640, 15 + 10*index, this);
		}
	}
}
