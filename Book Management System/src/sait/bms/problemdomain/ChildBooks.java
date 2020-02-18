package sait.bms.problemdomain;

public class ChildBooks extends Book{
    public String authors;
    public char format;

    /**
     * ChildBooks() - Constructor for the Object ChildBooks
     * 
     */
    public ChildBooks(long iSBN, String callNumber, int available, int total, String title, String authors, char format) {
        super(iSBN, callNumber, available, total, title);
        this.authors = authors;
        this.format = format;
    }

    /**
     * getFormat() - Gets the Format of the ChildBook
     * 
     * @return returns the format
     * 
     */    
    public char getFormat() {
        return format;
    }

    /**
     * printToSave() - Formats each on of the objects attributes into the specific format to be read by this program and
     * 				   saves it into the same .txt file
     * 
     * @return returns printToSave
     * 
     */  
    public String printToSave (){
        return iSBN+";"+callNumber+";"+available+";"+total+";"+title+";"+authors+";"+format;
    }
    
    /**
     * toString() - Replaces the default toString
     * 
     * @return returns the formated objects
     * 
     */  
    @Override
    public String toString() {
        String fullFormat = "";
        if (format == 'P'){fullFormat = "Picture Book";}
        if (format == 'E'){fullFormat = "Early Readers";}
        if (format == 'C'){fullFormat = "Chapter Book";}

        return  "ISBN:             " + iSBN 		+ "\n" +
                "Call Number:      " + callNumber 	+ "\n" +
                "Available:        " + available 	+ "\n" +
                "Total:            " + total 		+ "\n" +
                "Title:            " + title 		+ "\n" +
                "Authors:          " + authors 		+ "\n" +
                "Format:           " + fullFormat 	+ "\n";
    }
}
