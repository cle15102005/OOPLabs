
public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
        //single disc;
		DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion king", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2= new DigitalVideoDisc("Star wars", "Science fiction", "Geogre Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3= new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4= new DigitalVideoDisc("Zootopia", "Cartoon", 15.55f);
        
        System.out.println(dvd4.toString());
        //array disc;
        DigitalVideoDisc[] arrayDiscs= {dvd1, dvd2, dvd3};
        
        //add single discs;
        anOrder.addDigitalVideodisc(dvd1);
        anOrder.addDigitalVideodisc(dvd3);
        anOrder.removeDigitalVideoDisc(dvd3);
        anOrder.addDigitalVideodisc(dvd3);
        
        //add an array disc;
        anOrder.addDigitalVideodisc(arrayDiscs);
        
      //add an arbitrary number of discs;
        anOrder.addDigitalVideodisc(3, dvd1, dvd3, dvd4);
        
        //add two discs at the same time:
        anOrder.addDigitalVideodisc(dvd4, dvd2);
        
        anOrder.print();
        
        anOrder.Find(3);
        anOrder.Find("topi");
	}
}