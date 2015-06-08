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
		this.team1 = new Team(TeamColor.GREEN);
		this.team2 = new Team(TeamColor.RED);
		this.playingTeam = team1;
		this.map.setPlayingTeam(team1);
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
	public void deduct(int deductedPoints)
	{
		//TODO exceptions & all
		this.playingTeam.setActionPointsLeft(this.playingTeam.getActionPointsLeft() - deductedPoints);
		
		if (this.playingTeam.getActionPointsLeft() == 0)
			changePlayingTeam();
	}

	private void changePlayingTeam()
	{
		if (playingTeam == team1)
		{
			playingTeam = team2;
			this.map.setPlayingTeam(team2);
		}
		else
		{
			playingTeam = team1;
			this.map.setPlayingTeam(team1);
			}
		
		playingTeam.setActionPointsLeft(Team.DEFAULT_ACTION_POINT);
	}
	
	public Team getPlayingTeam()
	{
		return this.playingTeam;
	}
	
	
}
