package fr.iut.tapawaru.team;

import fr.iut.tapawaru.gui.VictoryFrame;
import fr.iut.tapawaru.map.CellPosition;
import fr.iut.tapawaru.map.Map;

public class TeamController
{
	
	private Map map;
	
	private Team team1;

	private Team team2;
	
	private Team playingTeam;

	
	public TeamController(Map map)
	{
		this.map = map;
		this.team1 = new Team(TeamColor.BLUE,map);
		this.team2 = new Team(TeamColor.RED,map);
		this.playingTeam = team1;

		this.map.putCharacter(this.team1.getCharacter()[0],new CellPosition(6, 5));
		this.map.putCharacter(this.team1.getCharacter()[1],new CellPosition(6, 6));
		this.map.putCharacter(this.team1.getCharacter()[2],new CellPosition(7, 6));
		
		this.map.putCharacter(this.team2.getCharacter()[0],new CellPosition(6, 4));
		this.map.putCharacter(this.team2.getCharacter()[1],new CellPosition(8, 6));
		this.map.putCharacter(this.team2.getCharacter()[2],new CellPosition(9, 3));
	}

	/**
	 * Method deducting action point to teams.
	 * If a team is at 0, the playingTeam changes. 
	 * @param deductedPoints
	 */
	public boolean isDeductable(int deductedPoints)
	{
		if (deductedPoints > playingTeam.getActionPointsLeft())
			return false;
		return true;
	}
	
	public void deduct(int deductedPoints)
	{
		if (this.isDeductable(deductedPoints))
		{
			this.playingTeam.setActionPointsLeft(this.playingTeam.getActionPointsLeft() - deductedPoints);
			
			if (this.playingTeam.getActionPointsLeft() == 0)
				changePlayingTeam();
		}
	}
	
	public void skipTurn()
	{
		deduct(playingTeam.getActionPointsLeft());
	}

	private void changePlayingTeam()
	{
		if (playingTeam == team1)
		{
			playingTeam = team2;
			//this.map.getBottomPanel().chooseDisplayTeam();

		}
		else
		{
			playingTeam = team1;
			//this.map.getBottomPanel().chooseDisplayTeam();
		}
		
		playingTeam.setActionPointsLeft(Team.DEFAULT_ACTION_POINT);
		
		this.applyBuff();
	}
	
	private void applyBuff()
	{
		for (int i = 0 ; i < 3 ; i++)
		{
			Character perso = this.playingTeam.getCharacter()[i];
			
			
			switch (perso.getBuff())
			{
				case NORMAL:
					break;
				case BURNING:
					this.map.getMapGui().buffAnimation(perso.getCellTraveled(),perso.getBuff());
					perso.inflict(1);
					break;
				case FREEZING:
					break;
				case DEAD:
					break;
			}
		}
	}

	public Team getPlayingTeam()
	{
		return this.playingTeam;
	}
	
	public Team getTeam1()
	{
		return this.team1;
	}
	
	public Team getTeam2()
	{
		return this.team2;
	}

	public void checkWin()
	{
		int countDead1 = 0;
		
		for (int i = 0 ; i < 3 ; i++)
		{
			if (  ! (this.getTeam1().getCharacter()[i].isAlive())  )
			{
				countDead1++;
			}
		}
		
		int countDead2 = 0;
		
		for (int i = 0 ; i < 3 ; i++)
		{
			if (  ! (this.getTeam2().getCharacter()[i].isAlive())  )
			{
				countDead2++;
			}
		}
		
		if (countDead1 == 3 && countDead2 < 3)
		{
			this.win(this.team2);
		}

		if (countDead2 == 3 && countDead1 < 3)
		{
			this.win(this.team1);
		}
		
		if (countDead1 == 3 && countDead2 == 3)
		{
			this.win(null);
		}
		
	}

	/**
	 * 
	 * @param gloriousTeam if null : ex aequo
	 */
	private void win(Team gloriousTeam)
	{
		new VictoryFrame(map, gloriousTeam);
	}
	
}
