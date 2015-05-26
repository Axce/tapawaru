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
	ICE ("I");
	// HOLY ("H"),
	// DARK ("D");  //
	
	/** Displays Glyph's type. */
    private final String display;
    
    
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
}
