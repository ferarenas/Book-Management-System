package sait.bms.managers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.ChildBooks;
import sait.bms.problemdomain.CookBooks;
import sait.bms.problemdomain.PaperBacks;
import sait.bms.problemdomain.Periodicals;



public class BookManagementSystem {

		/**
		 * loadBooks() - Opens the file books.txt, scans each one of the entries and creates an object for each entry with corresponding attributes and adds the object to an arraylist
		 * 
		 */
	 public static void loadBooks(ArrayList<Book> bList, String fileLocation) throws IOException {
	        File file = new File(fileLocation);
	        Scanner inputFile = new Scanner(file);

	        while (inputFile.hasNext()) {
	            String str = inputFile.nextLine();
	            String[] temp = str.split(";");

	            long iSBN = Long.parseLong(temp[0]);
	            if ((iSBN % 10) == 0 || (iSBN % 10) == 1) {
	                Book bookTemp = new ChildBooks(iSBN, temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4], temp[5], (temp[6].charAt(0)));
	                bList.add(bookTemp);
	            }
	            if ((iSBN % 10) == 2 || (iSBN % 10) == 3) {
	                Book bookTemp = new CookBooks(iSBN, temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4], temp[5], (temp[6].charAt(0)));
	                bList.add(bookTemp);
	            }
	            if ((iSBN % 10) >= 4 && (iSBN % 10) <= 7) {
	                Book bookTemp = new PaperBacks(iSBN, temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4], temp[5], Integer.parseInt(temp[6]), (temp[7].charAt(0)));
	                bList.add(bookTemp);
	            }
	            if ((iSBN % 10) == 8 || (iSBN % 10) == 9) {
	                Book bookTemp = new Periodicals(iSBN, temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4], (temp[5].charAt(0)));
	                bList.add(bookTemp);
	            }
	        }
	        inputFile.close();
	    }

	    /**
	     * display() - displays the menu and asks for an option
	     * 
	     * @return returns option number
	     */
	 public static int display(Scanner kbrd) {
	        int number;
	        System.out.println("\nWelcome in ABC Book Company: How May We Assist You?");

	        System.out.println("1. Checkout Book");
	        System.out.println("2. Find Books by Title");
	        System.out.println("3. Display Books by Type");
	        System.out.println("4. Produce Random Book List");
	        System.out.println("5. Save & Exit\n");
	        System.out.print("Enter an option: ");

	        number = kbrd.nextInt();
	        return number;
	    }
	 	
	 	/**
	     * checkOutBooks() - Asks the user for the ISBN, searches through the arraylist for a books that matches the ISBN and looks for how many
	     * 					 are available, and if there is one it substracts one from the books available and prints how many are left
	     * 
	     */
	 public static void checkOutBooks(ArrayList<Book> bList, Scanner kbrd){
		 
	        boolean found = false;
	        
	        System.out.print("Enter ISBN of Book: ");
	        long input = kbrd.nextLong();
	        
	        for (Book book : bList) {
	            if (book.getiSBN() == input) {
	                if(book.getAvailable()>0) {
	                    book.setAvailable(book.getAvailable()-1);
	                    System.out.println("The book \"" + book.getTitle() + "\" has been checked out.");
	                    System.out.println("It can be located using a call number: " + book.getCallNumber());
	                    System.out.println("There are  " + book.getAvailable()+ " books of \"" + book.getTitle() + "\" left");
	                    found = true;
	                }
	                else {
	                    System.out.println("Book Not Available");
	                    found = true;
	                }
	            }
	        }
	        if (!found || Long.toString(input).length()!=13) {
	            System.out.println("Incorrect ISBN");
	        }
	    }

	    /**
	     * saveChangesToFile() - Prints the arraylist of books into the same .txt file to save the book available amounts
	     * 
	     */
	 public static void saveChangesToFile(ArrayList<Book> bList, String fileLocation) throws IOException {
	        PrintWriter out= new PrintWriter (fileLocation);
	        for(Book book : bList) {
	            out.println(book.printToSave());
	        }
	        out.close();
	    }
	 
	    /**
	     * searchBooks() - Searches through the arraylist using the ISBN and prints the attributes of the object that match the user input
	     * 
	     */
	 public static void searchBooks(ArrayList<Book> bList, Scanner kbrd) {
	        System.out.print("Enter title to search for: ");
	        String searchArg = kbrd.nextLine().toLowerCase();
	        for (Book book : bList) {
	            if (book.getTitle().toLowerCase().contains(searchArg.toLowerCase())) {
	                System.out.println(book);
	            }
	        }
	    }
	   
	 	/**
	     * displayBooksType() - Asks for a type of book and then according to the type of book it asks for either format, 
	     * 						Diet, Genre or Frequency and displays the books that match the criteria
	     * 
	     */
	 public static void displayBooksType(ArrayList<Book> bList, Scanner kbrd) {
	        System.out.println("#\tType");
	        System.out.println("1\tChildren's Books");
	        System.out.println("2\tCookbooks");
	        System.out.println("3\tPaperbacks");
	        System.out.println("4\tPeriodicals\n");
	        System.out.print("Enter type of Book: ");
	        int tOfBook = kbrd.nextInt();

	        if (tOfBook == 1) {
	            System.out.println("Enter a format (P for Picture book, E for Early Readers, or C for Chapter book. )");
	            char input = Character.toUpperCase(kbrd.next().charAt(0));
	            for (Book book : bList) {
	                if (book instanceof ChildBooks) {
	                    if ((((ChildBooks) book).getFormat()) == input) {
	                        System.out.println(book);
	                    }
	                }
	            }
	        }
	        if (tOfBook == 2) {
	            System.out.println("Enter a Diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None )");
	            char input = Character.toUpperCase(kbrd.next().charAt(0));
	            for (Book book : bList) {
	                if (book instanceof CookBooks) {
	                    if ((((CookBooks) book).getDiet()) == input) {
	                        System.out.println(book);
	                    }
	                }
	            }
	        }
	        if (tOfBook == 3) {
	            System.out.println("Enter a Genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction.)");
	            char input = Character.toUpperCase(kbrd.next().charAt(0));
	            for (Book book : bList) {
	                if (book instanceof PaperBacks) {
	                    if ((((PaperBacks) book).getGenre()) == input) {
	                        System.out.println(book);
	                    }
	                }
	            }
	        }
	        if (tOfBook == 4) {
	            System.out.println("Enter a Frequency (D for Daily, W for Weekly, M for Monthly, B for Bimonthly, and Q for Quarterly)");
	            char input = Character.toUpperCase(kbrd.next().charAt(0));
	            for (Book book : bList) {
	                if (book instanceof Periodicals) {
	                    if ((((Periodicals) book).getFrenquency()) == input) {
	                        System.out.println(book);
	                    }
	                }
	            }
	        }

	    }

	    /**
	     * generateRandomBooks() - Asks for a number of Books to print and prints books at random from the arraylist of books
	     * 
	     */
	 public static void generateRandomBooks(ArrayList<Book> bList, Scanner kbrd) {
	        Random rand = new Random();
	        System.out.print("Enter a number of books: ");
	        int ranBooks = kbrd.nextInt();
	        System.out.println("\nRandom Books:\n");
	        while (ranBooks != 0) {
	            System.out.println(bList.get(rand.nextInt(bList.size())));
	            ranBooks--;
	        }
	    }

}
