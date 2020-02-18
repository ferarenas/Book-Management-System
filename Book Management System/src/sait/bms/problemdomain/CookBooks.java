package sait.bms.problemdomain;

public class CookBooks extends Book {

    public String publisher;
    public char diet;
    
    /**
     * CookBooks() - Constructor for the Object CookBooks
     * 
     */
    public CookBooks(long iSBN, String callNumber, int available, int total, String title, String publisher, char diet) {
        super(iSBN, callNumber, available, total, title);
        this.publisher = publisher;
        this.diet = diet;
    }
    
    /**
     * getDiet() - Gets the Diet of the CookBook
     * 
     * @return returns the format
     * 
     */ 
    public char getDiet() {
        return diet;
    }

    /**
     * printToSave() - Formats each on of the objects attributes into the specific format to be read by this program and
     * 				   saves it into the same .txt file
     * 
     * @return returns printToSave
     * 
     */  
    public String printToSave (){
        return iSBN+";"+callNumber+";"+available+";"+total+";"+title+";"+publisher+";"+diet;
    }

    /**
     * toString() - Replaces the default toString
     * 
     * @return returns the formated objects
     * 
     */  
    @Override
    public String toString() {
        String fullDiet = "";
        if (diet == 'D'){fullDiet = "Diabetic";}
        if (diet == 'V'){fullDiet = "Vegetarian";}
        if (diet == 'G'){fullDiet = "Gluten - Free";}
        if (diet == 'I'){fullDiet = "International";}
        if (diet == 'N'){fullDiet = "None";}

        return  "ISBN:             " + iSBN 		+ "\n" +
                "Call Number:      " + callNumber 	+ "\n" +
                "Available:        " + available 	+ "\n" +
                "Total:            " + total 		+ "\n" +
                "Title:            " + title 		+ "\n" +
                "Publisher:        " + publisher 	+ "\n" +
                "Diet:             " + fullDiet 	+ "\n";
    }
}
