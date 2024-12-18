package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;

import javax.naming.LimitExceededException;

public class Cart {
	public static final int  MAX_NUMBER_ORDERED = 20;
    private ObservableList<Media> itemsOrdered= 
    		FXCollections.observableArrayList();
    public float totalCost=0;
        
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void addMedia(Media mediaName) throws LimitExceededException {
		if(itemsOrdered.size()< MAX_NUMBER_ORDERED) {
			itemsOrdered.add(mediaName);
		}
		else {
			throw new LimitExceededException("ERROR: The number of"
					+ "media has reached its limit");
		}
    }
    
    public void removeMedia(Media mediaName) {
    	itemsOrdered.remove(mediaName);
    }
    
    public float totalCost(){
        for(Media media: itemsOrdered) {
        	totalCost+= media.getCost();
        }
        System.out.println("Total cost: ");
        return totalCost;
    }
    
    public void sortByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		System.out.println("Sorted by Title-Cost:");
		for(Media media: itemsOrdered) {
			System.out.println(media.toString());
		}
	}
    
    public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		System.out.println("Sorted by Cost-Title:");
		for(Media media: itemsOrdered) {
			System.out.println(media.toString());
		}
	}
    
    public void filterById(int id) {
    	boolean found= false;
		for(Media media: itemsOrdered) {
			if(media.getId()==id) {
				found= true;
				System.out.println(media.toString());
			}
		}
		if(!found) {
			System.out.println("There is no such media.");
		}
    }
    
    public void filterByTitle(String title) {
    	boolean found= false;
		for(Media media: itemsOrdered) {
			if(media.getTitle().equals(title)) {
				found= true;
				System.out.println(media.toString());
			}
		}
		if(!found) {
			System.out.println("There is no such media.");
		}
    }
    
    public void printCart() {
    	System.out.println("YOUR CART: "); 
		System.out.println("--------------------------------");
    	for(Media media: itemsOrdered) {
    		System.out.println(media.toString());
    	}
    }
}