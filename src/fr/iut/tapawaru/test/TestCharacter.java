package fr.iut.tapawaru.test;
import static org.junit.Assert.*;
import junit.framework.*;
import fr.iut.tapawaru.map.*;
import fr.iut.tapawaru.team.*;
import fr.iut.tapawaru.team.Character;


public class TestCharacter extends TestCase
{
	/**
	 * Constructor of the test
	 * @param string name of the test
	 */
	public TestCharacter(String name)
	{
		super(name);
	}
	
	/**
	 * test on the method isAlive()
	 */
	public void isAlive()
	{
		Map mapTest = new Map();
		try
		{
			Character character1 = new Character(new Team(TeamColor.RED,mapTest),mapTest);
			Character character2 = new Character(new Team(TeamColor.RED,mapTest),mapTest);
			Character character3 = new Character(new Team(TeamColor.RED,mapTest),mapTest);
			character2.inflict(5);
			character3.inflict(6);
			
			assertEquals(character1.isAlive(), true);
			assertEquals(character2.isAlive(), false);
			assertEquals(character3.isAlive(), false);
		}
		catch (Exception exception){};
	}
}
