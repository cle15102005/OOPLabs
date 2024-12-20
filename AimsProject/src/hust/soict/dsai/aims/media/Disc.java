package hust.soict.dsai.aims.media;

public class Disc extends Media{
	public int length;
	public String director;

	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	public Disc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost);
		this.length = length;
		this.director = director;
	}
	
	public Disc(int id, String title, String category, float cost, String director) {
		super(id, title, category, cost);
		this.director = director;
	}
	
	public String toString() {
		return "Disc - [" + this.getTitle() + "] - [" + this.getCategory()  
				+ "] - [" + this.getDirector() + "] - [" + this.getLength() + "] : [" 
				+ this.getCost() + "]$";
	}
}
