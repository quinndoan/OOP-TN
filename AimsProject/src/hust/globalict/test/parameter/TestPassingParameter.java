package hust.globalict.test.parameter;
import hust.globalict.aims.Media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("jungleDVD", "Animation", 19.95f, "Roger Allers", 87);
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("cinderellaDVD", "Animation", 19.95f, "Roger Allers", 87);

        swap(jungleDVD, cinderellaDVD);

        System.out.println("jungle dvd title: "+ jungleDVD.getTitle());
        System.out.println("Cinderella dvd title: "+ cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        System.out.println("jungle dvd title: "+ jungleDVD.getTitle());


    }

    public static void swap(Object o1, Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle,"Anime",13.45f,"Lucas",89);

    }
    
}