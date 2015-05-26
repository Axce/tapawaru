package fr.iut.tapawaru.team;

/**
 * Character of a team.
 * Contained in the listCharacter attribute.
 * 
 * @authors CEARD, MATHEY, MOUNIER, 
 * @authors PELLOUX-PRAYER, PRADELLE
 */
public class Character
{
	/////// Attributes ////////////////////////////////////////

	/** Character's team of appurtenance. */
	private Team team;
	
	/** Character's life points. */
	private int healthPoint;

	
	/////// Constructor ////////////////////////////////////////

  /**
   * Constructor of the Character.
   * @param team : Character's team.
   * @param healthpoint: Character's life points.
   */
	public Character(Team team, int healthpoint)
	  {
		  this.team = team;
		  this.healthPoint = healthpoint;
	  }
	
  
	/////// Methods //////////////////////////////////////// 

	  /**
	   * Method to cast a spell. 
	   */
	 public void castSpell()
	  {
		  //TODO  faire la méthode
	  }
  
	 
	  /**
	   * Method to check that character's still alive. 
	   */
	  public boolean isAlive()
	  {
		  if (this.healthPoint <= 0)
			  return false;
		  return true;
	  }
  
	  
	  /**
	   * Method to delete the current Character object.
	   */
	  public void kill()
	  {
		  if (!this.isAlive())
		  { 
			  //TODO faire la méthode;
		}
			 
	  }
}

