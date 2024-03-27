public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // More variable to control the ID
    private static int nbDigitalVideoDisc =0;
    private int id;


    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }

//Create a DVD object by title
public DigitalVideoDisc(String title) {
    super();
    this.title = title;
    // Update id through nbDigitalVideoDisc
    this.id = ++nbDigitalVideoDisc;
}


//Create a DVD object by category, title and cost
public DigitalVideoDisc(String title, String category, float cost) {
    super();
    this.title = title;
    this.category = category;
    this.cost = cost;
    this.id = ++nbDigitalVideoDisc;
}

//Create a DVD object by director, category, title and cost
public DigitalVideoDisc(String title, String category, String director, float cost) {
    super();
    this.title = title;
    this.category = category;
    this.director = director;
    this.cost = cost;
    this.id = ++nbDigitalVideoDisc;
}

//Create a DVD object by all attributes: title, category, director, length and cost
public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    super();
    this.title = title;
    this.category = category;
    this.director = director;
    this.length = length;
    this.cost = cost;
    this.id = ++nbDigitalVideoDisc;
}
public void setTitle(String title) {
    this.title = title;
}

}
    public class DigitalVideoDisc {
        private String title;
        private String category;
        private String director;
        private int length;
        private float cost;
        public String getTitle() {
            return title;
        }
        public String getCategory() {
            return category;
        }
        public String getDirector() {
            return director;
        }
        public int getLength() {
            return length;
        }
        public float getCost() {
            return cost;
        }
    
    //Create a DVD object by title
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
    }
    
    
    //Create a DVD object by category, title and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    //Create a DVD object by director, category, title and cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }
    
    //Create a DVD object by all attributes: title, category, director, length and cost
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
}
    public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }

//Create a DVD object by title
public DigitalVideoDisc(String title) {
    super();
    this.title = title;
}


//Create a DVD object by category, title and cost
public DigitalVideoDisc(String title, String category, float cost) {
    super();
    this.title = title;
    this.category = category;
    this.cost = cost;
}

//Create a DVD object by director, category, title and cost
public DigitalVideoDisc(String title, String category, String director, float cost) {
    super();
    this.title = title;
    this.category = category;
    this.director = director;
    this.cost = cost;
}

//Create a DVD object by all attributes: title, category, director, length and cost
public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    super();
    this.title = title;
    this.category = category;
    this.director = director;
    this.length = length;
    this.cost = cost;
}

}
