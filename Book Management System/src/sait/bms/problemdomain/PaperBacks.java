package sait.bms.problemdomain;


public class PaperBacks extends Book {

    public String authors;
    public int year;
    public char genre;

    /**
     * PaperBacks() - Constructor for the Object PaperBacks
     * 
     */
    public PaperBacks(long iSBN, String callNumber, int available, int total, String title, String authors, int year, char genre) {
        super(iSBN, callNumber, available, total, title);
        this.authors = authors;
        this.year = year;
        this.genre = genre;
    }
    
    /**
     * getGenre() - Gets the Genre of the PaperBack
     * 
     * @return returns the format
     * 
     */ 
    public char getGenre() {
        return genre;
    }

    /**
     * printToSave() - Formats each on of the objects attributes into the specific format to be read by this program and
     * 				   saves it into the same .txt file
     * 
     * @return returns printToSave
     * 
     */  
    public String printToSave (){
        return iSBN+";"+callNumber+";"+available+";"+total+";"+title+";"+authors+";"+year+";"+genre;
    }

    /**
     * toString() - Replaces the default toString
     * 
     * @return returns the formated objects
     * 
     */  
    @Override
    public String toString() {
        String fullGenre = "";
        if (genre == 'A'){fullGenre = "Adventure";}
        if (genre == 'D'){fullGenre = "Drama";}
        if (genre == 'E'){fullGenre = "Education";}
        if (genre == 'C'){fullGenre = "Classic";}
        if (genre == 'F'){fullGenre = "Fantasy";}
        if (genre == 'S'){fullGenre = "Science Fiction";}

        return  "ISBN:             " + iSBN 		+ "\n" +
                "Call Number:      " + callNumber 	+ "\n" +
                "Available:        " + available 	+ "\n" +
                "Total:            " + total 		+ "\n" +
                "Title:            " + title 		+ "\n" +
                "Authors:          " + authors 		+ "\n" +
                "Year:             " + year 		+ "\n" +
                "Genre:            " + fullGenre 	+ "\n";
    }
}
