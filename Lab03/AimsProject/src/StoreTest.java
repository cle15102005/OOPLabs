
public class StoreTest {

	public static void main(String[] args) {
		Store store= new Store();
		DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion king", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2= new DigitalVideoDisc("Star wars", "Science fiction", "Geogre Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3= new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.removeDVD(dvd3);
        
        store.print();
	}

}
