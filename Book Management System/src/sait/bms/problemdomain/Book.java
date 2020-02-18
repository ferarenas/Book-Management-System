package sait.bms.problemdomain;

public abstract class Book {

    public long iSBN;
    public String callNumber;
    public int available;
    public int total;
    public String title;

    /**
     * Movie() - Constructor for the Object Book
     * 
     */
    public Book(long iSBN, String callNumber, int available, int total, String title) {
        this.iSBN = iSBN;
        this.callNumber = callNumber;
        this.available = available;
        this.total = total;
        this.title = title;
    }
    
    /**
     * getiSBN() - Gets the ISBN attribute of the object
     * 
     * @return returns the ISBN
     * 
     */    
    public long getiSBN() {
        return iSBN;
    }

    /**
     * getCallNumber() - Gets the call number of the book
     * 
     * @return returns call number
     * 
     */  
    public String getCallNumber() {
        return callNumber;
    }

    /**
     * getAvailable() - Gets the number of books available
     * 
     * @return returns available
     * 
     */  
    public int getAvailable() {
        return available;
    }
    
    /**
     * setAvailable() - Sets the number of available books
     * 
     * @param available
     * 
     */  
    public void setAvailable(int available) {
        this.available = available;
    }

    /**
     * getTitle() - Gets the Title of the Book
     * 
     * @return returns Title
     * 
     */  
    public String getTitle() {
        return title;
    }

    /**
     * printToSave() - Abstract method to access the printToSave of each subclass
     * 
     * @return returns printToSave
     * 
     */  
    public abstract String printToSave ();
}
