package hust.soict.dsai.aims.Aims;
import java.util.ArrayList;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class Testo {
	
	public static void main(String[] args) {
		ArrayList<Media> mediae= new ArrayList<Media>();
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

		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book1);
		mediae.add(book2);
		
		for(Media m: mediae) {
			System.out.println(m.toString());
			cart.addMedia(m);
		}
		System.out.println(cart.totalCost());
		cart.sortByCostTitle();
	}
}

