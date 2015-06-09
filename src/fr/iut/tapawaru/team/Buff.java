package fr.iut.tapawaru.team;

public enum Buff
{
	NORMAL("N"), 
	BURNING("F"), // -1 hp per turn
	FREEZING("I"), // can't move
	DEAD("D");

	/** Displays Glyph's type. */
	private final String display;

	Buff(final String disp)
	{
		display = disp;
	}

	@Override
	public String toString()
	{
		return display;
	}

}
