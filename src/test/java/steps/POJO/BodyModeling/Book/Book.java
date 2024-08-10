package steps.POJO.BodyModeling.Book;

public class Book {
    private int id;
    private String name;
    private String author;
    private String isbn;
    private String type;
    private double price;
    private boolean available;
    private String currentStock;


    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}