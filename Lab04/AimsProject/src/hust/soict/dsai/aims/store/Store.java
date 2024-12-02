package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore= new ArrayList<Media>();
	
	public void addMedia(Media mediaName) {
		itemsInStore.add(mediaName);
    }
    
    public void removeMedia(Media mediaName) {
    	itemsInStore.remove(mediaName);
    }
	
	public void print() {
		for(Media store: itemsInStore) {
			System.out.println(store.toString());
		}
	}
	
	public Media findTitle(String title) {
		boolean found= false;
		for(Media media: itemsInStore) {
			if(media.getTitle().equals(title)) {
				found= true;
				return media;
			}
		}
		return null;
	}
}
