
public class Cart {
	public static final int  MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered= new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyOrdered=0;
    public float totalCost=0;

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

    public float totalCost(){
        for(int i=0; i<qtyOrdered;i++){
            totalCost+= itemsOrdered[i].getCost();
        }
        return totalCost;
    }
}
