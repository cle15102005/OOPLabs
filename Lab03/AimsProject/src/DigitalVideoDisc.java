
public class DigitalVideoDisc {
	private String title;
    private String category;
    private String director;
    private int id;
    private int length;
    private float cost;
    private static int nbDigitalVideoDisc= 0;
    
    //overloading method
    public DigitalVideoDisc(String title) {
    	super();
        this.title = title;
        nbDigitalVideoDisc+=1;
        this.id = nbDigitalVideoDisc;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
    	super();
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDisc+=1;
        this.id = nbDigitalVideoDisc;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
    	super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDisc+=1;
        this.id = nbDigitalVideoDisc;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    	super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDisc+=1;
        this.id = nbDigitalVideoDisc;
    }
    
    //get value
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getId() {
    	return id;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }
    
    //set value
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setId(int id) {
		this.id= id;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	//return String
	public String toString() {
		return "DVD - [" + this.getTitle() + "] - [" + this.getCategory()  
				+ "] - [" + this.getDirector() + "] - [" + this.getLength() + "] : [" 
				+ this.getCost() + "]$";
	}
	
	public boolean isMatch(String title) {
    	String discTitle= this.title.toLowerCase();
    	if(discTitle.indexOf(title.toLowerCase())!=-1) {
    		return true;
    	}
    	return false;
    }
}