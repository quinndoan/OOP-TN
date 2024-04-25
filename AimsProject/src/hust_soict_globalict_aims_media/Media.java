package hust_soict_globalict_aims_media;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(){

    }
    public Media(int id, String title, String category, float cost){
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;

    }
    public int getId(){
        return id;
    }
    public void setID(int id){
        this.id = id;

    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getCategory(){
        return category;
    }

    public void setCategory(){
        this.category = category;
    }

    public float getCost(){
        return cost;
    }
    public void setCost(float cost){
        this.cost = cost;
    }

