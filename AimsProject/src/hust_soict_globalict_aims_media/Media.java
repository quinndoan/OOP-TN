package hust_soict_globalict_aims_media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Media other = (Media) obj;
        return title.equals(other.getTitle());
    }

    public static class CompareByTitle implements Comparator<Media> {
        @Override
        public int compare(Media media1, Media media2) {
            return media1.getTitle().compareTo(media2.getTitle());
        }
    }

    public static class CompareByCost implements Comparator<Media> {
        @Override
        public int compare(Media media1, Media media2) {
            return Float.compare(media2.getCost(), media1.getCost());
        }
    }

    public static final Comparator<Media> COMPARE_BY_TITLE = new CompareByTitle();

    public static final Comparator<Media> COMPARE_BY_COST = new CompareByCost();
}
