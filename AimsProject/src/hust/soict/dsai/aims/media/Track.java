package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

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
	
	public void play() throws PlayerException { 
		if(this.getLength()> 0) {
			System.out.println("Playing track: " + this.getTitle()); 
			System.out.println("Track length: " + this.getLength());	
		}
		else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
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
