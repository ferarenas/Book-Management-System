package sait.bms.application;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import sait.bms.managers.*;
import sait.bms.problemdomain.*;

/**
 * ABC Book Company - CPRG251 Assignment #2
 * This program can load the books from a database into an Arraylist,
 * check out a book and change its availability on the Database, search for 
 * books using an user input ISBN as well as displaying books by their type and then
 * filtering the results by either the Format, Diet, Genre or Frequency as well as
 * printing a list of random books
 * 
 * 
 * 
 * Inputs:
 * 		Option
 *      Book ISBN
 *      Type of book
 *      Format, Diet, Genre or Frequency
 *      Number of Random books
 *      
 *     
 *      
 * Calculations:
 *      Load the books
 *      Check out books
 *      Save Changes to File
 *      Search for books
 *      Display Books by type
 *      Generate Random Books
 *      
 * 
 * @author Fernando Arenas
 * 
 * @version 1.1 (/02/2020)
 * 
 * 
 */
public class AppDriver {
    public static void main(String[] args) throws IOException {
        ArrayList<Book> bList = new ArrayList<>();

        String fileLocation = "res/books.txt";
        int option = 0;

        Scanner kbrd = new Scanner(System.in);
       

        BookManagementSystem.loadBooks(bList, fileLocation);

        while (option != 5) {
        	
            option = BookManagementSystem.display(kbrd);
            kbrd.nextLine(); //This just removes the \n generated
            
            if (option == 1) {
            	BookManagementSystem.checkOutBooks(bList, kbrd);
            }

            if (option == 2) {
            	BookManagementSystem.searchBooks(bList, kbrd);
            }

            if (option == 3) {
            	BookManagementSystem.displayBooksType(bList, kbrd);
            }

            if (option == 4) {
            	BookManagementSystem.generateRandomBooks(bList, kbrd);
            }

            if (option >  5 || option < 1) {
                System.out.println("Invalid option!");
            }

        }
        
        System.out.println("Thank you for using ABC Book Company");
        BookManagementSystem.saveChangesToFile(bList, fileLocation);
        System.out.println("Changes Saved successfully");
        kbrd.close();
        
    }

   
}







