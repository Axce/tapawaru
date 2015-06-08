package fr.iut.tapawaru.team;

import fr.iut.tapawaru.map.CellPosition;
import fr.iut.tapawaru.map.Map;
import fr.iut.tapawaru.map.TeamColor;

public class TeamController
{
	
	private Map map;
	
	private Team teamUn;

	private Team teamDeux;

	
	public TeamController(Map map)
	{
		this.map = map;
		this.teamUn = new Team(TeamColor.GREEN);
		this.teamDeux = new Team(TeamColor.RED);
		for(int indiceCharacter =0;indiceCharacter<this.teamUn.getNbCharacter();indiceCharacter++)
		{
			this.map.moveCharacter(this.teamUn.getCharacter()[indiceCharacter],new CellPosition(1, indiceCharacter+1));
		}
		for(int indiceCharacter =0;indiceCharacter<this.teamDeux.getNbCharacter();indiceCharacter++)
		{
			this.map.moveCharacter(this.teamDeux.getCharacter()[indiceCharacter],new CellPosition(10, indiceCharacter+1));
		}

}
}
