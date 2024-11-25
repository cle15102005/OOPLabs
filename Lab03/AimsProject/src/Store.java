
public class Store {
	DigitalVideoDisc[] itemsInStore= new DigitalVideoDisc[200];
	int numberOfDiscs= 0;
	
	public void addDVD(DigitalVideoDisc disc) {
		itemsInStore[numberOfDiscs]= disc;
		numberOfDiscs+=1;
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
        for(int i=0; i<numberOfDiscs ; i++){
            if(itemsInStore[i].equals(disc)){
                for(int j=i; j<numberOfDiscs-1; j++){
                	itemsInStore[j]= itemsInStore[j+1];
                }
                itemsInStore[numberOfDiscs-1]= null;
                numberOfDiscs-=1; 
                break;
            }
        }
	}
	
	public void print() {
		for(int i=0; i<numberOfDiscs; i++) {
			System.out.println(itemsInStore[i].toString());
		}
	}
}
