package fr.iut.tapawaru.map;


/**
 * All Types of Glyphs.
 * Enumeration of all the different types of glyphs.
 * TODO complete javadoc?
 * 
 * @authors CEARD, MATHEY, MOUNIER, 
 * @authors PELLOUX-PRAYER, PRADELLE
 */
public enum TypeGlyph {
	
	//TODO Est ce que cela vous convient? deux autres en bas au cas ou il en faut plus.
	
	FIRE ("F"),
	EARTH ("E"),
	WATER ("W"),
	AIR ("A"),
	THUNDER ("T"),
	ICE ("I"),
	HOLY ("H"),
	DARK ("D"); 
	
	/** Displays Glyph's type. */
    private final String display;
    
    /** The number of type available. */
    public final static int NUMBER_OF_TYPE = 8; 
    
	/////// Constructor ////////////////////////////////////////

    /** 
     * Constructor of the Glyph's type. 
     * @param disp: display of the Glyph's type.
     */
    TypeGlyph(final String disp) 
    {
        display = disp;
    }

    
    
    
    @Override
    public String toString() 
    {
    	return display;
    }
    
    /**
     * Return one TypeGlyph at random.
     * @return TypeGlyph
     */
    public final static TypeGlyph getRandomType()
    {
    	int type = (int) (Math.random() * NUMBER_OF_TYPE );
    	
    	switch (type)
		{
		case 0:
			return TypeGlyph.FIRE;
		case 1:
			return TypeGlyph.EARTH;
		case 2:
			return TypeGlyph.WATER;
		case 3:
			return TypeGlyph.AIR;
		case 4:
			return TypeGlyph.THUNDER;
		case 5:
			return TypeGlyph.ICE;
		case 6:
			return TypeGlyph.HOLY;
		case 7:
			return TypeGlyph.DARK;
		}
		return null;
    }
}
