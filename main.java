import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.util.*;

class BookstoreBook {
	Scanner input = new Scanner(System.in);

	private String author;
	private String title;
	private String isbn;
	double bookPrice;
	char onSale;
	String redPercentageInput = null;
	double redPercentageCal;
	double priceAfterReduction;

	static int bookCount; // keep track with how many books input
	
	public int getBookCount() {
		return bookCount;
	}
	
	public BookstoreBook(String author, String title, String isbn) {
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		bookCount ++;
	}

	public BookstoreBook() {
		author = "No Name";
		title = "No title";
		isbn = "No isbn";
		bookPrice = 00.00;
	}

	public BookstoreBook(String title, String isbn, double bookPrice) {
		author = "No Name";
		this.title = title;
		this.isbn = isbn;
		this.bookPrice = bookPrice;

	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setISBN(String isbn) {
		this.isbn = isbn;
	}

	public String getISBN() {
		return isbn;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public double getBookPice() {
		return bookPrice;
	}

	public void setPriceAfterReduction(double priceAfterReduction) {
		this.priceAfterReduction = priceAfterReduction;
	}

	public double getPriceAfterReduction() {
		return priceAfterReduction;
	}

	// Override
	public String toString() {
		return "[" + isbn + " - " + title + " by " + author + "," + "$" + bookPrice + " listed for " + "$"
				+ priceAfterReduction + "]";

	}

}

class LibraryBook {
	private String author;
	private String title;
	private String isbn;
	private String callNumber;

	Random rand = new Random();
	private static int bookCount; // keep track with how many books input
	
	public int getBookCount() {
		return bookCount;
	}

	public LibraryBook(String author, String title, String isbn) {
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		bookCount++;
	}

	public LibraryBook() {
		author = "No Name";
		title = "No title";
		isbn = "No isbn";
	}

	public LibraryBook(String title, String isbn) {
		author = "No Name";
		this.title = title;
		this.isbn = isbn;

	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setISBN(String isbn) {
		this.isbn = isbn;
	}

	public String getISBN() {
		return isbn;
	}

	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	void getCNumber() {

		int xx = rand.nextInt(1, 100);//floor number
		String yyy = author.substring(0,3); //author name
		char c = isbn.charAt(isbn.length()-1); //isbn
		
		callNumber = String.format("%d.%s.%c",xx,yyy,c);
	}

	public String toString() {
		return "[" + isbn + " - " + title + " by " + author + "-" + callNumber +  "]";

	}

}

public class main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String answer = null;
		String author = null;
		String title = null;
		String ibsn = null;
		String userInput = null;
		String userInput2 = null;
		int bookStoreCount2 = 0;
		int bookLibraryCount2 = 0;
		double percentage = 0;

		BookstoreBook[] bookStoreList;
		LibraryBook[] libraryBookList;

		bookStoreList = new BookstoreBook[100];// take up to 100
		libraryBookList = new LibraryBook[200];// take up to 200

		System.out.println("Welcome to the book progam!");
		System.out.println("Would you like to create a book objet?(yes/no):");
		answer = input.nextLine();
		answer.toLowerCase();

		while (1 == 1) {
			
			if (answer.equalsIgnoreCase("yes")) {
				System.out.println("Please enter the author, title, and the isbn of the book separated by/:");
				userInput = input.nextLine();
				String[] items = userInput.split("/");

				for (int i = 0; i < 3; i++) {
					if (i == 0)
						author = items[i];
					else if (i == 1)
						title = items[i];
					else
						ibsn = items[2];
				}

				System.out.println("Got it!");
				System.out.println(
						"Now, tell me if it is a bookstore book or a library book(enter BB for bookstore book or LB for library book):");
				userInput2 = input.nextLine();
				userInput2.toUpperCase();
				if (userInput2.equalsIgnoreCase("BB")) {
					System.out.println("Got it");
					//bookStoreCount++;

					BookstoreBook book = new BookstoreBook(author, title, ibsn);
					BookstoreBook bookStoreCount = new BookstoreBook();

					
					System.out.println("Please enter the list price of " + author + " by " + title + ":");
					String bookPriceInput = input.nextLine();
					double bookPrice = Double.parseDouble(bookPriceInput);
					
					
					System.out.println("Is it on sale?(y/n):");
					String onSale = input.nextLine(); //do we have to check if they enter something else?
													
					
					double priceAfterReduction = bookPrice;
					if (onSale.equalsIgnoreCase("y")) {
						while(true) {
							
							System.out.println("Input a deduction percentage:");
							
							String redPercentageInput = input.nextLine();
							
							if(redPercentageInput.charAt(redPercentageInput.length()-1) == '%') {
								
								String temp = redPercentageInput.substring(0, redPercentageInput.length()-1);
								try {
									percentage = Double.parseDouble(temp);
									System.out.println("Your percentage is:"+ percentage);
									break;
								}catch(NumberFormatException e) {
									System.out.println("The number you provided is incorrect!");
								}
							}
							else {
								System.out.println("You did not specify a percentage!");
							}
							
						}
						
					}
					
					
					priceAfterReduction = bookPrice - ((percentage / 100) * bookPrice);
					
					book.setBookPrice(bookPrice);
					book.setPriceAfterReduction(priceAfterReduction);
					
					bookStoreCount2 = bookStoreCount.getBookCount();
					bookStoreList[bookStoreCount2] = book;

					System.out.println("Here is your bookstore book information");
					System.out.println(book); // To Test your toString method

				} else if (userInput2.equalsIgnoreCase("LB")) {
					System.out.println("Got it");

					LibraryBook book = new LibraryBook(author, title, ibsn);
					LibraryBook bookLibraryCount = new LibraryBook();
					
					bookLibraryCount2 = bookLibraryCount.getBookCount();
					
					libraryBookList[bookLibraryCount2] = book;
					System.out.println("Here is your bookstore book information");
					book.getCNumber();
					System.out.println(book); // To Test your toString method

				} else {
					System.out.println("Oops! That's not a valid entry. Please try again to create a book object:");
					userInput2 = input.nextLine();
				}

				System.out.println("Would you like to create a book object?(yes/no):");
				answer = input.nextLine();
				//answer.toLowerCase();// do something if answer is not valid
			} else if (answer.equalsIgnoreCase("no")) {
				break;
			} else {
				System.out.println("I'm sorry but" + answer + " isn't a valid answer.Please enter either yes or no");
				answer = input.nextLine();
			}
		}
		
		System.out.println("Sure!!");
		System.out.println("Here are all your books...");
		
		System.out.println("Bookstore Books" + "("+bookStoreCount2+")");
		for (int j = 1; j <= bookStoreCount2; j++) {
			System.out.println(bookStoreList[j].toString());
		}
		System.out.println("------");
		
		
		System.out.println("Library Books" + "("+bookLibraryCount2+")");
		for (int z = 1; z <= bookLibraryCount2; z++) {
			System.out.println(libraryBookList[z].toString());
		}
		System.out.println("------");
		System.out.println("Take care now!");
		

	}

}
