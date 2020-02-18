package sait.bms.problemdomain;


public class Periodicals extends Book{
    public char frenquency;

    /**
     * Periodicals() - Constructor for the Object Periodicals
     * 
     */
    public Periodicals(long iSBN, String callNumber, int available, int total, String title, char frenquency) {
        super(iSBN, callNumber, available, total, title);
        this.frenquency = frenquency;
    }

    /**
     * getFrequency() - Gets the Frequency of the Periodical
     * 
     * @return returns the format
     * 
     */ 
    public char getFrenquency() {
        return frenquency;
    }

    /**
     * printToSave() - Formats each on of the objects attributes into the specific format to be read by this program and
     * 				   saves it into the same .txt file
     * 
     * @return returns printToSave
     * 
     */  
    public String printToSave (){
        return iSBN+";"+callNumber+";"+available+";"+total+";"+title+";"+frenquency;
    }

    /**
     * toString() - Replaces the default toString
     * 
     * @return returns the formated objects
     * 
     */  
    @Override
    public String toString() {
        String fullFrequency = "";
        if (frenquency == 'D'){fullFrequency = "Daily";}
        if (frenquency == 'W'){fullFrequency = "Weekly";}
        if (frenquency == 'M'){fullFrequency = "Monthly";}
        if (frenquency == 'B'){fullFrequency = "Bi Monthly";}
        if (frenquency == 'Q'){fullFrequency = "Quarterly";}


        return  "ISBN:             " + iSBN 		 + "\n" +
                "Call Number:      " + callNumber 	 + "\n" +
                "Available:        " + available 	 + "\n" +
                "Total:            " + total 		 + "\n" +
                "Title:            " + title 		 + "\n" +
                "Frequency:        " + fullFrequency + "\n";
    }
}
