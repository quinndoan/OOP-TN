public class Aims {
    public static void main(String[] args) {
       Cart anOrder = new Cart();

       DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
       anOrder.addDigitalVideoDisc(dvd1);

       DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
       anOrder.addDigitalVideoDisc(dvd2);

       DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
       anOrder.addDigitalVideoDisc(dvd3);

       System.out.println(dvd1.getTitle() +"  "+ dvd1.getCost());
       System.out.println(dvd2.getTitle() +"  "+ dvd2.getCost());
       System.out.println(dvd3.getTitle() +"  "+ dvd3.getCost());

       System.out.println("Total Cost is: ");
       System.out.println(anOrder.totalCost());


    }
    public void testRemove(Cart cart, DigitalVideoDisc dvd1){
        System.out.println("The Total Cost before removing the item: " + cart.totalCost());
        cart.removeDigitalVideoDisc(dvd1);
        System.out.println("The total cost after removing the item" + cart.totalCost());


    }
}