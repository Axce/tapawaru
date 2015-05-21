package fr.iut.tapawaru.team;

/**
 * Personnage d'une Ã©quipe.
 * Contenu dans l'attribut listCharacter.
 * 
 * @author Axce
 */
public class Character
{
 /**
  * team d'appartenance du character	
  */
	private Team team;
	
 /**
  * point de vie du character 
  */
	private int healthPoint;
	
  public Character(Team team, int healthpoint)
  {
	  this.team = team;
	  this.healthPoint = healthpoint;
  }
  
  /**
   * 
   */
  public void castSpell()
  {
	  //TODO  faire la méthode
  }
  
  /**
   * test si le character est en vie 
   */
  public boolean isAlive()
  {
	  if (this.healthPoint <= 0)
		  return false;
	  return true;
  }
  
  /**
   * supprime l'objet character courant
   */
  public void kill()
  {
	  if (!this.isAlive())
		  //TODO faire la méthode;
  }
}

