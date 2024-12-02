package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	public void play() { 
		System.out.println("Playing track: " + this.getTitle()); 
		System.out.println("Track length: " + this.getLength()); 
		} 
	
	@Override
	public boolean equals(Object o) {
		if(o== null || !(o instanceof Track)) {
			return false;
		}
		Track o1= (Track) o;
		return this.getTitle()== o1.getTitle() && this.getLength()== o1.getLength();
	}

}
