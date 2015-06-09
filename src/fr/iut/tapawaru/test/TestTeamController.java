package fr.iut.tapawaru.test;
import static org.junit.Assert.*;
import junit.framework.*;
import fr.iut.tapawaru.map.CellPosition;
import fr.iut.tapawaru.map.Map;
import fr.iut.tapawaru.team.*;


public class TestTeamController extends TestCase
{
	/**
	 * Constructor of the test
	 * @param string name of the test
	 */
	public TestTeamController(String name)
	{
		super(name);
	}
	
	/**
	 * test on the method deduct()
	 */
	public void deduct()
	{
		Map mapTest = new Map();
		try
		{
			TeamController teamControllerTest = new TeamController(mapTest);
			assertEquals(teamControllerTest.deduct(0), false);
			assertEquals(teamControllerTest.deduct(3), false);
			assertEquals(teamControllerTest.deduct(5), true);
		}
		catch (Exception exception){};
	}
}
