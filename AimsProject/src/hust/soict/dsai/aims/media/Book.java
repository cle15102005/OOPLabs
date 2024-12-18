package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class Book extends Media{
	private ArrayList<String> authors= new ArrayList<String>();
	
	public Book(String title, String category, float cost, ArrayList<String> authors) {
		super(title, category, cost);
		this.authors = authors;
	}

	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("Author already on the list");
		}
		else {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
		}
		else {
			System.out.println("Author is not on the list");
		}	
	}
	
	public String toString() {
		return "Book - [" + this.getTitle() + "] - [" + this.getCategory() + "] - ["+ this.authors 
				+ "] : [" + this.getCost() + "]$";
	}
}
