
public class Cart {
	public static final int  MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered= new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyOrdered=0;
    public float totalCost=0;
    
    //add a single disc
    public void addDigitalVideodisc(DigitalVideoDisc disc){
        if(qtyOrdered<MAX_NUMBER_ORDERED){
            itemsOrdered[qtyOrdered]= disc;
            System.out.printf("The disc: \"%s\" has been added. ", itemsOrdered[qtyOrdered].getTitle());
            System.out.printf("Cost: %.2f\n", itemsOrdered[qtyOrdered].getCost()); 
            qtyOrdered+=1;
        }
        else{
            System.out.println("The cart is almost full, please remove some disc.");
        }  
    }
    
    //add a list of disc
    public void addDigitalVideodisc(DigitalVideoDisc[] dvdList){
    	for(DigitalVideoDisc disc: dvdList){
    		if(qtyOrdered<MAX_NUMBER_ORDERED){
    			itemsOrdered[qtyOrdered]= disc;
    			System.out.printf("The disc: \"%s\" has been added. ", itemsOrdered[qtyOrdered].getTitle());
    			System.out.printf("Cost: %.2f\n", itemsOrdered[qtyOrdered].getCost()); 
    			qtyOrdered+=1;
    		}
    		else{
    			System.out.println("The cart is almost full, please remove some disc.");
    			break;
    		}
    	}
    }
    
    //add two disc
    public void addDigitalVideodisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
    	//add dvd1;
    	if(qtyOrdered<MAX_NUMBER_ORDERED){
            itemsOrdered[qtyOrdered]= dvd1;
            System.out.printf("The disc: \"%s\" has been added. ", itemsOrdered[qtyOrdered].getTitle());
            System.out.printf("Cost: %.2f\n", itemsOrdered[qtyOrdered].getCost()); 
            qtyOrdered+=1;
        }
        else{
            System.out.println("The cart is almost full, please remove some disc.");
        } 
    	
    	//add dvd2;
    	if(qtyOrdered<MAX_NUMBER_ORDERED){
            itemsOrdered[qtyOrdered]= dvd2;
            System.out.printf("The disc: \"%s\" has been added. ", itemsOrdered[qtyOrdered].getTitle());
            System.out.printf("Cost: %.2f\n", itemsOrdered[qtyOrdered].getCost()); 
            qtyOrdered+=1;
        }
        else{
            System.out.println("The cart is almost full, please remove some disc.");
        } 
    }
    
    //add an arbitrary number of DVDs;
    public void addDigitalVideodisc(int numberOfdvds, DigitalVideoDisc... dvdList){
    	for(DigitalVideoDisc disc: dvdList){
    		if(qtyOrdered<MAX_NUMBER_ORDERED){
    			itemsOrdered[qtyOrdered]= disc;
    			System.out.printf("The disc: \"%s\" has been added. ", itemsOrdered[qtyOrdered].getTitle());
    			System.out.printf("Cost: %.2f\n", itemsOrdered[qtyOrdered].getCost()); 
    			qtyOrdered+=1;
    		}
    		else{
    			System.out.println("The cart is almost full, please remove some disc.");
    			break;
    		}
    	}
    }
    
    //remove disc
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        int check=0;

        for(int i=0; i< qtyOrdered; i++){
            if(itemsOrdered[i].equals(disc)){
                System.out.printf("Removed: \"%s\"\n", disc.getTitle());
                for(int j=i; j<qtyOrdered-1; j++){
                    itemsOrdered[j]= itemsOrdered[j+1];
                }
                itemsOrdered[qtyOrdered-1]= null;
                qtyOrdered-=1; 
                check=1;
                break;
            }
        }

        if(check==0){
            System.out.println("There is no such disc to be removed.");
        }
    }
    
    //calculate the total cost of the added DVDs
    public float totalCost(){
        for(int i=0; i<qtyOrdered; i++){
            totalCost+= itemsOrdered[i].getCost();
        }
        return totalCost;
    }
    
    public void print() {
    	System.out.println("***********************CART*********************** ");
    	System.out.println("Ordered Items:");
    	for(int i=0; i<qtyOrdered; i++) {
    		System.out.println(itemsOrdered[i].toString());
    	}
    	System.out.printf("Total cost: [%.2f]\n", totalCost());
    	System.out.println("************************************************** ");
    }
    
    public void Find(int id) {
    	boolean found= false;
    	for(int i=0; i<qtyOrdered; i++) {
    		if(itemsOrdered[i].getId()==id) {
    			System.out.println(itemsOrdered[i].toString());
    			found= true;
    		}
    	}
    	if(!found) {
    		System.out.println("No match is found.");
    	}
    }
    
    public void Find(String title) {
    	boolean found= false;
    	for(int i=0; i< qtyOrdered; i++) {
    		if(itemsOrdered[i].isMatch(title)) {
    			System.out.println(itemsOrdered[i].toString());
    			found= true;
    		}
    	}
    	if(!found) {
    		System.out.println("No match is found.");
    	}
    }
}