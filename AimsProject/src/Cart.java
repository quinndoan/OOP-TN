

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered =0;
    
    // Add a Disc to cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered <MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");

        }
        else {
            System.out.println("The cart is almost full");
        }
    }

    // Remove a Disc from the cart
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for (int i=0;i<qtyOrdered;i++){
            if (itemsOrdered[i].equals(disc)){
                for (int j=i;j<qtyOrdered-1;j++){
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
                itemsOrdered[qtyOrdered-1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc is not found in the cart");
    }

    // Compute the total cost
    public double totalCost(){
        double totalCost = 0;
        for (int i=0; i<qtyOrdered;i++){
            totalCost += itemsOrdered[i].getCost();

        }
        return totalCost;

    }


}
