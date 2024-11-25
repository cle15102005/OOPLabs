public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD= new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD= new DigitalVideoDisc("Cinderella");
		
		//we try to swap name;
		swap(jungleDVD, cinderellaDVD);
		
		//the original title doesn't change;
		System.out.println("jungle dvd title: "+ jungleDVD.getTitle());
		System.out.println("cinderella dvd title: "+ cinderellaDVD.getTitle());
		
		//but this change the title; Why?
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: "+ jungleDVD.getTitle());	
	}
	
	public static void swap(Object o1, Object o2) {
		Object tmp= o1;
		o1= o2;
		o2= tmp;
	}
	
	/*correct method to swap;
	public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String temp= dvd1.getTitle();
		dvd1.setTitle(dvd2.getTitle());
		dvd2.setTitle(temp);
	}*/
	
	public static void changeTitle(DigitalVideoDisc dvd, String title){
		//String oldTitle= dvd.getTitle();
		dvd.setTitle(title);
		//dvd= new DigitalVideoDisc(oldTitle);
	}
}
