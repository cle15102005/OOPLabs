package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

	public DigitalVideoDisc(int id, String title, String category, 
			float cost, int length, String director) {
		super(id, title, category, cost, length, director);
	}

	public void play() { 
    	System.out.println("Playing DVD: " + this.getTitle()); 
    	System.out.println("DVD length: " + this.getLength()); 
    	}
    
    //return String
	public String toString() {
		return "DVD - [" + this.getTitle() + "] - [" + this.getCategory()  
				+ "] - [" + this.getDirector() + "] - [" + this.getLength() + "] : [" 
				+ this.getCost() + "]$";
	}
	
	@Override
	public int compareTo(Media o) {
		DigitalVideoDisc o1= (DigitalVideoDisc) o;
		int comp= this.getTitle().compareTo(o1.getTitle());
		if(this.getLength()> o1.getLength()) {
			comp= 1;
		}
		if(this.getCost()> o.getCost()) {
			comp= 1;
		}
		return comp;
	}
}