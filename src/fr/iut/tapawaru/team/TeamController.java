package fr.iut.tapawaru.team;

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
		this.team1 = new Team(TeamColor.GREEN,map);
		this.team2 = new Team(TeamColor.RED,map);
		this.playingTeam = team1;
		for(int indiceCharacter =0;indiceCharacter<this.team1.getNbCharacter();indiceCharacter++)
		{
			this.map.moveCharacter(this.team1.getCharacter()[indiceCharacter],new CellPosition(1, indiceCharacter+1));
		}
		for(int indiceCharacter =0;indiceCharacter<this.team2.getNbCharacter();indiceCharacter++)
		{
			this.map.moveCharacter(this.team2.getCharacter()[indiceCharacter],new CellPosition(10, indiceCharacter+1));
		}

	}

	/**
	 * Method deducting action point to teams.
	 * If a team is at 0, the playingTeam changes. 
	 * @param deductedPoints
	 */
	public boolean deduct(int deductedPoints)
	{
		System.out.println("dduct reach");
		if (deductedPoints > playingTeam.getActionPointsLeft())
			return false;
		
		this.playingTeam.setActionPointsLeft(this.playingTeam.getActionPointsLeft() - deductedPoints);
		
		if (this.playingTeam.getActionPointsLeft() == 0)
			changePlayingTeam();
		return true;
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
	
}
