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

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        for (DigitalVideoDisc disc : dvdList){
            if (qtyOrdered <MAX_NUMBERS_ORDERED){
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The disc has been added");
            }
            else {
                System.out.println("The cart has been full");
                break;
            }
        }
    }

    //Overloading with numbers of arguments
    // Note: we cannot put this method or the method :public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) at the same time
    // in the same file, so I mark this method as comments.
    
    //public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
    //    for (DigitalVideoDisc dvd : dvds) {
    //        addDigitalVideoDisc(dvd); 
    //    }
    //}
      
    // Overloading addDisc with two parameters
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if (qtyOrdered +1 == MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("One disc has been added, the cart is now full");

        }
        else if (qtyOrdered+1 <MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = dvd1;
            itemsOrdered[qtyOrdered+1] = dvd2;
            qtyOrdered = qtyOrdered+2;
            System.out.println("Two disc has been added");

        }
        else {
            System.out.println("The cart is full");
        }
    }


}

