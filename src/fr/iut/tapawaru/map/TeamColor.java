package fr.iut.tapawaru.map;


/**
 * All team's color.
 * Enumeration of all the different team's color.
 * TODO complete javadoc?
 * 
 * @authors CEARD, MATHEY, MOUNIER, 
 * @authors PELLOUX-PRAYER, PRADELLE
 */
public enum TeamColor {
	
	//TODO Est ce que cela vous convient? deux autres en bas au cas ou il en faut plus.
	
	 
	RED ("red"),
	BLUE ("blue"),
	GREEN ("green"),
	YELLOW ("yellow"),
	BLACK ("black");

	
	/** Displays Glyph's type. */
    private final String display;
    
	/////// Constructor ////////////////////////////////////////

    /** 
     * Constructor of the Glyph's type. 
     * @param disp: display of the Glyph's type.
     */
    TeamColor(final String disp) 
    {
        display = disp;
    }

    
    
    
    @Override
    public String toString() 
    {
    	return display;
    }

}
