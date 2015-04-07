package fr.iut.tapawaru.team;

/**
 * Équipe de persos. 2 équipes s'affrontent dans une partie. Une équipe contient
 * un nombre de persos déterminé au début de la partie (à confirmer). Chaque
 * équipe a une couleur.
 * 
 * @author Axce
 */
public class Team
{
	// TODO un enum des couleurs possibles.
	
	public final static int	DEFAULT_NB_CHARACTER	= 3;
	
	/**
	 * Nombre de persos dans la Team.
	 * À mettre en static si il doit être identique pour les deux équipes.
	 */
	private final int		nbCharacter;
	
	/**
	 * Liste des persos.
	 */
	private Character[]		listCharacter;
	
	/**
	 * Constructeur Team.
	 * 
	 * @param nb	Le nombre de persos.
	 */
	public Team(int nb)
	{
		nbCharacter = nb;
		listCharacter = new Character[nbCharacter];
	}
	
	/**
	 * Constructeur default Team.
	 * 
	 * @param nb	Le nombre de persos.
	 */
	public Team()
	{
		this(DEFAULT_NB_CHARACTER);
	}
}
