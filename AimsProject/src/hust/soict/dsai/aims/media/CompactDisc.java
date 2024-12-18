package hust.soict.dsai.aims.media;
import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks= new ArrayList<Track>();
		
	public String getArtist() {
		return artist;
	}
	
	public CompactDisc(String artist, String title, String category, float cost) {
		super(title, category, cost);
		this.artist= artist;
	}
	
	public CompactDisc(String title, String category, float cost, int length, String director, String artist,
			ArrayList<Track> tracks) {
		super(title, category, cost, length, director);
		this.artist = artist;
		this.tracks = tracks;
	}

	public void addTrack(Track trackName) {
		if(tracks.contains(trackName)) {
			System.out.println("Track already on the list");
		}
		else {
			tracks.add(trackName);
		}
	}
	
	public void reomoveTrack(Track trackName) {
		if(tracks.contains(trackName)) {
			tracks.remove(trackName);
		}
		else {
			System.out.println("Track is not on the list");
		}
	}
	
	public void play() throws PlayerException {
		if(this.getLength()> 0) {
			for(Track track: tracks) {
				track.play();
			}
			System.out.printf("CD's length: %d\n", this.getLength());
		}
		else {
			throw new PlayerException("Error: CD length is non-positive");
		}
	}
	
	public int getLength() {
		int CDLength= 0; 
		for(Track track: tracks) {
			CDLength+= track.getLength();
		}
		return CDLength;
	}
	
	public String toString() {
		String tr= "";
		for(Track track: tracks) {
			tr+= "\n+[" + track.getTitle() + "] - [" + track.getLength() + " minutes]";
		}
		
		return "CD - [" + this.getTitle() + "] - [" + this.getCategory() + "] - [" + this.getDirector() 
				+ "] - [" + this.getArtist() + "] - [" + this.getLength() + "] : [" 
				+ this.getCost() + "]$" + tr;
	}
	
}
