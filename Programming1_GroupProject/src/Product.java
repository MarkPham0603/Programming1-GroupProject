public class Product {
    private int id;
    private String name;
    private float price;
    private String category;

    public Product(int id, String name,float price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory() {
        this.category =category;
    }

}
