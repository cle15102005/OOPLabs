
public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
        DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion king", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2= new DigitalVideoDisc("Star wars", "Science fiction", "Geogre Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3= new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideodisc(dvd1);
        anOrder.addDigitalVideodisc(dvd2);
        anOrder.addDigitalVideodisc(dvd3);
        anOrder.removeDigitalVideoDisc(dvd3);
        anOrder.removeDigitalVideoDisc(dvd3);
        anOrder.addDigitalVideodisc(dvd3);
        
        
        float totalCost= anOrder.totalCost();
        System.out.printf("Total Cost is: %.2f", totalCost);
	}

}
