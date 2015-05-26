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
	
	/** Team's number of characters   (set to static if same in every Team). */
	private final int nbCharacter;
	
	/** Team's list of characters. */
	private Character[]	listCharacter;
	
	/** Team's enumeration of possible colors. */
	public enum ColorTeam { RED, BLUE, GREEN, YELLOW, PINK, ;};;
	private ColorTeam colorTeam;
	
	
	/////// Constructor ////////////////////////////////////////

	// TODO check colorTeam in constructor

	/**
	 * Constructor for the Team.
	 * @param nb : number of characters.
	 */
	public Team(int nb, ColorTeam color)
	{
		this.nbCharacter = nb;
		this.listCharacter = new Character[nbCharacter];
		this.colorTeam = color;
	}
	
	/**
	 * Constructor for a default Team.
	 * @param nb : number of characters.
	 */
	public Team( ColorTeam color)
	{
		this.nbCharacter = DEFAULT_NB_CHARACTER;
		this.listCharacter = new Character[nbCharacter];
		this.colorTeam = color;	
	}
}
