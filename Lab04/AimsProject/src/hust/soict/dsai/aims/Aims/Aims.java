package hust.soict.dsai.aims.Aims;

import java.util.ArrayList;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
	public static void showMenu() { 

		System.out.println("AIMS: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3"); 
	}
	
	public static void storeMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. See a media’s details"); 
		System.out.println("2. Add a media to cart"); 
		System.out.println("3. Play a media"); 
		System.out.println("4. See current cart"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void  displayMediaDetailsMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Add to cart"); 
		System.out.println("2. Play"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2"); 
		} 
	
	public static void cartMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Filter medias in cart"); 
		System.out.println("2. Sort medias in cart"); 
		System.out.println("3. Remove media from cart"); 
		System.out.println("4. Play a media"); 
		System.out.println("5. Place order"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4-5"); 
		} 
	
	public static void main(String[] args) {
		Store store= new Store();
		Cart cart= new Cart();
		ArrayList<String> authors= new ArrayList<String>();
		authors.add("Volvo");
	    authors.add("BMW");
	    authors.add("Ford");
	    
	    ArrayList<Track> CDs= new ArrayList<Track>();
		Track t1= new Track("Episode 1", 11);
		Track t2= new Track("Episode 2", 2);
		CDs.add(t1);
		CDs.add(t2);
		
		CompactDisc cd= new CompactDisc(1, "Gaoranger", "Super Sentai", 30.15f, "Kurosaki", "Ichigo", CDs);
		DigitalVideoDisc dvd= new DigitalVideoDisc(2, "Star wars", "Science fiction", 24.95f, 87, "Geogre Lucas");
		Book book1= new Book(3, "Murphy", "Psychology", 17.65f, authors);
		Book book2= new Book(4, "OOP", "IT", 15.55f, authors);
		Book book3= new Book(5, "CompArch", "IT", 15.65f, authors);

		store.addMedia(cd);
		store.addMedia(dvd);
		store.addMedia(book1);
		store.addMedia(book2);
		
		//cosole
		showMenu();
		Scanner inp = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter your number:");
	    int option = inp.nextInt();  // Read user input
	    if(option== 1) {
	    	System.out.println("Store: "); 
			System.out.println("--------------------------------"); 
	    	store.print();
	    	storeMenu();
	    	Scanner inp1 = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter your number:");
		    int option1 = inp1.nextInt();  // Read user input
		    if(option1== 1) {
		    	System.out.println("Enter title:");
		    	Scanner inp2 = new Scanner(System.in);  // Create a Scanner object
			    String title = inp2.nextLine();  // Read user input
			    Media media= store.findTitle(title);
			    if(media== null) {
			    	System.out.println("There is no such media");
			    }
			    else {
			    	System.out.println(media.toString());
			    }
		    }
		    displayMediaDetailsMenu();
		    Scanner inp2 = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter your number:");
		    int option2 = inp2.nextInt();  // Read user input
		    if(option2== 1) {
		    	System.out.println("Enter title:");
		    	Scanner inp3 = new Scanner(System.in);  // Create a Scanner object
			    String title = inp3.nextLine();  // Read user input
			    Media media= store.findTitle(title);
			    if(media== null) {
			    	System.out.println("There is no such media");
			    }
			    else {
			    	cart.addMedia(media);
			    	System.out.println("Cart added");
			    }
		    }
		    if(option2== 2) {
		    	System.out.println("Enter title:");
		    	Scanner inp4 = new Scanner(System.in);  // Create a Scanner object
			    String title = inp4.nextLine();  // Read user input
			    Media media= store.findTitle(title);
			    if(media== null || (media instanceof Book)) {
			    	System.out.println("There is no such media/ This is a book.");
			    }
			    else {
			    	if(media instanceof DigitalVideoDisc) {
			    		DigitalVideoDisc disc= (DigitalVideoDisc) media;
			    		disc.play();
			    	}
			    	if(media instanceof CompactDisc) {
			    		CompactDisc disc= (CompactDisc) media;
			    		disc.play();
			    	}
			    }
		    }
	    }
	    if(option==2) {
	    	store.addMedia(book3);
	    	System.out.println("Added Media");
	    }
	    if(option==3) {
	    	cart.addMedia(cd);
	    	cart.addMedia(dvd);
	    	cart.addMedia(book1);
	    	cart.addMedia(book2);
	    	cart.addMedia(book3);
	    	cart.printCart();
	    	cartMenu();
	    	Scanner inp1 = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter your number:");
		    int option1 = inp1.nextInt();  // Read user input
		    if(option1== 1) {
		    	System.out.println("By Id(1) or By Title(2)");
		    	Scanner inp2 = new Scanner(System.in);  // Create a Scanner object
			    System.out.println("Enter your number:");
			    int option2 = inp2.nextInt();  // Read user input
			    if(option2==1) {
			    	System.out.println("Enter ID:");
			    	Scanner inp3 = new Scanner(System.in);  // Create a Scanner object
				    int option3= inp3.nextInt();
				    cart.filterById(option3);
			    }
			    if(option2==2) {
			    	System.out.println("Enter Title:");
			    	Scanner inp3 = new Scanner(System.in);  // Create a Scanner object
				    String option3= inp3.nextLine();
				    cart.filterByTitle(option3);
			    }
		    }
		    if(option1==2) {
		    	System.out.println("By Title(1) or By Cost(2)");
		    	Scanner inp2 = new Scanner(System.in);  // Create a Scanner object
			    System.out.println("Enter your number:");
			    int option2 = inp2.nextInt();  // Read user input
			    if(option2==1) {
				    cart.sortByTitleCost();
			    }
			    if(option2==2) {
			    	cart.sortByCostTitle();
			    }
		    }
	    }
	}
}