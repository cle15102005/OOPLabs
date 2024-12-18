package hust.soict.dsai.aims.media;
import java.util.Comparator;

public abstract class Media implements Comparable<Media>{
	public int id;
	public String title;
	public String category;
	public float cost; 
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	
	public Media(String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o== null || !(o instanceof Media)) {
			return false;
		}
		Media o1= (Media) o;
		return this.getTitle()== o1.getTitle();
	}
	
	@Override
	public int compareTo(Media o) {
		int comp= this.getTitle().compareTo(o.getTitle());
		if(comp==1) {
			return 1;
		}
		if(this.getCost()< o.getCost()) {
			comp= 1;
		}
		return comp;
	}
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST= new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE= new MediaComparatorByCostTitle();
	
}
