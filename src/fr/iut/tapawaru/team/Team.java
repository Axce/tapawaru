package fr.iut.tapawaru.team;


/**
 * Team of Characters. 
 * Two Teams compete in a game. 
 * A Team contains a default number of characters at the beginning of the game. (To confirm)
 * Every Team has its representing color.
 * 
 * @authors CEARD, MATHEY, MOUNIER, 
 * @authors PELLOUX-PRAYER, PRADELLE
 */
public class Team
{
	/////// Attributes ////////////////////////////////////////

	// TODO check enum
	
	public final static int	DEFAULT_NB_CHARACTER	= 3;
	public final static int	DEFAULT_ACTION_POINT= 5;
	
	/** Team's number of characters   (set to static if same in every Team). */
	private final int nbCharacter;
	
	/** Team's list of characters. */
	private Character[]	listCharacter;
	
	/** Team's color. */
	private TeamColor colorTeam;
	
	private int actionPointLeft; 
	/////// Constructor ////////////////////////////////////////

	// TODO check colorTeam in constructor

	public TeamColor getColorTeam()
	{
		return colorTeam;
	}

	/**
	 * Constructor for the Team.
	 * @param nb : number of characters.
	 */
	public Team(int nb, TeamColor color)
	{
		this.nbCharacter = nb;
		this.listCharacter = new Character[nbCharacter];
		this.colorTeam = color;
		for(int nbCharacterCreated =0; nbCharacterCreated<nbCharacter;nbCharacterCreated++)
		{
			this.listCharacter[nbCharacterCreated] = new Character(this, 100);
		}
		this.actionPointLeft = DEFAULT_ACTION_POINT;
	}
	
	/**
	 * Constructor for a default Team.
	 * @param nb : number of characters.
	 */
	public Team( TeamColor color)
	{
		this.nbCharacter = DEFAULT_NB_CHARACTER;
		this.listCharacter = new Character[nbCharacter];
		this.colorTeam = color;	
		for(int nbCharacterCreated =0; nbCharacterCreated<nbCharacter;nbCharacterCreated++)
		{
			this.listCharacter[nbCharacterCreated] = new Character(this, 100);
		}
		this.actionPointLeft = DEFAULT_ACTION_POINT;
	}

	public int getNbCharacter()
	{
		// TODO Auto-generated method stub
		return nbCharacter;
	}

	public Character[] getCharacter()
	{
		// TODO Auto-generated method stub
		return this.listCharacter;
	}
	
	public int getActionPointsLeft()
	{
		return this.actionPointLeft;
	}
	
	public void setActionPointsLeft(int newActionPointLeft)
	{
		this.actionPointLeft=newActionPointLeft;
	}
}
